package model;

import javax.persistence.*;
import java.util.Collection;
import java.util.Objects;

@Entity
@Table(name = "Aspirants", schema = "interins")
public class Aspirant {
    private String nif;
    private String nom;
    private String llinatges;
    private String adreca;
    private String codiPostal;
    private Localitat localitat;
    private Collection<Preferencia> preferencies;

    @Id
    @Column(name = "Nif", nullable = false, length = 9)
    public String getNif() {
        return nif;
    }

    public void setNif(String nif) {
        this.nif = nif;
    }

    @Basic
    @Column(name = "nom", nullable = false, length = 45)
    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    @Basic
    @Column(name = "llinatges", nullable = false, length = 45)
    public String getLlinatges() {
        return llinatges;
    }

    public void setLlinatges(String llinatges) {
        this.llinatges = llinatges;
    }

    @Basic
    @Column(name = "adreca", nullable = true, length = 100)
    public String getAdreca() {
        return adreca;
    }

    public void setAdreca(String adreca) {
        this.adreca = adreca;
    }

    @Basic
    @Column(name = "codiPostal", nullable = true, length = 5)
    public String getCodiPostal() {
        return codiPostal;
    }

    public void setCodiPostal(String codiPostal) {
        this.codiPostal = codiPostal;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Aspirant aspirant = (Aspirant) o;
        return Objects.equals(nif, aspirant.nif) &&
                Objects.equals(nom, aspirant.nom) &&
                Objects.equals(llinatges, aspirant.llinatges) &&
                Objects.equals(adreca, aspirant.adreca) &&
                Objects.equals(codiPostal, aspirant.codiPostal);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nif, nom, llinatges, adreca, codiPostal);
    }

    @ManyToOne
    @JoinColumn(name = "idLocalitat", referencedColumnName = "idLocalitat")
    public Localitat getLocalitat() {
        return localitat;
    }

    public void setLocalitat(Localitat localitat) {
        this.localitat = localitat;
    }

    @OneToMany(mappedBy = "aspirant")
    public Collection<Preferencia> getPreferencies() {
        return preferencies;
    }

    public void setPreferencies(Collection<Preferencia> preferencies) {
        this.preferencies = preferencies;
    }

    @Override
    public String toString() {
        return "Aspirant{" +
                "nif='" + nif + '\'' +
                ", nom='" + nom + '\'' +
                ", llinatges='" + llinatges + '\'' +
                ", adreca='" + adreca + '\'' +
                ", codiPostal='" + codiPostal + '\'' +
                ", localitat=" + localitat +
                '}';
    }
}
