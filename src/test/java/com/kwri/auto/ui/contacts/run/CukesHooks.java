package com.kwri.auto.ui.contacts.run;

import com.google.inject.Inject;
import com.kwri.auto.ui.di.World;
import com.kwri.auto.ui.eyesApplitools.EyesApplitools;
import com.kwri.auto.ui.managers.WebDriverManager;

import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;

/**
 * Cucumber Hooks class to run generic methods before and after each scenario
 * 
 * @author preeti.dubey
 *
 */
public class CukesHooks {

	@Inject
	EyesApplitools applitools;

	@Inject
	WebDriverManager webManager;

	@Inject
	World world;

	/**
	@Before
	public void beforeScenario(Scenario scenario) {
	}

	@After
	public void afterScenario() {
	}
	**/
}
