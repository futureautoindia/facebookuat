package com.utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import com.common.Constant;

public class PropertiesFile {
	/**
	 * This method will open ObjectRepository.properties file and will return value
	 * associated with key
	 * 
	 * @param key
	 * @return
	 */
	public static String getProperty(String key) {
		String value = null;
		try {
			Constant.fis = new FileInputStream("Input/ObjectRepository.properties");
			Constant.prop = new Properties();
			Constant.prop.load(Constant.fis);
			value = Constant.prop.getProperty(key);

		} catch (IOException e) {

			e.printStackTrace();
		}
		return value;

	}

	public static String getProperty(String key, String filePath) {
		String value = null;
		try {
			Constant.fis = new FileInputStream(filePath);
			Constant.prop = new Properties();
			Constant.prop.load(Constant.fis);
			value = Constant.prop.getProperty(key);

		} catch (IOException e) {

			e.printStackTrace();
		}
		return value;

	}

	public static String[] getLocator(String key) {
		String[] value = null;
		try {
			Constant.fis = new FileInputStream("Input/ObjectRepository.properties");
			Constant.prop = new Properties();
			Constant.prop.load(Constant.fis);
			String part = Constant.prop.getProperty(key);
			value = part.split("##");// value[0]=locator , value[1]=locatorValue

		} catch (IOException e) {
			System.out.println("This is due to Exception in getLocator Method due to File not found");
			e.printStackTrace();
		}
		return value;

	}
}
