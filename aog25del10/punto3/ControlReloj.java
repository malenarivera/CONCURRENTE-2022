/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package universidad.concurrente.aog25del10.punto3;

/**
 *
 * @author male_
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
            System.out.println("Despierto al primer hilo");
            r.despertarPrimerHilo();
            r.esperarZZZ();
        }
        
        
    }
    
    private void simularTiempoSueño(){
        try {
            System.out.println("SHHHHHHHHHHHHHHHHHHHHHH");
                Thread.sleep(4000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
    }

  
    
}
