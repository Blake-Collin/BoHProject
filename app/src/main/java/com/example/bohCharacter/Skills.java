package com.example.bohCharacter;

import java.util.ArrayList;

public class Skills {

  //Variables
  private String name;
  private int APs;
  private ArrayList<String> subskills;

  public Skills() {
    subskills = new ArrayList<>();
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
}
