/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package universidad.concurrente.tp3.p3;

/**
 *
 * @author male_
 */
public class Asiento {
    private boolean ocupado;
    
    public Asiento(){
        ocupado=false;
    }
    
    public void setOcupacion(){
        ocupado=true;
    }
    
    public boolean getOcupacion(){
        return ocupado;
    }
    
}
