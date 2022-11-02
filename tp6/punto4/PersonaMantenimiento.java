/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package universidad.concurrente.tp6.punto4;

/**
 *
 * @author male_
 */
public class PersonaMantenimiento implements Runnable{
    Observatorio o;
    
    public PersonaMantenimiento(Observatorio o){
        this.o=o;
    }
    
    public void run(){
        this.simularTiempo(); //este simula el tiempo que espera a que la sala se ensucie
        o.entrarSalaPersonaMantenimiento();
        System.out.println(Thread.currentThread().getName()+": Entro a limpiar");
        this.simularTiempo(); //este simula el tiempo que llevaria limpiar la sala
        o.salirPersonaMantenimiento();
    
    }
    
    private void simularTiempo(){
        try {
            Thread.sleep(3000);
        } catch (Exception e) {
        }
    }
}
