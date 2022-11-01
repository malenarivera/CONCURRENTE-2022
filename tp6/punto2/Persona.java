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
public class Persona implements Runnable{
    private Sala sala;
    private int soyJubilado;
    
    public Persona(Sala sala){
        this.sala=sala;
        soyJubilado= (int) (Math.random()*2);
    }
    
    public void run(){
        if(soyJubilado==0)
            sala.entrarJubilado();
        else
            sala.entrarSala();
        this.simularTiempoAdentroSala();
        sala.salirSala();
    }
    
    private void simularTiempoAdentroSala(){
        try {
            Thread.sleep(4000);
        } catch (Exception e) {
        }
    }
    
}
