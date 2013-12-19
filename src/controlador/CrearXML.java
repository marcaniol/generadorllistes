/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package controlador;

import java.util.TreeMap;
import java.util.TreeSet;
import model.Alumne;

/**
 *
 * @author marc
 */
public class CrearXML {
    
    private TreeMap<String, TreeSet<Alumne>> materies;
    private String[] materiesSeleccionades;
    
    /**
     * Constructor per defecte
     */
    public CrearXML(){
    }
    
    /**
     * Constructor amb paràmetres
     * @param materies
     * @param materiesSeleccionades 
     */
    public CrearXML(TreeMap<String, TreeSet<Alumne>> materies, String[] materiesSeleccionades){
        this.materies = materies;
        this.materiesSeleccionades = materiesSeleccionades;
    }

    public TreeMap<String, TreeSet<Alumne>> getMateries() {
        return materies;
    }

    public void setMateries(TreeMap<String, TreeSet<Alumne>> materies) {
        this.materies = materies;
    }

    public String[] getMateriesSeleccionades() {
        return materiesSeleccionades;
    }

    public void setMateriesSeleccionades(String[] materiesSeleccionades) {
        this.materiesSeleccionades = materiesSeleccionades;
    }
    
    
    
}
