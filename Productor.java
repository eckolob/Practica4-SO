/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package practica4;

import java.util.ArrayList;
import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author Marcos
 */
public class Productor extends Thread{
    
   Sincronizador si;
    Proceso procesovacio=new Proceso();
        Proceso p=new Proceso();
        Interfaz ventana;        
        Random aleatorio;
     
        ArrayList <Proceso> ProcesosNuevos;
        ArrayList <Proceso> Memoria;
        ArrayList <Proceso> ProcesosTerminados;
         ArrayList <Proceso> ProcesosBloqueados;
        ArrayList <Integer> relojBloqueados;
        ArrayList <Integer> relojRestanteBloqueados;
        
        boolean procesoTerminado=false;
        int cuentaterminados=0;  
        int milisegundos= 200;
        int cuentat=0,unidadtme=0,j=0,bloq=0,relojGlobal=0,relojAux=0,relojAux2=10;
        int generaids=0;   
        boolean tal=false,error=false;
        boolean rej=false;
  
  
  
   
    int num1,num2;
    int tmeactual=0;
    int cuentaprocesos2=0;
    boolean termina=false;
      int id,tme,tr=0,procesosrecibidos; String resultado;
    //Contador que lleva el tiempo (determinar mi unidad de tiempo
    //ejemplo 1 tme = x segundos controlados por un delay
      
      int opcion=0;
      
      
    Productor(Sincronizador s,Interfaz v)
    {
       this.ventana =v;
     this.si=s;
    Memoria= new ArrayList<> (); 
    
         ProcesosNuevos = new ArrayList();
         ProcesosTerminados = new ArrayList();
         ProcesosBloqueados = new ArrayList();
         aleatorio = new Random();
         relojBloqueados = new ArrayList();
         relojRestanteBloqueados = new ArrayList();
    }
    
    	public String Sumar(int n1,int n2)
	{
		int suma= n1+n2;
		resultado=""+n1+" + "+n2+" = "+suma;
		return  resultado;
	}
	
	public String Restar(int n1,int n2)
	{
		int resta= n1-n2;
		resultado=""+n1+" - "+n2+" = "+resta;
		return  resultado;
	}
	
	public String Multiplicar(int n1,int n2)
	{
		int mult= n1*n2;
		resultado=""+n1+" * "+n2+" = "+mult;
		
		return  resultado;
	}
	
	public String Dividir(int n1,int n2)
	{
		if(n2<=0)
		{
		 	JOptionPane.showMessageDialog(null, "Error: Division entre 0!", "", JOptionPane.ERROR_MESSAGE);
                        error=true;
                        resultado="Error\t";
		}
		else
		{
		 int div= n1/n2;
		 resultado=""+n1+" / "+n2+" = "+div;	
		}
	
		
		return  resultado;
	}
	
	public String Residuo(int n1,int n2)
	{
		if(n2<=0)
		{
		 	
                        JOptionPane.showMessageDialog(null, "Division entre 0!", "", JOptionPane.ERROR_MESSAGE);
                        error=true;
                         resultado="Error\t";
		}
		else
		{
		 int residuo= n1%n2;
		 resultado=""+n1+" % "+n2+" = "+residuo;	
		}
		return  resultado;
	}
	
	public String Potencia(int n1,int n2)
	{
	 int potencia=(int) Math.pow(n1, n2);;
		resultado=""+n1+" ^ "+n2+" = "+potencia;
		return  resultado;	
	}
        
      
     
         
    
