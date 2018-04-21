package com.wolverine.pattern.proxy;

public class Client {
    
    private Subject proxy;
    
    public Client(){
        proxy = new Proxy();
    }

    public void buyTickets(){
        System.out.println("小王：我要买票...");
        proxy.soldTickets();
        System.out.println("小王：已买到票...");
    }
    
}
