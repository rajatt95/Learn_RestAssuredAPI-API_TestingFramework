package com.learning.setup.stripe;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import com.learning.utilities.Constants;
import com.learning.utilities.ExcelReader;

import io.restassured.RestAssured;

public class BaseTest_Stripe {

	public Properties config = new Properties();

	@BeforeSuite
	public void setup() {
		// RestAssured.baseURI = config.getProperty("stripe_baseURI");
		RestAssured.baseURI = Constants.Stripe_BaseURI;
		RestAssured.basePath = Constants.Stripe_BasePath;

		FileInputStream fis = null;
		try {
			fis = new FileInputStream(Constants.Properties_Config);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		try {
			config.load(fis);
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	@AfterSuite
	public void tearDown() {

	}
}
