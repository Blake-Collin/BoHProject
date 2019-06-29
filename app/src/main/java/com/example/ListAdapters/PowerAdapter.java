package com.example.ListAdapters;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import com.example.bohCharacter.Power;
import com.example.bohproject.R;
import java.util.ArrayList;

public class PowerAdapter extends BaseAdapter {
  Activity context;
  ArrayList<Power> powers;
  private static LayoutInflater inflater = null;

  public PowerAdapter( Activity context, ArrayList<Power> powers) {
    this.context  = context;
    this.powers = powers;
    inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
  }

  @Override
  public int getCount() {
    return powers.size();
  }

  @Override
  public Object getItem(int position) {
    return powers.get(position);
  }

  @Override
  public long getItemId(int position) {
    return position;
  }

  @Override
  public View getView(int position, View convertView, ViewGroup parent) {
    View itemView = convertView;
    itemView = (itemView == null) ? inflater.inflate(R.layout.list_power, null): itemView;
    TextView textViewPowerName = (TextView) itemView.findViewById(R.id.textListPowerName);
    TextView textViewPowerAPs = (TextView) itemView.findViewById(R.id.textListPowerAPs);
    Power selectedPower = powers.get(position);
    textViewPowerName.setText(selectedPower.getName());
    textViewPowerAPs.setText("APs: " + selectedPower.getAPs());
    return itemView;
  }
}
