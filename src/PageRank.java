
import Model.Archivos;
import java.io.IOException;


public class PageRank {

    public static void main(String[] args) throws IOException {
        Archivos af=new Archivos();
        af.cargar();
        for (int i = 0; i < 11; i++) {
            System.out.print("|");
            for (int j = 0; j < 11; j++) {
                System.out.print(af.matriz[i][j]);
            }
            System.out.println("|");
        }
    }
    
}
