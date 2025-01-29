package model;

import javax.persistence.Column;
import javax.persistence.Id;
import java.io.Serializable;
import java.util.Objects;

public class EspecialitatPK implements Serializable {
    private String idCos;
    private String idEspecialitat;

    public EspecialitatPK(String idCos, String idEspecialitat) {
        this.idCos = idCos;
        this.idEspecialitat = idEspecialitat;
    }

    public EspecialitatPK() {
        this.idCos = null;
        this.idEspecialitat = null;
    }

    @Column(name = "idCos", nullable = false, length = 4)
    @Id
    public String getIdCos() {
        return idCos;
    }

    public void setIdCos(String idCos) {
        this.idCos = idCos;
    }

    @Column(name = "idEspecialitat", nullable = false, length = 3)
    @Id
    public String getIdEspecialitat() {
        return idEspecialitat;
    }

    public void setIdEspecialitat(String idEspecialitat) {
        this.idEspecialitat = idEspecialitat;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        EspecialitatPK that = (EspecialitatPK) o;
        return Objects.equals(idCos, that.idCos) &&
                Objects.equals(idEspecialitat, that.idEspecialitat);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idCos, idEspecialitat);
    }
}
