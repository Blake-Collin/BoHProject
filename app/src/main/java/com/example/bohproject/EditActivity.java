package com.example.bohproject;

import android.annotation.SuppressLint;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.design.widget.TabLayout.BaseOnTabSelectedListener;
import android.support.design.widget.TabLayout.Tab;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;
import com.example.bohCharacter.Character;
import com.example.bohdatabase.DataBaseAccess;
import com.google.gson.Gson;

/**
 * our Edit Activity using Tab layout for editing our {@link Character}
 *
 * @author Collin Blake
 * @since 6-29-2019
 */
public class EditActivity extends AppCompatActivity {

  static final String TAG = "EditActivity";
  protected Character character;
  protected String name;

  /**
   * Requires an intent passed with json object of {@link Character} labeled at the hashmap
   * "character"
   */
  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    Log.i(TAG, "Starting Edit Activity");
    setContentView(R.layout.activity_edit);

    //Bring in our Action Bar/Toolbar
    Toolbar toolbar = findViewById(R.id.toolbar);
    setSupportActionBar(toolbar);
    getSupportActionBar().setDisplayShowTitleEnabled(false);

    Log.i(TAG, "Adding Tabs");
    //Add the tabs for our class with names
    TabLayout tabs = findViewById(R.id.tabs);
    tabs.addTab(tabs.newTab().setText(R.string.tab_text_1));
    tabs.addTab(tabs.newTab().setText(R.string.tab_text_2));
    tabs.addTab(tabs.newTab().setText(R.string.tab_text_3));
    tabs.addTab(tabs.newTab().setText(R.string.tab_text_4));
    tabs.addTab(tabs.newTab().setText(R.string.tab_text_5));
    tabs.setTabGravity(TabLayout.GRAVITY_FILL);

    //Print in our View Pager which has references to all our fragments
    final ViewPager viewPager = findViewById(R.id.view_pager);
    EditPagerAdapter editPagerAdapter = new EditPagerAdapter(getSupportFragmentManager(),
        tabs.getTabCount());

