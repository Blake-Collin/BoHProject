package com.example.bohproject;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * FragmentView {@link com.example.bohCharacter.Attributes} will allow you to view a {@link
 * com.example.bohCharacter.Character}'s {@link com.example.bohCharacter.Attributes}
 *
 * Part of the {@link ViewActivity}
 *
 * @Author Collin Blake
 * @since 6-29-2019
 */
public class FragmentViewAttributes extends Fragment {

  View view;

  public FragmentViewAttributes() {
  }

  @Nullable
  @Override
  public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
      @Nullable Bundle savedInstanceState) {

    view = (View) inflater.inflate(R.layout.view_attributes_fragment, container, false);
    return view;
  }
}
