package com.example.bohproject;

import android.content.Context;
import android.support.annotation.Nullable;
import android.support.annotation.StringRes;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.app.FragmentStatePagerAdapter;
import com.example.bohproject.R;
import java.util.ArrayList;
import java.util.List;


public class ViewPagerAdapter extends FragmentStatePagerAdapter {

  int counttab;

  public ViewPagerAdapter(FragmentManager fm, int counttab) {
    super(fm);
    this.counttab = counttab;
  }

  @Override
  public Fragment getItem(int position) {
    switch (position) {
      case 0:
        FragmentViewAttributes tab1 = new FragmentViewAttributes();
        return tab1;
      case 1:
        FragmentViewPowers tab2 = new FragmentViewPowers();
        return tab2;
      case 2:
        FragmentViewSkills tab3 = new FragmentViewSkills();
        return tab3;
      case 3:
        FragmentViewDrawAdvantage tab4 = new FragmentViewDrawAdvantage();
        return tab4;
      case 4:
        FragmentViewDescription tab5 = new FragmentViewDescription();
        return tab5;
      default:
        return null;
    }
  }


  @Override
  public int getCount() {
    return counttab;
  }


}