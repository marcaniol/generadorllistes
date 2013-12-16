/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package controlador;

import java.io.File;

/**
 *
 * @author marc
 */
public class LectorCSV {
    
    private File cvs;
    
    public LectorCSV(File cvs){
        this.cvs = cvs;
    }

    public File getCvs() {
        return cvs;
    }

    public void setCvs(File cvs) {
        this.cvs = cvs;
    }
     
}
