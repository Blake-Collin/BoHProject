package com.example.bohproject;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * FragmentViewDescription for viewing our {@link com.example.bohCharacter.Character}'s {@link
 * com.example.bohCharacter.Description} values
 *
 * Part of the {@link ViewActivity}
 *
 * @author Collin Blake
 * @since 6-29-2019
 */
public class FragmentViewDescription extends Fragment {

  View view;

  public FragmentViewDescription() {
  }

  @Nullable
  @Override
  public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
      @Nullable Bundle savedInstanceState) {
    view = inflater.inflate(R.layout.view_description_fragment, container, false);
    return view;
  }
}
