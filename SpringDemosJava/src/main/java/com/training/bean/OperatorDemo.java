package com.training.bean;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import com.training.interfaces.Operator;

public class OperatorDemo {

	//@Qualifier(value = "mul")
	@Autowired
	private Operator operator;

	/*public void setOperator(Operator operator)
	{
		this.operator=operator;
	}*/
		
	public int getResult(int x, int y)
	{
		return operator.operate(x, y);
	}
	
}
