package com.example.bohCharacter;

import java.util.ArrayList;

public class Character {

  //Variables
  private Attributes attributes;
  private ArrayList<Powers> powers;
  private ArrayList<Skills> skills;
  private ArrayList<DrawAdvantages> drawAdvantages;
  private Description description;

  public Character() {
    this.attributes = new Attributes();
    this.powers = new ArrayList<>();
    this.skills = new ArrayList<>();
    this.drawAdvantages = new ArrayList<>();
    this.description = new Description();
  }

  //Functions
  public void addPower(String name, int APs){
    Powers newPower = new Powers(name, APs);
    powers.add(newPower);
  }

  public void removePower(Powers power) {
     this.powers.remove(power);
  }

  //Getters
  public Attributes getAttributes() {
    return attributes;
  }

  public ArrayList<Powers> getPowers() {
    return powers;
  }

  public ArrayList<Skills> getSkills() {
    return skills;
  }

  public ArrayList<DrawAdvantages> getDrawAdvantages() {
    return drawAdvantages;
  }

  public Description getDescription() {
    return description;
  }

  //Setters

  public void setAttributes(Attributes attributes) {
    this.attributes = attributes;
  }

  public void setPowers(ArrayList<Powers> powers) {
    this.powers = powers;
  }

  public void setSkills(ArrayList<Skills> skills) {
    this.skills = skills;
  }

  public void setDrawAdvantages(
      ArrayList<DrawAdvantages> drawAdvantages) {
    this.drawAdvantages = drawAdvantages;
  }

  public void setDescription(Description description) {
    this.description = description;
  }
}
