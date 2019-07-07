package com.example.bohproject;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.TextView;
import com.example.ListAdapters.KnownRelationsAdapter;

/**
 * FragmentViewDescription for viewing our {@link com.example.bohCharacter.Character}'s {@link
 * com.example.bohCharacter.Description} values
 *
 * Part of the {@link ViewActivity}
 *
 * @author Collin Blake
 * @since 6-29-2019
 */
public class FragmentViewDescription extends Fragment {

  private static final String TAG = "FragmentViewDescription";
  private View view;
  private KnownRelationsAdapter knownRelationsAdapter;


  @Nullable
  @Override
  public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
      @Nullable Bundle savedInstanceState) {
    view = inflater.inflate(R.layout.view_description_fragment, container, false);
    Log.i(TAG, "Bringing in Character Data");

    //Name setter
    TextView textView = view.findViewById(R.id.textNameValue);
    textView.setText(((ViewActivity) getActivity()).character.getDescription().getName());

    //Character Type setter
    textView = view.findViewById(R.id.textTypeValue);
    textView.setText(((ViewActivity) getActivity()).character.getDescription().getType());

    //Motivation setter
    textView = view.findViewById(R.id.textMotivationValue);
    textView.setText(((ViewActivity) getActivity()).character.getDescription().getMotivation());

    //Alter Ego setter
    textView = view.findViewById(R.id.textAlterEgoValue);
    textView.setText(((ViewActivity) getActivity()).character.getDescription().getAlterEgo());

    //Height setter
    textView = view.findViewById(R.id.textHeightValue);
    textView.setText(((ViewActivity) getActivity()).character.getDescription().getHeight());

    //Weight setter
    textView = view.findViewById(R.id.textWeightValue);
    textView.setText(((ViewActivity) getActivity()).character.getDescription().getWeight());

    //Hair color setter
    textView = view.findViewById(R.id.textHairValue);
    textView.setText(((ViewActivity) getActivity()).character.getDescription().getHairColor());

    //Eye setter
    textView = view.findViewById(R.id.textEyeValue);
    textView.setText(((ViewActivity) getActivity()).character.getDescription().getEyeColor());

    //Group Affiliation Listener
    textView = view.findViewById(R.id.textGroupAffiliationValue);
    textView
        .setText(((ViewActivity) getActivity()).character.getDescription().getGroupAffiliation());

    //Occupation setter
    textView = view.findViewById(R.id.textOccupationValue);
    textView.setText(((ViewActivity) getActivity()).character.getDescription().getOccupation());

    //Base of Operations setter
    textView = view.findViewById(R.id.textBaseOfOperationsValue);
    textView
        .setText(((ViewActivity) getActivity()).character.getDescription().getBaseOfOperations());

    //Martial Status setter
    textView = view.findViewById(R.id.textMartialStatusValue);
    textView.setText(((ViewActivity) getActivity()).character.getDescription().getMartialStatus());

    //Personality setter
    textView = view.findViewById(R.id.textPersonalityValue);
    textView.setText(((ViewActivity) getActivity()).character.getDescription().getPersonality());

    //History setter
    textView = view.findViewById(R.id.textHistoryValue);
    textView.setText(((ViewActivity) getActivity()).character.getDescription().getHistory());

    //Description setter
    textView = view.findViewById(R.id.textDescriptionValue);
    textView.setText(((ViewActivity) getActivity()).character.getDescription().getDescription());

    //Update our list
    updateRelationsList();

    return view;
  }


  public void updateRelationsList() {
    //Update List
    Log.i(TAG, "Update Relations List");
    knownRelationsAdapter = new KnownRelationsAdapter(getActivity(),
        ((ViewActivity) getActivity()).character.getDescription().getKnownRelatives());
    ListView listRelations = view.findViewById(R.id.listViewKnownRelations);
    listRelations.setAdapter(knownRelationsAdapter);
  }
}
