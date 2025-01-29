package cat.paucasesnovescifp.spaad.jdbc.info;

public class Autor {
    
    public int id_aut;
    public String nom_aut;
    public String dnaix_aut;
    public String fk_nacionalitat;

    public Autor(int id_aut, String nom_aut, String dnaix_aut, String fk_nacionalitat) {
        this.id_aut = id_aut;
        this.nom_aut = nom_aut;
        this.dnaix_aut = dnaix_aut;
        this.fk_nacionalitat = fk_nacionalitat;
    }

    public Autor(int id_aut, String nom_aut, String dnaix_aut) {
        this.id_aut = id_aut;
        this.nom_aut = nom_aut;
        this.dnaix_aut = dnaix_aut;
    }

    public Autor() {
    }

    @Override
    public String toString() {
        return "Autor{" + id_aut + "," + nom_aut + "," + dnaix_aut + ", " + fk_nacionalitat + '}';
    }
    
    

    public int getId_aut() {
        return id_aut;
    }

    public void setId_aut(int id_aut) {
        this.id_aut = id_aut;
    }

    public String getNom_aut() {
        return nom_aut;
    }

    public void setNom_aut(String nom_aut) {
        this.nom_aut = nom_aut;
    }

    public String getDnaix_aut() {
        return dnaix_aut;
    }

    public void setDnaix_aut(String dnaix_aut) {
        this.dnaix_aut = dnaix_aut;
    }

    public String getFk_nacionalitat() {
        return fk_nacionalitat;
    }

    public void setFk_nacionalitat(String fk_nacionalitat) {
        this.fk_nacionalitat = fk_nacionalitat;
    }
    
    
    
}
