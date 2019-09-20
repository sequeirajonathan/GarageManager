/**
 *
 * File: Car.java
 *
 * A Car has a license plate number, a parking status and number of times moved.
 *
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
 * A Car consists of a license plate, its current status, and the number of
 * times temporarily moved from garage.
 */
public class Car implements ICar {

    private final String licensePlate;

    private String status;

    private int timesMoved;

    /**
     * Creates a Car with a user-specified license plate number and the current
     * state of either "ARRIVE" or "DEPART".
     *
     * @param licensePlate the initial balance
     * @param status the initial balance
     */
    public Car(String licensePlate, String status) {

        this.licensePlate = licensePlate;

        this.timesMoved = 0;

        this.status = status;

    }

    /**
     * Gets the number of times the car was moved out of the garage.
     *
     * @return timesMoved
     */
    @Override
    public int getTimesMoved() {

        return this.timesMoved;

    }

    /**
     * Increments Car's move counter by 1
     */
    @Override
    public void moveCar() {

        this.timesMoved++;

    }

    /**
     * Gets the number of times the car was moved out of the garage.
     *
     * @return timesMoved
     */
    @Override
    public String getLicense() {

        return this.licensePlate;

    }

    /**
     * Gets the current status of the car in the garage.
     *
     * @return status
     */
    @Override
    public String getStatus() {

        return this.status;

    }

    /**
     * Updates the status of the car that already exists in the garage.
     *
     * @param car the car with an updated status.
     */
    @Override
    public void updateStatus(Car car) {

        this.status = car.status;

    }

}
