package com.example.bohproject;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemLongClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;
import com.example.ListAdapters.SkillAdapater;
import com.example.bohCharacter.Skill;
import java.util.ArrayList;

/**
 * FragmentEditSkills is the fragment view for out Tab layout of editing a {@link
 * com.example.bohCharacter.Character}'s {@link Skill}s.
 *
 * Part of the {@link EditActivity}
 *
 * @author Collin Blake
 * @since 6-29-2019
 */

public class FragmentEditSkills extends Fragment implements OnClickListener {

  static final String TAG = "FragmentEditSkills";
  View view;
  ArrayList<String> subSkills = new ArrayList<>();
  private SkillAdapater skillAdapater;

  public FragmentEditSkills() {
  }

  /**
   * onCreateView to add our button listeners
   */
  @Nullable
  @Override
  public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
      @Nullable Bundle savedInstanceState) {
    view = inflater.inflate(R.layout.edit_skills_fragment, container, false);

    //Button listener Setups
    Button b = (Button) view.findViewById(R.id.buttonAddSkill);
    Button b2 = (Button) view.findViewById(R.id.buttonAddSubSkill);
    b.setOnClickListener(this);
    b2.setOnClickListener(this);

    Log.i(TAG, "Added Button Listeners");

    //Adding long click deletion
    ListView lv = (ListView) view.findViewById(R.id.listViewSkills);
    lv.setOnItemLongClickListener(new OnItemLongClickListener() {

      @Override
      public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {

        Log.i(TAG, "Delete: " + ((EditActivity) getActivity()).character.getSkills().get(position)
            .toString());
        ((EditActivity) getActivity()).character.getSkills().remove(position);

        //Update after deletion
        updateSkillList();
        return false;
      }
    });

    //Update Skill List
    updateSkillList();

    return view;
  }


  public void onClick(View v) {
    switch (v.getId()) {
      case R.id.buttonAddSkill:
        onAddSkill();
        break;
      case R.id.buttonAddSubSkill:
        onAddSubSkill();
      default:
        break;
    }
  }

  public void onAddSkill() {

    //Get EditTexts
    EditText editTextSkillName = view.findViewById(R.id.editTextSkillValue);
    EditText editTextAPS = view.findViewById(R.id.editTextSkillAPValue);

    //Assign Values
    String name = editTextSkillName.getText().toString();
    int num = Integer.parseInt(editTextAPS.getText().toString());

    if (name != "" && num > -1) {
      Log.i(TAG, "Skill Name: " + name + " at " + num + "\n" + "Subskills: " + this.subSkills);

      //Get character here and add the new Skill item.
      ((EditActivity) getActivity()).character.getSkills().add(new Skill(name, num, subSkills));
      Log.i(TAG, "Skill Added");

      //reset Inputs
      Log.i(TAG, "Reset Inputs");
      editTextSkillName.setText("");
      editTextAPS.setText("1");
      this.subSkills = new ArrayList<>();

      //Update Skill List
      updateSkillList();
    }
  }

  public void onAddSubSkill() {
    EditText editTextSubSkillName = view.findViewById(R.id.editTextSubSkillValue);

    //Assign Values
    String name = editTextSubSkillName.getText().toString();

    Log.i(TAG, "Added Subskill: " + name);

    this.subSkills.add(name);

    //Current list
    Toast.makeText(getActivity(), "Subskill " + name + " Added", Toast.LENGTH_LONG).show();

    //Clear the list
    editTextSubSkillName.setText("");
  }

  //Update Skill List
  public void updateSkillList() {
    Log.i(TAG, "Skill List Updating");
    skillAdapater = new SkillAdapater((EditActivity) getActivity(),
        ((EditActivity) getActivity()).character.getSkills());
    ListView listSkills = (ListView) view.findViewById(R.id.listViewSkills);
    listSkills.setAdapter(skillAdapater);
  }

}
