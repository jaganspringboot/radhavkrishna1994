package com.training.bean;

import com.training.interfaces.Operator;

public class OperatorDemo {

	private Operator operator;

	public void setOperator(Operator operator) {
		this.operator = operator;
	}
	
	
	public int getResult(int x, int y)
	{
		return operator.operate(x, y);
	}
	
}
