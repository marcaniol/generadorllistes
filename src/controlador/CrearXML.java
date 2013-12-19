/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package controlador;

import java.util.TreeMap;
import java.util.TreeSet;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import model.Alumne;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

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
        this.setMateriesSeleccionades(materiesSeleccionades);
    }
    
    public void generarArxiu(String nomArxiu){
        try {
            // Crear el document
            DocumentBuilderFactory docFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder docBuilder = docFactory.newDocumentBuilder();
            Document doc = docBuilder.newDocument();
            
            // Crear l'element arrel
            Element root = doc.createElement("llistes");
            
            // Iterar per les materies seleccionades
            for(int i = 0; i < materiesSeleccionades.length ; i++){
                Element materia = doc.createElement("llista");
                
                materia.setAttribute("materia", materiesSeleccionades[i]);
                
                // Iterar pel alumnes de la materia
                
            }
            
            
            
            // Crear 
        } catch (ParserConfigurationException ex) {
            System.err.println(ex.getMessage());
        }
    }   
    
}
