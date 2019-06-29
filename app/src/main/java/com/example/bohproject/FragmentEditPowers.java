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
import com.example.ListAdapters.PowerAdapter;

/**
 * FragmentEditPowers is the fragment view for out Tab layout of editing a character's powers
 *
 * @author Collin Blake
 * @since 6-29-2019
 */
public class FragmentEditPowers extends Fragment implements OnClickListener {

  static final String TAG = "FragmentEditPowers";
  private PowerAdapter powerAdapter;
  View view;

  public FragmentEditPowers() {
  }


  /**
   * onCreateView to create both our button leistener and power list update function.
   *
   * @param inflater
   * @param container
   * @param savedInstanceState
   * @return
   */
  @Nullable
  @Override
  public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
      @Nullable Bundle savedInstanceState) {
    view = inflater.inflate(R.layout.edit_powers_fragment, container, false);


    Button b = (Button) view.findViewById(R.id.buttonPowerAdd);
    b.setOnClickListener(this);
    Log.i(TAG, "Added Button Listener");

    //Update Power List
    updatePowerList();

    //Adding long click deletion
    ListView lv = (ListView)view.findViewById(R.id.listViewPowers);
    lv.setOnItemLongClickListener(new OnItemLongClickListener() {

      @Override
      public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {

        Log.i(TAG, "Delete: " + ((EditActivity) getActivity()).character.getPowers().get(position).toString());
        ((EditActivity) getActivity()).character.getPowers().remove(position);

        //Update after deletion
        updatePowerList();
        return false;
      }
    });

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

  /**
   * onPowerAdd Funciton
   *
   */
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

    //Update Power List
    updatePowerList();
  }

  /**
   * Update our powerlist with the powers of character.
   */
  public void updatePowerList() {
    //Will use this to update our Powerlist later
    Log.i(TAG, "powerList Updating");
    powerAdapter = new PowerAdapter((EditActivity) getActivity(), ((EditActivity) getActivity()).character.getPowers());
    ListView listPowers = (ListView) view.findViewById(R.id.listViewPowers);
    listPowers.setAdapter(powerAdapter);
  }

}
