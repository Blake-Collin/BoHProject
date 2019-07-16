package com.example.ListAdapters;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import com.example.bohCharacter.Character;
import com.example.bohproject.R;
import java.util.ArrayList;
import java.util.Locale;

/**
 * {@link Character} Custom list Adapter for displaying purposes on {@link
 * com.example.bohproject.MainActivity}
 *
 * @author Collin Blake
 * @since 7-15-2019
 */

public class CharacterAdapter extends BaseAdapter {

  private Activity context;
  private ArrayList<Character> characters;
  private static LayoutInflater inflater = null;

  /**
   *
   */
  public CharacterAdapter(Activity context, ArrayList<Character> characters,
      String searchText) {
    this.context = context;
    this.characters = characters;
    filter(searchText);
    inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

  }

  @Override
  public int getCount() {
    return characters.size();
  }

  @Override
  public Object getItem(int position) {
    return this.characters.get(position);
  }

  @Override
  public long getItemId(int position) {
    return position;
  }

  @Override
  public View getView(int position, View convertView, ViewGroup parent) {
    View itemView = convertView;
    itemView = (itemView == null) ? inflater.inflate(R.layout.list_characters, null) : itemView;
    TextView textViewCharacterName = itemView.findViewById(R.id.textCharacterName);
    TextView textViewAlterEgoName = itemView.findViewById(R.id.textAlterEgoName);
    Character selectedCharacter = characters.get(position);
    textViewCharacterName.setText(selectedCharacter.getDescription().getName());
    textViewAlterEgoName.setText(selectedCharacter.getDescription().getAlterEgo());
    return itemView;
  }

  public void filter(String charText) {
    charText = charText.toLowerCase(Locale.getDefault());

    if (charText.length() == 0) {
      //Do Nothing
    } else {
      ArrayList<Character> newList = new ArrayList<Character>();
      for (Character character : this.characters) {
        if (character.getDescription().getName().toLowerCase(Locale.getDefault()).contains(charText)
            || character.getDescription().getAlterEgo().toLowerCase(Locale.getDefault())
            .contains(charText)) {
          newList.add(character);
        }
      }
      this.characters = newList;
    }

  }
}
