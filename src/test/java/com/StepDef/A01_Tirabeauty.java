package com.StepDef;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.java.en.*;
import org.junit.Assert;
public class A01_Tirabeauty {
	WebDriver driver;
	@Given("User should launch tirabeauty")
	public void user_should_launch_tirabeauty() {
	    driver = new ChromeDriver();
	    driver.manage().window().maximize();
	    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	    
	    driver.get("https://www.tirabeauty.com/");
	}

	@When("User click on Makeup")
	public void user_click_on_makeup() {
	    driver.findElement(By.linkText("Makeup")).click();
	}

	@Then("Makeup url should display")
	public void makeup_url_should_display() {
		Assert.assertTrue(driver.getCurrentUrl().contains("makeup"));
	}

	@When("User click on Skin")
	public void user_click_on_skin() {
		driver.findElement(By.linkText("Skin")).click();
	}

	@Then("Skin url should display")
	public void skin_url_should_display() {
		Assert.assertTrue(driver.getCurrentUrl().contains("skin"));
	}

	@When("User click on Men")
	public void user_click_on_men() {
		driver.findElement(By.linkText("Men")).click();
	}

	@Then("Men url should display")
	public void men_url_should_display() {
		Assert.assertTrue(driver.getCurrentUrl().contains("men"));
	}

	@When("User click on Mom&Beauty")
	public void user_click_on_mom_beauty() {
		driver.findElement(By.linkText("Mom & Baby")).click();
	}

	@Then("Mom&Beauty url should display")
	public void mom_beauty_url_should_display() {
		Assert.assertTrue(driver.getCurrentUrl().contains("mom"));
	}
}
