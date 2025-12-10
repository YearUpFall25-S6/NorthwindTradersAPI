package com.pluralsight.NorthwindTradersAPI;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class NorthwindTradersApiApplication {

	public static void main(String[] args) {
	  ApplicationContext app =  SpringApplication.run(NorthwindTradersApiApplication.class, args);

//	  for(String s : app.getBeanDefinitionNames()){
//		  System.out.println(s);
//	  }


	}

}
