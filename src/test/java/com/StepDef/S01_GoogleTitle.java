package com.StepDef;

import java.time.Duration;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;


public class S01_GoogleTitle {
	WebDriver driver;
	String title;
	@Given("Launch Google")
	public void launch_google() {
	    driver= new ChromeDriver();
	    driver.manage().window().maximize();
	    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	    
	    driver.get("https://google.com");
	}

	@When("Read title")
	public void read_title() {
		title=driver.getTitle();
	}

	@Then("Title should be Google")
	public void title_should_be_google() {
		System.out.println("Title: " +title);
		Assert.assertTrue(title.equals("Google"));
	}
}
