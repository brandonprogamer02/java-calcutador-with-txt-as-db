package inicio;

import java.io.File;
import java.io.FileWriter;
import java.io.PrintWriter;

public class Escritura 
{
    public static void escribir(File ruta,String texto)
    {
        FileWriter fichero = null;
        PrintWriter pw = null;
        
        try
        {
            fichero = new FileWriter(ruta,true);
            pw = new PrintWriter(fichero);
            System.out.println("el tamano es:" + ruta.length() );
            
            pw.println(texto);

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
           try {
           // Nuevamente aprovechamos el finally para 
           // asegurarnos que se cierra el fichero.
           if (null != fichero)
              fichero.close();
           } catch (Exception e2) {
              e2.printStackTrace();
           }
        }
        
    }
    
    
    
}
