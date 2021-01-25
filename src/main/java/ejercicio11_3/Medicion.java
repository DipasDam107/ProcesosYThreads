/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejercicio11_3;

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
  
    
    public Medicion() {
        this.listaTemperatura = new ArrayList<Integer>();
        this.listaSensacionTermica = new ArrayList<Integer>();
        this.valor = new Random();
    }

    public synchronized  void  acumularTemp() {
        
            try {
                Thread.sleep(1);
            } catch (InterruptedException ex) {
                ex.printStackTrace();
            }
            this.listaTemperatura.add(valor.nextInt(tempMayor + tempMenor) - tempMenor);
        
    }

    public synchronized  void acumularTermica() {
        try {
            Thread.sleep(1);
        } catch (InterruptedException ex) {
            ex.printStackTrace();
        }
        
        this.listaSensacionTermica.add(valor.nextInt(tempMayor + tempMenor) - tempMenor);
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

}
