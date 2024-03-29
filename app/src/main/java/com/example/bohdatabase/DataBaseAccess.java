package com.example.bohdatabase;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Build.VERSION_CODES;
import android.support.annotation.RequiresApi;
import android.util.Log;
import com.example.bohCharacter.Character;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import java.util.HashMap;

/**
 * Database access for our local shared preferences of saved {@link com.example.bohCharacter.Character}s
 * This also handles deletion, update, and creation of this. (Built as a singleton instance to avoid
 * multiple edits at once)
 *
 * @author Collin Blake
 * @Since 6-29-2019
 */
public class DataBaseAccess {

  static final String TAG = "DataBaseAccess";
  private static final String MAPNAME = "bohCharacterMap";
  private static HashMap<String, Character> characterHashMap = null;


  private static final DataBaseAccess ourInstance = new DataBaseAccess();

  public static DataBaseAccess getInstance() {
    return ourInstance;
  }

  private DataBaseAccess() {
  }


  private static class DataBaseAccessSingleton {

    private static final com.example.bohdatabase.DataBaseAccess INSTANCE = new com.example.bohdatabase.DataBaseAccess();
  }

  @RequiresApi(api = VERSION_CODES.N)
  public static void updateCharacter(String name, Character character, Context context)
      throws Exception {
    //Pull in map
    HashMap<String, Character> map = getMap(context);
    Log.i(TAG, "Character Update in Progress");
    if (!map.containsKey(name)) {
      map.put(name, character);
    } else {
      map.replace(name, character);
    }
    saveMap(map, context);
  }

  public static void deleteCharacter(String name, Context context) throws Exception {

    Log.i(TAG, "Character Deletion in Progress");
    HashMap<String, Character> map = getMap(context);

    if (!map.containsKey(name)) {
      Log.e(TAG, "Character Doesn't Exist");
      Exception e = new CharacterNonExistenceException();
      throw e;
    }

    map.remove(name);
    saveMap(map, context);
  }

  public static void createCharacter(Character character, Context context) throws Exception {
    HashMap<String, Character> map = getMap(context);

    if (map == null) {
      Log.i(TAG, "No Map Yet Creating our first Hashmap!");
      map = new HashMap<String, Character>();
    }

    Log.i(TAG, "Character Creation in Progress");
    if (map.containsKey(character.getDescription().getName())) {
      Log.e(TAG, "Character Already Exists");
      Exception e = new CharacterExistsException();
      throw e;
    }
    map.put(character.getDescription().getName(), character);
    saveMap(map, context);
  }

  public static boolean containsCharacter(String name, Context context) {
    HashMap<String, Character> map = getMap(context);
    Log.i(TAG, "Checking if Character exists");
    if (map != null) {
      return map.containsKey(name);
    } else {
      return false;
    }

  }

  public static HashMap<String, Character> getHashMap(Context context) {
    characterHashMap = getMap(context);
    return characterHashMap;
  }

  private static HashMap<String, Character> getMap(Context context) {
    //Create our Pref to pull from
    Log.i(TAG, "Retrieving Map");
    SharedPreferences pref = context.getSharedPreferences(MAPNAME, 0);

    //Serialize and save our class
    String temp = pref.getString(MAPNAME, null);
    Gson gson = new Gson();
    HashMap<String, Character> map = gson
        .fromJson(temp, new TypeToken<HashMap<String, Character>>() {
        }.getType());

    //Return our map
    return map;
  }

  private static void saveMap(HashMap<String, Character> map, Context context) {

    Log.i(TAG, "Saving Map");

    //Create Edit for our Preferences
    SharedPreferences pref = context.getSharedPreferences(MAPNAME, 0);
    Editor edit = pref.edit();

    //Serialize and save
    Gson gson = new Gson();
    String temp = gson.toJson(map);
    edit.putString(MAPNAME, temp);
    edit.commit();
  }

}
