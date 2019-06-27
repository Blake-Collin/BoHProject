package com.example.bohdatabase;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Build.VERSION_CODES;
import android.support.annotation.RequiresApi;
import com.example.bohCharacter.Character;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import java.util.HashMap;

public class DataBaseAccess {

  private static final String MAPNAME = "bohCharacterMap";
  private static HashMap<String, Character> characterHashMap = null;

  private DataBaseAccess() {}

  private static class DataBaseAccessSingleton {
    private static final DataBaseAccess INSTANCE = new DataBaseAccess();
  }

  public static DataBaseAccess getInstance() {
    return DataBaseAccessSingleton.INSTANCE;
  }

  @RequiresApi(api = VERSION_CODES.N)
  public static boolean updateCharacter(String name, Character character, Context context) throws Exception {
    //Pull in map
    HashMap<String, Character> map = getMap(context);

    if(name != character.getDescription().getName())
    {
      map.remove(name);
      map.put(character.getDescription().getName(), character);
    }
    else {
      map.replace(name, character);
    }

    return false;
  }

  public static boolean deleteCharacter(Character character, Context context) throws Exception {
    HashMap<String, Character> map = getMap(context);
    map.remove(character.getDescription().getName());
    saveMap(map, context);
    return false;
  }

  public static boolean createCharacter(Character character, Context context) throws Exception {
    HashMap<String, Character> map = getMap(context);
    map.put(character.getDescription().getName(), character);
    saveMap(map, context);
    return true;
  }

  public static HashMap<String, Character> getHashMap(Context context) {
    characterHashMap = getMap(context);
    return characterHashMap;
  }

  private static HashMap<String, Character> getMap(Context context) {
    //Create our Pref to pull from
    SharedPreferences pref =  context.getSharedPreferences(MAPNAME, 0);

    //Serialize and save our class
    String temp = pref.getString(MAPNAME, null);
    Gson gson = new Gson();
    HashMap<String, Character> map = gson.fromJson(temp, new TypeToken<HashMap<String, Character>>(){}.getType());

    //Return our map
    return map;
  }

  private static boolean saveMap(HashMap<String, Character> map, Context context) {

    //Create Edit for our Preferences
    SharedPreferences pref = context.getSharedPreferences(MAPNAME, 0);
    Editor edit = pref.edit();

    //Serialize and save
    Gson gson = new Gson();
    String temp = gson.toJson(map);
    edit.putString(MAPNAME, temp);
    edit.commit();

    return false;
  }


}
