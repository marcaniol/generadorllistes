/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package model;

import java.util.ArrayList;

/**
 *
 * @author marc
 */
public class Materia {
    
    private String nom;
    private ArrayList<Alumne> alumnes;
    
    /**
     * Constructor amb paràmetres
     * @param nom
     * @param alumnes 
     */
    public Materia(String nom, ArrayList<Alumne> alumnes) {
        this.nom = nom;
        this.alumnes = alumnes;
    }
    
    /**
     * Constructor per defecte
     */
    public Materia(){
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public ArrayList<Alumne> getAlumnes() {
        return alumnes;
    }

    public void setAlumnes(ArrayList<Alumne> alumnes) {
        this.alumnes = alumnes;
    }
    
    
}
