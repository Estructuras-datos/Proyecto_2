/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Model.Archivos;
import Model.Grafo;
import Model.Vertice;
import java.util.Iterator;

/**
 *
 * @author SheshoVega
 */
public class Controlador {
    Archivos arch;
    Grafo grafo;
    public void cargarInfo(String file){
        arch = new Archivos();
        int[][] matrizAdj = arch.leerMatriz(file);
        int size = matrizAdj.length;
        grafo = new Grafo(size);
//        System.out.println(size);
        for (int row = 0; row < size; row++) {
            for (int col = 0; col < size; col++) {
                if(matrizAdj[row][col] == 1){
                    grafo.tablaAdj[row].getListAdj().add(Integer.toString(col));
                }
            }
        }
        
        //<--- Inprimir para probar
        grafo.imprimirTablaAdj();
        // --->
        
    }
}
