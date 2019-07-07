package com.example.bohproject;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemLongClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import com.example.ListAdapters.KnownRelationsAdapter;


/**
 * FragmentEditDescription for editing our {@link com.example.bohCharacter.Character}'s {@link
 * com.example.bohCharacter.Description} values
 *
 * Part of the {@link EditActivity}
 *
 * @author Collin Blake
 * @since 6-29-2019
 */
public class FragmentEditDescription extends Fragment implements OnClickListener {

  private static final String TAG = "FragmentEditDescription";
  private KnownRelationsAdapter knownRelationsAdapter;
  private View view;

  public FragmentEditDescription() {
  }

  /**
   * onCreateView will add all our listeners that will update the {@link
   * com.example.bohCharacter.Character} class in real-time every time you enter a value for editing
   * our {@link com.example.bohCharacter.Description}.
   */
  @Nullable
  @Override
  public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
      @Nullable Bundle savedInstanceState) {
    view = inflater.inflate(R.layout.edit_description_fragment, container, false);

    //Add Button Listener
    Button b = view.findViewById(R.id.buttonAddRelative);
    b.setOnClickListener(this);

    //Name Listener
    EditText editTextTemp = view.findViewById(R.id.textNameValue);
    editTextTemp.setText(((EditActivity) getActivity()).character.getDescription().getName());
    editTextTemp.addTextChangedListener(new TextWatcher() {
      public void afterTextChanged(Editable s) {
        final EditText editText = view.findViewById(R.id.textNameValue);
        Log.i(TAG, "Name Changed to: " + editText.getText());
        ((EditActivity) getActivity()).character.getDescription()
            .setName(editText.getText().toString());
      }

      public void beforeTextChanged(CharSequence s, int start, int count, int after) {
      }

      public void onTextChanged(CharSequence s, int start, int before, int count) {
      }
    });

    //Character Type Listener
    editTextTemp = view.findViewById(R.id.textTypeValue);
    editTextTemp.setText(((EditActivity) getActivity()).character.getDescription().getType());
    editTextTemp.addTextChangedListener(new TextWatcher() {
      public void afterTextChanged(Editable s) {
        final EditText editText = view.findViewById(R.id.textTypeValue);
        Log.i(TAG, "Type Changed to: " + editText.getText());
        ((EditActivity) getActivity()).character.getDescription()
            .setType(editText.getText().toString());
      }

      public void beforeTextChanged(CharSequence s, int start, int count, int after) {
      }

      public void onTextChanged(CharSequence s, int start, int before, int count) {
      }
    });

    //Motivation Listener
    editTextTemp = view.findViewById(R.id.textMotivationValue);
    editTextTemp.setText(((EditActivity) getActivity()).character.getDescription().getMotivation());
    editTextTemp.addTextChangedListener(new TextWatcher() {
      public void afterTextChanged(Editable s) {
        final EditText editText = view.findViewById(R.id.textMotivationValue);
        Log.i(TAG, "Motivation Changed to: " + editText.getText());
        ((EditActivity) getActivity()).character.getDescription()
            .setMotivation(editText.getText().toString());
      }

      public void beforeTextChanged(CharSequence s, int start, int count, int after) {
      }

      public void onTextChanged(CharSequence s, int start, int before, int count) {
      }
    });

    //Alter Ego Listener
    editTextTemp = view.findViewById(R.id.textAlterEgoValue);
    editTextTemp.setText(((EditActivity) getActivity()).character.getDescription().getAlterEgo());
    editTextTemp.addTextChangedListener(new TextWatcher() {
      public void afterTextChanged(Editable s) {
        final EditText editText = view.findViewById(R.id.textAlterEgoValue);
        Log.i(TAG, "Alter Ego Changed to: " + editText.getText());
        ((EditActivity) getActivity()).character.getDescription()
            .setAlterEgo(editText.getText().toString());
      }

      public void beforeTextChanged(CharSequence s, int start, int count, int after) {
      }

      public void onTextChanged(CharSequence s, int start, int before, int count) {
      }
    });

    //Height Listener
    editTextTemp = view.findViewById(R.id.textHeightValue);
    editTextTemp.setText(((EditActivity) getActivity()).character.getDescription().getHeight());
    editTextTemp.addTextChangedListener(new TextWatcher() {
      public void afterTextChanged(Editable s) {
        final EditText editText = view.findViewById(R.id.textHeightValue);
        Log.i(TAG, "Height Changed to: " + editText.getText());
        ((EditActivity) getActivity()).character.getDescription()
            .setHeight(editText.getText().toString());
      }

      public void beforeTextChanged(CharSequence s, int start, int count, int after) {
      }

      public void onTextChanged(CharSequence s, int start, int before, int count) {
      }
    });

    //Weight Listener
    editTextTemp = view.findViewById(R.id.textWeightValue);
    editTextTemp.setText(((EditActivity) getActivity()).character.getDescription().getWeight());
    editTextTemp.addTextChangedListener(new TextWatcher() {
      public void afterTextChanged(Editable s) {
        final EditText editText = view.findViewById(R.id.textWeightValue);
        Log.i(TAG, "Weight Changed to: " + editText.getText());
        ((EditActivity) getActivity()).character.getDescription()
            .setWeight(editText.getText().toString());
      }

      public void beforeTextChanged(CharSequence s, int start, int count, int after) {
      }

      public void onTextChanged(CharSequence s, int start, int before, int count) {
      }
    });

    //Hair color Listener
    editTextTemp = view.findViewById(R.id.textHairValue);
    editTextTemp.setText(((EditActivity) getActivity()).character.getDescription().getHairColor());
    editTextTemp.addTextChangedListener(new TextWatcher() {
      public void afterTextChanged(Editable s) {
        final EditText editText = view.findViewById(R.id.textHairValue);
        Log.i(TAG, "Hair Color Changed to: " + editText.getText());
        ((EditActivity) getActivity()).character.getDescription()
            .setHairColor(editText.getText().toString());
      }

      public void beforeTextChanged(CharSequence s, int start, int count, int after) {
      }

      public void onTextChanged(CharSequence s, int start, int before, int count) {
      }
    });

    //Eye Listener
    editTextTemp = view.findViewById(R.id.textEyeValue);
    editTextTemp.setText(((EditActivity) getActivity()).character.getDescription().getEyeColor());
    editTextTemp.addTextChangedListener(new TextWatcher() {
      public void afterTextChanged(Editable s) {
        final EditText editText = view.findViewById(R.id.textEyeValue);
        Log.i(TAG, "Eye Color Changed to: " + editText.getText());
        ((EditActivity) getActivity()).character.getDescription()
            .setEyeColor(editText.getText().toString());
      }

      public void beforeTextChanged(CharSequence s, int start, int count, int after) {
      }

      public void onTextChanged(CharSequence s, int start, int before, int count) {
      }
    });

    //Group Affiliation Listener
    editTextTemp = view.findViewById(R.id.textGroupAffiliationValue);
    editTextTemp
        .setText(((EditActivity) getActivity()).character.getDescription().getGroupAffiliation());
    editTextTemp.addTextChangedListener(new TextWatcher() {
      public void afterTextChanged(Editable s) {
        final EditText editText = view.findViewById(R.id.textGroupAffiliationValue);
        Log.i(TAG, "Group Affiliation Changed to: " + editText.getText());
        ((EditActivity) getActivity()).character.getDescription()
            .setGroupAffiliation(editText.getText().toString());
      }

      public void beforeTextChanged(CharSequence s, int start, int count, int after) {
      }

      public void onTextChanged(CharSequence s, int start, int before, int count) {
      }
    });

    //Occupation Listener
    editTextTemp = view.findViewById(R.id.textOccupationValue);
    editTextTemp.setText(((EditActivity) getActivity()).character.getDescription().getOccupation());
    editTextTemp.addTextChangedListener(new TextWatcher() {
      public void afterTextChanged(Editable s) {
        final EditText editText = view.findViewById(R.id.textOccupationValue);
        Log.i(TAG, "Occupation Changed to: " + editText.getText());
        ((EditActivity) getActivity()).character.getDescription()
            .setOccupation(editText.getText().toString());
      }

      public void beforeTextChanged(CharSequence s, int start, int count, int after) {
      }

      public void onTextChanged(CharSequence s, int start, int before, int count) {
      }
    });

    //Base of Operations Listener
    editTextTemp = view.findViewById(R.id.textBaseOfOperationsValue);
    editTextTemp
        .setText(((EditActivity) getActivity()).character.getDescription().getBaseOfOperations());
    editTextTemp.addTextChangedListener(new TextWatcher() {
      public void afterTextChanged(Editable s) {
        final EditText editText = view.findViewById(R.id.textBaseOfOperationsValue);
        Log.i(TAG, "Base of Operations Changed to: " + editText.getText());
        ((EditActivity) getActivity()).character.getDescription()
            .setBaseOfOperations(editText.getText().toString());
      }

      public void beforeTextChanged(CharSequence s, int start, int count, int after) {
      }

      public void onTextChanged(CharSequence s, int start, int before, int count) {
      }
    });

    //Martial Status Listener
    editTextTemp = view.findViewById(R.id.textMartialStatusValue);
    editTextTemp
        .setText(((EditActivity) getActivity()).character.getDescription().getMartialStatus());
    editTextTemp.addTextChangedListener(new TextWatcher() {
      public void afterTextChanged(Editable s) {
        final EditText editText = view.findViewById(R.id.textMartialStatusValue);
        Log.i(TAG, "Martial Status Changed to: " + editText.getText());
        ((EditActivity) getActivity()).character.getDescription()
            .setMartialStatus(editText.getText().toString());
      }

      public void beforeTextChanged(CharSequence s, int start, int count, int after) {
      }

      public void onTextChanged(CharSequence s, int start, int before, int count) {
      }
    });

    //Personality Listener
    editTextTemp = view.findViewById(R.id.textPersonalityValue);
    editTextTemp
        .setText(((EditActivity) getActivity()).character.getDescription().getPersonality());
    editTextTemp.addTextChangedListener(new TextWatcher() {
      public void afterTextChanged(Editable s) {
        final EditText editText = view.findViewById(R.id.textPersonalityValue);
        Log.i(TAG, "Personality Changed to: " + editText.getText());
        ((EditActivity) getActivity()).character.getDescription()
            .setPersonality(editText.getText().toString());
      }

      public void beforeTextChanged(CharSequence s, int start, int count, int after) {
      }

      public void onTextChanged(CharSequence s, int start, int before, int count) {
      }
    });

    //History Listener
    editTextTemp = view.findViewById(R.id.textHistoryValue);
    editTextTemp.setText(((EditActivity) getActivity()).character.getDescription().getHistory());
    editTextTemp.addTextChangedListener(new TextWatcher() {
      public void afterTextChanged(Editable s) {
        final EditText editText = view.findViewById(R.id.textHistoryValue);
        Log.i(TAG, "History Changed to: " + editText.getText());
        ((EditActivity) getActivity()).character.getDescription()
            .setHistory(editText.getText().toString());
      }

      public void beforeTextChanged(CharSequence s, int start, int count, int after) {
      }

      public void onTextChanged(CharSequence s, int start, int before, int count) {
      }
    });

    //Description Listener
    editTextTemp = view.findViewById(R.id.textDescriptionValue);
    editTextTemp
        .setText(((EditActivity) getActivity()).character.getDescription().getDescription());
    editTextTemp.addTextChangedListener(new TextWatcher() {
      public void afterTextChanged(Editable s) {
        final EditText editText = view.findViewById(R.id.textDescriptionValue);
        Log.i(TAG, "Description Changed to: " + editText.getText());
        ((EditActivity) getActivity()).character.getDescription()
            .setDescription(editText.getText().toString());
      }

      public void beforeTextChanged(CharSequence s, int start, int count, int after) {
      }

      public void onTextChanged(CharSequence s, int start, int before, int count) {
      }
    });

    //KnownRelations Fix
    ListView lv = view.findViewById(R.id.listViewKnownRelatives);
    lv.setOnTouchListener(new ListView.OnTouchListener() {
      @Override
      public boolean onTouch(View v, MotionEvent event) {
        int action = event.getAction();
        switch (action) {
          case MotionEvent.ACTION_DOWN:
            // Disallow ScrollView to intercept touch events.
            v.getParent().requestDisallowInterceptTouchEvent(true);
            break;

          case MotionEvent.ACTION_UP:
            // Allow ScrollView to intercept touch events.
            v.getParent().requestDisallowInterceptTouchEvent(false);
            break;
        }

        // Handle ListView touch events.
        v.onTouchEvent(event);
        return true;
      }

    });
    //Adding long click deletion
    lv.setOnItemLongClickListener(new OnItemLongClickListener() {

      @Override
      public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
        Log.i(TAG, "Delete: " + ((EditActivity) getActivity()).character.getDescription()
            .getKnownRelatives().get(position));
        ((EditActivity) getActivity()).character.getDescription().getKnownRelatives()
            .remove(position);

        //Update after deletion
        updateRelationsList();
        return false;
      }
    });

    //Update relations List
    updateRelationsList();

    return view;
  }

  /**
   * Button Switch
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

    Log.i(TAG, "Relative: " + name + " Added");

    //Get character here and add the new Relative.
    ((EditActivity) getActivity()).character.getDescription().getKnownRelatives().add(name);

    //Clear Inputs
    editTextRelative.setText("");

    //Update relations List
    updateRelationsList();
  }

  public void updateRelationsList() {
    //Update List
    Log.i(TAG, "Update Relations List");
    knownRelationsAdapter = new KnownRelationsAdapter(getActivity(),
        ((EditActivity) getActivity()).character.getDescription().getKnownRelatives());
    ListView listRelations = view.findViewById(R.id.listViewKnownRelatives);
    listRelations.setAdapter(knownRelationsAdapter);
  }


}
