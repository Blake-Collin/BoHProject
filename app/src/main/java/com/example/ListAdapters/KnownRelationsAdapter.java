package com.example.ListAdapters;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import com.example.bohproject.R;
import java.util.ArrayList;

/**
 * relations Custom list Adapter for displaying purposes.
 *
 * @author Collin Blake
 * @since 6-29-2019
 */
public class KnownRelationsAdapter extends BaseAdapter {
  Activity context;
  ArrayList<String> relations;
  private static LayoutInflater inflater = null;

  public KnownRelationsAdapter( Activity context, ArrayList<String> relations) {
    this.context  = context;
    this.relations = relations;
    inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
  }

  @Override
  public int getCount() {
    return relations.size();
  }

  @Override
  public Object getItem(int position) {
    return relations.get(position);
  }

  @Override
  public long getItemId(int position) {
    return position;
  }

  @Override
  public View getView(int position, View convertView, ViewGroup parent) {
    View itemView = convertView;
    itemView = (itemView == null) ? inflater.inflate(R.layout.list_relations, null): itemView;
    TextView textViewRelation = (TextView) itemView.findViewById(R.id.textListRelationName);
    String selectedRelation = relations.get(position);
    textViewRelation.setText(selectedRelation);
    return itemView;
  }
}
