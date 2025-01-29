package cat.paucasesnovescifp.spaad.jdbc.info;

public class Nacionalitat {
    public String nacionalitat;

    public Nacionalitat(String nacionalitat) {
        this.nacionalitat = nacionalitat;
    }

    @Override
    public String toString() {
        return nacionalitat;
    }

    public String getNacionalitat() {
        return nacionalitat;
    }

    public void setNacionalitat(String nacionalitat) {
        this.nacionalitat = nacionalitat;
    }
}
