package cat.paucasesnovescifp.spaad.jdbc.db;

import cat.paucasesnovescifp.spaad.jdbc.helpers.JDBCExcepcio;
import cat.paucasesnovescifp.spaad.jdbc.info.Autor;
import cat.paucasesnovescifp.spaad.jdbc.info.Nacionalitat;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Properties;

public class Database {
    static JDBCExcepcio jdbce;
    static String url;
    static Properties prop;
    
    public static ArrayList<String> llengues() throws SQLException {
        ArrayList<String> idiomes = new ArrayList<String>();
        try {
            Connection myConnection = DriverManager.getConnection(url, prop);
            Statement myStatment = myConnection.createStatement();
            
            ResultSet myResultSet = myStatment.executeQuery("SELECT * FROM biblioteca.llengues;");
            while(myResultSet.next())
            {
                idiomes.add(myResultSet.getString("llengua"));
            }
            
        } catch(Exception e){
            
        }	
        
        return idiomes;	
    }
    
//    public static ArrayList<String> rebllen(String idioma) {
//        ArrayList<String> llibres = new ArrayList<String>();
//        try {
//                Connection myConnection = DriverManager.getConnection(url, prop);		
//                Statement myStatment = myConnection.createStatement();
//
//                ResultSet myResultSet = myStatment.executeQuery("SELECT TITOL FROM biblioteca.llibres WHERE FK_LLENGUA = '" + idioma +"'");
//
//                while(myResultSet.next()) {
//                        llibres.add(myResultSet.getString("TITOL"));
//                }
//
//        }catch (SQLException e) {
//                jdbce = new JDBCExcepcio(e.getStackTrace().toString());
//        }
//        return llibres;
//    }
    
    //8.1
    public static ArrayList<Nacionalitat>  getNacionalitats() {
        ArrayList<Nacionalitat> nac = new ArrayList<>();
        try {
                Connection myConnection = DriverManager.getConnection(url, prop);
                Statement myStatment = myConnection.createStatement();

                ResultSet myResultSet = myStatment.executeQuery("SELECT * FROM biblioteca.nacionalitats");
                while(myResultSet.next()) {
                    nac.add(new Nacionalitat(myResultSet.getString("NACIONALITAT")));
                }
        }catch (SQLException e) {
                jdbce = new JDBCExcepcio(e.getStackTrace().toString());
        }
        return nac;
    }
    
    //8.2
    public static Autor getAutor(int idAutor) throws SQLException{
        try {
            Connection myConnection = DriverManager.getConnection(url, prop);
            Statement myStatment = myConnection.createStatement();

            ResultSet myResultSet = myStatment.executeQuery("SELECT * FROM biblioteca.autors WHERE ID_AUT = " + idAutor);
            Autor aut = new Autor();

            while(myResultSet.next())
            {
                int id = myResultSet.getInt("ID_AUT");
                String nom = myResultSet.getString("NOM_AUT"), data = myResultSet.getString("DNAIX_AUT"),  nacio = myResultSet.getString("FK_NACIONALITAT");
                aut = new Autor(id, nom, data, nacio);
            }

            if(myResultSet!=null) myResultSet.close();
            if(myStatment!=null) myStatment.close();
            if(myConnection!=null) myConnection.close();

            return aut;
        }catch (SQLException e) {
            jdbce = new JDBCExcepcio(e.getStackTrace().toString());
        }
        return null;
    }
    
    //8.3
    public ArrayList<Autor> getAutors(String nacionalitat){
        ArrayList<Autor> autor = new ArrayList<>();
        try {
                Connection myConnection = DriverManager.getConnection(url, prop);
                Statement myStatment = myConnection.createStatement();

                ResultSet myResultSet = myStatment.executeQuery("SELECT * FROM biblioteca.autors WHERE FK_NACIONALITAT = '" + nacionalitat + "'");
                Autor aut = new Autor();

                while(myResultSet.next()) {
                    int id = myResultSet.getInt("ID_AUT");
                    String nom = myResultSet.getString("NOM_AUT"), data = myResultSet.getString("DNAIX_AUT"),  nacio = myResultSet.getString("FK_NACIONALITAT");
                    aut = new Autor(id, nom, data, nacio);
                    autor.add(aut);
                }

        }catch (SQLException e) {
                //jdbce = new JDBCExcepcio(e.getStackTrace().toString());
                System.out.println(e.toString());
        }
        return autor;
    }
    
