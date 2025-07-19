package com.StepDef;

import java.time.Duration;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class S03_OHRMLogin {
	WebDriver driver;
	
	@Given("User should launch browser")
	public void user_should_launch_browser() {
	    driver = new EdgeDriver();
	    driver.manage().window().maximize();
	    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	    
	    driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
	}

	@When("User enters valid userid")
	public void user_enters_valid_userid() {
	    driver.findElement(By.name("username")).sendKeys("Admin");
	}

	@When("User enters valid password")
	public void user_enters_valid_password() {
	    driver.findElement(By.name("password")).sendKeys("admin123");
	}

	@When("User clicks on Login button")
	public void user_clicks_on_login_button() {
	    driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div/div[1]/div/div[2]/div[2]/form/div[3]/button")).click();
	}

	@Then("Dashboard page should display")
	public void dashboard_page_should_display() {
	    Assert.assertTrue(driver.getCurrentUrl().contains("dashboard"));
	}

	@When("User enters invalid userid")
	public void user_enters_invalid_userid() {
		driver.findElement(By.name("username")).sendKeys("Vinayak");
	}

	@When("User enters invalid password")
	public void user_enters_invalid_password() {
		driver.findElement(By.name("password")).sendKeys("admin123");
	}

	@When("Clicks on Login button")
	public void clicks_on_login_button() {
		driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div/div[1]/div/div[2]/div[2]/form/div[3]/button")).click();
	}

	@Then("Error message should display")
	public void error_message_should_display() {
		System.out.println(driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div/div[1]/div/div[2]/div[2]/div/div[1]/div[1]/p")).getText());
		Assert.assertTrue(driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div/div[1]/div/div[2]/div[2]/div/div[1]/div[1]/p")).getText().equals("Invalid credentials"));

	}

}
