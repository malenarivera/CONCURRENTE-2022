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
public class RecursoCompartido {
    private Semaphore lugaresTransbordador; //los lugares del transbordador
    private Semaphore viaje;// para q los autos no se bajen antes de llegar
    private Semaphore comienzaViajeTransbordador; //para avisarle al transbordador cuando puede empezar su viaje
    private int cantAutosMax=10; //la cantidad de autos maxima que puede haber en el transbordador, el enunciado dice 10
    
    
    public RecursoCompartido(){
        lugaresTransbordador= new Semaphore(cantAutosMax, true);
        viaje= new Semaphore(0);
        comienzaViajeTransbordador= new Semaphore(0);
    }
    
    public void iniciarViaje(){
        //metodo que usa el transbordador par iniciar su viaje
        //agarra los 10 permisos y se queda bloqueado hasta q los consigue
        try {
            comienzaViajeTransbordador.acquire(10);
        } catch (Exception e) {
        }
    }
    
    public void llegaADestino(){
        //metodo que usa el transbordador para avisar a los autos que ya se pueden bajar
        viaje.release(cantAutosMax);
    }
    
    public void terminoVuelta(){
        //metodo que usa el transbordador para avisar a los autos que ya termino de volver vacio
        //libera los permisos por lo cual los autos que no puedieron subir antes se quedaron trabados
        lugaresTransbordador.release(cantAutosMax);
    }
    
    public void agarroPermiso(){
        //metodo que usa el auto para agarrar un lugar en el transbordador
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
