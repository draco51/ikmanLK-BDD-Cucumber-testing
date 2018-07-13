package com.ikmanAutomation.cucumber;


import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;


public class StepDefinition {
	WebDriver driver = null;
	String[] parts = null;

	@Given("^I am on IkmanLK Website$")
    public void Openwebsite(String arg0) throws Throwable {
		System.setProperty("webdriver.chrome.driver","D:\\selnm\\chromedriver.exe"); 
		driver = new ChromeDriver();
		driver.get("https://ikman.lk/");
        System.out.println("Opened page ikman.lk");
    }
	
	 @When("^I click on the Property link$")
	    public void iClickOnProperty() throws Throwable {
		 	//findElement Property
			driver.findElement(By.linkText("Property")).click();
	    }
	 
	 @When("^I click on the Houese link$")
	    public void iClickOnHouses() throws Throwable {
		 	//findElement Houses
			driver.findElement(By.xpath("//a[@href='/en/ads/sri-lanka/houses?categoryType=ads&categoryName=Property']")).click();
	    }
	 
	 @When("^I click on the Colombo link$")
	    public void iClickOnColombo() throws Throwable {
		 	//findElement Colombo
			driver.findElement(By.xpath("//a[@href='/en/ads/colombo/houses?categoryType=ads&categoryName=Houses&type=for_sale']")).click();
	    }

	 
	 @When("^I select the Price range$")
	    public void iSelectPriceRange() throws Throwable {
		 	//findElement Price
			driver.findElement(By.linkText("Price (Rs)")).click();
			//Fill min value
			driver.findElement(By.id("filters[0][minimum]")).sendKeys("5000000");
			//Fill max value
			driver.findElement(By.id("filters[0][maximum]")).sendKeys("7500000");
			//Click Apply Button
			driver.findElement(By.xpath("//button[@class='ui-btn is-standard btn-apply']")).click();
	    }
	 
	 
	 @When("^I select No of Beds as 3$")
	    public void iSelectBeds() throws Throwable {
		 	//Click on Beds
			driver.findElement(By.linkText("Beds")).click();
			//Tick beds as 3
			driver.findElement(By.id("filters2values-3")).click();
	    }
	 
	 @Then("^Get the No of Total Ads$")
	    public void GetAdsCount() throws Throwable {
		 	String result = driver.findElement(By.xpath("//span[@class='t-small summary-count']")).getText();
			String[] parts = result.split(" ");
			System.out.println("Number of Ads : "+ parts[3]);
	    }
	 
	 @Then("^Print all the prices of Ads$")
	    public void printPrices() throws Throwable {
		 int noOfPages = (Integer.parseInt(parts[3]))/25;
			int pageNo = 0;  
		
			while( pageNo < noOfPages ) {
				List<WebElement> allElements = driver.findElements(By.xpath("//p[@class='item-info']/strong"));
				for (WebElement element: allElements) {
					String priceResult = element.getText();
					String[] parts2 = priceResult.split("( )|(\\,)");
					int price = Integer.parseInt(parts2[1]+parts2[2]+parts2[3]);
					System.out.println(price>= 5000000 && price<=7500000? "" : price+ " Not in the price range");
					//Assert.assertTrue(price>= 5000000 && price<=7500000, " Not in the price range");
					//System.out.println(price);
				}
				System.out.println("-----Page No:"+(pageNo+1)+ "-----"); 
		        pageNo++;
		        driver.findElement(By.linkText("Next")).click();
		      }
	    }
	 
	 @Then("^I Close the browser$")
	    public void closeBrowser() throws Throwable {
		 driver.close();
	 }
	 
	 
	
}
