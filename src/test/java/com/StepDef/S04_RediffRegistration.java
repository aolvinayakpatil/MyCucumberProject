package com.StepDef;

import java.time.Duration;
import java.util.List;
import java.util.Map;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.cucumber.java.en.*;

public class S04_RediffRegistration {
	WebDriver driver;
	
	@Given("Open rediff registration page")
	public void open_rediff_registration_page() {
		driver = new ChromeDriver();
	    driver.manage().window().maximize();
	    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	    
	    driver.get("https://register.rediff.com/register/register.php?FormName=user_details");
	}

	@When("User enters valid full name as {string}")
	public void user_enters_valid_full_name_as(String fn) {
	    driver.findElement(By.xpath("//input[@placeholder=\"Enter your full name\"]")).sendKeys(fn);
	}

	@When("User enters valid rediffid as {string}")
	public void user_enters_valid_rediffid_as(String rid) {
		driver.findElement(By.xpath("//input[starts-with(@name,\"login\")]")).sendKeys(rid);
	}

	@When("User enters valid password as {string}")
	public void user_enters_valid_password_as(String ps) {
		driver.findElement(By.xpath("//input[@id='newpasswd']")).sendKeys(ps);
	}

	@When("User re-enters password as {string}")
	public void user_re_enters_password_as(String rps) {
		driver.findElement(By.xpath("//input[@id='newpasswd1']")).sendKeys(rps);
	}
	
	@When("User Select birth date as")
	public void user_select_birth_date_as(io.cucumber.datatable.DataTable dataTable) {
	    List<List<String>> data = dataTable.asLists();
	    /*System.out.println(data.get(0));
	    System.out.println(data.get(1));
	    System.out.println(data.get(2));*/
	    new Select(driver.findElement(By.xpath("//select[starts-with(@name,\"DOB_Day\")]"))).selectByVisibleText(data.get(0).get(0));
	    new Select(driver.findElement(By.xpath("//select[starts-with(@name,\"DOB_Month\")]"))).selectByVisibleText(data.get(0).get(1));
	    new Select(driver.findElement(By.xpath("//select[starts-with(@name,\"DOB_Year\")]"))).selectByVisibleText(data.get(0).get(2));
	}

	@When("User click on Check availability button")
	public void user_click_on_check_availability_button() {
		driver.findElement(By.xpath("//input[starts-with(@name,'btnchkavail')]")).click();
	}

	@Then("Rediff id available message should display")
	public void rediff_id_available_message_should_display() {
		System.out.println(driver.findElement(By.xpath("//*[@id=\"check_availability\"]")).getText());
		Assert.assertTrue(driver.findElement(By.xpath("//*[@id=\"check_availability\"]")).getText().contains("available"));
	}

	@When("User enters Invalid full name as {string}")
	public void user_enters_invalid_full_name_as(String fn) {
	    driver.findElement(By.xpath("//input[@placeholder=\"Enter your full name\"]")).sendKeys(fn);
	}

	@When("User enters Invalid rediffid as {string}")
	public void user_enters_invalid_rediffid_as(String rid) {
		driver.findElement(By.xpath("//input[starts-with(@name,\"login\")]")).sendKeys(rid);
	}

	@When("User enters Invalid password as {string}")
	public void user_enters_invalid_password_as(String ps) {
		driver.findElement(By.xpath("//input[@id='newpasswd']")).sendKeys(ps);
	}

	@When("User re-enters Invalid password as {string}")
	public void user_re_enters_invalid_password_as(String rps) {
		driver.findElement(By.xpath("//input[@id='newpasswd1']")).sendKeys(rps);
	}
	
	@When("User Selects DOB as")
	public void user_selects_dob_as(io.cucumber.datatable.DataTable dataTable) {
	   List<Map<String,String>>bDate=dataTable.asMaps();
	   for(Map<String,String> bd :bDate) {
		   new Select(driver.findElement(By.xpath("//select[starts-with(@name,\"DOB_Day\")]"))).selectByVisibleText(bd.get("Day"));
		    new Select(driver.findElement(By.xpath("//select[starts-with(@name,\"DOB_Month\")]"))).selectByVisibleText(bd.get("Month"));
		    new Select(driver.findElement(By.xpath("//select[starts-with(@name,\"DOB_Year\")]"))).selectByVisibleText(bd.get("Year"));
		}
	}

	@When("User clicks on Check availability button")
	public void user_clicks_on_check_availability_button() {
		driver.findElement(By.xpath("//input[starts-with(@name,'btnchkavail')]")).click();
	}

	@Then("Rediff id not available message should display")
	public void rediff_id_not_available_message_should_display() {
		System.out.println(driver.findElement(By.xpath("//*[@id=\"check_availability\"]")).getText());
		Assert.assertTrue(driver.findElement(By.xpath("//*[@id=\"check_availability\"]")).getText().contains("available"));
	}
}
