/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entitiats;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 *
 * @author Xesc
 */
@Entity
@Table(name = "especialitats", catalog = "interins", schema = "")
@NamedQueries({
    @NamedQuery(name = "Especialitats.findAll", query = "SELECT e FROM Especialitats e")})
public class Especialitats implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected EspecialitatsPK especialitatsPK;
    @Basic(optional = false)
    @Column(name = "descripcio", nullable = false, length = 100)
    private String descripcio;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "especialitats")
    private List<Preferencies> preferenciesList;
    @JoinColumn(name = "idCos", referencedColumnName = "idCos", nullable = false, insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Cossos cossos;

    public Especialitats() {
    }

    public Especialitats(EspecialitatsPK especialitatsPK) {
        this.especialitatsPK = especialitatsPK;
    }

    public Especialitats(EspecialitatsPK especialitatsPK, String descripcio) {
        this.especialitatsPK = especialitatsPK;
        this.descripcio = descripcio;
    }

    public Especialitats(String idCos, String idEspecialitat) {
        this.especialitatsPK = new EspecialitatsPK(idCos, idEspecialitat);
    }

    public EspecialitatsPK getEspecialitatsPK() {
        return especialitatsPK;
    }

    public void setEspecialitatsPK(EspecialitatsPK especialitatsPK) {
        this.especialitatsPK = especialitatsPK;
    }

    public String getDescripcio() {
        return descripcio;
    }

    public void setDescripcio(String descripcio) {
        this.descripcio = descripcio;
    }

    public List<Preferencies> getPreferenciesList() {
        return preferenciesList;
    }

    public void setPreferenciesList(List<Preferencies> preferenciesList) {
        this.preferenciesList = preferenciesList;
    }

    public Cossos getCossos() {
        return cossos;
    }

    public void setCossos(Cossos cossos) {
        this.cossos = cossos;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (especialitatsPK != null ? especialitatsPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Especialitats)) {
            return false;
        }
        Especialitats other = (Especialitats) object;
        if ((this.especialitatsPK == null && other.especialitatsPK != null) || (this.especialitatsPK != null && !this.especialitatsPK.equals(other.especialitatsPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entitiats.Especialitats[ especialitatsPK=" + especialitatsPK + " ]";
    }
    
}
