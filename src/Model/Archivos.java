package Model;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

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
    
    

}
