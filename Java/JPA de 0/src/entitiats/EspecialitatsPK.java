/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entitiats;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 *
 * @author Xesc
 */
@Embeddable
public class EspecialitatsPK implements Serializable {

    @Basic(optional = false)
    @Column(name = "idCos", nullable = false, length = 4)
    private String idCos;
    @Basic(optional = false)
    @Column(name = "idEspecialitat", nullable = false, length = 3)
    private String idEspecialitat;

    public EspecialitatsPK() {
    }

    public EspecialitatsPK(String idCos, String idEspecialitat) {
        this.idCos = idCos;
        this.idEspecialitat = idEspecialitat;
    }

    public String getIdCos() {
        return idCos;
    }

    public void setIdCos(String idCos) {
        this.idCos = idCos;
    }

    public String getIdEspecialitat() {
        return idEspecialitat;
    }

    public void setIdEspecialitat(String idEspecialitat) {
        this.idEspecialitat = idEspecialitat;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idCos != null ? idCos.hashCode() : 0);
        hash += (idEspecialitat != null ? idEspecialitat.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof EspecialitatsPK)) {
            return false;
        }
        EspecialitatsPK other = (EspecialitatsPK) object;
        if ((this.idCos == null && other.idCos != null) || (this.idCos != null && !this.idCos.equals(other.idCos))) {
            return false;
        }
        if ((this.idEspecialitat == null && other.idEspecialitat != null) || (this.idEspecialitat != null && !this.idEspecialitat.equals(other.idEspecialitat))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entitiats.EspecialitatsPK[ idCos=" + idCos + ", idEspecialitat=" + idEspecialitat + " ]";
    }
    
}
