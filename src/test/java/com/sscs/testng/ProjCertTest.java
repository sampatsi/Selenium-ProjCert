package com.sscs.testng;


import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class ProjCertTest {
	WebDriver driver;

	@BeforeMethod
	public void launch() {
		driver = new ChromeDriver();
		String os = System.getProperty("os.name").toLowerCase();

		if (os.contains("mac")) {
			System.setProperty("webdriver.chrome.driver", System.getProperty("usre.dir") + "/chromedriver.exe");

		} else {
			System.setProperty("webdriver.chrome.driver", "chromedriver.exe");

		}
		driver.manage().window().maximize();
		driver.get("http://ec2-18-205-105-219.compute-1.amazonaws.com:80");
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	}

	@Test
	public void verifyTitle() {

		// driver.findElement(By.id("About Us" ));
		String title = driver.getTitle();
		System.out.println(title);
		Assert.assertEquals(title, "Home | Simple PHP Website");
	}

	@AfterMethod
	public void close() {
		driver.close();
	}
}

