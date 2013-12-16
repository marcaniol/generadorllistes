/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
//hola
package model;

/**
 *
 * @author marc
 */
public class Alumne {
    
    private String cognomsNom, grup;
    
    public Alumne(String cognomsNom, String grup) {
        this.cognomsNom = cognomsNom;
        this.grup = grup;
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
    
    
    
}
