package com.example.bohproject;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.example.bohCharacter.Skill;

/**
 * FragmentEditSkills is the fragment view for out Tab layout of editing a {@link
 * com.example.bohCharacter.Character}'s {@link Skill}s.
 *
 * Part of the {@link ViewActivity}
 *
 * @author Collin Blake
 * @since 6-29-2019
 */
public class FragmentViewSkills extends Fragment {

  View view;

  public FragmentViewSkills() {
  }

  @Nullable
  @Override
  public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
      @Nullable Bundle savedInstanceState) {
    view = inflater.inflate(R.layout.view_skills_fragment,container,false);
    return view;
  }
}
