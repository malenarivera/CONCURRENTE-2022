/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package universidad.concurrente.tp6.punto1;

/**
 *
 * @author male_
 */
public class Auto implements Runnable{
private int lado;
GestionTrafico gt;

public Auto(int lado, GestionTrafico gt){
    this.lado=lado;
    this.gt=gt;
}

public void run(){
    if(lado==0){
        gt.entrarCocheNorte();
        this.simularTiempo();
        gt.salirCocheNorte();
    }else{
        gt.entrarCocheSur();
        this.simularTiempo();
        gt.salirCocheSur();
}
}

private void simularTiempo(){
    try {
        Thread.sleep(1000);
    } catch (Exception e) {
    }
}

    
}