    @Override
    public void run()
    {
     
        
        Productor a = new Productor(si,ventana);
        int cuentaprocesos=0;
    
        
    	
        String op;

        procesosrecibidos = Integer.parseInt(JOptionPane.showInputDialog(null, "Ingresa el numero de procesos: "));
          int tam=0;
          
         
       do{
           //Bloque para introducir datos al array list
                       
                        if(cuentaprocesos2==procesosrecibidos)
           	{
           		 termina=true;                   
                        break;
           	}
                        
                     id = cuentaprocesos2+1 ;
       
                        tme = aleatorio.nextInt(30)+ 1 ;
                        tr=tme;
                               while(tme<=0)
                                {                       
                                      tme = aleatorio.nextInt(30);
                                }
                            
                      
                        

                        num1 = aleatorio.nextInt(10)+1;
                        num2 = aleatorio.nextInt(10) + 1;
                        int o=0;
                        do
                        {                  
                       opcion =  aleatorio.nextInt(6);
                        switch(opcion)
                        {
                            

                               case 1:resultado=Sumar(num1,num2);
                                        o=1;
                        		break;
                         	case 2:resultado=Restar(num1,num2);
                                        o=2;
                        		break;
                        	case 3:resultado=Multiplicar(num1,num2);
                                        o=3;
                        		break;
                        	case 4:resultado=Dividir(num1,num2);
                                        o=4;
                        		break;
                        	case 5:resultado=Residuo(num1,num2);
                                       o=5;
                        		break;
                        	case 6:resultado=Potencia(num1,num2);
                                        o=6;
                        		break;
                        
                        		default:
            			
                        }
                        }while(o==0);  
                           
                         ProcesosNuevos.add(new Proceso(id,tme,resultado,tr));  
                                         //nuevo,listo,ejecucion,terminado,bloqueado
                         
                         cuentaprocesos++;
                         cuentaprocesos2++;//controla el while
                
                         
                         if(cuentaprocesos>0&&cuentaprocesos<6)
                         {
                              for(int z=0;z<5;z++)
                                     {
                                        if(z<ProcesosNuevos.size()) 
                                        {
                                             
                                             ProcesosNuevos.get(z).AsignarEstado(true, false, false, false, false); 
                                             ProcesosNuevos.get(z).AsignarTLlegada(1);
                                            
                                             Memoria.add(ProcesosNuevos.get(z));  //Agrega 5 o menos procesos nuevos a memoria (ARRAYLISTPROCESOS)
                                                                         //Estados listo, ejecucion y bloqueado
                                        }
                                          
                                     }
                                     
                                     for(int z=0;z<5;z++)
                                     {
                                         
                                         if(z<ProcesosNuevos.size())
                                        {
                                            ProcesosNuevos.remove(ProcesosNuevos.get(z)); //Como ya estan en memoria, borralos 
                                        }
                                            
                                     }
                         }
                                    
                                    
                    	
       }while(error!=true||termina!=true);
       
       
      
             Timer relojProcesos = new Timer();        
            
            TimerTask mostrarproceso=new TimerTask()
                   
         {
          @Override
             public void run() 
             {   
         cuentat++;       
                 //Cada que pasen 3 segundos es una unidadtme
            
                 if(cuentat%3==0)              
                 {    
                    
             try {
                 si.productor();
             } catch (InterruptedException ex) {
                 Logger.getLogger(Productor.class.getName()).log(Level.SEVERE, null, ex);
             }
              //¿Que hace esto aqui?
                     for(int z=0;z<ProcesosNuevos.size();z++)
                                     {
                                        
                                             ProcesosNuevos.get(z).AsignarEstado(true, false, false, false, false); 
                                        
                                     }
                     
                if(!Memoria.isEmpty())
                     { //Asigna el tiempo de respuesta solo si no lo habias asignado ya
                         Memoria.get(j).AsignarTFinalizacion(relojGlobal+1);
                                        Memoria.get(j).AsignarTRetorno(relojGlobal+1);
                                        Memoria.get(j).AsignarTServicio(unidadtme+1);
                                        Memoria.get(j).AsignarTEspera();
                         if(Memoria.get(j).tRespuesta()==0)
                         { 
                            Memoria.get(j).AsignarTRespuesta(relojGlobal+1);
                         }
                     }
                        
                        //Mostrar procesos en cola de nuevos(pendientes)
                     //Evaluar que show aqui
                      ventana.txt_procesosPendientes.setText(Integer.toString(ProcesosNuevos.size()));
     
                        String LA="";
                        //Puedo hacer un arraylist de cadenas para que en cada posicion este la info de un proceso
                        //y agregar cada posicin al jtextarea al mismo tiempo, y asi tambien poder quitar individualmente
                        
                         
                    if(!Memoria.isEmpty()) //Para que no trate de acceder a una posicion que no existe
                     {
                         for(int y=1;y<Memoria.size();y++)
                                     {
                                     
                                       LA +=(Memoria.get(y).ObtenerId())+"      "+(Memoria.get(y).ObtenerTME())+"     "+Memoria.get(y).ObtenerTR()+"\n";
                                                                                      //nuevo,listo,ejecucion,terminado,bloqueado 
                                       Memoria.get(y).AsignarEstado(false, true, false, false, false);
                                     }
                         //Mostrar los procesos listos
                                      ventana.ta_procesosListos.setText(LA); 
                                      ventana.ta_procesosListos.setLineWrap(true); 
                                      ventana.ta_procesosListos.setWrapStyleWord(true);
                       
                     
                     
                    
                     
                  
                         tmeactual= (Memoria.get(j).ObtenerTME());
                               //PROCESO EN EJECUCION
                         
                                                                             //nuevo,listo,ejecucion,terminado,bloqueado
                                 Memoria.get(j).AsignarEstado(false, false, true,   false,    false);
                                 ventana.txt_idproceso2.setText(Integer.toString(Memoria.get(j).ObtenerId()));  
                                 ventana.txt_operacion.setText(Memoria.get(j).ObtenerOperacion());
                                 ventana.txt_tme2.setText(Integer.toString(Memoria.get(j).ObtenerTME()));
                                 tme=Memoria.get(j).ObtenerTME();
                               
                                 ventana.txt_tr.setText(Integer.toString( ((Memoria.get(j).ObtenerTR()))-unidadtme)); 
                                 ventana.txt_tt.setText(Integer.toString(unidadtme));
                       
                             
                                 //Mostrar reloj global
                                  ventana.txt_reloj.setText(Integer.toString(relojGlobal));
                                 
                    }     
              
                     
                         //INTERRUPCIONES
                       if(si.I_u==1)
                       {
                                 
                     id = cuentaprocesos2+1 ;
       
                        tme = aleatorio.nextInt(30)+ 1 ;
                        tr=tme;
                               while(tme<=0)
                                {                       
                                      tme = aleatorio.nextInt(30);
                                }
                            
                      
                        

                        num1 = aleatorio.nextInt(10)+1;
                        num2 = aleatorio.nextInt(10) + 1;
                        int o=0;
                        do
                        {                  
                       opcion =  aleatorio.nextInt(6);
                        switch(opcion)
                        {
                            

                               case 1:resultado=Sumar(num1,num2);
                                        o=1;
                        		break;
                         	case 2:resultado=Restar(num1,num2);
                                        o=2;
                        		break;
                        	case 3:resultado=Multiplicar(num1,num2);
                                        o=3;
                        		break;
                        	case 4:resultado=Dividir(num1,num2);
                                        o=4;
                        		break;
                        	case 5:resultado=Residuo(num1,num2);
                                       o=5;
                        		break;
                        	case 6:resultado=Potencia(num1,num2);
                                        o=6;
                        		break;
                        
                        		default:
            			
                        }
                        }while(o==0);  
                             
                         ProcesosNuevos.add(new Proceso(id,tme,resultado,tr));  
                         
                         cuentaprocesos2++;
                                         //nuevo,listo,ejecucion,terminado,bloqueado
                         for(int z=0;z<ProcesosNuevos.size();z++)
                         {
                             ProcesosNuevos.get(z).AsignarEstado(true, false, false, false, false); 
                            
                         }
                        if(Memoria.size()+ProcesosBloqueados.size()<5)
                                          {
                                            ProcesosNuevos.get(0).AsignarTLlegada(relojGlobal+1);
                                            Memoria.add(ProcesosNuevos.get(0));
                                            //Asignale el momento en que llego
                                          
                                            ProcesosNuevos.remove(ProcesosNuevos.get(0));
                                          }
                       
                         
                       }
                       
                       
                       if(si.I_t==1)
                       {
                           String listos="";
                           String ejecutandose="";
                          if(!Memoria.isEmpty())
                          {
                              
                          
                          
                           if(Memoria.size()>=2)
                           {
                           for(int k=1;k<Memoria.size();k++)
                           {
                        //LISTOS
                                        Memoria.get(k).AsignarTFinalizacion(relojGlobal);
                                        Memoria.get(k).AsignarTRetorno(relojGlobal);
                                        
                                        Memoria.get(k).AsignarTServicio(0);
                                        Memoria.get(k).AsignarTEspera();
                                        
                                       //  Memoria.get(k).AsignarTRespuesta(0);
                                        
                                        
                                       
                     
                                listos+=Integer.toString(Memoria.get(k).ObtenerId())+"    "+
                                Memoria.get(k).ObtenerEstado()+"      "+
                                "          "+Integer.toString(Memoria.get(k).ObtenerTME())+"      "+
                               Integer.toString( ((Memoria.get(k).ObtenerTME()))) +"    "+
                                Memoria.get(k).ObtenerOperacion()+"                       "+
                               Integer.toString(Memoria.get(k).tLlegada())+"                    "+
                                "null"+"                  "+
                                Integer.toString(Memoria.get(k).tRetorno())+"               ";
                                
                                   listos+="null"+"                 "; 
                                
                               
                                listos+=Integer.toString(Memoria.get(k).tEspera())+"             "+
                                Integer.toString(Memoria.get(k).tServicio())+"                  "+
                                "\n---------------------------------------------------------------"+
                                 "------------------------------------------------------------------------------------\n";
                                }
                           }
                            //EJECUCION
                           
                                        Memoria.get(j).AsignarTFinalizacion(relojGlobal);
                                        Memoria.get(j).AsignarTRetorno(relojGlobal);
                                        Memoria.get(j).AsignarTServicio(unidadtme);
                                        Memoria.get(j).AsignarTEspera();
                                        
                           ejecutandose+=Integer.toString(Memoria.get(j).ObtenerId())+"    "+
                                Memoria.get(j).ObtenerEstado()+"      ";                               
                                ejecutandose+=Integer.toString(Memoria.get(j).ObtenerTME())+"      ";                                                     
                                ejecutandose+=Integer.toString( ((Memoria.get(j).ObtenerTR()))-unidadtme)+"    "+
                                Memoria.get(j).ObtenerOperacion()+"                       "+
                               Integer.toString(Memoria.get(j).tLlegada())+"                    "+
                                "null"+"                  "+
                                Integer.toString(Memoria.get(j).tRetorno())+"               ";
                                if(Memoria.get(j).tRespuesta()<0)
                                {
                                   ejecutandose+="null"+"                 "; 
                                }
                                ejecutandose+=Integer.toString(Memoria.get(j).tRespuesta())+"                 "+
                                Integer.toString(Memoria.get(j).tEspera())+"             "+
                                Integer.toString(Memoria.get(j).tServicio())+"                  "+
                                "\n---------------------------------------------------------------"+
                                 "------------------------------------------------------------------------------------\n";
                           
                           
                          } 
                           
                           
                           
                               String Bloqueados="";
                            for(int k=0;k<ProcesosBloqueados.size();k++)
                           {
                           
                                
                                Bloqueados+=Integer.toString(ProcesosBloqueados.get(k).ObtenerId())+"    "+
                               ProcesosBloqueados.get(k).ObtenerEstado()+"      "+
                               Integer.toString(ProcesosBloqueados.get(k).ObtenerTME())+"      "+
                               Integer.toString(ProcesosBloqueados.get(k).ObtenerTRB())+"    "+
                               ProcesosBloqueados.get(k).ObtenerOperacion()+"                       "+
                               Integer.toString(ProcesosBloqueados.get(k).tLlegada())+"             "+
                               "null"+"                  "+
                               Integer.toString(ProcesosBloqueados.get(k).tRetorno())+"             "+
                               Integer.toString(ProcesosBloqueados.get(k).tRespuesta())+"                 "+
                               Integer.toString(ProcesosBloqueados.get(k).tEspera())+"             "+
                               Integer.toString(ProcesosBloqueados.get(k).tServicio())+"                  "+
                               "\n---------------------------------------------------------------"+
                                "------------------------------------------------------------------------------------\n";
                           }
                            String Terminados="";
                            for(int k=0;k<ProcesosTerminados.size();k++)
                           {
                               
                                
                               Terminados+=Integer.toString(ProcesosTerminados.get(k).ObtenerId())+"    "+
                               ProcesosTerminados.get(k).ObtenerEstado()+"      "+
                               Integer.toString(ProcesosTerminados.get(k).ObtenerTME())+"      "+
                               Integer.toString(ProcesosTerminados.get(k).ObtenerTR())+"    "+
                               ProcesosTerminados.get(k).ObtenerOperacion()+"                   "+
                               Integer.toString(ProcesosTerminados.get(k).tLlegada())+"                 "+
                               Integer.toString(ProcesosTerminados.get(k).tFinalizacion())+"                  "+
                               Integer.toString(ProcesosTerminados.get(k).tRetorno())+"                      "+
                               Integer.toString(ProcesosTerminados.get(k).tRespuesta())+"                 "+
                               Integer.toString(ProcesosTerminados.get(k).tEspera())+"           "+
                               Integer.toString(ProcesosTerminados.get(k).tServicio())+"                  "+
                               "\n---------------------------------------------------------------"+
                               "------------------------------------------------------------------------------------\n";
                           }
                            String Nuevos="";
                            for(int k=0;k<ProcesosNuevos.size();k++)
                           {
                               
                                
                              Nuevos+= Integer.toString(ProcesosNuevos.get(k).ObtenerId())+"    "+
                               ProcesosNuevos.get(k).ObtenerEstado()+"             "+
                               "null"+"    "+
                               "null"+"    "+
                               "null"+"                     "+
                               "null"+"             "+
                               "null"+"                  "+
                               "null"+"             "+
                               "null"+"             "+
                               "null"+"           "+
                               "null"+"                  "+
                               "\n---------------------------------------------------------------"
                                        + "------------------------------------------------------------------------------------\n";
                           }
                                ventana.ta_DatosProceso.setText(Nuevos+listos+ejecutandose+Bloqueados+Terminados);
                                 
                                   
                                
                     
                         try {
                             Thread.sleep(10000);
                         } catch (InterruptedException ex) {
                             Logger.getLogger(Productor.class.getName()).log(Level.SEVERE, null, ex);
                         }
                       }    
                    
                     
                 
                          if(si.I_w==1)
                            {                                                                   
                              String ope = "Error          ";
                              if(!Memoria.isEmpty())
                              {
                                  Memoria.get(j).AsignarOperacion(ope);  
                              
                              Memoria.get(j).terminado_w=true;
                              }
                              
                            }
                                   
                        if (ProcesosBloqueados.isEmpty())//Si no hay nada ya no muestres nada
                        {
                                     ventana.ta_procesosBloqueados.setText(""); 
                                      ventana.ta_procesosBloqueados.setLineWrap(true); 
                                      ventana.ta_procesosBloqueados.setWrapStyleWord(true);
                        }
                          
                          //  solo se pueden bloquear maximo 5 procesos, si ya estan todos bloqueados no permitir agregar mas         
                     if(ProcesosBloqueados.size()<5)
                       {       
                          
                         if(si.I_e==1)
                         {
                         //Despues de esta interrupcion el tr pasa a ser la referencia 
                         //Al presionar E guarda el tiempo que le resta a el proceso  
                             
                             if(!Memoria.isEmpty())
                             {
                                 Memoria.get(j).respuesta_e=true;
                                 Memoria.get(j).AsignarTR(tme-(unidadtme));   
                                                             //nuevo,listo,ejecucion,terminado,bloqueado
                            Memoria.get(j).AsignarEstado(false, false, false,   false,    true);
                       
                            ProcesosBloqueados.add(Memoria.get(j));
                             }
                            relojBloqueados.add(0);
                            relojRestanteBloqueados.add(10);
                            //Al proceso que entra a bloqueados asignale el valor de su reloj
                            ProcesosBloqueados.get(ProcesosBloqueados.size()-1).AsignarTT(relojBloqueados.get(relojBloqueados.size()-1));
                           
                            ProcesosBloqueados.get(ProcesosBloqueados.size()-1).AsignarTRB(relojRestanteBloqueados.get(relojRestanteBloqueados.size()-1));
                            
                             //borralo de la posicion actual
                            if(!Memoria.isEmpty())
                            {
                               Memoria.remove(Memoria.get(j));
                            }
                                  
                            
                                 
                               unidadtme=0;
                            
                         }
                                      
                       }else //si hay 5 procesos en bloqueados no muestres nada en ejecucion(porque en realidad no hay nada jeje)
                     {
                         ventana.txt_idproceso2.setText("");  
                                 ventana.txt_operacion.setText("");
                                 ventana.txt_tme2.setText("");
                         
                                 ventana.txt_tr.setText(""); 
                                 ventana.txt_tt.setText("");
                     }
                         
                         //PROCESOS BLOQUEADOS           
                        
                         if(!ProcesosBloqueados.isEmpty())
                         {
                             
                            for(int d=0;d<ProcesosBloqueados.size();d++)
                            {
                                relojRestanteBloqueados.get(d);
                                relojAux2--;
                                ProcesosBloqueados.get(d).AsignarTRB(relojRestanteBloqueados.set(d,relojAux2));
                                relojAux = relojBloqueados.get(d);
                                relojAux++;                     
                                ProcesosBloqueados.get(d).AsignarTT(relojBloqueados.set(d,relojAux));
                            }
                             
                          String PB="";
                       
                          
                         for(int n=0;n<ProcesosBloqueados.size();n++)
                                     {                               
                                       PB +=(ProcesosBloqueados.get(n).ObtenerId())+"     "+(ProcesosBloqueados.get(n).ObtenerTT())+"\n";                     
                                     }
                          //Mostrar los procesos listos
                                      ventana.ta_procesosBloqueados.setText(PB); 
                                      ventana.ta_procesosBloqueados.setLineWrap(true); 
                                      ventana.ta_procesosBloqueados.setWrapStyleWord(true);
                                      
                                      for(int z=0;z<ProcesosBloqueados.size();z++)
                                      {
                                           if((ProcesosBloqueados.get(z).ObtenerTT())==10)
                                      {
                                          
                                          Memoria.add(ProcesosBloqueados.get(z));
                                          ProcesosBloqueados.remove(ProcesosBloqueados.get(z));
                                          relojBloqueados.remove(relojBloqueados.get(z));
                                          relojRestanteBloqueados.remove(relojRestanteBloqueados.get(z));
                                          
                                         
                                      }
                                      }
                                      
                                     
                         }
                         
                         
                         
                          unidadtme++;
                    
                    
                    
                          
                          
                    if(!Memoria.isEmpty())
                    {
                        
                                  //TRANSICION DE EJECUCION A TERMINADO
                                  //El atributo TR cambia disminuye solo visualmente, pero solo cambia su valor dentro del proceso en caso de interrupcion E
                        if( Memoria.get(j).ObtenerTR()==unidadtme||si.I_w==1)
                                 {              
                                        
                                                                             //nuevo,listo,ejecucion,terminado,bloqueado
                                         Memoria.get(j).AsignarEstado(false, false, false,   true,    false);
                                         
                                         if(Memoria.get(j).terminado_w==false)
                                         {
                                             Memoria.get(j).AsignarTR(0);    
                                         }
                                         else
                                         {
                                             Memoria.get(j).AsignarTR(tme-(unidadtme)); 
                                         }
                                       
                                   
                                                            
                                         procesoTerminado = Memoria.get(j).ObtenerEstadoTerminado();
                                         if(procesoTerminado==true)
                                          {
                                            cuentaterminados++; 
                                          }        
                                    
                                     //Cada que termine un proceso, agregalo a la lista de terminados, borralo de memoria y muestralo desde terminados
                                    if( !Memoria.isEmpty())
                                    {                             
                                        
                                        ProcesosTerminados.add(Memoria.get(j));
                                        Memoria.remove(Memoria.get(j));
                                    }  
                                         ventana.ta_procesosTerminados.append(Integer.toString(ProcesosTerminados.get(cuentaterminados-1).ObtenerId()));
                                         ventana.ta_procesosTerminados.append("        "+ProcesosTerminados.get(cuentaterminados-1).ObtenerOperacion());
                                         ventana.ta_procesosTerminados.append("\n");
                                        
                                         
                                     //Tambien cada que termina un proceso, debe entrar un proceso nuevo a memoria, 
                                         //y quitarlo de nuevos, siempre y cuando la suma de procesos en los estados bloqueado, listo y ejecucion sean menos de 5   
                                         if(!ProcesosNuevos.isEmpty())
                                         {                             
                                          if(Memoria.size()+ProcesosBloqueados.size()<5)
                                          {  //Procesos Nuevos que entrar cuando terminan otros (cuando hay lugar)
                                            ProcesosNuevos.get(0).AsignarTLlegada(relojGlobal+1);
                                            Memoria.add(ProcesosNuevos.get(0));
                                            //Asignale el momento en que llego
                                          
                                            ProcesosNuevos.remove(ProcesosNuevos.get(0));
                                          }
                                          
                                         }
                                      //J se pasa al otro proceso aunque siga siendo el mismo valor, porque ya se elminino el proceso en esa poscicion                                
                                     //Empieza a contar otra vez
                                     unidadtme=0;  
                                
                                 }
                                  
                    
                     }    
                   
                    //Aqui se evalua cuando ya no hay mas procesos 
                    if(Memoria.isEmpty()&&ProcesosBloqueados.isEmpty())
                                {
                               
                                       
                                  ventana.ta_procesosListos.setText(""); 
                                  ventana.ta_procesosListos.setLineWrap(true); 
                                  ventana.ta_procesosListos.setWrapStyleWord(true);
                                      
                         
                                 ventana.txt_idproceso2.setText("");  
                                 ventana.txt_operacion.setText("");
                                 ventana.txt_tme2.setText("");
                         
                                 ventana.txt_tr.setText(""); 
                                 ventana.txt_tt.setText("");
                                 
                          ventana.ta_DatosProceso.setText("");
                                 
                                for(int k=0;k<ProcesosTerminados.size();k++)
                                {
                             
                        
                                ventana.ta_DatosProceso.append(Integer.toString(ProcesosTerminados.get(k).ObtenerId())+"    ");
                                ventana.ta_DatosProceso.append(ProcesosTerminados.get(k).ObtenerEstado()+"      ");
                                ventana.ta_DatosProceso.append(Integer.toString(ProcesosTerminados.get(k).ObtenerTME())+"      ");
                                ventana.ta_DatosProceso.append(Integer.toString(ProcesosTerminados.get(k).ObtenerTR())+"    ");
                                ventana.ta_DatosProceso.append(ProcesosTerminados.get(k).ObtenerOperacion()+"                   ");
                                ventana.ta_DatosProceso.append(Integer.toString(ProcesosTerminados.get(k).tLlegada())+"                 ");
                                ventana.ta_DatosProceso.append(Integer.toString(ProcesosTerminados.get(k).tFinalizacion())+"                     ");
                                ventana.ta_DatosProceso.append(Integer.toString(ProcesosTerminados.get(k).tRetorno())+"                ");
                                ventana.ta_DatosProceso.append(Integer.toString(ProcesosTerminados.get(k).tRespuesta())+"                   ");
                                ventana.ta_DatosProceso.append(Integer.toString(ProcesosTerminados.get(k).tEspera())+"               ");
                                ventana.ta_DatosProceso.append(Integer.toString(ProcesosTerminados.get(k).tServicio())+"                 ");
                                ventana.ta_DatosProceso.append("\n---------------------------------------------------------------------------------------------------------------------------------------------------\n");
                                }
                                
                                 
                                 //Cuando todos los procesos terminen, acaba de contar el reloj global
                                 relojProcesos.cancel();
                                 relojProcesos.purge();
                                }
                            
                    //cuando un proceso termina o es interrumpido a unidadtme se le asigna 0, pero aqui antes de que vuelva a empezar
                    //se incrementa, osea que segun yo no vuelve a contar de 0 sino de 1
                   
                    
                     relojGlobal++; 
                    
                          
                     
                     
                 
             } 
          }
            
                    };
                      relojProcesos.scheduleAtFixedRate(mostrarproceso,250,milisegundos); 
       
           
       
             //OJO CUANDO PASAN DE BLOQUEADOS A LISTOS ME MUESTRA VALORES NEGATIVOS en espera y retorno
     
              
              
    }
   
        
       
}

