/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package universidad.concurrente.tp5.punto7;

/**
 *
 * @author male_
 */
public class Main {
    
    public static void main(String[] args) {
        Thread babuinos []= new Thread[10];
        Puente p = new Puente(5);
        for (int i=0;i<babuinos.length;i++){
            babuinos[i]= new Thread( new Babuino(p));
        }
        for (int i=0;i<babuinos.length;i++){
            babuinos[i].start();
        }

    }
    
}

