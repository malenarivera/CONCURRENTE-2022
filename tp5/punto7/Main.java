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
        Scanner s= new Scanner(System.in);
        System.out.println("Ingrese la cantidad de babuinos del lado der");
        int cantBabuinosD= s.nextInt();
        System.out.println("Ingrese la cantidad de babuinos del lado izq");
        int cantBabuinosI =s.nextInt();


        Thread babuinos[]= new Thread[cantBabuinosD+cantBabuinosI];

        int limite;


        Cuerda c= new Cuerda();

        int j=0;

        for (int i=0;i<cantBabuinosI+cantBabuinosD;i++){
            if (i<cantBabuinosI){
                babuinos[i]= new Thread(new Babuino('I',c), "Babuino Izquierda "+i);
            }
            else{

                babuinos[i]= new Thread(new Babuino('D',c), "Babuino Derecho "+j);
                j++;
            }
        }
        for (int i=0;i<cantBabuinosI+cantBabuinosD;i++){
            babuinos[i].start();
        }
        


    }
}
