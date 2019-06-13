package com.example.bohproject;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

public class EditPagerAdapter extends FragmentStatePagerAdapter {

  int countTab;

  public EditPagerAdapter(FragmentManager fm, int countTab) {
    super(fm);
    this.countTab = countTab;
  }

  //Get each tab and return the correct fragment
  @Override
  public Fragment getItem(int position) {
    switch (position) {
      case 0:
        FragmentEditAttributes tab1 = new FragmentEditAttributes();
        return tab1;
      case 1:
        FragmentEditPowers tab2 = new FragmentEditPowers();
        return tab2;
      case 2:
        FragmentEditSkills tab3 = new FragmentEditSkills();
        return tab3;
      case 3:
        FragmentEditDrawAdvantage tab4 = new FragmentEditDrawAdvantage();
        return tab4;
      case 4:
        FragmentEditDescription tab5 = new FragmentEditDescription();
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
