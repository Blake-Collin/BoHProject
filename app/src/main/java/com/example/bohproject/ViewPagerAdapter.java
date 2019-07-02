package com.example.bohproject;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

/**
 * View Pager adapter for {@link ViewActivity}
 *
 * @author Collin Blake
 * @since 6-29-2019
 */

public class ViewPagerAdapter extends FragmentStatePagerAdapter {

  int countTab;

  public ViewPagerAdapter(FragmentManager fm, int countTab) {
    super(fm);
    this.countTab = countTab;
  }

  //Get each tab and return the correct fragment
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
    return countTab;
  }


}