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

public class FragmentEditPowers extends Fragment implements OnClickListener {

  static final String TAG = "FragmentEditPowers";
  View view;

  public FragmentEditPowers() {
  }

  @Nullable
  @Override
  public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
      @Nullable Bundle savedInstanceState) {
    view = inflater.inflate(R.layout.edit_powers_fragment, container, false);

    Button b = (Button) view.findViewById(R.id.buttonPowerAdd);
    b.setOnClickListener(this);



    return view;
  }

  /**
   * Button Switch
   * @param v
   */
  public void onClick(View v) {
    switch (v.getId()) {
      case R.id.buttonPowerAdd:
        onPowerAdd();
        break;
      default:
        break;
    }
  }

  public void onPowerAdd() {

    Log.i(TAG, "Add Power was Pressed");
    //Get EditTexts
    EditText editTextPowerName = view.findViewById(R.id.editTextPowerName);
    EditText editTextPowerAPs = view.findViewById(R.id.editTextPowerAPs);

    //Assign Values
    String name = editTextPowerName.getText().toString();
    int APs = Integer.parseInt(editTextPowerAPs.getText().toString());

    Log.i(TAG, "Temp Values assigned");

    Log.i(TAG,"Power: " + name + "\n" + "APs: " + APs);

    //Get character here and add the new power item.
    ((EditActivity) getActivity()).character.addPower(name, APs);


    Log.i(TAG, "Power Added");

    //Clear Inputs
    editTextPowerAPs.setText("");
    editTextPowerName.setText("");
    Log.i(TAG, "Boxes emptied for next power to add.");
  }

  public void updatePowerList() {
    //Will use this to update our Powerlist later
    Log.i(TAG, "powerList Updating");
  }

}
