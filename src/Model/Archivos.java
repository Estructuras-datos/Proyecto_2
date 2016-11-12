package Model;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class Archivos {

    public int[][] matriz;
    
    public Archivos() {
        
    }

    public void cargar() {
        try {
            // Abriendo el archivo
            FileInputStream saveFile = new FileInputStream("SaveMatriz.sav");
            
            
            // Leer objetos del archivo guardado
            ObjectInputStream save = new ObjectInputStream(saveFile);

            // Restaurando el objeto recuperado
            // readObject() retorna un objeto generico, por lo que hay que castearlo
            matriz = (int[][]) save.readObject();

            // cerrar el archivo
            save.close();
        } catch (Exception exc) {
            exc.printStackTrace();
        }
    }

    public void guardar() throws IOException {
        try {
            FileOutputStream saveFile = new FileOutputStream("SaveMatriz.sav");

            ObjectOutputStream save = new ObjectOutputStream(saveFile);

            int[][] mat = generarMatriz();
            save.writeObject(mat);

            save.close();
        } catch (Exception exc) {
            exc.printStackTrace();
        }
    }

    public int[][] generarMatriz() {
        int[][] matAd = new int[11][11];
        matAd[1][2] = 1;
        matAd[2][1] = 1;
        matAd[3][0] = 1;
        matAd[3][1] = 1;
        matAd[4][1] = 1;
        matAd[4][3] = 1;
        matAd[4][5] = 1;
        matAd[5][1] = 1;
        matAd[5][4] = 1;
        matAd[6][1] = 1;
        matAd[6][4] = 1;
        matAd[7][1] = 1;
        matAd[7][4] = 1;
        matAd[8][1] = 1;
        matAd[8][4] = 1;
        matAd[9][3] = 1;
        matAd[10][3] = 1;
        for (int i = 0; i < 11; i++) {
            for (int j = 0; j < 11; j++) {
                if (matAd[i][j] != 1) {
                    matAd[i][j] = 0;
                }
            }
        }

        return matAd;
    }

}
