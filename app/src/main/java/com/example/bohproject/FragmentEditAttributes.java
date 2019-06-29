package com.example.bohproject;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnFocusChangeListener;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;
import com.example.bohCharacter.Character;

public class FragmentEditAttributes extends Fragment {

  static final String TAG = "FragmentEditAttributes";
  View view;

  public FragmentEditAttributes() {
  }

  @Nullable
  @Override
  public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
      @Nullable Bundle savedInstanceState) {

    view = (View) inflater.inflate(R.layout.edit_attributes_fragment, container, false);

    //Assign attribute values
    Log.i(TAG, "Assigning Values");

    //Physical
    Log.i(TAG, "Assigning Physical Values");
    TextView textView = view.findViewById(R.id.textStrValue);
    textView.setText(Integer.toString(((EditActivity) getActivity()).character.getAttributes().getStr()));
    textView = view.findViewById(R.id.textDexValue);
    textView.setText(Integer.toString(((EditActivity) getActivity()).character.getAttributes().getDex()));
    textView = view.findViewById(R.id.textBodyValue);
    textView.setText(Integer.toString(((EditActivity) getActivity()).character.getAttributes().getBody()));

    //Mental
    Log.i(TAG, "Assigning Mental Values");
    textView = view.findViewById(R.id.textIntValue);
    textView.setText(Integer.toString(((EditActivity) getActivity()).character.getAttributes().getInt()));
    textView = view.findViewById(R.id.textWillValue);
    textView.setText(Integer.toString(((EditActivity) getActivity()).character.getAttributes().getWill()));
    textView = view.findViewById(R.id.textMindValue);
    textView.setText(Integer.toString(((EditActivity) getActivity()).character.getAttributes().getMind()));

    //Spiritual
    Log.i(TAG, "Assigning Spiritual Values");
    textView = view.findViewById(R.id.textInflValue);
    textView.setText(Integer.toString(((EditActivity) getActivity()).character.getAttributes().getInfl()));
    textView = view.findViewById(R.id.textAuraValue);
    textView.setText(Integer.toString(((EditActivity) getActivity()).character.getAttributes().getAura()));
    textView = view.findViewById(R.id.textSpiritValue);
    textView.setText(Integer.toString(((EditActivity) getActivity()).character.getAttributes().getSpirit()));

    //Wealth & HeroPoints
    textView = view.findViewById(R.id.textWealthValue);
    textView.setText(Integer.toString(((EditActivity) getActivity()).character.getAttributes().getWealth()));
    textView = view.findViewById(R.id.textHeroPointsValue);
    textView.setText(Integer.toString(((EditActivity) getActivity()).character.getAttributes().getHeroPoints()));


    //addTextChangedListeners

    //Dex
    EditText editTextTemp = (EditText) view.findViewById(R.id.textDexValue);
    editTextTemp.setOnFocusChangeListener(new OnFocusChangeListener() {

      public void onFocusChange(View v, boolean hasFocus) {


        if (hasFocus) {
          // If view having focus.
        } else {
          final EditText editText = (EditText) view.findViewById(R.id.textDexValue);
          if (!(editText.getText().toString().matches(""))) {
            Log.i(TAG, "Dex Changed to: " + editText.getText());
            ((EditActivity) getActivity()).character.getAttributes()
                .setDex(Integer.parseInt(editText.getText().toString()));
          }
        }
      }
    });

    //Str
    editTextTemp = (EditText) view.findViewById(R.id.textStrValue);
    editTextTemp.setOnFocusChangeListener(new OnFocusChangeListener() {

      public void onFocusChange(View v, boolean hasFocus) {


        if (hasFocus) {
          // If view having focus.
        } else {
          final EditText editText = (EditText) view.findViewById(R.id.textStrValue);
          if (!(editText.getText().toString().matches(""))) {
            Log.i(TAG, "Str Changed to: " + editText.getText());
            ((EditActivity) getActivity()).character.getAttributes()
                .setStr(Integer.parseInt(editText.getText().toString()));
          }
        }
      }
    });

    //Body
    editTextTemp = (EditText) view.findViewById(R.id.textBodyValue);
    editTextTemp.setOnFocusChangeListener(new OnFocusChangeListener() {

      public void onFocusChange(View v, boolean hasFocus) {


        if (hasFocus) {
          // If view having focus.
        } else {
          final EditText editText = (EditText) view.findViewById(R.id.textBodyValue);
          if (!(editText.getText().toString().matches(""))) {
            Log.i(TAG, "Body Changed to: " + editText.getText());
            ((EditActivity) getActivity()).character.getAttributes()
                .setBody(Integer.parseInt(editText.getText().toString()));
          }
        }
      }
    });

    //Int
    editTextTemp = (EditText) view.findViewById(R.id.textIntValue);
    editTextTemp.setOnFocusChangeListener(new OnFocusChangeListener() {

      public void onFocusChange(View v, boolean hasFocus) {


        if (hasFocus) {
          // If view having focus.
        } else {
          final EditText editText = (EditText) view.findViewById(R.id.textIntValue);
          if (!(editText.getText().toString().matches(""))) {
            Log.i(TAG, "Int Changed to: " + editText.getText());
            ((EditActivity) getActivity()).character.getAttributes()
                .setInt(Integer.parseInt(editText.getText().toString()));
          }
        }
      }
    });

    //Will
    editTextTemp = (EditText) view.findViewById(R.id.textWillValue);
    editTextTemp.setOnFocusChangeListener(new OnFocusChangeListener() {

      public void onFocusChange(View v, boolean hasFocus) {


        if (hasFocus) {
          // If view having focus.
        } else {
          final EditText editText = (EditText) view.findViewById(R.id.textWillValue);
          if (!(editText.getText().toString().matches(""))) {
            Log.i(TAG, "Will Changed to: " + editText.getText());
            ((EditActivity) getActivity()).character.getAttributes()
                .setWill(Integer.parseInt(editText.getText().toString()));
          }
        }
      }
    });

    //Mind
    editTextTemp = (EditText) view.findViewById(R.id.textMindValue);
    editTextTemp.setOnFocusChangeListener(new OnFocusChangeListener() {

      public void onFocusChange(View v, boolean hasFocus) {


        if (hasFocus) {
          // If view having focus.
        } else {
          final EditText editText = (EditText) view.findViewById(R.id.textMindValue);
          if (!(editText.getText().toString().matches(""))) {
            Log.i(TAG, "Mind Changed to: " + editText.getText());
            ((EditActivity) getActivity()).character.getAttributes()
                .setMind(Integer.parseInt(editText.getText().toString()));
          }
        }
      }
    });

    //Infl
    editTextTemp = (EditText) view.findViewById(R.id.textInflValue);
    editTextTemp.setOnFocusChangeListener(new OnFocusChangeListener() {

      public void onFocusChange(View v, boolean hasFocus) {


        if (hasFocus) {
          // If view having focus.
        } else {
          final EditText editText = (EditText) view.findViewById(R.id.textInflValue);
          if (!(editText.getText().toString().matches(""))) {
            Log.i(TAG, "Infl Changed to: " + editText.getText());
            ((EditActivity) getActivity()).character.getAttributes()
                .setInfl(Integer.parseInt(editText.getText().toString()));
          }
        }
      }
    });

    //Aura
    editTextTemp = (EditText) view.findViewById(R.id.textAuraValue);
    editTextTemp.setOnFocusChangeListener(new OnFocusChangeListener() {

      public void onFocusChange(View v, boolean hasFocus) {


        if (hasFocus) {
          // If view having focus.
        } else {
          final EditText editText = (EditText) view.findViewById(R.id.textAuraValue);
          if (!(editText.getText().toString().matches(""))) {
            Log.i(TAG, "Aura Changed to: " + editText.getText());
            ((EditActivity) getActivity()).character.getAttributes()
                .setAura(Integer.parseInt(editText.getText().toString()));
          }
        }
      }
    });

    //Spirit
    editTextTemp = (EditText) view.findViewById(R.id.textSpiritValue);
    editTextTemp.setOnFocusChangeListener(new OnFocusChangeListener() {

      public void onFocusChange(View v, boolean hasFocus) {


        if (hasFocus) {
          // If view having focus.
        } else {
          final EditText editText = (EditText) view.findViewById(R.id.textSpiritValue);
          if (!(editText.getText().toString().matches(""))) {
            Log.i(TAG, "Spirit Changed to: " + editText.getText());
            ((EditActivity) getActivity()).character.getAttributes()
                .setSpirit(Integer.parseInt(editText.getText().toString()));
          }
        }
      }
    });

    //Wealth
    editTextTemp = (EditText) view.findViewById(R.id.textWealthValue);
    editTextTemp.setOnFocusChangeListener(new OnFocusChangeListener() {

      public void onFocusChange(View v, boolean hasFocus) {


        if (hasFocus) {
          // If view having focus.
        } else {
          final EditText editText = (EditText) view.findViewById(R.id.textWealthValue);
          if (!(editText.getText().toString().matches(""))) {
            Log.i(TAG, "Wealth Changed to: " + editText.getText());
            ((EditActivity) getActivity()).character.getAttributes()
                .setWealth(Integer.parseInt(editText.getText().toString()));
          }
        }
      }
    });
    //HeroPoints
    editTextTemp = (EditText) view.findViewById(R.id.textHeroPointsValue);
    editTextTemp.setOnFocusChangeListener(new OnFocusChangeListener() {

      public void onFocusChange(View v, boolean hasFocus) {


        if (hasFocus) {
          // If view having focus.
        } else {
          final EditText editText = (EditText) view.findViewById(R.id.textHeroPointsValue);
          if (!(editText.getText().toString().matches(""))) {
            Log.i(TAG, "Dex Changed to: " + editText.getText());
            ((EditActivity) getActivity()).character.getAttributes()
                .setHeroPoints(Integer.parseInt(editText.getText().toString()));
          }
        }
      }
    });

    return view;
  }
}
