/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package practica4;

/**
 *
 * @author Marcos
 */
public class Manejador {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Sincronizador s = new Sincronizador(0,0);
        
        Interfaz ventana= new Interfaz(s);
        Productor productor = new Productor(s,ventana);
        
        
        ventana.start();
        productor.start();
      
    }
    
}
