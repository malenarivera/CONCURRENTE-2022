/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package universidad.concurrente.aog25del10.punto1;

import java.util.concurrent.Semaphore;



/**
 *
 * @author @author GRUPO 7
 * TORRES, ANTONELLA
 * VALDESOLO, MATEO
 * RIVERA, MALENA
 */
public class RecursoCompartido {   private Semaphore lugaresTransbordador; //para simular los lugares que habra en el transbordador
    private Semaphore viaje;// usado como comunicacion entre el transbordador y los autos
    private Semaphore comienzaViajeTransbordador; //para avisarle al transbordador cuando puede empezar su viaje, tmb es de comunicacion entre autos-transbordador
    private int cantAutosMax=10; //la cantidad de autos maxima que puede haber en el transbordador, el enunciado dice 10
    
    
    public RecursoCompartido(){
        lugaresTransbordador= new Semaphore(cantAutosMax, true);
        viaje= new Semaphore(0);
        comienzaViajeTransbordador= new Semaphore(0);
    }
    
    public void iniciarViaje(){
        //metodo que usa el transbordador para iniciar su viaje
        //hasta que no consiga la cantAutosMax permisos no puede comenzar el viaje
        try {
            comienzaViajeTransbordador.acquire(cantAutosMax);
        } catch (Exception e) {
        }
    }
    
    public void llegaADestino(){
        //metodo que usa el transbordador para avisarle a los autos que ya se pueden bajar
        viaje.release(cantAutosMax);
    }
    
    public void terminoVuelta(){
        //metodo que usa el transbordador para avisar a los autos que ya termino de volver vacio
        lugaresTransbordador.release(cantAutosMax);
    }
    
    public void agarroPermiso(){
        //metodo que usa el auto para agarrar un lugar en el transbordador
        //si no hay mas permisos se quedan trabados hasta que el transbordador vuelva vacio
        try {
            lugaresTransbordador.acquire();
        } catch (Exception e) {
        }
    }
    
    public void avisoLlegada(){
        //metodo que usa el auto para avisarle al transbordador que entro
        //cuando el transbordador consiga cantMaxAutos permisos arracna el viaje
        comienzaViajeTransbordador.release();
    }
    
    public void avisoSalida(){
        //metodo que usa el auto para avisarle al transbordador que salio
        //esto es para que el transbordador no se pueda ir hasta que no salgan todos los autos
        comienzaViajeTransbordador.release();
    }
    
    public void bajarse(){
        //metodo que usa el auto para intentar bajarse
        //los que suban van a quedarse bloqueados esperando a que el transbordador libere los permisos cuando llege a destino
        try {
            viaje.acquire();
        } catch (Exception e) {
        }
    }
    
}
