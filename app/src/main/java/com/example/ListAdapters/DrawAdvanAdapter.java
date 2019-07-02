package com.example.ListAdapters;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import com.example.bohCharacter.DrawAdvantage;
import com.example.bohproject.R;
import java.util.ArrayList;

/**
 * {@link DrawAdvantage} Custom list Adapter for displaying purposes on both {@link
 * com.example.bohproject.FragmentViewDrawAdvantage} & {@link com.example.bohproject.FragmentEditDrawAdvantage}
 *
 * @author Collin Blake
 * @since 6-29-2019
 */

public class DrawAdvanAdapter extends BaseAdapter {

  Activity context;
  ArrayList<DrawAdvantage> drawAdvantages;
  private static LayoutInflater inflater = null;

  public DrawAdvanAdapter(Activity context, ArrayList<DrawAdvantage> drawAdvantages) {
    this.context = context;
    this.drawAdvantages = drawAdvantages;
    inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
  }

  @Override
  public int getCount() {
    return drawAdvantages.size();
  }

  @Override
  public Object getItem(int position) {
    return drawAdvantages.get(position);
  }

  @Override
  public long getItemId(int position) {
    return position;
  }

  @Override
  public View getView(int position, View convertView, ViewGroup parent) {
    View itemView = convertView;
    itemView = (itemView == null) ? inflater.inflate(R.layout.list_drawadvan, null) : itemView;
    TextView textViewPowerName = (TextView) itemView.findViewById(R.id.textListDrawAdvanName);
    TextView textViewPowerAPs = (TextView) itemView.findViewById(R.id.textListDrawAdvanDesc);
    DrawAdvantage selectedDrawAdvantage = drawAdvantages.get(position);
    textViewPowerName.setText(selectedDrawAdvantage.getName());
    textViewPowerAPs
        .setText(selectedDrawAdvantage.getDescription());
    return itemView;
  }

}
