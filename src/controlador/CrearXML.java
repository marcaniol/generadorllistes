/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package controlador;

import java.io.File;
import java.util.Iterator;
import java.util.List;
import java.util.TreeMap;
import java.util.TreeSet;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import model.Alumne;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

/**
 *
 * @author marc
 */
public class CrearXML {
    
    private TreeMap<String, TreeSet<Alumne>> materies;
    private List<String> seleccionats;
    
    /**
     * Constructor per defecte
     */
    public CrearXML(){
    }
    
    /**
     * Constructor amb paràmetres
     * @param materies
     * @param seleccionats 
     */
    public CrearXML(TreeMap<String, TreeSet<Alumne>> materies, List<String> seleccionats) {
       this.materies = materies;
       this.seleccionats = seleccionats;
    }

    public TreeMap<String, TreeSet<Alumne>> getMateries() {
        return materies;
    }

    public void setMateries(TreeMap<String, TreeSet<Alumne>> materies) {
        this.materies = materies;
    }

    public List<String> getMateriesSeleccionades() {
        return seleccionats;
    }

    public void setMateriesSeleccionades(List<String> seleccionats) {
        this.setMateriesSeleccionades(seleccionats);
    }
    
    public boolean generarArxiu(String nomArxiu){
        boolean retorn = false;
        try {
            // Crear el XML DOM Object
            DocumentBuilderFactory docFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder docBuilder = docFactory.newDocumentBuilder();
            Document doc = docBuilder.newDocument();
            
            // Crear l'element arrel
            Element root = doc.createElement("llistes");
            doc.appendChild(root);
            
            // Iterar pels elements seleccionats
            Iterator<String> it =  seleccionats.iterator();
            
            while(it.hasNext()){
                String materia = it.next();
                Element etMateria = doc.createElement("llista");
                etMateria.setAttribute("materia", materia);
                root.appendChild(etMateria);
                
                // Iterar pel alumnes de la materia
                TreeSet<Alumne> alumnes = materies.get(materia);
                Iterator<Alumne> it2 = alumnes.iterator();
                
                while(it2.hasNext()){
                    // Capturar alumne
                    Alumne a = it2.next();
                    // Crear etiqueta alumne
                    Element etAlumne = doc.createElement("alumne");
                        // Crear etiquetes <cognomsNom> i <grup>. Assignar-li els valors
                        Element etCognomsNom = doc.createElement("cognomNom");
                        etCognomsNom.appendChild(doc.createTextNode(a.getCognomsNom()));
                        Element etGrup = doc.createElement("grup");
                        etGrup.appendChild(doc.createTextNode(a.getGrup()));
                    // Assignar les etiquetes fills a <alumne>
                    etAlumne.appendChild(etCognomsNom);
                    etAlumne.appendChild(etGrup);
                    
                    // Assignar els alumnes a la materia
                    etMateria.appendChild(etAlumne);
                    retorn = true;
                }
            }
            // Enregistrar el contingut a disc
            try {
                TransformerFactory transformerFactory = TransformerFactory.newInstance();
                Transformer transformer = transformerFactory.newTransformer();
                DOMSource source = new DOMSource(doc);
                StreamResult result = new StreamResult(new File(nomArxiu));
                
                // Propietats de sortida, format.
                transformer.setOutputProperty(OutputKeys.INDENT, "yes");
                transformer.setOutputProperty(OutputKeys.METHOD, "xml");
                transformer.setOutputProperty(OutputKeys.OMIT_XML_DECLARATION, "no");
                transformer.transform(source, result);
                
            } catch (TransformerConfigurationException ex) {
                System.err.println(ex.getMessage());
            } catch (TransformerException ex) {
                System.err.println(ex.getMessage());
            }            
                       
        } catch (ParserConfigurationException ex) {
            System.err.println(ex.getMessage());
        }
        return retorn;
    }   
}