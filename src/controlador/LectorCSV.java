/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package controlador;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import javax.swing.DefaultListModel;
import model.Alumne;

/**
 *
 * @author marc
 */
public class LectorCSV {
    
    private String rutaArxiu;
    
    public LectorCSV(String rutaArxiu){
        this.rutaArxiu = rutaArxiu;
    }

    public String getRutaArxiu() {
        return rutaArxiu;
    }

    public void setRutaArxiu(String rutaArxiu) {
        this.rutaArxiu = rutaArxiu;
    }
    
    public ArrayList<Alumne> obtenirInformacioCSV(){
        // Crear les llistes necessaries
        ArrayList<Alumne> llistatAlumnes = new ArrayList<Alumne>();
        ArrayList<String> materies = new ArrayList<>();
        String linea, cognomsNom, curs, llistaMateries;
        DefaultListModel llistaElements = new DefaultListModel();
        
        // Cadena que comprovara la validesa del document
        
        try {
            // Llegir l'arxiu
            BufferedReader buffer = new BufferedReader(new FileReader(rutaArxiu));
            
            while((linea = buffer.readLine()) != null){
                // Extreure informació
                String[] sepCometes = linea.split("\"");
                cognomsNom = sepCometes[1];
                curs = sepCometes[3];
                llistaMateries = sepCometes[5];

                String[] materia = llistaMateries.split(",");
                
                for(int i = 0; i < materia.length ; i++){
                    materies.add(materia[i]);
                    // Afegir a la llista
                    omplirJList(llistaElements, materia[i]);
                }                
                
                // Afegir l'alumne a la llista
                llistatAlumnes.add(new Alumne(cognomsNom, curs, materies));
            }
                        
            
        } catch (FileNotFoundException ex) {
            System.err.println(ex.getMessage());
        } catch (IOException ex) {
            System.err.println(ex.getMessage());
        }
        
        return llistatAlumnes;
    }

    private DefaultListModel crearModelLlista(DefaultListModel llista, String materia) {
        
        for(int i = 0; i < llista.getSize(); i++){
            if(!llista.getElementAt(i).toString().equals(materia)){
                llista.addElement(materia);
            }
            llista.add(i, llista);
            System.out.println(llista.getSize());
        }        
        
        return llista;
    }

    private void omplirJList(DefaultListModel llistaElements, String materia) {
        
        for(int i = 0; i < llistaElements.getSize(); i++){
            if(llistaElements.getElementAt(i).equals(materia)) {
                System.out.println();
            }
        }
        
    }
    
}