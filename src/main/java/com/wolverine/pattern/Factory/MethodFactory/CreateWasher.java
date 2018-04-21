package com.wolverine.pattern.Factory.MethodFactory;

//创建洗衣机的工厂 
public class CreateWasher implements Factory {
	public Product create() {
		return new Washer();
	}
}
