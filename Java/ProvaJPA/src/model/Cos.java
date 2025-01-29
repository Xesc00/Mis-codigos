package model;

import javax.persistence.*;
import java.util.Collection;
import java.util.Objects;

@Entity
@Table(name = "Cossos", schema = "interins")
public class Cos {
    private String idCos;
    private String descripcio;
    private Collection<Especialitat> especialitats;

    @Id
    @Column(name = "idCos", nullable = false, length = 4)
    public String getIdCos() {
        return idCos;
    }

    public void setIdCos(String idCos) {
        this.idCos = idCos;
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
        Cos cos = (Cos) o;
        return Objects.equals(idCos, cos.idCos) &&
                Objects.equals(descripcio, cos.descripcio);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idCos, descripcio);
    }

    @OneToMany(mappedBy = "cos")
    public Collection<Especialitat> getEspecialitats() {
        return especialitats;
    }

    public void setEspecialitats(Collection<Especialitat> especialitats) {
        this.especialitats = especialitats;
    }

    @Override
    public String toString() {
        return "Cos{" +
                "idCos='" + idCos + '\'' +
                ", descripcio='" + descripcio + '\'' +
                '}';
    }
}
