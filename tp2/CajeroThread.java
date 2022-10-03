/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package universidad.concurrente.tp2;

/**
 *
 * @author male_
 */
public class CajeroThread extends Thread{
    private String nombre;
    private ClienteCajero cliente;
    private long initialTime;
// Constructor, y métodos de acceso

    public CajeroThread(String nombre, ClienteCajero cliente, long initialTime) {
        this.nombre = nombre;
        this.cliente = cliente;
        this.initialTime = initialTime;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public ClienteCajero getCliente() {
        return cliente;
    }

    public void setCliente(ClienteCajero cliente) {
        this.cliente = cliente;
    }

    public long getInitialTime() {
        return initialTime;
    }

    public void setInitialTime(long initialTime) {
        this.initialTime = initialTime;
    }
    
    

    public void run() {
        System.out.println("El cajero " + this.nombre
                + " COMIENZA A PROCESAR LA COMPRA DEL CLIENTE "
                + this.cliente.getNombre() + " EN EL TIEMPO: "
                + (System.currentTimeMillis() - this.initialTime) / 1000 + "seg");
        for (int i = 0; i < this.cliente.getCarroCompra().length; i++) {
            this.esperarXsegundos(cliente.getCarroCompra()[i]);
            System.out.println("Procesado el producto " + (i + 1) + " del cliente " + this.cliente.getNombre() + "->Tiempo: "
                    +(System.currentTimeMillis() - this.initialTime)/ 1000 + "seg");
}
System.out.println("El cajero " + this.nombre + " HA TERMINADO DE PROCESAR "+ this.cliente.getNombre() + " EN EL TIEMPO: "
        +(System.currentTimeMillis() - this.initialTime) / 1000 +"seg");
}   
    
      private void esperarXsegundos(int i){
      try {
          Thread.sleep(i*1000);
      } catch (Exception e) {
          
      }
  }
}
