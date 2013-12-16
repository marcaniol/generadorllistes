/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package controlador;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author marc
 */
public class LectorCSV {
    
    private static File cvs;
    
    public LectorCSV(File cvs){
        this.cvs = cvs;
    }

    public File getCvs() {
        return cvs;
    }

    public void setCvs(File cvs) {
        this.cvs = cvs;
    }
    
    public static void main(String[] args){
        try {
            // Llegir l'arxiu
            BufferedReader inputStream = new BufferedReader(new FileReader("/home/marc/NetBeansProjects/matriculats.csv"));
            
            String linea;
            while((linea = inputStream.readLine()) != null){
                String[] sepCometes = linea.split("\"");
                System.out.println(sepCometes[1]); // CognomsNom
                System.out.println(sepCometes[3]); // Curs
                
                System.out.println(sepCometes[5]); // Materies
                String[] materies = sepCometes[5].split(",");
                for(int i = 0; i < materies.length ; i++){
                    System.out.println(materies[i]);
                }                
                
            }
            
        } catch (FileNotFoundException ex) {
            Logger.getLogger(LectorCSV.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(LectorCSV.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
     
}
