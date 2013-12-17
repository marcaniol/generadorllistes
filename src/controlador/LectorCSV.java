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
import java.util.ArrayList;
import java.util.Iterator;
import java.util.TreeSet;
import model.Alumne;
import model.CatalegMateries;
import model.Materia;

/**
 *
 * @author marc
 */
public class LectorCSV {
    
    private static File cvs;
    private CatalegMateries cataleg;
    
    public LectorCSV(File cvs){
        this.cvs = cvs;
    }

    public File getCvs() {
        return cvs;
    }

    public void setCvs(File cvs) {
        this.cvs = cvs;
    }
    
    public CatalegMateries obtenirInformacioCSV(){
        // Crear el cataleg de materies
        CatalegMateries cataleg = new CatalegMateries();
        TreeSet<Materia> setMateries = new TreeSet<Materia>();
        try {
            // Llegir l'arxiu
            BufferedReader inputStream = new BufferedReader(new FileReader("/home/marc/NetBeansProjects/matriculats.csv"));
            
            String linea, cognomsNom, curs, llistaMateries;
            while((linea = inputStream.readLine()) != null){
                String[] sepCometes = linea.split("\"");
                cognomsNom = sepCometes[1];
                curs = sepCometes[3];
                llistaMateries = sepCometes[5];

                String[] materia = llistaMateries.split(",");
                
                for(int i = 0; i < materia.length ; i++){
                    Materia m = new Materia(materia[i], new ArrayList<Alumne>());
                    m.getAlumnes().add(new Alumne(cognomsNom, curs));
                    
                    setMateries.add(m);
                    System.out.println(i);
                }                
                 cataleg.setLlistaMateries(setMateries);
            }
            
        } catch (FileNotFoundException ex) {
            System.err.println(ex.getMessage());
        } catch (IOException ex) {
            System.err.println(ex.getMessage());
        }
        
        return cataleg;
    }
    
    
    
    public static void main(String[] args){
        LectorCSV csv = new LectorCSV(cvs);
        
        CatalegMateries cataleg = csv.obtenirInformacioCSV();
        
        Iterator<Materia> it = cataleg.getLlistaMateries().iterator();
        
        while(it.hasNext()){
            System.out.println(it.next().getNom());
        }
    }
     
}
