package com.wolverine.pattern.Factory.abstractFactory;

//创建型号为B的产品工厂 
public class FactoryB implements Factory{ 
     //创建洗衣机-B 
     public Washer createWasher(){ 
          return new WasherB(); 
     } 

     //创建冰箱-B 
     public Icebox createIcebox(){ 
          return new IceboxB(); 
     } 
} 
