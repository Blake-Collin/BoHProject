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
import android.view.Menu;
import android.view.MenuItem;

public class EditActivity extends AppCompatActivity {

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_edit);

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
        intent = new Intent(this, MainActivity.class);
        startActivity(intent);
        finish();
        return true;
      case (R.id.save):
        System.out.println("Save has been pushed");
        //Do something for Edit
        intent = new Intent(this, ViewActivity.class);
        startActivity(intent);
        return true;
      case (R.id.delete):
        System.out.println("Delete has been pushed");
        //Do something for delete
        AlertDialog.Builder builder = new AlertDialog.Builder(EditActivity.this);
        builder.setCancelable(true);
        builder.setTitle("Delete Character");
        builder.setMessage("Are you sure you want to delete this character?");
        builder.setPositiveButton("Confirm",
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
      default:
        return true;
    }
  }
}