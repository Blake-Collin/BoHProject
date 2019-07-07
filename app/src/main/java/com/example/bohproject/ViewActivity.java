package com.example.bohproject;

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
import com.example.bohCharacter.Character;
import com.example.bohdatabase.DataBaseAccess;
import com.google.gson.Gson;


/**
 * our ViewActivity using Tab layout for viewing our {@link Character}
 *
 * @author Collin Blake
 * @since 6-29-2019
 */
public class ViewActivity extends AppCompatActivity {


  private static final String TAG = "ViewActivity";
  protected Character character;
  protected String name;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_view);

    //Bring in our Action Bar/Toolbar
    Toolbar toolbar = findViewById(R.id.toolbar);
    setSupportActionBar(toolbar);
    getSupportActionBar().setDisplayShowTitleEnabled(false);

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
    ViewPagerAdapter viewPagerAdapter = new ViewPagerAdapter(getSupportFragmentManager(),
        tabs.getTabCount());

    viewPager.setAdapter(viewPagerAdapter);
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
   * Creates our basic menu choices
   *
   * @param menu
   * @return
   */
  @Override
  public boolean onCreateOptionsMenu(Menu menu) {
    getMenuInflater().inflate(R.menu.viewmenu, menu);
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
          intent = new Intent(this, MainActivity.class );
          startActivity(intent);
          finish();
          return true;
        case (R.id.edit):
          Log.i(TAG, "Moving to the Edit View");

          //Do something for Edit
          intent = new Intent(this, EditActivity.class );
          Gson gson = new Gson();
          String temp = gson.toJson(character);
          intent.putExtra("character", temp);
          startActivity(intent);
          finish();
          return true;
        case (R.id.delete):
          System.out.println("Delete has been pushed");
          AlertDialog.Builder builder = new AlertDialog.Builder(ViewActivity.this);
          builder.setCancelable(true);
          builder.setTitle("Delete Character");
          builder.setMessage("Are you sure you want to delete this character?");
          builder.setPositiveButton("Confirm",
              new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                  //Yes Delete
                  System.out.println("Confirmed!");
                  //Add Character Delete here
                  DataBaseAccess dataBaseAccess = DataBaseAccess.getInstance();
                  if (DataBaseAccess.containsCharacter(name, ViewActivity.this)) //Need more logic
                  {
                    Log.i(TAG, "Deleting Character: " + name);
                    try {
                      DataBaseAccess
                          .deleteCharacter(name, ViewActivity.this);
                    } catch (Exception e) {
                      e.printStackTrace();
                    }
                  }
                  Intent intent = new Intent( ViewActivity.this ,MainActivity.class);
                  startActivity(intent);
                  finish();
                }
              });
          builder.setNegativeButton(android.R.string.cancel, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
              //No Delete
              Log.i(TAG, "Canceled Deletion");
            }
          });
          AlertDialog dialog = builder.create();
          dialog.show();

          return true;
      default:
        return true;
    }
  }

}