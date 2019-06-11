package com.example.bohproject;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.design.widget.TabLayout.BaseOnTabSelectedListener;
import android.support.design.widget.TabLayout.Tab;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;

public class ViewActivity extends AppCompatActivity {


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
      switch (item.getItemId()) {
        case (R.id.returnHome):
          finish();
          return true;
        case (R.id.edit):
          System.out.println("Edit has been pushed");
          //Do something for Edit
          return true;
        case (R.id.delete):
          System.out.println("Delete has been pushed");
          //Do something for delete
          return true;
      default:
        return true;
    }
  }

}