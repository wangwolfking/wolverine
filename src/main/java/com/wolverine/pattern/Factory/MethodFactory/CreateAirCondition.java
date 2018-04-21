package com.wolverine.pattern.Factory.MethodFactory;

//创建空调的工厂 
public class CreateAirCondition implements Factory{ 
  public Product create(){ 
        return new AirCondition(); 
  } 
} 
