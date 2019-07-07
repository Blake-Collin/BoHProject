package com.example.bohproject;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import com.example.ListAdapters.PowerAdapter;
import com.example.bohCharacter.Power;

/**
 * FragmentViewPowers is the fragment view for out Tab layout of viewing a {@link
 * com.example.bohCharacter.Character}'s {@link Power} list
 *
 * Part of the {@link EditActivity}
 *
 * @author Collin Blake
 * @since 6-29-2019
 */
public class FragmentViewPowers extends Fragment {

  private final String TAG = "FragmentViewPowers";
  private View view;
  private PowerAdapter powerAdapter;


  @Nullable
  @Override
  public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
      @Nullable Bundle savedInstanceState) {
    view = inflater.inflate(R.layout.view_powers_fragment,container, false);

    Log.i(TAG, "Bring in charcter data");
    updatePowerList();

    return view;
  }

  /**
   * Update our powerlist with the powers of character.
   */
  public void updatePowerList() {
    //Will use this to update our Powerlist later
    Log.i(TAG, "powerList Updating");
    powerAdapter = new PowerAdapter(getActivity(),
        ((ViewActivity) getActivity()).character.getPowers());
    ListView listPowers = view.findViewById(R.id.listViewPowers);
    listPowers.setAdapter(powerAdapter);
  }
}
