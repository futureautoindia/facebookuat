/*
 * Project Name - Health Care
 * Author Name - Chirag Swami
 * Client - Bajaj
 * Organization - XYZ
 */
package com.common;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Keyword extends Constant {
	/**
	 * This Method will Open Chrome or Firefox or Edge Browser
	 * 
	 * @param browserName
	 */
	public static void openBrowser(String browserName) {
		switch (browserName) {
		case "Chrome":
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
			break;
		case "Firefox":
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
			break;
		case "Edge":
			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();
			break;

		default:
			System.out.println("Invalid Browser Name:  " + browserName);
		}
	}

	/**
	 * It will open specified url in Web Browser recently opened driver instance
	 * 
	 * @param url {@code String} url to Open
	 * @return void
	 */
	public static void openURL(String url) {
		driver.get(url);
	}

	public static WebElement getWebElement(String locatorType, String locatorValue) {
		WebElement element = null;
		switch (locatorType) {
		case "ID":
			element = driver.findElement(By.id(locatorValue));
			break;
		case "XPATH":
			element = driver.findElement(By.xpath(locatorValue));
			break;
		case "CLASSNAME":
			element = driver.findElement(By.className(locatorValue));
			break;
		case "NAME":
			element = driver.findElement(By.name(locatorValue));
			break;
		case "LINKTEXT":
			element = driver.findElement(By.linkText(locatorValue));
			break;
		case "PARTIALLINKTEXT":
			element = driver.findElement(By.partialLinkText(locatorValue));
			break;
		case "TAGNAME":
			element = driver.findElement(By.tagName(locatorValue));
			break;
		case "CSSSELECTOR":
			element = driver.findElement(By.cssSelector(locatorValue));
			break;

		default:
			System.err.println("Invalid Locator Type :  " + locatorType);
			break;
		}

		return element;
	}

	public static void enterText(String locatorType, String locatorValue, String textToEnter) {

		getWebElement(locatorType, locatorValue).sendKeys(textToEnter);
	}

	public static void clickOnButton(String locatorType, String locatorValue) {
		getWebElement(locatorType, locatorValue).click();
	}

	public static void selectValueFromDropDown(String locatorType, String locatorValue, String textToSelect) {
		WebElement element = getWebElement(locatorType, locatorValue);
		Select select = new Select(element);
		select.selectByValue(textToSelect);
	}

	public static void maximizeWindow() {
		driver.manage().window().maximize();
	}

	public static void closeBrowser() {
		driver.close();
	}

	public static void closeAllBrowsers() {
		driver.quit();

	}
}
