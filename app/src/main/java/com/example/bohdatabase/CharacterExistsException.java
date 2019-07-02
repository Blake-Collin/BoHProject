package com.example.bohdatabase;

/**
 * When the {@link com.example.bohCharacter.Character} already exists
 *
 * @author Collin Blake
 * @Since 6-29-2019
 */
public class CharacterExistsException extends Exception {

  public CharacterExistsException() {
    super("Character already Exists. Please rename your character!");
  }

}
