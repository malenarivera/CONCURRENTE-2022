/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package universidad.concurrente.tp6.punto2;

/**
 *
 * @author male_
 */
public class ControlTemperatura implements Runnable{
    Sala sala;
    private int temp;
    
    public ControlTemperatura(Sala sala){
        this.sala=sala;
    }
    
    public void run(){
        while(true){
            this.simularTiempoCambioTemp();
            temp= (int)(Math.random()*(40-20+1)+20);
            sala.notificarTemperatura(temp);
        }
    }
    
    private void simularTiempoCambioTemp(){
        try {
            Thread.sleep(10000);
        } catch (Exception e) {
        }
    }
    
}
