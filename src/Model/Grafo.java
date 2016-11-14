/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.util.Iterator;

/**
 *
 * @author SheshoVega
 */
public class Grafo {
    public int numVertices;
    public Vertice[] tablaAdj;
    
    public Grafo(int cantVertices){
        this.numVertices = cantVertices;
        this.tablaAdj = new Vertice[cantVertices];
        for(int i=0;i<numVertices;i++){
            Vertice ver = new Vertice(Integer.toString(i));
            tablaAdj[i] = ver;
        }
    }

    public Vertice[] getTablaAdj() {
        return tablaAdj;
    }

    public int getNumVertices() {
        return numVertices;
    }
    
    public void imprimirTablaAdj(){
        for(int i=0;i<tablaAdj.length;i++){
            Iterator<Arco> ite = tablaAdj[i].listAdj.iterator();
            System.out.print( i+":\t");
            while(ite.hasNext()){
                Arco ele = ite.next();
                System.out.print(ele.getDestino() + "\t");
            }
            System.out.println();
        }
    }
}
