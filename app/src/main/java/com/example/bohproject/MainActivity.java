package com.example.bohproject;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.EditText;
import android.widget.ListView;
import com.example.ListAdapters.CharacterAdapter;
import com.example.bohCharacter.Character;
import com.example.bohdatabase.DataBaseAccess;
import com.google.gson.Gson;
import java.util.ArrayList;
import java.util.HashMap;

/**
 * Our main Activity for showing our list of {@link Character}s
 *
 * @author Collin Blake
 * @Since 7-15-2019
 */
public class MainActivity extends AppCompatActivity {

  private CharacterAdapter characterAdapter;
  private HashMap<String, Character> characters;
  private static final String TAG = "MainActivity";
  private View view;


  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);

    Log.i(TAG, "Getting our character list");
    this.characters = DataBaseAccess.getHashMap(this);

    //Add Text Watcher
    EditText editText = findViewById(R.id.search);
    editText.addTextChangedListener(new TextWatcher() {
      @Override
      public void beforeTextChanged(CharSequence s, int start, int count, int after) {
      }

      @Override
      public void onTextChanged(CharSequence s, int start, int before, int count) {

      }

      @Override
      public void afterTextChanged(Editable s) {
        Log.i(TAG, "Search Value Changed");
        final EditText editText = findViewById(R.id.search);
        updateCharacterList(editText.getText().toString());
      }
    });

    //Add our listview listeners
    ListView lv = findViewById(R.id.listViewCharacters);
    lv.setOnItemClickListener(new OnItemClickListener() {
      @Override
      public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        Character character = (Character) characterAdapter.getItem(position);
        Intent intent = new Intent(getApplicationContext(), ViewActivity.class);
        Gson gson = new Gson();
        String temp = gson.toJson(character);
        intent.putExtra("character", temp);
        startActivity(intent);
      }
    });

    Log.i(TAG, "First run of character update");
    updateCharacterList("");
  }


  protected void onPress(View view) {
    Intent intent = new Intent(this, EditActivity.class);
    Gson gson = new Gson();
    String temp = gson.toJson(new Character());
    intent.putExtra("character", temp);
    startActivity(intent);
  }

  //Update Skill List
  public void updateCharacterList(String searchText) {
    if (this.characters == null) {
      Log.i(TAG, "Characters are null");
      return;
    }

    Log.i(TAG, "Character List Updating");

    //temp list to transfer
    ArrayList<Character> temp = new ArrayList<Character>();
    temp.addAll(characters.values());

    characterAdapter = new CharacterAdapter(this,
        temp, searchText);
    ListView listCharacters = this.findViewById(R.id.listViewCharacters);
    listCharacters.setAdapter(characterAdapter);
  }
}
