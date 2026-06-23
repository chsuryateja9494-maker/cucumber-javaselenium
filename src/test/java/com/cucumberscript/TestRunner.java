package com.cucumberscript;

import org.junit.platform.suite.api.ConfigurationParameter;
import org.junit.platform.suite.api.IncludeEngines;
import org.junit.platform.suite.api.SelectClasspathResource;
import org.junit.platform.suite.api.Suite;

import static io.cucumber.junit.platform.engine.Constants.PLUGIN_PROPERTY_NAME;
import static io.cucumber.junit.platform.engine.Constants.PLUGIN_PUBLISH_ENABLED_PROPERTY_NAME;

@Suite  //indicates the test cases of the class to execute
@IncludeEngines("cucumber") //Junit support multiple engines, here 'cucumber' engine is selected
@SelectClasspathResource("features")  //this looks for feature files in the 'features' folder
@ConfigurationParameter(key = PLUGIN_PROPERTY_NAME, value = "pretty, html:build/reports/cucumber/report.html")
//pretty = to provide in a more readable way
//html is for reports in html format
@ConfigurationParameter(key = PLUGIN_PUBLISH_ENABLED_PROPERTY_NAME, value = "true")
//Cucumber report is published online , above "PLUGIN_PUBLISH_ENABLED_PROPERTY_NAME" is used instead of "publish = true"

public class TestRunner {  //this don't have methods as annotations will take care of all

}
