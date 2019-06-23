package com.example.bohCharacter;

import java.util.ArrayList;

public class Description {

  private String name;
  private String type;
  private String alterEgo;
  private String height;
  private String weight;
  private String eyeColor;
  private String groupAffliatiion;
  private String occupation;
  ArrayList<String> knownRelatives;
  private String baseOfOperations;
  private String martialStatus;
  private String personality;
  private String history;
  private String description;


  public Description() {
    this.name = "";
    this.type = "";
    this.alterEgo = "";
    this.height = "";
    this.weight = "";
    this.eyeColor = "";
    this.groupAffliatiion = "";
    this.occupation = "";
    this.knownRelatives = new ArrayList<>();
    this.baseOfOperations = "";
    this.martialStatus = "";
    this.personality = "";
    this.history = "";
    this.description = "";
  }

  //Getters
  public String getName() {
    return name;
  }

  public String getType() {
    return type;
  }

  public String getAlterEgo() {
    return alterEgo;
  }

  public String getHeight() {
    return height;
  }

  public String getWeight() {
    return weight;
  }

  public String getEyeColor() {
    return eyeColor;
  }

  public String getGroupAffliatiion() {
    return groupAffliatiion;
  }

  public String getOccupation() {
    return occupation;
  }

  public ArrayList<String> getKnownRelatives() {
    return knownRelatives;
  }

  public String getBaseOfOperations() {
    return baseOfOperations;
  }

  public String getMartialStatus() {
    return martialStatus;
  }

  public String getPersonality() {
    return personality;
  }

  public String getHistory() {
    return history;
  }

  public String getDescription() {
    return description;
  }

  //Setters
  public void setName(String name) {
    this.name = name;
  }

  public void setType(String type) {
    this.type = type;
  }

  public void setAlterEgo(String alterEgo) {
    this.alterEgo = alterEgo;
  }

  public void setHeight(String height) {
    this.height = height;
  }

  public void setWeight(String weight) {
    this.weight = weight;
  }

  public void setEyeColor(String eyeColor) {
    this.eyeColor = eyeColor;
  }

  public void setGroupAffliatiion(String groupAffliatiion) {
    this.groupAffliatiion = groupAffliatiion;
  }

  public void setOccupation(String occupation) {
    this.occupation = occupation;
  }

  public void setKnownRelatives(ArrayList<String> knownRelatives) {
    this.knownRelatives = knownRelatives;
  }

  public void setBaseOfOperations(String baseOfOperations) {
    this.baseOfOperations = baseOfOperations;
  }

  public void setMartialStatus(String martialStatus) {
    this.martialStatus = martialStatus;
  }

  public void setPersonality(String personality) {
    this.personality = personality;
  }

  public void setHistory(String history) {
    this.history = history;
  }

  public void setDescription(String description) {
    this.description = description;
  }
}
