package com.kwri.auto.ui.contacts.run;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;


/**
 * Cucumber Test Runner to run scenarios and outlines.
 * <p>
 * Includes tags to run selective scenarios, the path of cucumber feature files
 * and Step Definitions to compile and execute the test-/
 * </p>
 * 
 * @author preeti.dubey
 *
 */
@RunWith(Cucumber.class)
@CucumberOptions(
		plugin = {"pretty", "json:target/cucumber.json"},
		features = {"src/test/resources/features"},
		glue = {"com.kwri"},
		tags = {"@RegistrationNewEmail"},	
		monochrome = true,
		strict = true,
		dryRun = false
		)

public class RunCukesTest {

}
