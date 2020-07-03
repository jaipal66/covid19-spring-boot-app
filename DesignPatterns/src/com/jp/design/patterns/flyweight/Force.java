package com.jp.design.patterns.flyweight;

public class Force implements Player{

	 // Intrinsic Attribute 
    private final String TASK; 
  
    // Extrinsic Attribute 
    private String weapon; 
  
    public Force() 
    { 
        TASK = "DIFFUSE BOMB"; 
    } 
    public void assignWeapon(String weapon) 
    { 
        this.weapon = weapon; 
    } 
    public void mission() 
    { 
        System.out.println("Force with weapon "
                           + weapon + "|" + " Task is " + TASK); 
    } 

}
