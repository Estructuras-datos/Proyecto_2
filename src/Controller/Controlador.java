/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Model.Archivos;
import Model.Grafo;
import Model.Vertice;
import java.util.ArrayList;
import java.util.Iterator;

/**
 *
 * @author SheshoVega
 */
public class Controlador {

    Archivos arch;
    Grafo grafo;

    public void cargarInfo(String file) {
        arch = new Archivos();
        int[][] matrizAdj = arch.leerMatriz(file);
        int size = matrizAdj.length;
        grafo = new Grafo(size);
//        System.out.println(size);
        for (int row = 0; row < size; row++) {
            for (int col = 0; col < size; col++) {
                if (matrizAdj[row][col] == 1) {
                    grafo.tablaAdj[row].getListAdj().add(Integer.toString(col));
                }
            }
        }
        //<--- Inprimir para probar
        System.out.println("\nLista de adyacencias:\n");
        grafo.imprimirTablaAdj();
        // --->
        System.out.println("\nResultados PageRank:\n");
        for(int i=0;i<grafo.getNumVertices();i++){
            System.out.print("Vertice "+i+":\t");
            System.out.println(pageRank(grafo.getTablaAdj()[i]));
        }
        System.out.println();
    }

    public double pageRank(Vertice actual) {

        ArrayList<Vertice> apuntando = new ArrayList<Vertice>();

        for (int i = 0; i < grafo.getNumVertices(); i++) {
            for (String aux : grafo.getTablaAdj()[i].getListAdj()) {
                if (aux.equals(actual.nomVertice())) {
                    apuntando.add(grafo.getTablaAdj()[i]);
                }
            }
        }

        Iterator<Vertice> it = apuntando.iterator();
        double resultado = 0.01616948;

        while (it.hasNext()) {
            Vertice aux=it.next();
            resultado = (0.85 * (pageRank(aux) / aux.getListAdj().size())) + (1 - 0.85);
        }

        return resultado;

    }
}
