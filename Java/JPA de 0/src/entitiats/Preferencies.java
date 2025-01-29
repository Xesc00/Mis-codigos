/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entitiats;

import java.io.Serializable;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

/**
 *
 * @author Xesc
 */
@Entity
@Table(name = "preferencies", catalog = "interins", schema = "")
@NamedQueries({
    @NamedQuery(name = "Preferencies.findAll", query = "SELECT p FROM Preferencies p")})
public class Preferencies implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected PreferenciesPK preferenciesPK;
    @JoinColumn(name = "nif", referencedColumnName = "Nif", nullable = false, insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Aspirants aspirants;
    @JoinColumn(name = "idCentre", referencedColumnName = "idCentre", nullable = false)
    @ManyToOne(optional = false)
    private Centres idCentre;
    @JoinColumns({
        @JoinColumn(name = "idCos", referencedColumnName = "idCos", nullable = false),
        @JoinColumn(name = "idEspecialitat", referencedColumnName = "idEspecialitat", nullable = false)})
    @ManyToOne(optional = false)
    private Especialitats especialitats;

    public Preferencies() {
    }

    public Preferencies(PreferenciesPK preferenciesPK) {
        this.preferenciesPK = preferenciesPK;
    }

    public Preferencies(String nif, int ordre) {
        this.preferenciesPK = new PreferenciesPK(nif, ordre);
    }

    public PreferenciesPK getPreferenciesPK() {
        return preferenciesPK;
    }

    public void setPreferenciesPK(PreferenciesPK preferenciesPK) {
        this.preferenciesPK = preferenciesPK;
    }

    public Aspirants getAspirants() {
        return aspirants;
    }

    public void setAspirants(Aspirants aspirants) {
        this.aspirants = aspirants;
    }

    public Centres getIdCentre() {
        return idCentre;
    }

    public void setIdCentre(Centres idCentre) {
        this.idCentre = idCentre;
    }

    public Especialitats getEspecialitats() {
        return especialitats;
    }

    public void setEspecialitats(Especialitats especialitats) {
        this.especialitats = especialitats;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (preferenciesPK != null ? preferenciesPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Preferencies)) {
            return false;
        }
        Preferencies other = (Preferencies) object;
        if ((this.preferenciesPK == null && other.preferenciesPK != null) || (this.preferenciesPK != null && !this.preferenciesPK.equals(other.preferenciesPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entitiats.Preferencies[ preferenciesPK=" + preferenciesPK + " ]";
    }
    
}
