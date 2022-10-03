/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package universidad.concurrente.tp4.punto4;

import utiles.TecladoIn;

/**
 *
 * @author male_
 */
public class MainCentroImpresion {
    private static CentroImpresion c;
    private static Usuario [] usuarios;
    private static Thread [] threadUsuarios;
    private static int cantUsuarios, cantImpresorasTipoA, cantImpresorasTipoB;
    
    public static void main(String[] args) {
        System.out.println("Ingrese la cantidad de impresoras tipo A");
        cantImpresorasTipoA= TecladoIn.readLineInt();
        System.out.println("Ingrese la cantidad de impresoras de Tipo B");
        cantImpresorasTipoB= TecladoIn.readLineInt();
        c= new CentroImpresion(cantImpresorasTipoA,cantImpresorasTipoB);
        System.out.println("Ingrese la cantidad de Usuarios");
        cantUsuarios= TecladoIn.readLineInt();
        usuarios= new Usuario[cantUsuarios];
        threadUsuarios= new Thread[cantUsuarios];
        
        inicializarUsuarios();
        inicializarHilos();
        iniciarHilos();
        
    }
    
    private static void inicializarUsuarios(){
        for (int i = 0; i < usuarios.length; i++) {
            usuarios[i]= new Usuario(c, "USUARIO "+i);
        }
    }
    
    private static void  inicializarHilos(){
        for (int i = 0; i < threadUsuarios.length; i++) {
            threadUsuarios[i]= new Thread(usuarios[i], "Usuario "+i);
            
        }
    }
    
    private static void iniciarHilos(){
        for (int i = 0; i < threadUsuarios.length; i++) {
            threadUsuarios[i].start();
        }
    }
    
    
    
}
