package com.example.bohdatabase;

public class CharacterNonExistenceException extends Exception {

  public CharacterNonExistenceException() {
    super("Character doesn't exist yet. Please create him first.");
  }

}
