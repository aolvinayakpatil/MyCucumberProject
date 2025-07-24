package com.Runner;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(features = "src/test/resources/MyCucumberProject/MyCucumberProject/F04_RediffRegistration.feature",
					glue = "com.StepDef",
					publish = true
					)
public class R04_RediffRegstration {

}
