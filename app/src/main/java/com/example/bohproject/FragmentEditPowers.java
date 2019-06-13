package com.example.bohproject;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

public class FragmentEditPowers extends Fragment implements OnClickListener {

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

    //Get EditTexts
    EditText editTextPowerName = view.findViewById(R.id.editTextPowerName);
    EditText editTextPowerAPs = view.findViewById(R.id.editTextPowerAPs);

    //Assign Values
    String name = editTextPowerName.getText().toString();
    int APs = Integer.parseInt(editTextPowerAPs.getText().toString());

    System.out.println("Power: " + name + "\n" + "APs: " + APs);

    //Get character here and add the new power item.


    //Clear Inputs
    editTextPowerAPs.setText("");
    editTextPowerName.setText("");
  }


}
