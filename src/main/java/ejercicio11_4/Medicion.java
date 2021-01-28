/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejercicio11_4;

import ejercicio11_3.*;
import ejercicio11_2.*;
import java.awt.List;
import java.util.ArrayList;
import java.util.Random;

/**
 *
 * @author daniel.ignacio.dipas
 */
public class Medicion {
    private ArrayList<Integer> listaTemperatura, listaSensacionTermica;
    private Random valor;
    final int tempMenor = 20;
    final int tempMayor = 40;
    Object monitor1, monitor2;
    final int senMayor = 60;
    final int senMenor = 20;
    private int contadorStats = 1;
    
    public Medicion() {
        this.listaTemperatura = new ArrayList<Integer>();
        this.listaSensacionTermica = new ArrayList<Integer>();
        this.valor = new Random();
        monitor1 = new Object();
        monitor2 = new Object();
    }

    public   void  acumularTemp() {
        synchronized(monitor1){
            try {
                Thread.sleep(1);
            } catch (InterruptedException ex) {
                ex.printStackTrace();
            }
            this.listaTemperatura.add(valor.nextInt(tempMayor + tempMenor) - tempMenor);
        }        
    }

    public   void acumularTermica() {
        synchronized(monitor2){
        try {
            Thread.sleep(1);
        } catch (InterruptedException ex) {
            ex.printStackTrace();
        }
        
        this.listaSensacionTermica.add(valor.nextInt(senMayor + senMenor) - senMenor);
        }
    }

    public void proceso() {
        for (int i = 0; i < 1000; i++) {
            this.acumularTemp();
            this.acumularTermica();
        }
    }

    int numElemList(char l) {
        int resultado = 0;
        switch (l) {
            case 'c':
                resultado = this.listaTemperatura.size();
                break;
            case 'v':
                resultado = this.listaSensacionTermica.size();
                break;
            default:
                resultado = 0;
        }
        return resultado;
    }

    double[] media(){
        double[] resultado = {0, 0};
	double[] resultadosParciales = new double[4];
	Thread t1, t2, t3, t4;

	t1 = new Thread(new Runnable() {
            public void run() {
                resultadosParciales[0] = mediaMitad('t', false, 1);
            }
	});
	t2 = new Thread(new Runnable() {
            @Override
            public void run() {
               resultadosParciales[1]= mediaMitad('t', true,2 );
            }
		// primera lista pares
	});
	t3 = new Thread(new Runnable() {
		@Override
            public void run() {
                 resultadosParciales[2] = mediaMitad('s', false,3);
            }
	});
	t4 = new Thread(new Runnable() {
		@Override
            public void run() {
                resultadosParciales[3] = mediaMitad('s', true,4);
            }
	});        
            t1.start();
            t2.start();
            t3.start();
            t4.start();
	try {        
		t1.join();
		t2.join();
		t3.join();
		t4.join();
	} catch (InterruptedException e) {
		e.printStackTrace();
	}   
        // Acumular resultados parciales en resultado[0] y resultado[1]
        resultado[0] = (resultadosParciales[0] + resultadosParciales[1])/2;
        resultado[1] = (resultadosParciales[2] + resultadosParciales[3])/2;
	
	return resultado;

    
    }
    
    private double mediaMitad(char l, boolean par, int contador) {
        long start = System.currentTimeMillis();
	double resultado = 0;
	ArrayList<Integer> lista;
	int inicio = 0;
	switch (l) {
		case 't':
			// asignar lista a la variable lista
			lista = this.listaTemperatura;
			if (!par) {
                            inicio = 1;
			}
			break;
		case 's':
			lista = this.listaSensacionTermica;
			if (!par) {
                            inicio = 1;
			}
			break;
		default:
			inicio = -1;
			lista = new ArrayList<Integer>();
        }
        
        if (inicio > -1) {
            
            for(int i=inicio; i<lista.size(); i+=2){
                resultado += lista.get(i);
                try{
                    Thread.sleep(1);
                }catch(Exception e){
                    e.printStackTrace();
                }
                
            }
        }
        long end = System.currentTimeMillis();
        System.out.println("DDP Time Spent Calculating Average Process "  + contador + ": "+ (end - start));  
	return resultado / lista.size();
    }

}
