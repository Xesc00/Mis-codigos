package cat.paucasesnovescifp.spaad.definitions;

import java.util.ArrayList;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlRootElement(name="bookstore")
@XmlType(propOrder = {"bsType","bsname","book"})
public class BookMulti {
    private String bookstore;
    private String bsType;
    private String bsname;
    private ArrayList<Book> book;

    @Override
    public String toString() {
        return "Bookss{" + "bookstore=" + bookstore + ", bsType=" + bsType + ", bsname=" + bsname + ", books=" + book + '}';
    }

    public BookMulti() {
        this(null, null);
    }

     public BookMulti(String bsType, String bsname) {
        this.setBsType(bsType);
        this.setBsname(bsname);
        this.setBook(new ArrayList<>());
    }
    
    @XmlAttribute
    public String getBookstore() {
        return bookstore;
    }

    public void setBookstore(String bookstore) {
        this.bookstore = bookstore;
    }

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
    @XmlElementWrapper(name = "books")
    @XmlElement(name = "book")
    public ArrayList<Book> getBook() {
        return book;
    }

    public void setBook(ArrayList<Book> books) {
        this.book = books;
    }
}
