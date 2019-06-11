package com.example.bohproject;

import android.content.Context;
import android.support.test.InstrumentationRegistry;
import android.support.test.runner.AndroidJUnit4;

import org.junit.Test;
import org.junit.runner.RunWith;

import static org.junit.Assert.*;

/**
 * Instrumented test, which will execute on an Android device.
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
@RunWith(AndroidJUnit4.class)
public class ExampleInstrumentedTest {

  @Test
  public void useAppContext() {
    // Context of the app under test.
    Context appContext = InstrumentationRegistry.getTargetContext();

    assertEquals("com.example.bohproject", appContext.getPackageName());
    assertEquals(4, 2 + 2);
  }

  @Test //Will test we cannot go negative but can do 0 or any number above.
  public void CharacterAttributesTestValues() {

  }

  @Test //Test Name shouldn't be allowed to be blank or below 2 characters.
  public void CharacterNamesAreNotBlank() {

  }

  @Test //Test powers APs do not allow below 0.
  public void CharacterTestPowersValues() {

  }

  @Test //Test skills APs do not allow below 0.
  public void CharacterTestSkillsValues() {

  }

}
