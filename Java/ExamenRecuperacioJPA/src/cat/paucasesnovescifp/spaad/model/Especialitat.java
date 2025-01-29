package cat.paucasesnovescifp.spaad.model;

import javax.persistence.*;
import java.util.Collection;
import java.util.Objects;

@Entity
@Table(name = "Especialitats", schema = "interins")
@IdClass(EspecialitatPK.class)
public class Especialitat {
    private String idCos;
    private String idEspecialitat;
    private String descripcio;
    private Cos cos;
    private Collection<Preferencia> preferencies;

    @Id
    @Column(name = "idCos", nullable = false, length = 4, insertable = false, updatable = false)
    public String getIdCos() {
        return idCos;
    }

    public void setIdCos(String idCos) {
        this.idCos = idCos;
    }

    @Id
    @Column(name = "idEspecialitat", nullable = false, length = 3)
    public String getIdEspecialitat() {
        return idEspecialitat;
    }

    public void setIdEspecialitat(String idEspecialitat) {
        this.idEspecialitat = idEspecialitat;
    }

    @Basic
    @Column(name = "descripcio", nullable = false, length = 100)
    public String getDescripcio() {
        return descripcio;
    }

    public void setDescripcio(String descripcio) {
        this.descripcio = descripcio;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Especialitat that = (Especialitat) o;
        return Objects.equals(idCos, that.idCos) &&
                Objects.equals(idEspecialitat, that.idEspecialitat) &&
                Objects.equals(descripcio, that.descripcio);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idCos, idEspecialitat, descripcio);
    }

    @ManyToOne
    @JoinColumn(name = "idCos", referencedColumnName = "idCos", nullable = false, insertable = false, updatable = false)
    public Cos getCos() {
        return cos;
    }

    public void setCos(Cos cos) {
        this.cos = cos;
    }

    @OneToMany(mappedBy = "especialitat")
    public Collection<Preferencia> getPreferencies() {
        return preferencies;
    }

    public void setPreferencies(Collection<Preferencia> preferencies) {
        this.preferencies = preferencies;
    }

    @Override
    public String toString() {
        return "Especialitat{" +
                "idCos='" + idCos + '\'' +
                ", idEspecialitat='" + idEspecialitat + '\'' +
                ", descripcio='" + descripcio + '\'' +
                ", cos=" + cos +
                '}';
    }
}
