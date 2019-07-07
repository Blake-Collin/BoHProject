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
import com.example.ListAdapters.SkillAdapater;
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

  private final String TAG = "FragmentViewSkills";
  private SkillAdapater skillAdapater;
  private View view;


  @Nullable
  @Override
  public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
      @Nullable Bundle savedInstanceState) {
    view = inflater.inflate(R.layout.view_skills_fragment,container,false);
    Log.i(TAG, "Bringing in character data");
    updateSkillList();
    return view;
  }

  //Update Skill List
  public void updateSkillList() {
    Log.i(TAG, "Skill List Updating");
    skillAdapater = new SkillAdapater(getActivity(),
        ((ViewActivity) getActivity()).character.getSkills());
    ListView listSkills = view.findViewById(R.id.listViewSkills);
    listSkills.setAdapter(skillAdapater);
  }
}
