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
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 *
 * @author Xesc
 */
@Entity
@Table(name = "illes", catalog = "interins", schema = "")
@NamedQueries({
    @NamedQuery(name = "Illes.findAll", query = "SELECT i FROM Illes i")})
public class Illes implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "idIlla", nullable = false, length = 3)
    private String idIlla;
    @Basic(optional = false)
    @Column(name = "nomIlla", nullable = false, length = 45)
    private String nomIlla;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idIlla")
    private List<Localitats> localitatsList;

    public Illes() {
    }

    public Illes(String idIlla) {
        this.idIlla = idIlla;
    }

    public Illes(String idIlla, String nomIlla) {
        this.idIlla = idIlla;
        this.nomIlla = nomIlla;
    }

    public String getIdIlla() {
        return idIlla;
    }

    public void setIdIlla(String idIlla) {
        this.idIlla = idIlla;
    }

    public String getNomIlla() {
        return nomIlla;
    }

    public void setNomIlla(String nomIlla) {
        this.nomIlla = nomIlla;
    }

    public List<Localitats> getLocalitatsList() {
        return localitatsList;
    }

    public void setLocalitatsList(List<Localitats> localitatsList) {
        this.localitatsList = localitatsList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idIlla != null ? idIlla.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Illes)) {
            return false;
        }
        Illes other = (Illes) object;
        if ((this.idIlla == null && other.idIlla != null) || (this.idIlla != null && !this.idIlla.equals(other.idIlla))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entitiats.Illes[ idIlla=" + idIlla + " ]";
    }
    
}
