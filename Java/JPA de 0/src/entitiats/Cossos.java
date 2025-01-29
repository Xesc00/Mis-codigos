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
@Table(name = "cossos", catalog = "interins", schema = "")
@NamedQueries({
    @NamedQuery(name = "Cossos.findAll", query = "SELECT c FROM Cossos c")})
public class Cossos implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "idCos", nullable = false, length = 4)
    private String idCos;
    @Basic(optional = false)
    @Column(name = "descripcio", nullable = false, length = 100)
    private String descripcio;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "cossos")
    private List<Especialitats> especialitatsList;

    public Cossos() {
    }

    public Cossos(String idCos) {
        this.idCos = idCos;
    }

    public Cossos(String idCos, String descripcio) {
        this.idCos = idCos;
        this.descripcio = descripcio;
    }

    public String getIdCos() {
        return idCos;
    }

    public void setIdCos(String idCos) {
        this.idCos = idCos;
    }

    public String getDescripcio() {
        return descripcio;
    }

    public void setDescripcio(String descripcio) {
        this.descripcio = descripcio;
    }

    public List<Especialitats> getEspecialitatsList() {
        return especialitatsList;
    }

    public void setEspecialitatsList(List<Especialitats> especialitatsList) {
        this.especialitatsList = especialitatsList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idCos != null ? idCos.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Cossos)) {
            return false;
        }
        Cossos other = (Cossos) object;
        if ((this.idCos == null && other.idCos != null) || (this.idCos != null && !this.idCos.equals(other.idCos))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entitiats.Cossos[ idCos=" + idCos + " ]";
    }
    
}
