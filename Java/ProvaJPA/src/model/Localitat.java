package model;

import javax.persistence.*;
import java.util.Collection;
import java.util.Objects;

@Entity
@Table(name = "Localitats", schema = "interins")
public class Localitat {
    private String idLocalitat;
    private String nomLocalitat;
    private Collection<Aspirant> aspirants;
    private Collection<Centre> centres;
    private Illa illa;

    @Id
    @Column(name = "idLocalitat", nullable = false, length = 9)
    public String getIdLocalitat() {
        return idLocalitat;
    }

    public void setIdLocalitat(String idLocalitat) {
        this.idLocalitat = idLocalitat;
    }

    @Basic
    @Column(name = "nomLocalitat", nullable = false, length = 100)
    public String getNomLocalitat() {
        return nomLocalitat;
    }

    public void setNomLocalitat(String nomLocalitat) {
        this.nomLocalitat = nomLocalitat;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Localitat localitat = (Localitat) o;
        return Objects.equals(idLocalitat, localitat.idLocalitat) &&
                Objects.equals(nomLocalitat, localitat.nomLocalitat);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idLocalitat, nomLocalitat);
    }

    @OneToMany(mappedBy = "localitat")
    public Collection<Aspirant> getAspirants() {
        return aspirants;
    }

    public void setAspirants(Collection<Aspirant> aspirants) {
        this.aspirants = aspirants;
    }

    @OneToMany(mappedBy = "localitat")
    public Collection<Centre> getCentres() {
        return centres;
    }

    public void setCentres(Collection<Centre> centres) {
        this.centres = centres;
    }

    @ManyToOne
    @JoinColumn(name = "idIlla", referencedColumnName = "idIlla", nullable = false)
    public Illa getIlla() {
        return illa;
    }

    public void setIlla(Illa fkIlla) {
        this.illa = fkIlla;
    }

    @Override
    public String toString() {
        return "Localitat{" +
                "idLocalitat='" + idLocalitat + '\'' +
                ", nomLocalitat='" + nomLocalitat + '\'' +
                ", illa=" + illa +
                '}';
    }
}
