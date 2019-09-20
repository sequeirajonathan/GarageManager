/*
   File: Garage.java
   
   This class contains the harness of the Garage 
   function to park vehicles in the garage using the valet method which takes
   a Car type for a signature. Based on the file input the car is parked, moved
   or dispatched based on the status of a vehicle. If object exists within the 
   cars array list the object is updated with the new data so 
   no new objects will be created if already instantiated.

 */
package com.jonathan_sequeira.garage;

/**
 * 
 * I affirm that this program is entirely my own work and none 
 * of it is the work of any other person.
 * 
 * @author Jonathan Sequeira
**/

import java.util.ArrayList; // import the ArrayList class

/**
 * A Garage consists of properties such as GARAGE_LIMIT which is a constant of 
 * the max capacity of the garage, A constant cars array list that holds car 
 * objects, a status String array yo use as a flag for Car object status,
 * and a results string which is being appended to as the program 
 * executes to be later used in a results visual.
 */
public class Garage implements IGarage { // Garage Interface

    private final int GARAGE_LIMIT = 10 ; // Max occupancy of vehicles

    private final ArrayList< Car> cars ; // Stores Cars parked in garage

    private final String[] status = new String[]{"ARRIVE", "DEPART"} ;

    private String results = "" ; // processed results appended to string

    
     /**
     *
     * Constructor that initializes the array list 
     * that will store the Car objects.
     */
    public Garage() {

        this.cars = new ArrayList<>() ;
    }

     /**
     * Method that determines what to do based on the status of a vehicle
     * can park, turn away, move, and dispatch vehicles.
     * 
     * @param _car car to be parked or dispatched.
     */
    @Override
    public void valetCars(Car _car) {
        try {

            // Checks if garage is empty, if so park first car.
            if (this.cars.isEmpty()) {

                System.out.print(arrive(_car)) ;

            } else {

                // Checks the garage if there are any spaces available
                // using the status 0 for ARRIVE and the method that 
                // returns true if space is available in garage.
                if (_car.getStatus().equals(status[0]) && spaceAvailable()) {

                    System.out.print(arrive(_car)) ;
                    
                // Checks if garage if no space vailable and checks if vehicle status mathcrs 
                // ARRIVE, if so then vehicle is rejected and never parked.
                } else if (_car.getStatus().equals(status[0]) && !spaceAvailable()) {
                    
                    // Accumulates the results into a string.
                    results += "No space available in"
                            + " FIU garage for " + _car.getLicense() + "\n" ;

                    System.out.print("No space available in"
                            + " FIU garage for " + _car.getLicense() + "\n") ;

                } else if (_car.getStatus().equals(status[1])) {
                    // When the status of a vehicle is 
                    // DEPART the depart method is called
                    System.out.print(depart(_car)) ;

                }
            }
            
            // Throws an exeption if try block fails to e
            // xecute but still runs program.
        } catch (Exception ex) {

            throw ex;

        }
    }

    
     /**
     * Checks the size of the array list to see if it is less than limit.
     *
     * @return true if size is less than 10.
     */
    @Override
    public boolean spaceAvailable() {
        return this.cars.size() < this.GARAGE_LIMIT ;
    }
    
     /**
     * Adds the car passed to the garage array list.
     *
     * @param _car the car to be added to the garage.
     * @return a string with plate of the car parked and departing position.
     */
    @Override
    public String arrive(Car _car) {

        this.cars.add(_car) ;
        
        // if not found in array list -1 is returned.
        int position = -1 ;

        // Loop that gets the postion of the vehicle.
        for (int i = 0; i < cars.size(); i++) {
            
            // When mathced by license plate postion is updated.
            if (this.cars.get(i).getLicense().equals(_car.getLicense())) {
                position = i ;
            }
        }

        // Accumulates results.
        results += _car.getLicense() + " Parked in spot " 
                + (position + 1) + "\n" ;
        
        return _car.getLicense() + " Parked in spot " 
                + (position + 1) + "\n" ;
    }

     /**
     * Dispatches the car passed and removes it from the array list.
     *
     * @param _car the car to be added to the garage.
     * @return a string with plate, position of departure and times moved.
     */
    @Override
    public String depart(Car _car) {

        int currentPosition = -1;

        // Loop that gets the postion of the vehicle.
        for (int i = 0; i < cars.size(); i++) {

             // When mathced by license plate postion is updated.
            if (this.cars.get(i).getLicense().equals(_car.getLicense())) {
                currentPosition = i;

            }
        }
        
        // If position is -1 this means vehicle was never parked in garage.
        if (currentPosition == -1) {

            results += _car.getLicense()
                    + " Cannot depart beacause "
                    + "it was never parked in FIU garage.\n" ;

            return _car.getLicense()
                    + " Cannot depart beacause "
                    + "it was never parked in FIU garage.\n" ;

        } else {
            
            // If positon is zero car does not need to be moved.
            if (currentPosition > 0) {
                
                // Current position determines exactly 
                // how many cars are in front of it by 
                //starting from the current postion and iterating backwards, 
                //the cars in front are moved in acending order.
                for (int i = currentPosition - 1; i >= 0; i--) {
                    
                    this.cars.get(i).moveCar() ;
                    
                }
            }
            
            // gstores the amount of times the car was moved out of
            //the garage temporarily.
            int timesMoved = this.cars.get(currentPosition).getTimesMoved() ;
            
            // Lambda expression used on array list to filter 
            // and remove an object if the license plate returns true.
            this.cars.removeIf((licensePlate) -> {
                
                return licensePlate.getLicense().equals(_car.getLicense());
                
            });
            
            // Logic that customizes message if it was moved more than once.
            if (timesMoved != 1) {

                results += _car.getLicense() + " Departed from spot "
                        + (currentPosition + 1) + ", vehicle was moved "
                        + timesMoved + " times.\n" ;

                return _car.getLicense() + " Departed from spot "
                        + (currentPosition + 1) + ", vehicle was moved "
                        + timesMoved + " times.\n" ;

            } else {

                results += _car.getLicense() + " Departed from spot "
                        + (currentPosition + 1) + ", vehicle was moved "
                        + timesMoved + " time.\n" ;

                return _car.getLicense() + " Departed from spot "
                        + (currentPosition + 1) + ", vehicle was moved "
                        + timesMoved + " time.\n" ;

            }

        }

    }
    
     /**
     *
     * A joined string logging all of the results executed 
     * used as a display message for the user.
     * 
     * @return results string.
     */
    @Override
    public String getResults() {

        return this.results ;
    }

}
