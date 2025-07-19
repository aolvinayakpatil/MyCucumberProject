package com.StepDef;

import java.time.Duration;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.java.en.*;

public class S02_GoogleSearch {
	WebDriver driver;
	@Given("User launch Google")
	public void user_launch_google() {
	    driver = new ChromeDriver();
	    driver.manage().window().maximize();
	    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	    
	    driver.get("https://google.com");
	}

	@When("User enters any keyword to search")
	public void user_enters_any_keyword_to_search() {
	    driver.findElement(By.xpath("//*[@id=\"APjFqb\"]")).sendKeys("Kolhapuri Paytaan");
	}

	@When("User press enter key")
	public void user_press_enter_key() {
	    driver.findElement(By.xpath("//*[@id=\"APjFqb\"]")).sendKeys(Keys.ENTER);
	}

	@Then("Valid search result should display")
	public void valid_search_result_should_display() {
	    Assert.assertTrue(driver.getCurrentUrl().contains("Kolhapuri"));
	}
}
