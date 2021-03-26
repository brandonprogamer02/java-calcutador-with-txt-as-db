package inicio;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;

public class Lectura {

    public static void leerArchivo(File archivo) {
        FileReader fr = null;
        BufferedReader br = null;

        try
        {
            // Apertura del fichero y creacion de BufferedReader para poder
            // hacer una lectura comoda (disponer del metodo readLine()).
            archivo = new File("texto.txt");
            fr = new FileReader(archivo);
            br = new BufferedReader(fr);

            // Lectura del fichero
            String linea;
            while ((linea = br.readLine()) != null)
            {
                System.out.println(linea);
            }
        } catch (Exception e)
        {
            e.printStackTrace();
        } finally
        {
            // En el finally cerramos el fichero, para asegurarnos
            // que se cierra tanto si todo va bien como si salta 
            // una excepcion.
            try
            {
                if (null != fr)
                {
                    fr.close();
                }
            } catch (Exception e2)
            {
                e2.printStackTrace();
            }
        }

    }

    public static ArrayList<String> getLista(File archivo) {
        ArrayList<String> lista = new ArrayList<>();
        FileReader fr = null;
        BufferedReader br = null;

        try
        {
            archivo = new File("texto.txt");
            fr = new FileReader(archivo);
            br = new BufferedReader(fr);

            String linea;
            while ((linea = br.readLine()) != null)
            {
                lista.add(linea);
            }
        } catch (Exception e)
        {
            e.printStackTrace();
        } finally
        {
            try
            {
                if (null != fr)
                {
                    fr.close();
                }
            } catch (Exception e2)
            {
                e2.printStackTrace();
            }
        }
        return lista;

    }

    public static String getLineaResultado(String resultado) {
        ArrayList<String> lista = getLista(new File("texto.txt"));
        String linea = null;
        for (int i = 0; i < lista.size(); i++)
        {
            String f = getResultado(lista.get(i));
            if(f.equals(resultado))
            {
                System.out.println("se encontro conincidencia en la linea" + (i +1));
                linea = String.valueOf(i +1);
            }

        }

        return linea;
    }

    public static String getResultado(String cadena) 
    {
        String sub = null;
        for (int i = 0; i < cadena.length(); i++)
        {
            char c = cadena.charAt(i);
            if(c == '=')
            {
                sub = cadena.substring(i +1);
                sub = sub.trim();
            }
        }
        
        return sub;
    }

}
