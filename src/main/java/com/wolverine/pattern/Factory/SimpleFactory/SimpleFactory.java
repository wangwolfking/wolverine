package com.wolverine.pattern.Factory.SimpleFactory;

public class SimpleFactory {

	public static Product factory(String productName) throws Exception {
		if (productName.equals("Washer")) {
			return new Washer();
		} else if (productName.equals("Icebox")) {
			return new Icebox();
		} else if (productName.equals("AirCondition")) {
			return new AirCondition();
		} else {
			throw new Exception("没有该产品");
		}
	}

	public static void main(String[] args) {
		try {
			SimpleFactory.factory("Washer");
			SimpleFactory.factory("Icebox");
			SimpleFactory.factory("AirCondition");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
