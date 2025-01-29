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
import javax.persistence.Entity;
import javax.persistence.Id;
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
@Table(name = "centres", catalog = "interins", schema = "")
@NamedQueries({
    @NamedQuery(name = "Centres.findAll", query = "SELECT c FROM Centres c")})
public class Centres implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "idCentre", nullable = false, length = 8)
    private String idCentre;
    @Basic(optional = false)
    @Column(name = "nomCentre", nullable = false, length = 100)
    private String nomCentre;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idCentre")
    private List<Preferencies> preferenciesList;
    @JoinColumn(name = "idLocalitat", referencedColumnName = "idLocalitat", nullable = false)
    @ManyToOne(optional = false)
    private Localitats idLocalitat;

    public Centres() {
    }

    public Centres(String idCentre) {
        this.idCentre = idCentre;
    }

    public Centres(String idCentre, String nomCentre) {
        this.idCentre = idCentre;
        this.nomCentre = nomCentre;
    }

    public String getIdCentre() {
        return idCentre;
    }

    public void setIdCentre(String idCentre) {
        this.idCentre = idCentre;
    }

    public String getNomCentre() {
        return nomCentre;
    }

    public void setNomCentre(String nomCentre) {
        this.nomCentre = nomCentre;
    }

    public List<Preferencies> getPreferenciesList() {
        return preferenciesList;
    }

    public void setPreferenciesList(List<Preferencies> preferenciesList) {
        this.preferenciesList = preferenciesList;
    }

    public Localitats getIdLocalitat() {
        return idLocalitat;
    }

    public void setIdLocalitat(Localitats idLocalitat) {
        this.idLocalitat = idLocalitat;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idCentre != null ? idCentre.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Centres)) {
            return false;
        }
        Centres other = (Centres) object;
        if ((this.idCentre == null && other.idCentre != null) || (this.idCentre != null && !this.idCentre.equals(other.idCentre))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entitiats.Centres[ idCentre=" + idCentre + " ]";
    }
    
}
