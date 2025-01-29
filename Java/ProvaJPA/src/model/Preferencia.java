package model;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "Preferencies", schema = "interins")
@IdClass(PreferenciaPK.class)
public class Preferencia {
    private String nif;
    private int ordre;
    private Aspirant aspirant;
    private Especialitat especialitat;
    private Centre centre;

    @Id
    @Column(name = "nif", nullable = false, length = 9)
    public String getNif() {
        return nif;
    }

    public void setNif(String nif) {
        this.nif = nif;
    }

    @Id
    @Column(name = "ordre", nullable = false)
    public int getOrdre() {
        return ordre;
    }

    public void setOrdre(int ordre) {
        this.ordre = ordre;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Preferencia that = (Preferencia) o;
        return ordre == that.ordre &&
                Objects.equals(nif, that.nif);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nif, ordre);
    }

    @ManyToOne
    @JoinColumn(name = "nif", referencedColumnName = "Nif", nullable = false, insertable = false, updatable = false)
    public Aspirant getAspirant() {
        return aspirant;
    }

    public void setAspirant(Aspirant aspirant) {
        this.aspirant = aspirant;
    }

    @ManyToOne
    @JoinColumns({@JoinColumn(name = "idCos", referencedColumnName = "idCos", nullable = false), @JoinColumn(name = "idEspecialitat", referencedColumnName = "idEspecialitat", nullable = false)})
    public Especialitat getEspecialitat() {
        return especialitat;
    }

    public void setEspecialitat(Especialitat especialitat) {
        this.especialitat = especialitat;
    }

    @ManyToOne
    @JoinColumn(name = "idCentre", referencedColumnName = "idCentre", nullable = false)
    public Centre getCentre() {
        return centre;
    }

    public void setCentre(Centre centre) {
        this.centre = centre;
    }

    @Override
    public String toString() {
        return "Preferencia{" +
                "nif='" + nif + '\'' +
                ", ordre=" + ordre +
                ", aspirant=" + aspirant +
                ", especialitat=" + especialitat +
                ", centre=" + centre +
                '}';
    }
}