    //9
    public static void setNacionalitatAutors(String nacionalitat, ArrayList<Autor> autors) {
        try {				
            Connection myConnection = DriverManager.getConnection(url, prop);
            Statement myStatement = myConnection.createStatement();

            int i = 0;
            while (i < autors.size()) {
                    myStatement.addBatch("INSERT INTO biblioteca.AUTORS (ID_AUT, NOM_AUT, DNAIX_AUT, FK_NACIONALITAT) VALUES (" + autors.get(i).getId_aut() + ", '"  + autors.get(i).getNom_aut() +"' , '" +  autors.get(i).getDnaix_aut() + "', '" + nacionalitat +"' )");
                    i++;
            }
            myStatement.executeBatch();

            System.out.println("Dades afegides correctament a la Base de Dades");

            if(myStatement!=null) myStatement.close();
            if(myConnection!=null) myConnection.close();

        }catch(Exception e) {
            System.out.println(e.toString());
        }
    }
    
    //11
    public static void deleteNacionalitat(String nacionalitat) {
        try {
                        Connection myConnection = DriverManager.getConnection(url, prop);
                        Statement myStatement = myConnection.createStatement();

                        myStatement.addBatch("DELETE FROM autors WHERE FK_NACIONALITAT = " + nacionalitat);
                        myStatement.addBatch("DELETE FROM nacionalitats WHERE NACIONALITAT = " + nacionalitat);


                        myStatement.executeBatch();

                        System.out.println("Dades eliminades de la Base de Dades");

                        if(myStatement!=null) myStatement.close();
                        if(myConnection!=null) myConnection.close();

        }catch(Exception e) {
            System.out.println(e.toString());
        }
    }
    
    //12
    public static void setNacionalitatAutorsTransaccio(String nacionalitat, ArrayList<Autor> autors) {
        try {
                Connection myConnection = DriverManager.getConnection(url, prop);
                Statement myStatement = myConnection.createStatement();

                int i = 0;
                while (i < autors.size()) {
                        myStatement.addBatch("INSERT INTO AUTORS (ID_AUT, NOM_AUT, DNAIX_AUT, FK_NACIONALITAT) VALUES (" + autors.get(i).getId_aut() + ", '"  + autors.get(i).getNom_aut() +"' , '" +  autors.get(i).getDnaix_aut() + "', '" + nacionalitat +"' )");
                        i++;
                }
                myStatement.executeBatch();

                System.out.println("Dades afegides de la Base de Dades");

                if(myStatement!=null) myStatement.close();
                if(myConnection!=null) myConnection.close();

        }catch(Exception e) {
            System.out.println(e.toString());
            
            //Falta afegir el rollback
        }
    }
    
    //14
    public static void correcio(String llgood, String llbad){
        try {
                Connection myConnection = DriverManager.getConnection(url, prop);
                Statement myStatement = myConnection.createStatement();

                myStatement.addBatch("INSERT INTO llengues VALUES '" + llgood + "'");
                myStatement.addBatch("UPDATE llibres SET FK_LLENGUA = '" + llgood + "' WHERE FK_LLENGUA = '" + llbad + "'");
                myStatement.addBatch("DELETE FROM llengues WHERE LLENGUA = '" + llgood + "'");

                myStatement.executeBatch();

                System.out.println("Dades eliminades de la Base de Dades");

                if(myStatement!=null) myStatement.close();
                if(myConnection!=null) myConnection.close();

        }catch(Exception e) {
            System.out.println(e.toString());
        }
    }

    public Database(String url, Properties prop) {
        this.url = url;
        this.prop = prop;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public Properties getProp() {
        return prop;
    }

    public void setProp(Properties prop) {
        this.prop = prop;
    }
}