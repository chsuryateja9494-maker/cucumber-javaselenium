package com.cucumberscript.stepdefs;

import com.cucumberscript.pageObjects.BaseClass;
import io.cucumber.java.After;
import io.cucumber.java.Before;

import java.io.IOException;

public class Hooks extends BaseClass {

  @Before
    public static void setUp() throws IOException {
      initializationDriver();
  }

  @After
  public static void close() {
      closeDriver();
  }

}
