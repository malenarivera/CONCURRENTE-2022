/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package universidad.concurrente.aog25del10.punto3;

/**
 *
 * @author GRUPO 7
 * TORRES, ANTONELLA
 * VALDESOLO, MATEO
 * RIVERA, MALENA
 */
public class ControlReloj  implements Runnable {
    private Reloj r;
    public ControlReloj(Reloj r){
        this.r=r;
    }
    @Override

    public void run() {
        while (true){
           this.simularTiempoSueño();
            System.out.println("Termino la hora de dormir");
            System.out.println("Despierto al primer trabajador");
            System.out.println("-----------------------------------------");
            r.despertarPrimerHilo();
            r.esperarZZZ();
        }
        
        
    }
    
    private void simularTiempoSueño(){
        try {
            System.out.println("-----------------------------------------");
            System.out.println("TRABAJADORES DURMIENDO, SHHHH");
                Thread.sleep(4000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
    }

  
    
}
