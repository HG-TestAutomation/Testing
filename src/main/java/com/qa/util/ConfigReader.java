package com.qa.util;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class ConfigReader {
  

    //This is used to read from properties files and returns properties object
    public static Properties loadConfigProperties() {
    	Properties prop = new Properties();
       
        try {
            FileInputStream fileInputStream = new FileInputStream("./src/test/resources/config.properties");
            prop.load(fileInputStream);
        } catch (Exception e) {
            System.out.println("Unable to read Properties file.");
        }
        return prop;
    }
    
    public static Properties loadExtentProperties() {
    	
    	Properties prop = new Properties();
    		try {
    			FileInputStream ip = new FileInputStream("./src/test/resources/extent.properties");
    			prop.load(ip);
    		}catch(FileNotFoundException e) {
    			e.printStackTrace();
    		}catch (IOException e) {
    			e.printStackTrace();
    		}
    		return prop;
    	}
    	
    	
    }
    
    
