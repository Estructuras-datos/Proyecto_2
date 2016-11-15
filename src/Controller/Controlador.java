/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Model.Archivos;
import Model.Arco;
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
        for (int row = 0; row < size; row++) {
            for (int col = 0; col < size; col++) {
                if (matrizAdj[row][col] == 1) {
                    grafo.tablaAdj[row].getListAdj().add(new Arco(col));
                }
            }
        }

        //<--- Inprimir para probar
        System.out.println("\nLista de adyacencias:");
        grafo.imprimirTablaAdj();
        // --->
        
        //<--- Inprimir hash entradas para probar
        Vertice[] ins = this.getEntradas(grafo);
//        System.out.print(grafo.numVertices);
        System.out.println("\nLista de entradas de cada vertice:");
        for(int z=0;z<ins.length;z++){
            Iterator<Arco> ite = ins[z].getListAdj().iterator();
            System.out.print( z+":\t");
            while(ite.hasNext()){
                Arco ele = ite.next();
                System.out.print(ele.getDestino() + "\t");
            }
            System.out.println();
        }
        // --->
        
        //Cantidad de Entradas y Salidas de cada Vertice
        this.imprimirNumInputsOutputs(ins, grafo.getTablaAdj());
        
        System.out.println("Resultados PageRank:");
        for(int i=0;i<grafo.getNumVertices();i++){
            System.out.print("Vertice "+i+":\t");
            System.out.println(pageRank(grafo.getTablaAdj()[i]));
        }
        System.out.println();
        
    }

    public double pageRank(Vertice actual) {

        ArrayList<Vertice> apuntando = new ArrayList<Vertice>();

        for (int i = 0; i < grafo.getNumVertices(); i++) {
            for (Arco aux : grafo.getTablaAdj()[i].getListAdj()) {
                if (aux.getDestino()==Integer.parseInt(actual.getNombre())) {
                    apuntando.add(grafo.getTablaAdj()[i]);
                }
            }
        }

        Iterator<Vertice> it = apuntando.iterator();
        double resultado = 0;
        

        while (it.hasNext()) {
            Vertice aux=it.next();
            resultado +=( pageRank(aux) / aux.getListAdj().size() );
            
        }
        resultado=0.85*resultado;
        resultado+=(1-0.85);
        if(apuntando.size()==0){
            resultado = 0.15;
        }
        return resultado;

    }
    
    public Vertice[] getEntradas(Grafo g){
        int size = g.numVertices;
        Vertice[] entradas = new Vertice[size];
        for(int i=0;i<size;i++){ //inicializar entradas
            Vertice ver = new Vertice(Integer.toString(i));
            entradas[i] = ver;
        }
        for(int j=0;j<size;j++){
            for(int k=0;k<g.tablaAdj.length;k++){
                Iterator<Arco> ite = g.tablaAdj[k].getListAdj().iterator();
                while(ite.hasNext()){
                    Arco ele = ite.next();
                    if(ele.getDestino() == j){
                        entradas[j].getListAdj().add(new Arco(k));
                    }
                }
            }            
        }
        return entradas;
    }
    
    public void imprimirNumInputsOutputs(Vertice[] entradas, Vertice[] salidas){
        System.out.println("\nCantidad de entradas por Vertice:");
        for(int i=0;i<entradas.length;i++){
            System.out.print("Vertice "+i+":\t");
            System.out.println(entradas[i].getListAdj().size());
        }
        System.out.println("\nCantidad de entradas por Vertice:");
        for(int j=0;j<salidas.length;j++){
            System.out.print("Vertice "+j+":\t");
            System.out.println(salidas[j].getListAdj().size());
        }
        System.out.println();
    }
}
