
import Controller.Controlador;
import Model.Archivos;
import java.io.IOException;


public class PageRank {

    public static void main(String[] args) throws IOException {
        Controlador ctr = new Controlador();
        ctr.cargarInfo("matrix.txt");
    }
    
}
