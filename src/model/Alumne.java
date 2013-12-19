/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package model;

/**
 *
 * @author marc
 */
public class Alumne implements Comparable<Alumne>{
    
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

    @Override
    public int compareTo(Alumne t) {
        return cognomsNom.compareTo(t.getCognomsNom());
    }
    
    @Override
    public String toString(){
        return "COGNOMS, NOM: " + cognomsNom + " - GRUP: " + grup;
    }
    
}
