package com.automationpractice.utilities;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

public class ReadConfig {
	
	Properties Pro;
	
	public ReadConfig() {
		File src = new File("./Configuration/config.properties");
		try {
			FileInputStream fis = new FileInputStream(src);
			Pro = new Properties();
			Pro.load(fis);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public String getApplicationUrl()
	{
		String url = Pro.getProperty("baseURL");
		return url;
	}
	
	public String getChromepath()
	{
		String chromepah = Pro.getProperty("chromepath");
		System.out.println("Chrom path---"+chromepah);
		return chromepah;
	}
	
	public String getUsername()
	{
		 String user = Pro.getProperty("username");
		 return user;
	}
	
	public String getPassword()
	{
		 String pass = Pro.getProperty("password");
		 return pass;
	}
	

}
