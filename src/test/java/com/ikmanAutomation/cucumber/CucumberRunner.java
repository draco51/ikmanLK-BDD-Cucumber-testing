package com.ikmanAutomation.cucumber;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(features="C:\\Users\\Javis\\eclipse-workspace\\com.ikmanAutomation.cucumber\\features\\ikman.feature", glue="StepDefinition")

public class CucumberRunner {

		
}
