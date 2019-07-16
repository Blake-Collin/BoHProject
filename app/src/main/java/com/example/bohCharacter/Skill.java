package com.example.bohCharacter;

import java.util.ArrayList;

/**
 * {@link com.example.bohCharacter.Character} skill object type
 *
 * @auithor Collin Blake
 * @since 6-29-2019
 */
public class Skill {

  //Variables
  private String name;
  private int APs;
  private ArrayList<String> subskills;

  public Skill(String name, int APs, ArrayList<String> subskills) {
    this.name = name;
    this.APs = APs;
    this.subskills = subskills;
  }

  //Getters
  public String getName() {
    return name;
  }

  public int getAPs() {
    return APs;
  }

  public ArrayList<String> getSubskills() {
    return subskills;
  }

  //Setters
  public void setName(String name) {
    this.name = name;
  }

  public void setAPs(int APs) {
    this.APs = APs;
  }

  public void setSubskills(ArrayList<String> subskills) {
    this.subskills = subskills;
  }

  @Override
  public String toString() {
    return "Skill{" +
        "name='" + name + '\'' +
        ", APs=" + APs +
        ", subskills=" + subskills +
        '}';
  }
}
