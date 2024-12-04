package com.assignment;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class GoogleSearchAutomation {

	public static void main(String[] args) {


		ChromeOptions options = new ChromeOptions();
		options.addArguments("--start-maximized");
		WebDriver driver = new ChromeDriver(options);

		try {
			// Open Google
			driver.get("https://www.google.com");

			// Wait for the search input field to be visible
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
			WebElement searchBox = wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("q")));

			// Type the search query into the search box
			searchBox.sendKeys("Selenium WebDriver");

			// Wait for the search button to be clickable
			WebElement searchButton = wait.until(ExpectedConditions.elementToBeClickable(By.name("btnK")));

			// Click the search button
			searchButton.click();

			// Wait for the search results page to load and results to be displayed
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("search")));

			// print the title of the page
			System.out.println("Title: " + driver.getTitle());

			// Add further interactions if necessary

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			// Closing the browser
			driver.quit();
		}
	}
}