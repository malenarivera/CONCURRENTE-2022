/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package universidad.concurrente.tp1;
import java.io.IOException;
import utiles.TecladoIn;
import java.util.Random;

/**
 *
 * @author male_
 */
public class punto8 {
    //genera error si la persona es menor de edad
    
    public static void menor() throws IOException{
        int edad;
           System.out.println("Ingrese la edad");
            edad= TecladoIn.readLineInt();
             if(edad<18)
                throw new IOException ("La persona es menor de edad");
    }
    
    //genera error si el numero que ingresa el usuario no es igual al random
    public static void randomm() throws IOException{
        int numeroJugador;
        Random r = new Random();
        int rr= r.nextInt(10+1)+1;
        System.out.println("Ingrese un numero del 1 al 10");
        numeroJugador= TecladoIn.readLineInt();
            if(rr!=numeroJugador)
              throw new IOException ("Lastima");
            
    }
    
    //genera error porque se va de rango
    public static void coleccion() throws ArrayIndexOutOfBoundsException{
        int []a = new int [5];
        int num;
        for (int i = 0; i < a.length; i++) {
            System.out.println("Ingrese un numero");
            a[i]= TecladoIn.readLineInt();
        }
        System.out.println("EMPIEZO A MOSTRARR");
        for (int i = 0; i < 7; i++) {
            System.out.println("a["+i+"]: "+a[i]);
        }
    }
    
    public static void main(String[] args) {
        try{
          coleccion();
    } catch (Exception e){
       e.printStackTrace();
    }
        
    
    }
}
