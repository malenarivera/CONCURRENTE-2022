/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package universidad.concurrente.tp1;

/**
 *
 * @author male_
 */
public class punto1 {
  /*  public static void main(String[] args) {
        
   
    String aux= "41";
    int aux2 = Integer.parseInt(aux);
}}*/
 //se hace dps
    public static void  acceso_por_indice(double[] v, int j){
            if ((0 <= j) && (j <= v.length))
                System.out.println(v[j]);
            else
             System.out.println("El indice " + j + " no existe en el vector");
    }
    
    public static void main(String[] args) {
        double[] v = new double[15];
        acceso_por_indice(v, 16);
    }
    
    
  
}


