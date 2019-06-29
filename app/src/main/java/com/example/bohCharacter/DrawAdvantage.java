package com.example.bohCharacter;

/**
 * Character Advantage & Drawback object type
 *
 * @auithor Collin Blake
 * @since 6-29-2019
 */
public class DrawAdvantage {

  private String name;
  private String description;

  public DrawAdvantage(String name, String description) {
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