    viewPager.setAdapter(editPagerAdapter);
    viewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabs));

    tabs.addOnTabSelectedListener(new BaseOnTabSelectedListener() {
      @Override
      public void onTabSelected(Tab tab) {
        viewPager.setCurrentItem(tab.getPosition());
      }

      @Override
      public void onTabUnselected(Tab tab) {

      }

      @Override
      public void onTabReselected(Tab tab) {

      }
    });

    Log.i(TAG, "Allocating character info");
    //Bring in our character
    Intent intent = getIntent();
    String temp = intent.getStringExtra("character");
    Gson gson = new Gson();
    this.character = gson.fromJson(temp, Character.class);
    this.name = this.character.getDescription().getName();
  }

  /**
   * Creates our basic toolbar inflation for when you press the menu
   */
  @Override
  public boolean onCreateOptionsMenu(Menu menu) {
    getMenuInflater().inflate(R.menu.editmenu, menu);
    return true;
  }

  @Override
  public void setSupportActionBar(@Nullable Toolbar toolbar) {
    super.setSupportActionBar(toolbar);
  }

  /**
   * Callout to our menu functions which will save, return to home,
   *
   * @return completion Boolean
   */
  @SuppressLint("NewApi")
  @Override
  public boolean onOptionsItemSelected(MenuItem item) {
    // Handle item selection

    switch (item.getItemId()) {
      case (R.id.returnHome):
        AlertDialog.Builder builder = new AlertDialog.Builder(EditActivity.this);
        builder.setCancelable(true);
        builder.setTitle("Return to Main Menu");
        builder.setMessage("Changes will not be saved, are you sure?");
        builder.setPositiveButton("Confirm",
            new DialogInterface.OnClickListener() {
              @Override
              public void onClick(DialogInterface dialog, int which) {
                Log.i(TAG, "Return to home screen");

                Intent intent = new Intent(EditActivity.this, MainActivity.class);
                startActivity(intent);
                finish();
              }
            });
        builder.setNegativeButton(android.R.string.cancel, new DialogInterface.OnClickListener() {
          @Override
          public void onClick(DialogInterface dialog, int which) {
            System.out.println("Not returning home");
          }
        });
        AlertDialog dialog = builder.create();
        dialog.show();
        return true;

      case (R.id.save):
        Log.i(TAG, "Save has been pushed");
        //Save Character to our Database
        final DataBaseAccess dataBaseAccess = DataBaseAccess.getInstance();
        if (this.name.equals("") && DataBaseAccess
            .containsCharacter(character.getDescription().getName(), this)) {
          AlertDialog.Builder builder3 = new AlertDialog.Builder(EditActivity.this);
          builder3.setCancelable(true);
          builder3.setTitle("Overwrite Character");
          builder3.setMessage("Character Already exists, do you wish to Overwrite?");
          builder3.setPositiveButton("Confirm",
              new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                  Log.i(TAG, "Character Overwriting");
                  try {
                    DataBaseAccess.updateCharacter(character.getDescription().getName(), character,
                        EditActivity.this);
                  } catch (Exception e) {
                    e.printStackTrace();
                  }
                  toViewActivity();
                }
              });
          builder3
              .setNegativeButton(android.R.string.cancel, new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                  //No Delete
                  Log.i(TAG, "Canceled overwrite");
                }
              });
          AlertDialog dialog3 = builder3.create();
          dialog3.show();
        } else if (this.name.equals(this.character.getDescription().getName()) && DataBaseAccess
            .containsCharacter(this.name, this)) {
          Log.i(TAG, "Updating Character");
          try {
            DataBaseAccess.updateCharacter(this.name, this.character, this);
          } catch (Exception e) {
            e.printStackTrace();
            return false;
          }
          toViewActivity();
        } else if (this.name.equals("") && this.character.getDescription().getName().equals("")) {
          Log.i(TAG, "The name is empty informing user we need a name");
          Toast.makeText(this, "Character Name is Required", Toast.LENGTH_LONG).show();
        } else {
          Log.i(TAG, "Creating new Character");
          try {
            DataBaseAccess.createCharacter(this.character, this);
          } catch (Exception e) {
            e.printStackTrace();
          }
          toViewActivity();
        }
        return true;

      case (R.id.delete):
        Log.i(TAG, "Delete has been pushed");
        //Do something for delete
        AlertDialog.Builder builder2 = new AlertDialog.Builder(EditActivity.this);
        builder2.setCancelable(true);
        builder2.setTitle("Delete Character");
        builder2.setMessage("Are you sure you want to delete this character?");
        builder2.setPositiveButton("Confirm",
            new DialogInterface.OnClickListener() {
              @Override
              public void onClick(DialogInterface dialog, int which) {
                //ADd Character Delete here
                DataBaseAccess dataBaseAccess1 = DataBaseAccess.getInstance();
                if (DataBaseAccess.containsCharacter(name, EditActivity.this)) //Need more logic
                {
                  Log.i(TAG, "Deleting Character: " + name);
                  try {
                    DataBaseAccess
                        .deleteCharacter(name, EditActivity.this);
                  } catch (Exception e) {
                    e.printStackTrace();
                  }
                }
                Intent intent = new Intent(EditActivity.this, MainActivity.class);
                startActivity(intent);
                finish();
              }
            });
        builder2.setNegativeButton(android.R.string.cancel, new DialogInterface.OnClickListener() {
          @Override
          public void onClick(DialogInterface dialog, int which) {
            //No Delete
            Log.i(TAG, "Canceled the deletion of " + name);
          }
        });
        AlertDialog dialog2 = builder2.create();
        dialog2.show();

        return true;
      default:
        return true;
    }
  }

  private void toViewActivity() {
    //To the View Activity
    Intent intent = new Intent(this, ViewActivity.class);
    Gson gson = new Gson();
    String temp = gson.toJson(character);
    intent.putExtra("character", temp);
    startActivity(intent);
    finish();
  }
}