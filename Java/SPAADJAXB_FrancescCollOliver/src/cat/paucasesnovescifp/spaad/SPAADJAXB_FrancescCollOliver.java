package cat.paucasesnovescifp.spaad;

import cat.paucasesnovescifp.spaad.definitions.Book;
import cat.paucasesnovescifp.spaad.definitions.BookMulti;
import cat.paucasesnovescifp.spaad.definitions.BooksStore;
import cat.paucasesnovescifp.spaad.jaxbmanager.Manager;

public class SPAADJAXB_FrancescCollOliver {

  
    public static void main(String[] args) {
        
        //Crei un string amb la ruta que ha de seguir el progrma per torbar l'xml fora aquest perque aixi no he d'e copiar cada vegade la direccio
        String ruta = "C:\\Users\\xesc2\\Documents\\NetBeansProjects\\SPAADJAXB_FrancescCollOliver\\src\\cat\\paucasesnovescifp\\spaad\\xmlfiles\\";
       
        try{
            //1.4
            Book book = Manager.readBook(ruta + "book.xml");
            System.out.println("Informacio = " + book);
            
            //1.6
            Book nB = new Book(1, "accion", "AAAA", "es", "Brandon", 2010, 13);
            Manager.writeBook(ruta + "porves.xml", nB);
            
            //2
            BooksStore bookStore = Manager.readBookstore(ruta + "bookstore.xml");
            System.out.println("Informacio = " + bookStore);
            
            //Pas l'bjecte que ma tornat per fer més via 
            Manager.writeBookStore(ruta + "porves.xml", bookStore);
            
            
            //3
            BookMulti bookMulti = Manager.readBookMulti(ruta + "multibookstore.xml");
            System.out.println("Informacio = " + bookMulti);
            
            //Pas l'bjecte que ma tornat per fer més via 
            Manager.writeBookMulti(ruta + "porves.xml", bookMulti);
            
        } catch (Exception e){
            System.out.println("Error: " + e.getMessage());
            e.printStackTrace();
        }
    }
    
}
