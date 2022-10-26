/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package universidad.concurrente.aog25del10.punto2;

/**
 *
 * @author GRUPO 7
 * TORRES, ANTONELLA
 * VALDESOLO, MATEO
 * RIVERA, MALENA
 */
public class Recipiente implements Runnable {
     private Espacio e;


    public Recipiente (Espacio e){
        this.e=e;
    }
    public void run (){
        while (true){
            e.avisarRecipienteVacio();
            e.chequearRecipienteLleno();
            System.out.println(" VACIA RECIPIENTE ");
            try {
                Thread.sleep(100);
            } catch (InterruptedException e1) {
                // TODO Auto-generated catch block
                e1.printStackTrace();
            }

        }
    }
    
}
