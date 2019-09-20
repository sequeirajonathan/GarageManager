/*
   File: Config.java
   
   This class consitis of static methods to be used as 
   helpers to keep code clean and readable. Contains methods that return file paths,
   and validate files for processing in the application.
 */

package com.jonathan_sequeira.garage;

import java.io.File ;
import java.nio.file.Path ;
import java.nio.file.Paths ;
import javax.swing.JFileChooser ;

/**
 * 
 * I affirm that this program is entirely my own work and none 
 * of it is the work of any other person.
 * 
 * @author Jonathan Sequeira
**/

/**
 * Configuration class consists of helper methods for file 
 * retrieval and processing.
 */
public class Config{

     /**
     * Gets the file object to use on the 
     * Scanner class by locating the path of the file.
     *
     * @return A File object to be used by Scanner
     */
    public static File getGarageFile() {

        // Path handle
        Path currentRelativePath = Paths.get("") ;
        
        // Uses path handle to get relative path.
        String currentPath = currentRelativePath.toAbsolutePath().toString() ;

        // Append the file name to relative path
        String fileLocation = currentPath + "\\" + "garage.txt" ;

        // Returns the file to be used with the correct path information.
        return new File(fileLocation) ;
    }

    /**
     * Overloaded method that uses the file selected by user
     * and implements it with the Scanner class. 
     * 
     * @param filePath from file selector.
     * @return A File object to be used by Scanner
     */
    public static File getGarageFile(String filePath) {

        return new File(filePath) ;
    }

    
    /**
     * Initiates the file picker pop up for the user to select the file for 
     * processing.
     * 
     * @return A File path string.
     */
    public static String selectFile() {

        // Initiates GUI file picker
        JFileChooser chooser = new JFileChooser() ;
        
        // Sets current directory to the root of executable.
        chooser.setCurrentDirectory(new java.io.File(".")) ;

        // Mesaage for user.
        chooser.setDialogTitle("Select file for processing") ;

        // Allows user to choose folders and files.
        chooser.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES) ;
        
        // Determines whether the AcceptAll FileFilter is used as an 
        // available choice in the choosable filter list.
        chooser.setAcceptAllFileFilterUsed(false) ;
        
        // If user approves of selection the absolute path is returned
        if (chooser.showOpenDialog(null) == JFileChooser.APPROVE_OPTION) {

            return chooser.getSelectedFile().getAbsolutePath() ;
            
        // else null is returned
        } else {

            return null ;

        }
    }

    
    
    /**
     * Checks the data set for any fallacies
     * 
     * @param licensePlate car license plate
     * @param status car garage status ARRIVE or DEPART
     * @return true when both license plate and status is valid
     */
    public static boolean isValidFile(String licensePlate, String status) {

        boolean validPlate = false ;

        boolean validStatus = false ;

        // If the first scan token does not
        // match JAV it is not considered valid.
        if ((licensePlate.contains("JAV"))) {

            validPlate = true ;

        }
        
        // If ARRIVE or DEPART don't match on second scanner token 
        // it is not considered valid.
        if (status.equals("ARRIVE") || status.equals("DEPART")) {

            validStatus = true ;

        }

        return validPlate && validStatus ;

    }
}
