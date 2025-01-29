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
@Table(name = "localitats", catalog = "interins", schema = "")
@NamedQueries({
    @NamedQuery(name = "Localitats.findAll", query = "SELECT l FROM Localitats l")})
public class Localitats implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "idLocalitat", nullable = false, length = 9)
    private String idLocalitat;
    @Basic(optional = false)
    @Column(name = "nomLocalitat", nullable = false, length = 100)
    private String nomLocalitat;
    @OneToMany(mappedBy = "idLocalitat")
    private List<Aspirants> aspirantsList;
    @JoinColumn(name = "idIlla", referencedColumnName = "idIlla", nullable = false)
    @ManyToOne(optional = false)
    private Illes idIlla;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idLocalitat")
    private List<Centres> centresList;

    public Localitats() {
    }

    public Localitats(String idLocalitat) {
        this.idLocalitat = idLocalitat;
    }

    public Localitats(String idLocalitat, String nomLocalitat) {
        this.idLocalitat = idLocalitat;
        this.nomLocalitat = nomLocalitat;
    }

    public String getIdLocalitat() {
        return idLocalitat;
    }

    public void setIdLocalitat(String idLocalitat) {
        this.idLocalitat = idLocalitat;
    }

    public String getNomLocalitat() {
        return nomLocalitat;
    }

    public void setNomLocalitat(String nomLocalitat) {
        this.nomLocalitat = nomLocalitat;
    }

    public List<Aspirants> getAspirantsList() {
        return aspirantsList;
    }

    public void setAspirantsList(List<Aspirants> aspirantsList) {
        this.aspirantsList = aspirantsList;
    }

    public Illes getIdIlla() {
        return idIlla;
    }

    public void setIdIlla(Illes idIlla) {
        this.idIlla = idIlla;
    }

    public List<Centres> getCentresList() {
        return centresList;
    }

    public void setCentresList(List<Centres> centresList) {
        this.centresList = centresList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idLocalitat != null ? idLocalitat.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Localitats)) {
            return false;
        }
        Localitats other = (Localitats) object;
        if ((this.idLocalitat == null && other.idLocalitat != null) || (this.idLocalitat != null && !this.idLocalitat.equals(other.idLocalitat))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entitiats.Localitats[ idLocalitat=" + idLocalitat + " ]";
    }
    
}
