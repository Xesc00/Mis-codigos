package cat.paucasesnovescifp.spaad.model;

import javax.persistence.*;
import java.util.Collection;
import java.util.Objects;

@Entity
@Table(name = "Illes", schema = "interins")
public class Illa {
    private String idIlla;
    private String nomIlla;
    private Collection<Localitat> localitats;

    public Illa() {
    }

        
    public Illa(String idIlla, String nomIlla) {
        this.idIlla = idIlla;
        this.nomIlla = nomIlla;
    }
    
    @Id
    @Column(name = "idIlla", nullable = false, length = 3)
    public String getIdIlla() {
        return idIlla;
    }

    public void setIdIlla(String idIlla) {
        this.idIlla = idIlla;
    }

    @Basic
    @Column(name = "nomIlla", nullable = false, length = 45)
    public String getNomIlla() {
        return nomIlla;
    }

    public void setNomIlla(String nomIlla) {
        this.nomIlla = nomIlla;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Illa illa = (Illa) o;
        return Objects.equals(idIlla, illa.idIlla) &&
                Objects.equals(nomIlla, illa.nomIlla);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idIlla, nomIlla);
    }

    @OneToMany(mappedBy = "illa")
    public Collection<Localitat> getLocalitats() {
        return localitats;
    }

    public void setLocalitats(Collection<Localitat> localitats) {
        this.localitats = localitats;
    }

    @Override
    public String toString() {
        return "Illa{" +
                "idIlla='" + idIlla + '\'' +
                ", nomIlla='" + nomIlla + '\'' +
                '}';
    }
}
