package cat.paucasesnovescifp.spaad.model;

import javax.persistence.*;
import java.util.Collection;
import java.util.Objects;

@Entity
@Table(name = "Centres", schema = "interins")
public class Centre {
    private String idCentre;
    private String nomCentre;
    private Localitat localitat;
    private Collection<Preferencia> preferencies;

    public Centre() {
    }

    
    public Centre(String idCentre, String nomCentre, Localitat localitat) {
        this.idCentre = idCentre;
        this.nomCentre = nomCentre;
        this.localitat = localitat;
    }

    @Id
    @Column(name = "idCentre", nullable = false, length = 8)
    public String getIdCentre() {
        return idCentre;
    }

    public void setIdCentre(String idCentre) {
        this.idCentre = idCentre;
    }

    @Basic
    @Column(name = "nomCentre", nullable = false, length = 100)
    public String getNomCentre() {
        return nomCentre;
    }

    public void setNomCentre(String nomCentre) {
        this.nomCentre = nomCentre;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Centre centre = (Centre) o;
        return Objects.equals(idCentre, centre.idCentre) &&
                Objects.equals(nomCentre, centre.nomCentre);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idCentre, nomCentre);
    }

    @ManyToOne
    @JoinColumn(name = "idLocalitat", referencedColumnName = "idLocalitat", nullable = false)
    public Localitat getLocalitat() {
        return localitat;
    }

    public void setLocalitat(Localitat localitat) {
        this.localitat = localitat;
    }

    @OneToMany(mappedBy = "centre")
    public Collection<Preferencia> getPreferencies() {
        return preferencies;
    }

    public void setPreferencies(Collection<Preferencia> preferencies) {
        this.preferencies = preferencies;
    }

    @Override
    public String toString() {
        return "Centre{" +
                "idCentre='" + idCentre + '\'' +
                ", nomCentre='" + nomCentre + '\'' +
                ", localitat=" + localitat +
                '}';
    }


}
