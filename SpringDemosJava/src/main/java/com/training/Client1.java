package com.training;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;


import com.training.bean.OperatorDemo;
import com.training.config.MyConfiguration;
import com.training.interfaces.Operator;


public class Client1
{
    public static void main( String[] args )
    {
        
    	//load the context 
    	ApplicationContext context = new AnnotationConfigApplicationContext(MyConfiguration.class);
    	
    	OperatorDemo operatorDemo = (OperatorDemo) context.getBean(OperatorDemo.class);
    	
    	System.out.println(operatorDemo.getResult(12, 13));
    	
    
    	
    	
    
    }
}
