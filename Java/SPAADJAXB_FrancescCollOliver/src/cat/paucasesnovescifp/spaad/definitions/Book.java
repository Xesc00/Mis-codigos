package cat.paucasesnovescifp.spaad.definitions;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlRootElement(name="book")
@XmlType(propOrder = {"id", "category", "lang", "title", "author", "year", "price"})
public class Book {
    private int id;
    private String category;
    private String title;
    private String lang;
    private String author;
    private int year;
    private float price;

    @Override
    public String toString() {
        return "Book{" + "id=" + id + ", category=" + category + ", title=" + title + ", lang = " + lang + ", author=" + author + ", year=" + year + ", price=" + price + '}';
    }
    
    public Book(int id, String category, String title, String lang, String author, int year, float price) {
        this.id = id;
        this.category = category;
        this.title = title;
        this.lang = lang;
        this.author = author;
        this.year = year;
        this.price = price;
    }

    public Book() {
    }

    @XmlAttribute
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
    
     public String getLang() {
        return lang;
    }

    public void setLang(String lang) {
        this.lang = lang;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }
    
}
