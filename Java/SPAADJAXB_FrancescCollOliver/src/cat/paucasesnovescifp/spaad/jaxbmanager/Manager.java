package cat.paucasesnovescifp.spaad.jaxbmanager;

import cat.paucasesnovescifp.spaad.definitions.Book;
import cat.paucasesnovescifp.spaad.definitions.BookMulti;
import cat.paucasesnovescifp.spaad.definitions.BooksStore;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;

public class Manager {
    
    public static Book readBook(String origen)throws JAXBException{
        JAXBContext context;
	context = JAXBContext.newInstance(Book.class);
	Unmarshaller unmar = context.createUnmarshaller();
        
        return (Book) unmar.unmarshal(new File(origen));
    }
    
    public static void writeBook(String desti, Book informacio) throws IOException, JAXBException {
        try (FileWriter fw = new FileWriter(desti)) {
            JAXBContext context = JAXBContext.newInstance(Book.class);
            Marshaller marshaller = context.createMarshaller();
            marshaller.marshal(informacio, fw);
        }
    }
    
    public static BooksStore readBookstore(String origen) throws JAXBException{
        JAXBContext context;	
        context = JAXBContext.newInstance(BooksStore.class);
        Unmarshaller unmar = context.createUnmarshaller();
        
        return (BooksStore) unmar.unmarshal(new File(origen));
    }
    
    public static void writeBookStore(String desti, BooksStore informacio) throws IOException, JAXBException {
        try (FileWriter fw = new FileWriter(desti)) {
            JAXBContext context = JAXBContext.newInstance(BooksStore.class);
            Marshaller marshaller = context.createMarshaller();
            marshaller.marshal(informacio, fw);
        }
    }
    
    public static BookMulti readBookMulti(String origen) throws JAXBException{
        JAXBContext context;	
        context = JAXBContext.newInstance(BookMulti.class);
        Unmarshaller unmar = context.createUnmarshaller();
        
        return (BookMulti) unmar.unmarshal(new File(origen));
    }
    
    public static void writeBookMulti(String desti, BookMulti informacio) throws IOException, JAXBException {
        try (FileWriter fw = new FileWriter(desti)) {
            JAXBContext context = JAXBContext.newInstance(BookMulti.class);
            Marshaller marshaller = context.createMarshaller();
            marshaller.marshal(informacio, fw);
        }
    }
}

