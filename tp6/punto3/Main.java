/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package universidad.concurrente.tp6.punto3;

/**
 *
 * @author male_
 */
public class Main {
    public static void main(String[] args) {
        Soldado s[]= new Soldado[100];
        Comedor c= new Comedor();
        Thread soldaditos[]= new Thread[100];
        for (int i = 0; i < s.length; i++) {
            s[i]= new Soldado(c);
            soldaditos[i]= new Thread(s[i], "Soldado "+i);
        }
        for (int i = 0; i < soldaditos.length; i++) {
            soldaditos[i].start();
        }
    }
}

