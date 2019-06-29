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
import com.example.ListAdapters.DrawAdvanAdapter;
import com.example.bohCharacter.DrawAdvantage;

/**
 * FragmentEditDrawAdvantage is the fragment view for out Tab layout of editing a character's
 * drawbacks & advantages
 *
 * @author Collin Blake
 * @since 6-29-2019
 */
public class FragmentEditDrawAdvantage extends Fragment implements OnClickListener {

  static final String TAG = "FragmentEditDrawAdvant";
  View view;
  DrawAdvanAdapter drawAdvanAdapter;

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


    //Adding long click deletion
    ListView lv = (ListView)view.findViewById(R.id.listViewDrawAdvan);
    lv.setOnItemLongClickListener(new OnItemLongClickListener() {

      @Override
      public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {

        Log.i(TAG, "Delete: " + ((EditActivity) getActivity()).character.getDrawAdvantages().get(position).toString());
        ((EditActivity) getActivity()).character.getDrawAdvantages().remove(position);

        //Update after deletion
        updateDrawAdvanList();
        return false;
      }
    });

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
    ((EditActivity) getActivity()).character.getDrawAdvantages().add(new DrawAdvantage(name,desc));

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
    drawAdvanAdapter = new DrawAdvanAdapter((EditActivity) getActivity(), ((EditActivity) getActivity()).character.getDrawAdvantages());
    ListView listDrawAdvans = (ListView) view.findViewById(R.id.listViewDrawAdvan);
    listDrawAdvans.setAdapter(drawAdvanAdapter);
  }

}
