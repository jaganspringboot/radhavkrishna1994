package com.training.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Scope;

import com.training.bean.AddOperator;
import com.training.bean.HelloWorld;
import com.training.bean.MultiplyOperator;
import com.training.bean.OperatorDemo;
import com.training.interfaces.Operator;

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
	
	/*
	 * @Bean(name="add") public Operator getOperatorAdd() { return new
	 * AddOperator(); }
	 */
	
	@Bean(name="mul")
	public Operator getOperatorMul()
	{
		return new MultiplyOperator();
	}
	
	@Bean
	public OperatorDemo getOperatorDemo()
	{
		OperatorDemo demo=new OperatorDemo();
	//	demo.setOperator(getOperatorMul());  //DI
		return demo;
	}
	
}
