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

public class FragmentEditDrawAdvantage extends Fragment implements OnClickListener {

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

    System.out.println("Drawback/Advantage: " + name + "\n" + "Description: " + desc);

    //Get character here and add the new Drawback or advantage item.


    //Clear Inputs
    editTextName.setText("");
    editTextDescription.setText("");
  }

}
