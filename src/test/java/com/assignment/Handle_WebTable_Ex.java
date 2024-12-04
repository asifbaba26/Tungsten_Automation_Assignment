package com.assignment;

import java.time.Duration;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;


public class Handle_WebTable_Ex {

	public static void main(String[] args) throws InterruptedException {
	
		// Initialize WebDriver (Chrome in this case)
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://www.w3schools.com/html/tryit.asp?filename=tryhtml_table_intro");
		// switch to frame , get the no of rows and columns
		// iterate over rows and columns and get the text

		driver.switchTo().frame("iframeResult");

		List<WebElement> rows = driver.findElements(By.xpath("/html/body/table/tbody/tr"));
		System.out.println("ROWS = " + rows.size());
		int rowSize = rows.size();

		List<WebElement> columns = driver.findElements(By.xpath("/html/body/table/tbody/tr[2]/td")); 
		System.out.println("COLUMNS =" + columns.size());
		int columnSize = columns.size();

		for (int i = 2; i <= rowSize; i++) {
			for (int j = 1; j <= columnSize; j++) {
				System.out.print(
						driver.findElement(By.xpath("/html/body/table/tbody/tr[" + i + "]/td[" + j + "]")).getText()+",");

			}
			System.out.println();

		}

		driver.quit();

	}

}
