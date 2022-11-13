/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package universidad.concurrente.segundoParcial.temaTres;

/**
 *
 * @author male_
 */
public class MontañaRusa implements Runnable{
    private Carro c;
    private int cantVueltas;
    
    public MontañaRusa(Carro c, int cantVueltas){
        this.c=c;
        this.cantVueltas=cantVueltas;
        
    }
    
    public void run(){
        //ESTE WHILE LO TENGO ASI PARA Q CORTE LA EJECUCION :P
        while(cantVueltas>0){
            c.empezarAtraccion();
            System.out.println("Empezo la Montaña Rusa!!");
            this.simularTiempo();
            System.out.println("Termino la Montaña Rusa");
           c.terminarAtraccion();
           cantVueltas--;
        }
        System.out.println("----------"+'\n'+"ATRACCION CERRADA"+'\n'+"----------");
    }
    
    private void simularTiempo(){
        try {
            Thread.sleep(4000);
        } catch (Exception e) {
        }
    }
    
}
