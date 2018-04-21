package com.wolverine.pattern.Factory.MethodFactory;

//创建冰箱的工厂 
public class CreateIcebox implements Factory{ 
  public Product create(){ 
        return new Icebox(); 
  } 
} 

