package com.training;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;


import com.training.bean.OperatorDemo;


public class Client1
{
    public static void main( String[] args )
    {
        
    	//load the context 
    	ApplicationContext context = new ClassPathXmlApplicationContext("spring.xml");
    	
    	OperatorDemo operatorDemo = (OperatorDemo) context.getBean("demo");
    	
    	System.out.println(operatorDemo.getResult(12, 13));
    	System.out.println(operatorDemo.hashCode());
    	
    	OperatorDemo operatorDemo1 = (OperatorDemo) context.getBean("demo");
        
    	System.out.println(operatorDemo1.hashCode());
    }
}
