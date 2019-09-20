/*
   File: ICar.java
   
   This interface is binding contract to the Car class 

*/

package com.jonathan_sequeira.garage;

/**
 * 
 * I affirm that this program is entirely my own work and none 
 * of it is the work of any other person.
 * 
 * @author Jonathan Sequeira
**/

/**
 * Ensures the Car class meets the requirements of the interface.
 * 
 */

public interface ICar {
    
    public int getTimesMoved() ;
    
    public void moveCar() ;
    
    public String getLicense () ;
    
    public String getStatus () ;
    
    public void updateStatus (Car _car) ;
    
}
