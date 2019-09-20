/*
   File: IGarage.java
   
   This interface is binding contract to the Garage class 

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
 * Ensures the Garage class meets the requirements of the interface.
 * 
 */
public interface IGarage {

    public void valetCars(Car _car) ;

    public boolean spaceAvailable() ;

    public String arrive(Car _car) ;

    public String depart(Car _car) ;

    public String getResults() ;

}
