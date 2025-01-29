package basurero.newFile;

import static basurero.NewClass.addText;
import static basurero.NewClass.read;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import org.json.simple.JSONObject;


public class crearUnFitchero {
    public static void main( String[] args )
    {
        File fichero = new File ("fichero.txt");
        
        try {
          // A partir del objeto File creamos el fichero físicamente
          if (fichero.createNewFile())
            System.out.println("El fichero se ha creado correctamente");
          else
            System.out.println("No ha podido ser creado el fichero");
        } catch (IOException ioe) {
          ioe.printStackTrace();
        }
    }
}
