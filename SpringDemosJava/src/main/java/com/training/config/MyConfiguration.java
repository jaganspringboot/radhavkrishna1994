package com.training.config;

import org.springframework.context.annotation.Bean;

import com.training.bean.HelloWorld;

// configuration instead of spring.xml
public class MyConfiguration {

	//HelloWorld
	
	@Bean
	public HelloWorld getHelloWorld()
	{
		HelloWorld hello = new HelloWorld();
		hello.setMessage("This is a message with java config");
		return hello;
	}
	
	
	
}
