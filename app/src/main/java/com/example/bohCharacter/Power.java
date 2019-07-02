package com.example.bohCharacter;

/**
 * {@link com.example.bohCharacter.Character} Power Object Type
 *
 * @auithor Collin Blake
 * @since 6-29-2019
 */
public class Power {

  //Variables
  private String name;
  private int APs;

  public Power(String name, int APs) {
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
