package com.qa.util;

	import java.util.Base64;
	import java.util.Properties;

import com.microsoft.playwright.Locator;

	public abstract class WebActions {

	    public static String getProperty(String key) {
	        ConfigReader configReader = new ConfigReader();
	        Properties properties = configReader.loadConfigProperties();    // Reading from config properties file
	        String value = properties.getProperty(key);
	        System.out.println(key + ": " + value); // Add this line for debugging
	        return value;
	    }

	    public static boolean waitUntilElementDisplayed(Locator locator, int timeoutSec) {
	        boolean elementVisible = locator.isVisible();
	        int timer = 0;
	        while (!elementVisible && timer < timeoutSec) {
	            try {
	                Thread.sleep(1000);
	                elementVisible = locator.isVisible();
	                timer++;

	            } catch (Exception e) {
	                System.out.println(locator + "was not visible.");
	            }
	        }
	        return elementVisible;
	    }

	    //base64 encoding: This is used to encrypt the password and save the encrypted value in config.properties file
	    public static void encrypt() {
	        try {
	            byte[] encodedBytes = Base64.getEncoder().encode("yourPassword".getBytes("UTF-8"));
	            String encodedValue = new String(encodedBytes);
	        } catch (Exception e) {
	            System.out.println("Password was not Encrypted.");
	        }
	    }

	    //base64 decoding: This is used to decrypt the password from the encrypted value in config.properties file while passing to app
	    public static String decrypt(String passwordField) {
	        String encodedBytes = WebActions.getProperty(passwordField);
	        String decodedString = "";
	        try {
	            byte[] decodedBytes = Base64.getDecoder().decode(encodedBytes);
	            decodedString = new String(decodedBytes);
	        } catch (Exception e) {
	            System.out.println("Password was not Decrypted.");
	        }
	        return decodedString;
	    }

}
