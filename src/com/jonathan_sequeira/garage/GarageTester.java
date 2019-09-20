/*
   File: GarageTester.java
   
   This class tests the Garage class, using the Scanner class and method 
   hasNext() to read parking data obtained from either user file slection 
   or default file location for garage.txt by using a custom Config class that
   can check if a file is valid and an overloaded method that can either take 
   the file path or not.
   
   After reading the data for each Car, a Car object is created
   and added to the garage where the valet method takes care of the logic 
   of the depart and arrive methods.
   
   Note: If no path is chosen for the file. In that case, the default root 
   path is used to obtain the garage.txt.
 */

package com.jonathan_sequeira.garage ;

import java.awt.Dimension ;
import java.io.FileNotFoundException ;
import java.util.Scanner ;
import javax.swing.JOptionPane ;
import javax.swing.UIManager ;

/**
 * 
 * I affirm that this program is entirely my own work and none 
 * of it is the work of any other person.
 * 
 * @author Jonathan Sequeira
**/

/**
 * GarageTester retrieves file used for processing 
 * then while the file contains data will continue to iterate and 
 * create new Car objects to be valet into the garage.
 */
public class GarageTester {

    public static void main(String[] args) throws FileNotFoundException {

        // Asks user to select file path
        String file = Config.selectFile() ;

        // Creates Garage object
        Garage fiuParking = new Garage() ;
        
        // Checks if  file was selected and uses the file path to read the file.
        if (file == null) {

            Scanner scan = new Scanner(Config.getGarageFile()) ;

            while (scan.hasNext()) {
                
                 // Stores each token 
                String licensePlate = scan.next() ;

                String status = scan.next();

                if (Config.isValidFile(licensePlate, status)) {

                    fiuParking.valetCars(new Car(licensePlate, status)) ;

                }

            }
            
            // Checks if file exists in the root folder
        } else if (Config.getGarageFile().exists()) {

            Scanner scan = new Scanner(Config.getGarageFile(file)) ;

            while (scan.hasNext()) {
                
                // Stores each token 
                String licensePlate = scan.next() ;

                String status = scan.next() ;
                
                // Checks if file contains the correct format and data
                if (Config.isValidFile(licensePlate, status)) {
                    
                    // Logic that calls depart and arrive methods
                    //based on status of vehicle
                    fiuParking.valetCars(new Car(licensePlate, status)) ;

                }

            }
        }
        
        // Increases the dimesnions for the dialog message
        UIManager.put("OptionPane.minimumSize", new Dimension(600, 600)) ;
        
        // Displays results gathered from the valet method by appending 
        // actions to a string and neatly displaying them for the user
        JOptionPane.showMessageDialog(null,
                fiuParking.getResults(), "Garage Parking Results",
                JOptionPane.INFORMATION_MESSAGE);
        
        // Used to indicate successful termination
        System.exit(0) ;
    }
}
