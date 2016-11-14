/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

/**
 *
 * @author SheshoVega
 */
public class Arco {
    int destino;
    
    public Arco(int d){
        this.destino = d;
    }

    public int getDestino() {
        return destino;
    }
    
    public boolean equals(Object n){
        Arco a = (Arco)n;
        return destino == a.destino;
    }
}
