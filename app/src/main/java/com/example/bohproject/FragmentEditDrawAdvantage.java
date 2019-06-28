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
import android.widget.Button;
import android.widget.EditText;
import com.example.bohCharacter.DrawAdvantages;

public class FragmentEditDrawAdvantage extends Fragment implements OnClickListener {

  static final String TAG = "FragmentEditDrawAdvant";
  View view;

  public FragmentEditDrawAdvantage() {
  }

  @Nullable
  @Override
  public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
      @Nullable Bundle savedInstanceState) {
    view = inflater.inflate(R.layout.edit_advantage_fragment,container,false );

    //Add Button Listener
    Button b = (Button) view.findViewById(R.id.buttonAddDrawAdvantage);
    b.setOnClickListener(this);
    Log.i(TAG, "Added Button Listener");


    //Update List
    updateDrawAdvanList();

    return view;
  }

  /**
   * Button Switch
   * @param v
   */
  public void onClick(View v) {
    switch (v.getId()) {
      case R.id.buttonAddDrawAdvantage:
        onDrawAdvantageAdd();
        break;
      default:
        break;
    }
  }

  public void onDrawAdvantageAdd() {

    //Get EditTexts
    EditText editTextName = view.findViewById(R.id.editDrawAdvantageName);
    EditText editTextDescription = view.findViewById(R.id.editDrawAdvantageDescription);

    //Assign Values
    String name = editTextName.getText().toString();
    String desc = editTextDescription.getText().toString();

    Log.i(TAG,"Drawback/Advantage: " + name + "\n" + "Description: " + desc);

    //Get character here and add the new Drawback or advantage item.
    ((EditActivity) getActivity()).character.getDrawAdvantages().add(new DrawAdvantages(name,desc));

    Log.i(TAG, "Draw/Advantage Added to the list");

    //Clear Inputs
    editTextName.setText("");
    editTextDescription.setText("");
    Log.i(TAG, "Cleared the Input Fields");

    //Update List
    updateDrawAdvanList();
  }

  public void updateDrawAdvanList() {
    //Add code for updating later
    Log.i(TAG, "Updating the Draw & Advantages List");

  }

}
