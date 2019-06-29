package com.example.ListAdapters;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import com.example.bohCharacter.Skill;
import com.example.bohproject.R;
import java.util.ArrayList;

/**
 * skill Custom list Adapter for displaying purposes.
 *
 * @author Collin Blake
 * @since 6-29-2019
 */
public class SkillAdapater extends BaseAdapter {

  Activity context;
  ArrayList<Skill> skills;
  private static LayoutInflater inflater = null;

  public SkillAdapater(Activity context, ArrayList<Skill> skills) {
    this.context = context;
    this.skills = skills;
    inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
  }

  @Override
  public int getCount() {
    return skills.size();
  }

  @Override
  public Object getItem(int position) {
    return skills.get(position);
  }

  @Override
  public long getItemId(int position) {
    return position;
  }

  @Override
  public View getView(int position, View convertView, ViewGroup parent) {
    View itemView = convertView;
    itemView = (itemView == null) ? inflater.inflate(R.layout.list_skills, null) : itemView;
    TextView textViewPowerName = (TextView) itemView.findViewById(R.id.textListSkillName);
    TextView textViewPowerAPs = (TextView) itemView.findViewById(R.id.textListDrawSkillDescAP);
    Skill selectedSkill = skills.get(position);
    textViewPowerName.setText(selectedSkill.getName());
    textViewPowerAPs
        .setText("APs: " + selectedSkill.getAPs() + " Subs: " + selectedSkill.getSubskills());
    return itemView;
  }
}
