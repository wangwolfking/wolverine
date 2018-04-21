package com.wolverine.pattern.Factory.abstractFactory;

public class Test {

	public static void main(String[] args) {
		Factory fa = new FactoryA();
		Factory fb= new FactoryB();
		fa.createIcebox();
		fa.createWasher();
		fb.createIcebox();
		fb.createWasher();

	}

}
