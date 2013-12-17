/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package model;

import java.util.TreeSet;

/**
 *
 * @author marc
 */
public class CatalegMateries {
    
    private TreeSet<Materia> llistaMateries;
    
    public CatalegMateries(TreeSet<Materia> llistaMateries) {
        this.llistaMateries = llistaMateries;
    }

    public CatalegMateries() {
    }

    public TreeSet<Materia> getLlistaMateries() {
        return llistaMateries;
    }

    public void setLlistaMateries(TreeSet<Materia> llistaMateries) {
        this.llistaMateries = llistaMateries;
    }
    
    
}
