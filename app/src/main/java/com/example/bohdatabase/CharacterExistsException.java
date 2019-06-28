package com.example.bohdatabase;

public class CharacterExistsException extends Exception {

  public CharacterExistsException() {
    super("Character already Exists. Please rename your character!");
  }

}
