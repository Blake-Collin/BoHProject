package com.example.bohproject;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

/**
 * FragmentView {@link com.example.bohCharacter.Attributes} will allow you to view a {@link
 * com.example.bohCharacter.Character}'s {@link com.example.bohCharacter.Attributes}
 *
 * Part of the {@link ViewActivity}
 *
 * @Author Collin Blake
 * @since 6-29-2019
 */
public class FragmentViewAttributes extends Fragment {

  private static final String TAG = "FragmentViewAttributes";
  private View view;


  @Nullable
  @Override
  public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
      @Nullable Bundle savedInstanceState) {

    view = inflater.inflate(R.layout.view_attributes_fragment, container, false);

    //Assign attribute values
    Log.i(TAG, "Assigning Values");

    //Physical
    Log.i(TAG, "Assigning Physical Values");
    TextView textView = view.findViewById(R.id.textStrValue);
    textView.setText(
        Integer.toString(((ViewActivity) getActivity()).character.getAttributes().getStr()));
    textView = view.findViewById(R.id.textDexValue);
    textView.setText(
        Integer.toString(((ViewActivity) getActivity()).character.getAttributes().getDex()));
    textView = view.findViewById(R.id.textBodyValue);
    textView.setText(
        Integer.toString(((ViewActivity) getActivity()).character.getAttributes().getBody()));

    //Mental
    Log.i(TAG, "Assigning Mental Values");
    textView = view.findViewById(R.id.textIntValue);
    textView.setText(
        Integer.toString(((ViewActivity) getActivity()).character.getAttributes().getInt()));
    textView = view.findViewById(R.id.textWillValue);
    textView.setText(
        Integer.toString(((ViewActivity) getActivity()).character.getAttributes().getWill()));
    textView = view.findViewById(R.id.textMindValue);
    textView.setText(
        Integer.toString(((ViewActivity) getActivity()).character.getAttributes().getMind()));

    //Spiritual
    Log.i(TAG, "Assigning Spiritual Values");
    textView = view.findViewById(R.id.textInflValue);
    textView.setText(
        Integer.toString(((ViewActivity) getActivity()).character.getAttributes().getInfl()));
    textView = view.findViewById(R.id.textAuraValue);
    textView.setText(
        Integer.toString(((ViewActivity) getActivity()).character.getAttributes().getAura()));
    textView = view.findViewById(R.id.textSpiritValue);
    textView.setText(
        Integer.toString(((ViewActivity) getActivity()).character.getAttributes().getSpirit()));

    //Wealth & HeroPoints
    textView = view.findViewById(R.id.textWealthValue);
    textView.setText(
        Integer.toString(((ViewActivity) getActivity()).character.getAttributes().getWealth()));
    textView = view.findViewById(R.id.textHeroPointsValue);
    textView.setText(
        Integer.toString(((ViewActivity) getActivity()).character.getAttributes().getHeroPoints()));

    return view;
  }
}
