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
@Table(name = "aspirants", catalog = "interins", schema = "")
@NamedQueries({
    @NamedQuery(name = "Aspirants.findAll", query = "SELECT a FROM Aspirants a")})
public class Aspirants implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "Nif", nullable = false, length = 9)
    private String nif;
    @Basic(optional = false)
    @Column(name = "nom", nullable = false, length = 45)
    private String nom;
    @Basic(optional = false)
    @Column(name = "llinatges", nullable = false, length = 45)
    private String llinatges;
    @Column(name = "adreca", length = 100)
    private String adreca;
    @Column(name = "codiPostal", length = 5)
    private String codiPostal;
    @JoinColumn(name = "idLocalitat", referencedColumnName = "idLocalitat")
    @ManyToOne
    private Localitats idLocalitat;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "aspirants")
    private List<Preferencies> preferenciesList;

    public Aspirants() {
    }

    public Aspirants(String nif) {
        this.nif = nif;
    }

    public Aspirants(String nif, String nom, String llinatges) {
        this.nif = nif;
        this.nom = nom;
        this.llinatges = llinatges;
    }

    public String getNif() {
        return nif;
    }

    public void setNif(String nif) {
        this.nif = nif;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getLlinatges() {
        return llinatges;
    }

    public void setLlinatges(String llinatges) {
        this.llinatges = llinatges;
    }

    public String getAdreca() {
        return adreca;
    }

    public void setAdreca(String adreca) {
        this.adreca = adreca;
    }

    public String getCodiPostal() {
        return codiPostal;
    }

    public void setCodiPostal(String codiPostal) {
        this.codiPostal = codiPostal;
    }

    public Localitats getIdLocalitat() {
        return idLocalitat;
    }

    public void setIdLocalitat(Localitats idLocalitat) {
        this.idLocalitat = idLocalitat;
    }

    public List<Preferencies> getPreferenciesList() {
        return preferenciesList;
    }

    public void setPreferenciesList(List<Preferencies> preferenciesList) {
        this.preferenciesList = preferenciesList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (nif != null ? nif.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Aspirants)) {
            return false;
        }
        Aspirants other = (Aspirants) object;
        if ((this.nif == null && other.nif != null) || (this.nif != null && !this.nif.equals(other.nif))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entitiats.Aspirants[ nif=" + nif + " ]";
    }
    
}
