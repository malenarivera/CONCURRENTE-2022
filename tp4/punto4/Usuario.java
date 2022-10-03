/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package universidad.concurrente.tp4.punto4;

/**
 *
 * @author male_
 */
public class Usuario implements Runnable{
    Documento []docs;
    CentroImpresion c;
    char[] tipoDocs= {'A','B','X'};
    String nombre;
    
    public Usuario(CentroImpresion c, String nombre){
        this.c=c;
        this.nombre=nombre;
        docs= new Documento[(int)((Math.random()*5)+1)];
        System.out.println(nombre+" me tocaron "+docs.length+" documentos");
        this.generarDocumentos();
        
    }
    
    private void generarDocumentos(){
        for (int i = 0; i < docs.length; i++) {
            int posArreglo= (int)((Math.random()*tipoDocs.length));
            docs[i]= new Documento(tipoDocs[posArreglo]);
        }
    }
    
    public void run(){
        int i=0;
        while(i<docs.length) {
            int impresora= c.imprimirDocumento(docs[i].getTipo());
            this.esperar(impresora, docs[i], i);
            c.liberarImpresora(impresora);
            i++;
        }
    }
    
    private void esperar(int impresora, Documento a,int  nroDocumento){
        try {
            System.out.println(nombre+ " y estoy imprimiendo el documento "+a.getTipo()+nroDocumento);
            Thread.sleep(1000);
        } catch (Exception e) {
        }
    }
           
}
