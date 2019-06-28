package com.example.bohproject;

import android.content.Context;
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
import android.widget.TextView;
import com.example.bohCharacter.Character;
import com.google.gson.Gson;

public class EditActivity extends AppCompatActivity {

  static final String TAG = "EditActivity";
  protected Character character;

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
  }

  /**
   * Creates our basic menu choices
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

  @Override
  public boolean onOptionsItemSelected(MenuItem item) {
    // Handle item selection
    Intent intent = null;

    switch (item.getItemId()) {
      case (R.id.returnHome):
        AlertDialog.Builder builder = new AlertDialog.Builder(EditActivity.this);
        builder.setCancelable(true);
        builder.setTitle("Return to Main Menu");
        builder.setMessage("Changes will nto be saved, are you sure?");
        builder.setPositiveButton("Confirm",
            new DialogInterface.OnClickListener() {
              @Override
              public void onClick(DialogInterface dialog, int which) {
                System.out.println("Confirmed!");

                Intent intent = new Intent(EditActivity.this, MainActivity.class);
                startActivity(intent);
                finish();
              }
            });
        builder.setNegativeButton(android.R.string.cancel, new DialogInterface.OnClickListener() {
          @Override
          public void onClick(DialogInterface dialog, int which) {
            //No Delete
            System.out.println("Denied!");
          }
        });
        AlertDialog dialog = builder.create();
        dialog.show();
        return true;
      case (R.id.save):
        System.out.println("Save has been pushed");
        //Save Character to our Database



        //To the View Activity
        intent = new Intent(this, ViewActivity.class);
        Gson gson = new Gson();
        String temp = gson.toJson(character);
        intent.putExtra("character", temp);
        startActivity(intent);
        return true;
      case (R.id.delete):
        System.out.println("Delete has been pushed");
        //Do something for delete
        AlertDialog.Builder builder2 = new AlertDialog.Builder(EditActivity.this);
        builder2.setCancelable(true);
        builder2.setTitle("Delete Character");
        builder2.setMessage("Are you sure you want to delete this character?");
        builder2.setPositiveButton("Confirm",
            new DialogInterface.OnClickListener() {
              @Override
              public void onClick(DialogInterface dialog, int which) {
                //Yes Delete
                System.out.println("Confirmed!");
                //ADd Character Delete here


                Intent intent = new Intent( EditActivity.this ,MainActivity.class);
                startActivity(intent);
                finish();
              }
            });
        builder2.setNegativeButton(android.R.string.cancel, new DialogInterface.OnClickListener() {
          @Override
          public void onClick(DialogInterface dialog, int which) {
            //No Delete
            System.out.println("Denied!");
          }
        });

        AlertDialog dialog2 = builder2.create();
        dialog2.show();

        return true;
      default:
        return true;
    }
  }
}