package com.training;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;


import com.training.bean.HelloWorld;
import com.training.config.MyConfiguration;

public class Client
{
    public static void main( String[] args )
    {
        
    	//load the context 
    	ApplicationContext context = new AnnotationConfigApplicationContext(MyConfiguration.class);
    	
    	HelloWorld hello = (HelloWorld) context.getBean(HelloWorld.class);
        
        System.out.println(hello.sayHello());
        
        
    }
}
