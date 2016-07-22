/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package practica4;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

/**
 *
 * @author Marcos
 */
public class Interfaz  extends Thread{
    
    JTextArea ta_procesosListos,ta_procesosTerminados,ta_procesosBloqueados,ta_DatosProceso;
    JScrollPane sp_procesosPendientes,sp_procesoTerminado,sp_procesosBloqueados,sp_DatosProceso;
 
    JLabel et_procesosPendientes,et_procesosListos,et_Idproceso,et_tme;//Etiquetas Procesos Listos
    JLabel et_procesoEjecutandose,et_idproceso2,et_operacion,et_tme2,et_tr,et_tt; //Etiquetas Panel Proceso Actual
    JLabel et_procesosB;                                                   //Etiquetas Procesos Bloqueados
    JLabel et_procesosTerminados,et_operacion2,et_idproceso3;//Etiquetas Panel Procesos Terminados
    JLabel et_idprocesoB,et_TTB;//Procesos Bloqueados
    //Datos del proceso
    JLabel et_DatosProceso,et_idD,et_tmeD,et_trD,et_opD,et_llegada,et_finalizacion,et_retorno,et_respuesta,et_espera,et_servicio,et_estado;
    
    JLabel et_reloj,et_tr2;
   
    JTextField txt_procesosPendientes;
    //investigar donde puedo mostrar el contador del reloj, barrade progreso o con numeritos
    JTextField txt_idproceso2, txt_operacion, txt_tme2, txt_tr, txt_tt; //txt Panel Proceso Actual
     
    
    JTextField txt_reloj;
	JFrame ventana;
        Sincronizador si;
        
        
	public Interfaz(Sincronizador s) {
	
                this.si=s;
                
                int x=130,y=60,ancho=100,alto=20,y2=300;
 
        ventana = new JFrame("PROCESOS");  
        ventana.setLayout(null);
        
        
        
        et_reloj = new JLabel("Reloj:");
        et_reloj.setBounds(10,240,40,20);
        ventana.add(et_reloj);
        
        
      
      
        
        txt_reloj = new JTextField();
        txt_reloj.setBounds(42,240,40,20);
        txt_reloj.setEditable(false);
        ventana.add(txt_reloj);
       
        
        //Componentes Procesos Listos
        et_procesosPendientes = new JLabel("Nuevos:");
        et_procesosPendientes.setBounds(30,15, 120, 10);
        ventana.add(et_procesosPendientes);     
        
        txt_procesosPendientes  = new JTextField();
        txt_procesosPendientes.setBounds(80,10, 20, 20);
        txt_procesosPendientes.setEditable(false);
        ventana.add(txt_procesosPendientes);
        
        et_procesosPendientes = new JLabel("Listos");
        et_procesosPendientes.setBounds(30,35, 120, 10);
        ventana.add(et_procesosPendientes); 
          
        
        et_Idproceso = new JLabel("ID");
        et_Idproceso.setBounds(20, 60, 20, 20);
        ventana.add(et_Idproceso);
        
        et_tme = new JLabel("TME");  
        et_tme.setBounds(40, 60, 30, 20);
        ventana.add(et_tme);   
        
         et_tr2 = new JLabel("TR");  
        et_tr2.setBounds(70, 60, 20, 20);
        ventana.add(et_tr2); 
        
        ta_procesosListos = new JTextArea();
        sp_procesosPendientes = new JScrollPane(ta_procesosListos);
        sp_procesosPendientes.setBounds(20,80,90,150);
        ta_procesosListos.setEditable(false);
        ventana.add(sp_procesosPendientes);
        
        
        //Componentes Proceso en ejecucion
         et_procesoEjecutandose = new JLabel("Ejecutandose");
         et_procesoEjecutandose.setBounds(x+20, 30, ancho, 20);
         ventana.add(et_procesoEjecutandose );
       
    
        et_idproceso2           = new JLabel("Id:");
        et_idproceso2.setBounds         (x-10, y+40, 20, 20);
        ventana.add(et_idproceso2 );
          
        et_operacion            = new JLabel("Operacion:");
        et_operacion.setBounds          (x-10, y+60, 70, 20);
        ventana.add(et_operacion);
        
        et_tme2                 = new JLabel("TME:");
        et_tme2.setBounds               (x-10, y+80, 40, 20);
         ventana.add(et_tme2);
               
        et_tr                   = new JLabel("TR:");
        et_tr.setBounds                 (x-10, y+100, 40, 20);
        ventana.add(et_tr );
               
        et_tt                   = new JLabel("TT:");
        et_tt.setBounds                 (x-10, y+120, 40, 20);
        ventana.add(et_tt);     
        
    
         
         
         txt_idproceso2     = new JTextField();
         txt_idproceso2.setBounds(x+70, y+40, 90, 20);
         txt_idproceso2.setEditable(false);
         ventana.add(txt_idproceso2);
         
         
         txt_operacion      = new JTextField();
         txt_operacion.setBounds(x+70, y+60, 90, 20); 
         txt_operacion.setEditable(false);
         ventana.add(txt_operacion);
         
         txt_tme2           = new JTextField();
         txt_tme2.setBounds(x+70, y+80, 90, 20); 
         txt_tme2.setEditable(false);
         ventana.add(txt_tme2);
        
         txt_tr             = new JTextField();
         txt_tr.setBounds(x+70, y+100, 90, 20);
         txt_tr.setEditable(false);
         ventana.add(txt_tr );
         
         txt_tt             = new JTextField();
         txt_tt.setBounds(x+70, y+120, 90, 20);
         txt_tt.setEditable(false);
         ventana.add(txt_tt);
   
       //Componentes Procesos Bloqueados
        et_procesosB         = new JLabel("Bloqueados");
        et_procesosB.setBounds         (x+180, 30, 140, 20);
        ventana.add(et_procesosB ); 
        
        et_idprocesoB     = new JLabel("ID");
        et_idprocesoB.setBounds(x+180, y, 20, 20);     
        ventana.add(et_idprocesoB); 
        
        
        
        et_TTB       = new JLabel("TT");
        et_TTB.setBounds(x+210, y, 70, 20);
        ventana.add(et_TTB);
        
       ta_procesosBloqueados= new JTextArea();
        sp_procesosBloqueados = new JScrollPane(ta_procesosBloqueados);
        sp_procesosBloqueados.setBounds(x+180,80,70,150);
        ta_procesosBloqueados.setEditable(false);
        ventana.add(sp_procesosBloqueados);
         
     
         
         
       //Componentes Procesos Terminados
        et_procesosTerminados  = new JLabel("Terminados");
        et_procesosTerminados.setBounds(x+290, 30, ancho, 20);
        ventana.add(et_procesosTerminados); 
      
        et_idproceso3       = new JLabel("ID");
        et_idproceso3.setBounds(x+280, y, 20, 20);     
        ventana.add(et_idproceso3); 
        
        et_operacion2       = new JLabel("Operacion");
        et_operacion2.setBounds(x+310, y, 70, 20);
        ventana.add(et_operacion2);
        
            
         
        ta_procesosTerminados = new JTextArea();
        sp_procesoTerminado = new JScrollPane(ta_procesosTerminados);
        sp_procesoTerminado.setBounds(x+280,80,130,150);
        ta_procesosTerminados.setEditable(false);
        ventana.add(sp_procesoTerminado);
        
        //DATOS PROCESO
        et_DatosProceso  = new JLabel("Tabla de Control de Procesos");
        et_DatosProceso.setBounds(250, y2-34, 500, 20);
        ventana.add(et_DatosProceso); 
      
        
        
        
        et_idD       = new JLabel("ID");
        et_idD.setBounds(50, y2, 20, 20);     
        ventana.add(et_idD); 
        
        et_estado       = new JLabel("Estado");
        et_estado.setBounds(70, y2, 70, 20);     
        ventana.add(et_estado); 
        
        
        et_tmeD       = new JLabel("TME");
        et_tmeD.setBounds(140, y2, 30, 20);     
        ventana.add(et_tmeD); 
        
        et_trD       = new JLabel("TR");
        et_trD.setBounds(170, y2, 20, 20);     
        ventana.add(et_trD); 
        
        et_opD       = new JLabel("Operacion");
        et_opD.setBounds(190, y2, 100, 20);     
        ventana.add(et_opD);
       
        et_llegada       = new JLabel("Llegada");
        et_llegada.setBounds(300, y2, 70, 20);     
        ventana.add(et_llegada);
        
        et_finalizacion       = new JLabel("Finalizacion");
        et_finalizacion.setBounds(350, y2, 70, 20);     
        ventana.add(et_finalizacion);
        
        et_retorno       = new JLabel("Retorno");
        et_retorno.setBounds(420, y2, 70, 20);     
        ventana.add(et_retorno);
        
        et_respuesta       = new JLabel("Respuesta");
        et_respuesta.setBounds(480, y2, 70, 20);     
        ventana.add(et_respuesta);
        
        et_espera       = new JLabel("Espera");
        et_espera.setBounds(550, y2, 70, 20);     
        ventana.add(et_espera);
        
        et_servicio       = new JLabel("Servicio");
        et_servicio.setBounds(620, y2, 70, 20);     
        ventana.add(et_servicio);
        
        
     ta_DatosProceso = new JTextArea();
        sp_DatosProceso = new JScrollPane(ta_DatosProceso);
        sp_DatosProceso.setBounds(50,y2+20,650,200);
        ta_DatosProceso.setEditable(false);
        ventana.add(sp_DatosProceso);
             
	}   
        
        
        
        
        @Override
      public void run()
      {
           KeyListener listener = new KeyListener() {
             Interfaz listen = new Interfaz(si);
			@Override
			public void keyTyped(KeyEvent e) {
			}

			@Override
			public void keyPressed(KeyEvent e) {
			
                                if("P".equals(KeyEvent.getKeyText(e.getKeyCode())))
                                {
                                    
                                    try {
                                        this.listen.si.escuchador(0,1,0,0,0,0);
                                       
                                    } catch (InterruptedException ex) {
                                        Logger.getLogger(Interfaz.class.getName()).log(Level.SEVERE, null, ex);
                                    }
                                }
                                if("C".equals(KeyEvent.getKeyText(e.getKeyCode())))
                                {
                                   
                                    try {
                                         this.listen.si.escuchador(1,0,0,0,0,0);
                                        
                                    } catch (InterruptedException ex) {
                                        Logger.getLogger(Interfaz.class.getName()).log(Level.SEVERE, null, ex);
                                    }
                                }
                                if("W".equals(KeyEvent.getKeyText(e.getKeyCode())))
                                {
                                   
                                    try {
                                         this.listen.si.escuchador(0,0,1,0,0,0);
                                        
                                    } catch (InterruptedException ex) {
                                        Logger.getLogger(Interfaz.class.getName()).log(Level.SEVERE, null, ex);
                                    }
                                }
                                if("T".equals(KeyEvent.getKeyText(e.getKeyCode())))
                                {
                                   
                                    try {
                                        //le paso como si hubiera pulsado la p para que se pause y luego veo como mostrarlo
                                         this.listen.si.escuchador(1,0,0,1,0,0);
                                        
                                    } catch (InterruptedException ex) {
                                        Logger.getLogger(Interfaz.class.getName()).log(Level.SEVERE, null, ex);
                                    }
                                }
                                
                                if("U".equals(KeyEvent.getKeyText(e.getKeyCode())))
                                {
                                   
                                    try {
                                        //le paso como si hubiera pulsado la p para que se pause y luego veo como mostrarlo
                                         this.listen.si.escuchador(0,0,0,0,1,0);
                                        
                                    } catch (InterruptedException ex) {
                                        Logger.getLogger(Interfaz.class.getName()).log(Level.SEVERE, null, ex);
                                    }
                                }
                          
                                if("E".equals(KeyEvent.getKeyText(e.getKeyCode())))
                                {
                                   
                                    try {
                                        //le paso como si hubiera pulsado la p para que se pause y luego veo como mostrarlo
                                         this.listen.si.escuchador(0,0,0,0,0,1);
                                        
                                    } catch (InterruptedException ex) {
                                        Logger.getLogger(Interfaz.class.getName()).log(Level.SEVERE, null, ex);
                                    }
                                }
			}
           
              
 	
			@Override
			public void keyReleased(KeyEvent e) {

                             if("P".equals(KeyEvent.getKeyText(e.getKeyCode())))
                                {
                                    
                                    try {
                                        this.listen.si.escuchador(0,0,0,0,0,0);
                                       
                                    } catch (InterruptedException ex) {
                                        Logger.getLogger(Interfaz.class.getName()).log(Level.SEVERE, null, ex);
                                    }
                                }
                                if("C".equals(KeyEvent.getKeyText(e.getKeyCode())))
                                {
                                   
                                    try {
                                         this.listen.si.escuchador(0,0,0,0,0,0);
                                        
                                    } catch (InterruptedException ex) {
                                        Logger.getLogger(Interfaz.class.getName()).log(Level.SEVERE, null, ex);
                                    }
                                }
                                if("W".equals(KeyEvent.getKeyText(e.getKeyCode())))
                                {
                                   
                                    try {
                                         this.listen.si.escuchador(0,0,0,0,0,0);
                                        
                                    } catch (InterruptedException ex) {
                                        Logger.getLogger(Interfaz.class.getName()).log(Level.SEVERE, null, ex);
                                    }
                                }
                                if("T".equals(KeyEvent.getKeyText(e.getKeyCode())))
                                {
                                   
                                    try {
                                        //le paso como si hubiera pulsado la p para que se pause y luego veo como mostrarlo
                                         this.listen.si.escuchador(1,0,0,0,0,0);
                                        
                                    } catch (InterruptedException ex) {
                                        Logger.getLogger(Interfaz.class.getName()).log(Level.SEVERE, null, ex);
                                    }
                                }
                                
                                if("U".equals(KeyEvent.getKeyText(e.getKeyCode())))
                                {
                                   
                                    try {
                                        //le paso como si hubiera pulsado la p para que se pause y luego veo como mostrarlo
                                         this.listen.si.escuchador(0,0,0,0,0,0);
                                        
                                    } catch (InterruptedException ex) {
                                        Logger.getLogger(Interfaz.class.getName()).log(Level.SEVERE, null, ex);
                                    }
                                }
                          
                                if("E".equals(KeyEvent.getKeyText(e.getKeyCode())))
                                {
                                   
                                    try {
                                        //le paso como si hubiera pulsado la p para que se pause y luego veo como mostrarlo
                                         this.listen.si.escuchador(0,0,0,0,0,0);
                                        
                                    } catch (InterruptedException ex) {
                                        Logger.getLogger(Interfaz.class.getName()).log(Level.SEVERE, null, ex);
                                    }
                                }
			}
                        
		};
        
        ventana.addKeyListener(listener);
        ventana.setFocusable(true);            
         
             
        
        ventana.setLocation(100, 50);
        ventana.setResizable(true);
        ventana.setVisible(true);
        ventana.setSize(720, 570);
        ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
	
	}
      }
	

