package com.example.bohproject;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnFocusChangeListener;
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

  static final String TAG = "FragmentEditDescription";
  KnownRelationsAdapter knownRelationsAdapter;
  View view;

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
    Button b = (Button) view.findViewById(R.id.buttonAddRelative);
    b.setOnClickListener(this);

    //Name Listener
    EditText editTextTemp = (EditText) view.findViewById(R.id.textNameValue);
    editTextTemp.setOnFocusChangeListener(new OnFocusChangeListener() {

      public void onFocusChange(View v, boolean hasFocus) {

        if (hasFocus) {
          // If view having focus.
        } else {
          final EditText editText = (EditText) view.findViewById(R.id.textNameValue);
          Log.i(TAG, "Name Changed to: " + editText.getText());
          ((EditActivity) getActivity()).character.getDescription()
              .setName(editText.getText().toString());

        }
      }
    });

    //Character Type Listener
    editTextTemp = (EditText) view.findViewById(R.id.textTypeValue);
    editTextTemp.setOnFocusChangeListener(new OnFocusChangeListener() {

      public void onFocusChange(View v, boolean hasFocus) {

        if (hasFocus) {
          // If view having focus.
        } else {
          final EditText editText = (EditText) view.findViewById(R.id.textTypeValue);
          Log.i(TAG, "Character Type Changed to: " + editText.getText());
          ((EditActivity) getActivity()).character.getDescription()
              .setType(editText.getText().toString());

        }
      }
    });

    //Motivation Listener
    editTextTemp = (EditText) view.findViewById(R.id.textMotivationValue);
    editTextTemp.setOnFocusChangeListener(new OnFocusChangeListener() {

      public void onFocusChange(View v, boolean hasFocus) {

        if (hasFocus) {
          // If view having focus.
        } else {
          final EditText editText = (EditText) view.findViewById(R.id.textMotivationValue);
          Log.i(TAG, "Motivation Changed to: " + editText.getText());
          ((EditActivity) getActivity()).character.getDescription()
              .setMotivation(editText.getText().toString());

        }
      }
    });

    //Alter Ego Listener
    editTextTemp = (EditText) view.findViewById(R.id.textAlterEgoValue);
    editTextTemp.setOnFocusChangeListener(new OnFocusChangeListener() {

      public void onFocusChange(View v, boolean hasFocus) {

        if (hasFocus) {
          // If view having focus.
        } else {
          final EditText editText = (EditText) view.findViewById(R.id.textAlterEgoValue);
          Log.i(TAG, "Alter Ego Changed to: " + editText.getText());
          ((EditActivity) getActivity()).character.getDescription()
              .setAlterEgo(editText.getText().toString());

        }
      }
    });

    //Height Listener
    editTextTemp = (EditText) view.findViewById(R.id.textHeightValue);
    editTextTemp.setOnFocusChangeListener(new OnFocusChangeListener() {

      public void onFocusChange(View v, boolean hasFocus) {

        if (hasFocus) {
          // If view having focus.
        } else {
          final EditText editText = (EditText) view.findViewById(R.id.textHeightValue);
          Log.i(TAG, "Height Changed to: " + editText.getText());
          ((EditActivity) getActivity()).character.getDescription()
              .setHeight(editText.getText().toString());

        }
      }
    });

    //Weight Listener
    editTextTemp = (EditText) view.findViewById(R.id.textWeightValue);
    editTextTemp.setOnFocusChangeListener(new OnFocusChangeListener() {

      public void onFocusChange(View v, boolean hasFocus) {

        if (hasFocus) {
          // If view having focus.
        } else {
          final EditText editText = (EditText) view.findViewById(R.id.textWeightValue);
          Log.i(TAG, "Weight Changed to: " + editText.getText());
          ((EditActivity) getActivity()).character.getDescription()
              .setWeight(editText.getText().toString());

        }
      }
    });

    //Hair color Listener
    editTextTemp = (EditText) view.findViewById(R.id.textHairValue);
    editTextTemp.setOnFocusChangeListener(new OnFocusChangeListener() {

      public void onFocusChange(View v, boolean hasFocus) {

        if (hasFocus) {
          // If view having focus.
        } else {
          final EditText editText = (EditText) view.findViewById(R.id.textHairValue);
          Log.i(TAG, "Hair Color Changed to: " + editText.getText());
          ((EditActivity) getActivity()).character.getDescription()
              .setName(editText.getText().toString());
        }
      }
    });

    //Eye Listener
    editTextTemp = (EditText) view.findViewById(R.id.textEyeValue);
    editTextTemp.setOnFocusChangeListener(new OnFocusChangeListener() {

      public void onFocusChange(View v, boolean hasFocus) {

        if (hasFocus) {
          // If view having focus.
        } else {
          final EditText editText = (EditText) view.findViewById(R.id.textEyeValue);
          Log.i(TAG, "Eye Color Changed to: " + editText.getText());
          ((EditActivity) getActivity()).character.getDescription()
              .setEyeColor(editText.getText().toString());
        }
      }
    });

    //Group Affiliation Listener
    editTextTemp = (EditText) view.findViewById(R.id.textGroupAffiliationValue);
    editTextTemp.setOnFocusChangeListener(new OnFocusChangeListener() {

      public void onFocusChange(View v, boolean hasFocus) {

        if (hasFocus) {
          // If view having focus.
        } else {
          final EditText editText = (EditText) view.findViewById(R.id.textGroupAffiliationValue);
          Log.i(TAG, "Group Affiliation Changed to: " + editText.getText());
          ((EditActivity) getActivity()).character.getDescription()
              .setGroupAffiliation(editText.getText().toString());
        }
      }
    });

    //Occupation Listener
    editTextTemp = (EditText) view.findViewById(R.id.textOccupationValue);
    editTextTemp.setOnFocusChangeListener(new OnFocusChangeListener() {

      public void onFocusChange(View v, boolean hasFocus) {

        if (hasFocus) {
          // If view having focus.
        } else {
          final EditText editText = (EditText) view.findViewById(R.id.textOccupationValue);
          Log.i(TAG, "Occupation Changed to: " + editText.getText());
          ((EditActivity) getActivity()).character.getDescription()
              .setOccupation(editText.getText().toString());
        }
      }
    });

    //Base of Operations Listener
    editTextTemp = (EditText) view.findViewById(R.id.textBaseOfOperationsValue);
    editTextTemp.setOnFocusChangeListener(new OnFocusChangeListener() {

      public void onFocusChange(View v, boolean hasFocus) {

        if (hasFocus) {
          // If view having focus.
        } else {
          final EditText editText = (EditText) view.findViewById(R.id.textBaseOfOperationsValue);
          Log.i(TAG, "Base of Operations Changed to: " + editText.getText());
          ((EditActivity) getActivity()).character.getDescription()
              .setBaseOfOperations(editText.getText().toString());
        }
      }
    });

    //Martial Status Listener
    editTextTemp = (EditText) view.findViewById(R.id.textMartialStatusValue);
    editTextTemp.setOnFocusChangeListener(new OnFocusChangeListener() {

      public void onFocusChange(View v, boolean hasFocus) {

        if (hasFocus) {
          // If view having focus.
        } else {
          final EditText editText = (EditText) view.findViewById(R.id.textMartialStatusValue);
          Log.i(TAG, "Martial Status Changed to: " + editText.getText());
          ((EditActivity) getActivity()).character.getDescription()
              .setMartialStatus(editText.getText().toString());
        }
      }
    });

    //Personality Listener
    editTextTemp = (EditText) view.findViewById(R.id.textPersonalityValue);
    editTextTemp.setOnFocusChangeListener(new OnFocusChangeListener() {

      public void onFocusChange(View v, boolean hasFocus) {

        if (hasFocus) {
          // If view having focus.
        } else {
          final EditText editText = (EditText) view.findViewById(R.id.textPersonalityValue);
          Log.i(TAG, "Personality Changed to: " + editText.getText());
          ((EditActivity) getActivity()).character.getDescription()
              .setPersonality(editText.getText().toString());
        }
      }
    });

    //History Listener
    editTextTemp = (EditText) view.findViewById(R.id.textHistoryValue);
    editTextTemp.setOnFocusChangeListener(new OnFocusChangeListener() {

      public void onFocusChange(View v, boolean hasFocus) {

        if (hasFocus) {
          // If view having focus.
        } else {
          final EditText editText = (EditText) view.findViewById(R.id.textHistoryValue);
          Log.i(TAG, "History Changed to: " + editText.getText());
          ((EditActivity) getActivity()).character.getDescription()
              .setHistory(editText.getText().toString());
        }
      }
    });

    //Description Listener
    editTextTemp = (EditText) view.findViewById(R.id.textDescriptionValue);
    editTextTemp.setOnFocusChangeListener(new OnFocusChangeListener() {

      public void onFocusChange(View v, boolean hasFocus) {

        if (hasFocus) {
          // If view having focus.
        } else {
          final EditText editText = (EditText) view.findViewById(R.id.textDescriptionValue);
          Log.i(TAG, "Description Changed to: " + editText.getText());
          ((EditActivity) getActivity()).character.getDescription()
              .setDescription(editText.getText().toString());
        }
      }
    });

    //KnownRelations Fix
    ListView lv = (ListView) view.findViewById(R.id.listViewKnownRelatives);
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
    knownRelationsAdapter = new KnownRelationsAdapter((EditActivity) getActivity(),
        ((EditActivity) getActivity()).character.getDescription().getKnownRelatives());
    ListView listRelations = (ListView) view.findViewById(R.id.listViewKnownRelatives);
    listRelations.setAdapter(knownRelationsAdapter);
  }


}
