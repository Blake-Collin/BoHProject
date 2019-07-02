package com.example.bohdatabase;

/**
 * Exception for {@link com.example.bohCharacter.Character} doesn't exist when updating.
 *
 * @author Collin Blake
 * @since 6-29-2019
 */
public class CharacterNonExistenceException extends Exception {

  public CharacterNonExistenceException() {
    super("Character doesn't exist yet. Please create him first.");
  }

}
