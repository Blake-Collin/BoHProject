package com.example.bohproject;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.design.widget.TabLayout.BaseOnTabSelectedListener;
import android.support.design.widget.TabLayout.Tab;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;

public class ViewActivity extends AppCompatActivity {

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);

    setContentView(R.layout.activity_view);

    TabLayout tabs = findViewById(R.id.tabs);
    tabs.addTab(tabs.newTab().setText(R.string.tab_text_1));
    tabs.addTab(tabs.newTab().setText(R.string.tab_text_2));
    tabs.addTab(tabs.newTab().setText(R.string.tab_text_3));
    tabs.addTab(tabs.newTab().setText(R.string.tab_text_4));
    tabs.addTab(tabs.newTab().setText(R.string.tab_text_5));
    tabs.setTabGravity(TabLayout.GRAVITY_FILL);

    final ViewPager viewPager = findViewById(R.id.view_pager);
    ViewPagerAdapter viewPagerAdapter = new ViewPagerAdapter(getSupportFragmentManager(), tabs.getTabCount());

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
}