package com.example.config_client;

import org.springframework.beans.factory.annotation.Value;

public class Show {
	
	
	 @Value("${welcome.message}")
	  static String welcomeText;
	 
	public void sho() {
		System.out.println(welcomeText);
	}

}
