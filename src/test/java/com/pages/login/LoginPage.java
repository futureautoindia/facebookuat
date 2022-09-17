package com.pages.login;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class LoginPage {
	@CacheLookup
	@FindBy(xpath = "//input[@name='email']")
	WebElement emaill; // id or name (driver.findElement(By.name("email")))

	@FindBy(how = How.XPATH, using = "//input[@name='pass']")
	WebElement password;

	public void enterEmail(String value) {

		emaill.sendKeys(value);
	}

	public void enterPassword(String passwd) {
		password.sendKeys(passwd);
	}

	public void enterEmailIntoAnField() {
		emaill.click();
	}
}
