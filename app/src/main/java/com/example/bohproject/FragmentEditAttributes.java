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
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;

/**
 * FragmentEdit {@link com.example.bohCharacter.Attributes} will allow you to edit a {@link
 * com.example.bohCharacter.Character}'s {@link com.example.bohCharacter.Attributes}
 *
 * Part of the {@link EditActivity}
 *
 * @Author Collin Blake
 * @since 6-29-2019
 */
public class FragmentEditAttributes extends Fragment {

  private static final String TAG = "FragmentEditAttributes";
  private View view;

  public FragmentEditAttributes() {
  }

  /**
   * onCreateView will create our metric ton of listeners which save the value once focus is lost it
   * worked better and caused less function calling instead of doing on change which caused a bunch
   * of issues
   */
  @Nullable
  @Override
  public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
      @Nullable Bundle savedInstanceState) {

    view = inflater.inflate(R.layout.edit_attributes_fragment, container, false);

    //Assign attribute values
    Log.i(TAG, "Assigning Values");

    //Physical
    Log.i(TAG, "Assigning Physical Values");
    TextView textView = view.findViewById(R.id.textStrValue);
    textView.setText(
        Integer.toString(((EditActivity) getActivity()).character.getAttributes().getStr()));
    textView = view.findViewById(R.id.textDexValue);
    textView.setText(
        Integer.toString(((EditActivity) getActivity()).character.getAttributes().getDex()));
    textView = view.findViewById(R.id.textBodyValue);
    textView.setText(
        Integer.toString(((EditActivity) getActivity()).character.getAttributes().getBody()));

    //Mental
    Log.i(TAG, "Assigning Mental Values");
    textView = view.findViewById(R.id.textIntValue);
    textView.setText(
        Integer.toString(((EditActivity) getActivity()).character.getAttributes().getInt()));
    textView = view.findViewById(R.id.textWillValue);
    textView.setText(
        Integer.toString(((EditActivity) getActivity()).character.getAttributes().getWill()));
    textView = view.findViewById(R.id.textMindValue);
    textView.setText(
        Integer.toString(((EditActivity) getActivity()).character.getAttributes().getMind()));

    //Spiritual
    Log.i(TAG, "Assigning Spiritual Values");
    textView = view.findViewById(R.id.textInflValue);
    textView.setText(
        Integer.toString(((EditActivity) getActivity()).character.getAttributes().getInfl()));
    textView = view.findViewById(R.id.textAuraValue);
    textView.setText(
        Integer.toString(((EditActivity) getActivity()).character.getAttributes().getAura()));
    textView = view.findViewById(R.id.textSpiritValue);
    textView.setText(
        Integer.toString(((EditActivity) getActivity()).character.getAttributes().getSpirit()));

    //Wealth & HeroPoints
    textView = view.findViewById(R.id.textWealthValue);
    textView.setText(
        Integer.toString(((EditActivity) getActivity()).character.getAttributes().getWealth()));
    textView = view.findViewById(R.id.textHeroPointsValue);
    textView.setText(
        Integer.toString(((EditActivity) getActivity()).character.getAttributes().getHeroPoints()));

    //addTextChangedListeners

    //Dex
    EditText editTextTemp = view.findViewById(R.id.textDexValue);
    editTextTemp.addTextChangedListener(new TextWatcher() {
      public void afterTextChanged(Editable s) {
        final EditText editText = view.findViewById(R.id.textDexValue);
        if (!(editText.getText().toString().matches(""))) {
          Log.i(TAG, "Dex Changed to: " + Integer.parseInt(editText.getText().toString()));
          ((EditActivity) getActivity()).character.getAttributes()
              .setDex(Integer.parseInt(editText.getText().toString()));
        }
      }

      public void beforeTextChanged(CharSequence s, int start, int count, int after) {
      }

      public void onTextChanged(CharSequence s, int start, int before, int count) {
      }
    });

    //Str
    editTextTemp = view.findViewById(R.id.textStrValue);
    editTextTemp.addTextChangedListener(new TextWatcher() {
      public void afterTextChanged(Editable s) {
        final EditText editText = view.findViewById(R.id.textStrValue);
        if (!(editText.getText().toString().matches(""))) {
          Log.i(TAG, "Str Changed to: " + Integer.parseInt(editText.getText().toString()));
          ((EditActivity) getActivity()).character.getAttributes()
              .setStr(Integer.parseInt(editText.getText().toString()));
        }
      }

      public void beforeTextChanged(CharSequence s, int start, int count, int after) {
      }

      public void onTextChanged(CharSequence s, int start, int before, int count) {
      }
    });

    //Body
    editTextTemp = view.findViewById(R.id.textBodyValue);
    editTextTemp.addTextChangedListener(new TextWatcher() {
      public void afterTextChanged(Editable s) {
        final EditText editText = view.findViewById(R.id.textBodyValue);
        if (!(editText.getText().toString().matches(""))) {
          Log.i(TAG, "Body Changed to: " + Integer.parseInt(editText.getText().toString()));
          ((EditActivity) getActivity()).character.getAttributes()
              .setBody(Integer.parseInt(editText.getText().toString()));
        }
      }

      public void beforeTextChanged(CharSequence s, int start, int count, int after) {
      }

      public void onTextChanged(CharSequence s, int start, int before, int count) {
      }
    });

    //Int
    editTextTemp = view.findViewById(R.id.textIntValue);
    editTextTemp.addTextChangedListener(new TextWatcher() {
      public void afterTextChanged(Editable s) {
        final EditText editText = view.findViewById(R.id.textIntValue);
        if (!(editText.getText().toString().matches(""))) {
          Log.i(TAG, "Int Changed to: " + Integer.parseInt(editText.getText().toString()));
          ((EditActivity) getActivity()).character.getAttributes()
              .setInt(Integer.parseInt(editText.getText().toString()));
        }
      }

      public void beforeTextChanged(CharSequence s, int start, int count, int after) {
      }

      public void onTextChanged(CharSequence s, int start, int before, int count) {
      }
    });

    //Will
    editTextTemp = view.findViewById(R.id.textWillValue);
    editTextTemp.addTextChangedListener(new TextWatcher() {
      public void afterTextChanged(Editable s) {
        final EditText editText = view.findViewById(R.id.textWillValue);
        if (!(editText.getText().toString().matches(""))) {
          Log.i(TAG, "Will Changed to: " + Integer.parseInt(editText.getText().toString()));
          ((EditActivity) getActivity()).character.getAttributes()
              .setWill(Integer.parseInt(editText.getText().toString()));
        }
      }

      public void beforeTextChanged(CharSequence s, int start, int count, int after) {
      }

      public void onTextChanged(CharSequence s, int start, int before, int count) {
      }
    });

    //Mind
    editTextTemp = view.findViewById(R.id.textMindValue);
    editTextTemp.addTextChangedListener(new TextWatcher() {
      public void afterTextChanged(Editable s) {
        final EditText editText = view.findViewById(R.id.textMindValue);
        if (!(editText.getText().toString().matches(""))) {
          Log.i(TAG, "Mind Changed to: " + Integer.parseInt(editText.getText().toString()));
          ((EditActivity) getActivity()).character.getAttributes()
              .setMind(Integer.parseInt(editText.getText().toString()));
        }
      }

      public void beforeTextChanged(CharSequence s, int start, int count, int after) {
      }

      public void onTextChanged(CharSequence s, int start, int before, int count) {
      }
    });

    //Infl
    editTextTemp = view.findViewById(R.id.textInflValue);
    editTextTemp.addTextChangedListener(new TextWatcher() {
      public void afterTextChanged(Editable s) {
        final EditText editText = view.findViewById(R.id.textInflValue);
        if (!(editText.getText().toString().matches(""))) {
          Log.i(TAG, "Infl Changed to: " + Integer.parseInt(editText.getText().toString()));
          ((EditActivity) getActivity()).character.getAttributes()
              .setInfl(Integer.parseInt(editText.getText().toString()));
        }
      }

      public void beforeTextChanged(CharSequence s, int start, int count, int after) {
      }

      public void onTextChanged(CharSequence s, int start, int before, int count) {
      }
    });

    //Aura
    editTextTemp = view.findViewById(R.id.textAuraValue);
    editTextTemp.addTextChangedListener(new TextWatcher() {
      public void afterTextChanged(Editable s) {
        final EditText editText = view.findViewById(R.id.textAuraValue);
        if (!(editText.getText().toString().matches(""))) {
          Log.i(TAG, "Aura Changed to: " + Integer.parseInt(editText.getText().toString()));
          ((EditActivity) getActivity()).character.getAttributes()
              .setAura(Integer.parseInt(editText.getText().toString()));
        }
      }

      public void beforeTextChanged(CharSequence s, int start, int count, int after) {
      }

      public void onTextChanged(CharSequence s, int start, int before, int count) {
      }
    });

    //Spirit
    editTextTemp = view.findViewById(R.id.textSpiritValue);
    editTextTemp.addTextChangedListener(new TextWatcher() {
      public void afterTextChanged(Editable s) {
        final EditText editText = view.findViewById(R.id.textSpiritValue);
        if (!(editText.getText().toString().matches(""))) {
          Log.i(TAG, "Spirit Changed to: " + Integer.parseInt(editText.getText().toString()));
          ((EditActivity) getActivity()).character.getAttributes()
              .setSpirit(Integer.parseInt(editText.getText().toString()));
        }
      }

      public void beforeTextChanged(CharSequence s, int start, int count, int after) {
      }

      public void onTextChanged(CharSequence s, int start, int before, int count) {
      }
    });

    //Wealth
    editTextTemp = view.findViewById(R.id.textWealthValue);
    editTextTemp.addTextChangedListener(new TextWatcher() {
      public void afterTextChanged(Editable s) {
        final EditText editText = view.findViewById(R.id.textWealthValue);
        if (!(editText.getText().toString().matches(""))) {
          Log.i(TAG, "Wealth Changed to: " + Integer.parseInt(editText.getText().toString()));
          ((EditActivity) getActivity()).character.getAttributes()
              .setWealth(Integer.parseInt(editText.getText().toString()));
        }
      }

      public void beforeTextChanged(CharSequence s, int start, int count, int after) {
      }

      public void onTextChanged(CharSequence s, int start, int before, int count) {
      }
    });

    //HeroPoints
    editTextTemp = view.findViewById(R.id.textHeroPointsValue);
    editTextTemp.addTextChangedListener(new TextWatcher() {
      public void afterTextChanged(Editable s) {
        final EditText editText = view.findViewById(R.id.textHeroPointsValue);
        if (!(editText.getText().toString().matches(""))) {
          Log.i(TAG, "Hero Points Changed to: " + Integer.parseInt(editText.getText().toString()));
          ((EditActivity) getActivity()).character.getAttributes()
              .setHeroPoints(Integer.parseInt(editText.getText().toString()));
        }
      }

      public void beforeTextChanged(CharSequence s, int start, int count, int after) {
      }

      public void onTextChanged(CharSequence s, int start, int before, int count) {
      }
    });

    return view;
  }
}
