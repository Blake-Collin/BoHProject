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

public class FragmentEditDescription extends Fragment implements OnClickListener {

  View view;

  public FragmentEditDescription() {
  }

  @Nullable
  @Override
  public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
      @Nullable Bundle savedInstanceState) {
    view = inflater.inflate(R.layout.edit_description_fragment, container, false);

    //Add Button Listener
    Button b = (Button) view.findViewById(R.id.buttonAddRelative);
    b.setOnClickListener(this);

    return view;
  }

  /**
   * Button Switch
   * @param v
   */
  public void onClick(View v) {
    switch (v.getId()) {
      case R.id.buttonAddRelative:
        onRelativeAdd();
        break;
      default:
        break;
    }
  }

  public void onRelativeAdd() {
    //Get EditTexts
    EditText editTextRelative = view.findViewById(R.id.editTextRelativeAdd);

    //Assign Values
    String name = editTextRelative.getText().toString();

    System.out.println("Relative: " + name);

    //Get character here and add the new Relative.


    //Clear Inputs
    editTextRelative.setText("");
  }

}
