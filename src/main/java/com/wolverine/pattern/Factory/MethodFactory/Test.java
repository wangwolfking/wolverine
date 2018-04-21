package com.wolverine.pattern.Factory.MethodFactory;

public class Test {

	public static void main(String[] args) {
		Factory fa = new CreateAirCondition();
		fa.create();
		Factory fb = new CreateIcebox();
		fb.create();
		Factory fc = new CreateWasher();
		fc.create();

	}

}
