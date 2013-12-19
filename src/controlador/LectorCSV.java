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
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;
import javax.swing.DefaultListModel;
import model.Alumne;

/**
 *
 * @author marc i aniol
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
    
    public TreeMap<String, TreeSet<Alumne>> obtenirInformacioCSV(){
        // Crear les llistes necessaries
        TreeMap<String, TreeSet<Alumne>>  materies = new TreeMap<String, TreeSet<Alumne>>();
        String linea, cognomsNom, grup, llistaMateries;
        DefaultListModel llistaElements = new DefaultListModel();
        
        // Cadena que comprovara la validesa del document
        
        try {
            // Llegir l'arxiu
            BufferedReader buffer = new BufferedReader(new FileReader(rutaArxiu));
            
            while((linea = buffer.readLine()) != null){
                // Extreure informació
                String[] sepCometes = linea.split("\"");
                cognomsNom = sepCometes[1];
                grup = sepCometes[3];
                llistaMateries = sepCometes[5];

                String[] materia = llistaMateries.split(",");
                
                // Iterar materies
                for(int i = 0; i < materia.length ; i++){
                    
                    // Comprovar si la materia existeix a la collecció
                    if(materies.containsKey(materia[i])){
                        materies.get(materia[i]).add(new Alumne(cognomsNom, grup));
                    } else {
                        TreeSet<Alumne> alumnes = new TreeSet<Alumne>();
                        alumnes.add(new Alumne(cognomsNom, grup));
                        materies.put(materia[i], alumnes);
                    }
                }
            }
                        
            
        } catch (FileNotFoundException ex) {
            System.err.println(ex.getMessage());
        } catch (IOException ex) {
            System.err.println(ex.getMessage());
        }
        
        
        mostrar(materies);
        return materies;
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

    private void mostrar(TreeMap<String, TreeSet<Alumne>> materies) {
        Set<Entry<String, TreeSet<Alumne>>> clauValor =  materies.entrySet();
	Iterator<Entry<String, TreeSet<Alumne>>> it = clauValor.iterator();
        
        Entry<String, TreeSet<Alumne>> entrada;
        
        while(it.hasNext()){
            entrada = it.next();
            
            System.out.println("MATERIA: " + entrada.getKey());
            System.out.println("ALUMNES: ");
            
            Iterator<Alumne> it2 = entrada.getValue().iterator();
            
            while(it2.hasNext()){
                System.out.println(it2.next().toString());
            }
        }
    }
    
}