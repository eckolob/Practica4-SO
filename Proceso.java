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

public class Proceso{
 
    
    
    //Datos de entrada

	int idProceso,tme,num1,num2;
	
   // int[] idsProcesos = new int[l.procesosrecibidos];//hacer metodo obtener procesosrecibidos para invocarlo desde aqui y que me regrese 
    //el numero de procesos que recibio el objeto lote
    
    //Datos de salida
	String operacion;
	int tr,tt,trb;
        boolean nuevo,listo,ejecucion,terminado,bloqueado,terminado_w,respuesta_e;
        int llegada,finalizacion,retorno,respuesta,espera,servicio;
	
    public Proceso()
    {  	
  
        idProceso=0;
        tme=0;
        num1=0;
        num2=0;
        operacion="";
        tr=0;
        tt=0;
        nuevo=false;
        listo=false;
        ejecucion=false;
        terminado=false;
        terminado_w=false;
        bloqueado=false;
        respuesta_e=false;
        llegada=0;
        finalizacion=0;
        retorno=0;
        respuesta=0;
        espera=0;
        servicio=0;
    	//Si creo un objeto y no le paso parametros se ejecuta este metodo constructor
    	//Los atributos se inicializan con los valores por defecto del sistema
    } 
  
    public Proceso(int id,int tme,String op,int t){
    	//Si creo un objeto y le paso estos parametros se ejecuta este metodo constuctor
    	//Los atributos se inicializan con los valores que recibe como parametro
        this.idProceso = id;
        this.tr=t;
        this.tme = tme;   
        this.operacion = op;   
        nuevo=false;
        listo=false;
        ejecucion=false;
        terminado=false;
        bloqueado=false;
    }
 
        
    
    public int tLlegada()
    {
        return llegada;
    }
    
    public int tFinalizacion()
    {
        return finalizacion;
    }
    
    public int tRetorno()
    {
        return retorno;
    }
    
    public int tRespuesta()
    {
        return respuesta;
    }
    
    
    
    public int tEspera()
    {
        return espera;
    }
    
    public int tServicio()
    {
        return servicio;
    }
    
    public int ObtenerId() {
        return idProceso;
    }
 
    
    public int ObtenerTME() {
        return tme;
    }
    
    
    public void AsignarTR(int x)
    {
        this.tr=x;
    }
    
    public int ObtenerTR()
    {
     return this.tr;    
    }
    
    
    public void AsignarTLlegada(int l)
    {
        this.llegada=l;
    }
    
    public void AsignarTFinalizacion(int f)
    {
        this.finalizacion=f;
    }
    
    public void AsignarTRetorno(int t)
    {
      
        //finalizacion - llegada
           this.retorno= (t-llegada)+1;
       
        
    }
    
    public void AsignarTRespuesta(int re)
    {   
                    
            this.respuesta=(re-llegada);  
       
              
    }
    
    public void AsignarTEspera()
    {
       
        if(bloqueado==true)
        {
            this.espera=tr;
        }
        else
        {
          this.espera=(retorno-servicio);  
        }
        
    }
    
    
    public void AsignarTServicio(int unidadtme)
    {
        
        if (this.terminado_w==true)
        {
            this.servicio=tme-tr;
        }
        else
        {
         this.servicio=unidadtme;   
        }
        
    }
    
    
    
    public void AsignarTT(int y)
    {
        this.tt=y;
    }
    
     public void AsignarTRB(int n)
    {
        this.trb=n;
    }
    
     public int ObtenerTRB()
    {
    	return trb;
    }
     
    public int ObtenerTT()
    {
    	return tt;
    }
    
    public String ObtenerOperacion()
    {
    	return operacion;
    }
    
    public void AsignarOperacion(String o)
    {
        this.operacion=o;
    }
    
    public boolean ObtenerEstadoNuevo()
    {
        return nuevo;
    }
    public boolean ObtenerEstadoListo()
    {
        return listo;
    }
    public boolean ObtenerEstadoEjecucion()
    {
        return ejecucion;
    }
    public boolean ObtenerEstadoTerminado()
    {
        return terminado;
    }
    public boolean ObtenerEstadoBloqueado()
    {
        return bloqueado;
    }
    
    
    public String ObtenerEstado()
    {
        String estado="";
        
        if(nuevo==true)
        {
            estado="Nuevo";   
        }
        
        if(listo==true)
        {
            estado="Listo";   
        }
        
        if(ejecucion==true)
        {
            estado="Ejecucion";   
        }
        
        if(bloqueado==true)
        {
            estado="Bloqueado";   
        }
        
        if(terminado==true)
        {
            estado="Terminado";   
        }
        
        return estado;
    }

public void AsignarEstado(boolean n,boolean l,boolean e,boolean t,boolean b)
{
     this.nuevo=n;
     this.listo=l;
     this.ejecucion=e;
     this.terminado=t;
     this.bloqueado=b;
}


    	
}
