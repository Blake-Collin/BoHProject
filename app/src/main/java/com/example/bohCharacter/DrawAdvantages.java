package com.example.bohCharacter;

public class DrawAdvantages {

  private String name;
  private String description;

  public DrawAdvantages(String name, String description) {
    this.name = name;
    this.description = description;
  }

  //Setters
  public void setName(String name) {
    this.name = name;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  //Getters
  public String getName() {
    return name;
  }

  public String getDescription() {
    return description;
  }
}
