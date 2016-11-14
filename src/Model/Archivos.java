package Model;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class Archivos {

    public int[][] matriz;
    
    public Archivos() {
        
    }
    
    public int[][] leerMatriz(String ruta){
        int[][] matrizAdj = null; 
        try{
            File file = new File(ruta);
            FileReader reader = new FileReader(file);
            BufferedReader br = new BufferedReader(reader);
            int size = 0;
            int row = 0;
            String linea = "";
            linea = br.readLine();
            while(linea != null){
                String[] vals = linea.trim().split(" ");
                linea = br.readLine();
                if (matrizAdj == null) {
                    size = vals.length;
                    matrizAdj = new int[size][size];
                }
                for (int col = 0; col < size; col++) {
                    matrizAdj[row][col] = Integer.parseInt(vals[col]);
                }
                row++;
            }
            br.close();
            //<--- Inprimir para probar
            System.out.println("\nMatriz de adyacencia: \n");
            System.out.print("\t\t");
            for (int k = 0; k < size; k++) {
                System.out.print(k+"\t");
            }
            System.out.println();
            for (int i = 0; i < size; i++) {
                System.out.print(i+"\t|\t");
                for (int j = 0; j < size; j++) {
                    System.out.print(matrizAdj[i][j] + "\t");
                }
                System.out.println("|");
            }
            // --->
        }catch(IOException e){
            System.out.println("ERROR: " + e.getMessage());
        }
        return matrizAdj;
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
