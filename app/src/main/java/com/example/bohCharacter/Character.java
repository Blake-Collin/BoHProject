package com.example.bohCharacter;

import java.util.ArrayList;

/**
 * Basic Character Class Object containing {@link Attributes}, Arraylist of {@link Power}, Arraylist
 * of {@link Skill}, ArrayList of {@link DrawAdvantage}, and {@link Description};
 *
 * @Author Collin Blake
 * @since 6-29-2019
 */
public class Character {

  //Variables
  private Attributes attributes;
  private ArrayList<Power> powers;
  private ArrayList<Skill> skills;
  private ArrayList<DrawAdvantage> drawAdvantages;
  private Description description;

  public Character() {
    this.attributes = new Attributes();
    this.powers = new ArrayList<>();
    this.skills = new ArrayList<>();
    this.drawAdvantages = new ArrayList<>();
    this.description = new Description();
  }

  //Getters
  public Attributes getAttributes() {
    return attributes;
  }

  public ArrayList<Power> getPowers() {
    return powers;
  }

  public ArrayList<Skill> getSkills() {
    return skills;
  }

  public ArrayList<DrawAdvantage> getDrawAdvantages() {
    return drawAdvantages;
  }

  public Description getDescription() {
    return description;
  }

  //Setters

  public void setAttributes(Attributes attributes) {
    this.attributes = attributes;
  }

  public void setPowers(ArrayList<Power> powers) {
    this.powers = powers;
  }

  public void setSkills(ArrayList<Skill> skills) {
    this.skills = skills;
  }

  public void setDrawAdvantages(
      ArrayList<DrawAdvantage> drawAdvantages) {
    this.drawAdvantages = drawAdvantages;
  }

  public void setDescription(Description description) {
    this.description = description;
  }
}
