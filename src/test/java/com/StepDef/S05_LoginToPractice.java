package com.StepDef;

import java.time.Duration;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.java.en.*;

public class S05_LoginToPractice {
WebDriver driver;
	@Given("Launch page {string}")
	public void launch_page(String url) {
		driver = new ChromeDriver();
	    driver.manage().window().maximize();
	    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	    
	    driver.get(url);
	}

	@When("User enter username as {string}")
	public void user_enter_username_as(String un) {
	    driver.findElement(By.xpath("//input[@id='username']")).sendKeys(un);
	}

	@When("User enter password as {string}")
	public void user_enter_password_as(String ps) {
		driver.findElement(By.xpath("//input[@id='password']")).sendKeys(ps);
	}

	@When("Click on Login button")
	public void click_on_login_button() {
		driver.findElement(By.xpath("//button[@type='submit']")).submit();
	}

	@Then("Home page should display")
	public void home_page_should_display() {
	    Assert.assertTrue(driver.getCurrentUrl().contains("secure"));
	}
}
