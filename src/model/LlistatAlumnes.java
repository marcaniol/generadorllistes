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
public class LlistatAlumnes {
    
    private ArrayList<Alumne> llistatAlumnes;
    
    public LlistatAlumnes(){
    }
    
    public LlistatAlumnes(ArrayList<Alumne> llistatAlumnes){
        this.llistatAlumnes = llistatAlumnes;
    }

    public ArrayList<Alumne> getLlistatAlumnes() {
        return llistatAlumnes;
    }

    public void setLlistatAlumnes(ArrayList<Alumne> llistatAlumnes) {
        this.llistatAlumnes = llistatAlumnes;
    }
    
}
