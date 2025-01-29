package cat.paucasesnovescifp.spaad.jdbc;


import cat.paucasesnovescifp.spaad.jdbc.db.Database;
import static cat.paucasesnovescifp.spaad.jdbc.db.Database.*;
import cat.paucasesnovescifp.spaad.jdbc.info.Autor;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Properties;

public class jdbc {

    public static void main(String[] args) throws SQLException {
        
        //Conexio
        Properties prop = new Properties();
        prop.put("user", "lector");
        prop.put("password", "12345678");
        Database db = new Database("jdbc:mysql://localhost/biblioteca", prop);

        int id = 6672;        
        //8.1
//        System.out.println(db.getNacionalitats());
//        //8.2
//        System.out.println(db.getAutor(1));
//        //8.3
//        System.out.println(db.getAutors("IRLANDESA"));
//        
        //9
//        ArrayList<Autor> autors = new ArrayList<>();
//        Autor a = new Autor(id, "jj, xx", "2000-7-13 09:00:00");
//        Autor b = new Autor(++id, "xx, jj", "2011-8-13 07:00:00");
//        
//        autors.add(a);
//        autors.add(b);
//        
//        setNacionalitatAutors("ESPANYOLA", autors);
        
        //10
//        System.out.println(db.getAutor(id));
//        System.out.println(db.getAutor(++id));
        
        //11
//        System.out.println(db.getAutors("CATALANA"));
//        deleteNacionalitat("CATALANA");
//        System.out.println(db.getAutors("CATALANA"));
        
        //14
        //correcio("ESPANYOLA", "ESPAÑOLA");
    }
    
    
}
