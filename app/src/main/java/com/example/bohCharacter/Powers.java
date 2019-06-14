package com.example.bohCharacter;

public class Powers {

  //Variables
  private String name;
  private int APs;

  public Powers(String name, int APs) {
    this.name = name;
    this.APs = APs;
  }

  //Getters
  public String getName() {
    return name;
  }

  public int getAPs() {
    return APs;
  }

  //Setters

  public void setName(String name) {
    this.name = name;
  }

  public void setAPs(int APs) {
    this.APs = APs;
  }
}
