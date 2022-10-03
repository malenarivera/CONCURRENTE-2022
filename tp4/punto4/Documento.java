/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package universidad.concurrente.tp4.punto4;

/**
 *
 * @author male_
 */
public class Documento {
    private char tipo;
    
    public Documento (char tipo){
        this.tipo=tipo;
    }
    
    public char getTipo(){
        return this.tipo;
    }
    
}
