package com.tests;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import com.common.Constant;
import com.common.Keyword;
import com.pages.login.LoginPage;

public class LoginTests  {
	@Test
	public void FB_001() {

		Keyword.openBrowser("Chrome");
		Keyword.openURL("https://www.facebook.com/");

		LoginPage lp = PageFactory.initElements(Constant.driver, LoginPage.class);
		lp.enterEmail("test@gmail.com");
		lp.enterPassword("Admin32@");
	}

}
