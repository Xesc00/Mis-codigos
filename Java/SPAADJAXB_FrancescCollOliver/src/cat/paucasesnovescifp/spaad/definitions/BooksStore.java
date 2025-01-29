package cat.paucasesnovescifp.spaad.definitions;

import java.util.ArrayList;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlRootElement(name="bookstore")
@XmlType(propOrder = {"bsType","bsname","books"})
public class BooksStore {
    private String bsType;
    private String bsname;
    private ArrayList<Book> books;

    @Override
    public String toString() {
        return "Bookss{" + " bsType=" + bsType + ", bsname=" + bsname + ", books=" + books + "}";
    }

    public BooksStore() {
        this(null, null);
    }

    public BooksStore(String bsType, String bsname) {
        this.setBsType(bsType);
        this.setBsname(bsname);
        this.setBooks(new ArrayList<>());
    }
    
    @XmlAttribute
    public String getBsType() {
        return bsType;
    }

    public void setBsType(String bsType) {
        this.bsType = bsType;
    }

    public String getBsname() {
        return bsname;
    }

    public void setBsname(String bsname) {
        this.bsname = bsname;
    }
    
    @XmlElement(name = "book")
    public ArrayList<Book> getBooks() {
        return books;
    }

    public void setBooks(ArrayList<Book> books) {
        this.books = books;
    }
}
