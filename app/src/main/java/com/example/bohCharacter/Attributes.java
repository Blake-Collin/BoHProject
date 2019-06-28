package com.example.bohCharacter;

public class Attributes {

  private int str;
  private int dex;
  private int body;
  private int Int;
  private int will;
  private int mind;
  private int infl;
  private int aura;
  private int spirit;
  private int wealth;
  private int heroPoints;

  public Attributes() {
    this.str = 1;
    this.dex = 1;
    this.body = 1;
    this.Int = 1;
    this.will = 1;
    this.mind = 1;
    this.infl = 1;
    this.aura = 1;
    this.spirit = 1;
    this.wealth = 0;
    this.heroPoints = 0;
  }

  //Getters
  public int getStr() {
    return str;
  }

  public int getDex() {
    return dex;
  }

  public int getBody() {
    return body;
  }

  public int getInt() {
    return Int;
  }

  public int getWill() {
    return will;
  }

  public int getMind() {
    return mind;
  }

  public int getInfl() {
    return infl;
  }

  public int getAura() {
    return aura;
  }

  public int getSpirit() {
    return spirit;
  }

  public int getWealth() {
    return wealth;
  }

  public int getHeroPoints() {
    return heroPoints;
  }

  //Setters
  public void setStr(int str) {
    this.str = str;
  }

  public void setDex(int dex) {
    this.dex = dex;
  }

  public void setBody(int body) {
    this.body = body;
  }

  public void setInt(int anInt) {
    Int = anInt;
  }

  public void setWill(int will) {
    this.will = will;
  }

  public void setMind(int mind) {
    this.mind = mind;
  }

  public void setInfl(int infl) {
    this.infl = infl;
  }

  public void setAura(int aura) {
    this.aura = aura;
  }

  public void setSpirit(int spirit) {
    this.spirit = spirit;
  }

  public void setWealth(int wealth) {
    this.wealth = wealth;
  }

  public void setHeroPoints(int heroPoints) {
    this.heroPoints = heroPoints;
  }

  //To String for Testing

  @Override
  public String toString() {
    return "Attributes{" +
        "str=" + str +
        ", dex=" + dex +
        ", body=" + body +
        ", Int=" + Int +
        ", will=" + will +
        ", mind=" + mind +
        ", infl=" + infl +
        ", aura=" + aura +
        ", spirit=" + spirit +
        ", wealth=" + wealth +
        ", heroPoints=" + heroPoints +
        '}';
  }
}
