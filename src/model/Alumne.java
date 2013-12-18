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
public class Alumne {
    
    private String cognomsNom, grup;
    private ArrayList<String> materies;
    
    public Alumne(String cognomsNom, String grup, ArrayList<String> materies) {
        this.cognomsNom = cognomsNom;
        this.grup = grup;
        this.materies = materies;
    }

    public String getCognomsNom() {
        return cognomsNom;
    }

    public void setCognomsNom(String cognomsNom) {
        this.cognomsNom = cognomsNom;
    }

    public String getGrup() {
        return grup;
    }

    public void setGrup(String grup) {
        this.grup = grup;
    }

    public ArrayList<String> getMateries() {
        return materies;
    }

    public void setMateries(ArrayList<String> materies) {
        this.materies = materies;
    }
    
    
    
}
