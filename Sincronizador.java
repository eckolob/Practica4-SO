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
public class Sincronizador {
    
      
     private int Pausa=0;
     private int Continuar=0;
     int  I_e,I_w,I_u,I_t;
    
    public Sincronizador(int p, int t)
    {
       this.Pausa=0;
       this.Continuar=0;   
       this.I_e=0;
       this.I_t=0;
       this.I_u=0;
       this.I_w=0;
    }
    
    public synchronized void productor() throws InterruptedException
    {        //mientras pausa sea verdadero manten dormido a productor
      if(this.Pausa==1)
       {
        
 
       }
      while(this.Pausa==1)
       {
          wait();
 
       }
     
      
      
     notifyAll();
      
    }
    
    
      public synchronized void escuchador(int continuar , int pausa, int i_w, int i_t, int i_u, int i_e) throws InterruptedException
    {
      this.Pausa=pausa;
      this.Continuar=continuar;
      this.I_e=i_e;
      this.I_t=i_t;
      this.I_u=i_u;
      this.I_w=i_w;
     
        
      if(this.Continuar==1)  
      { 
        
          notifyAll();
      }
      
    }
    
    
}
