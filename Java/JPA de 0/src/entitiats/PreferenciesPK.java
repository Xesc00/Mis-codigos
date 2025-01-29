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
public class PreferenciesPK implements Serializable {

    @Basic(optional = false)
    @Column(name = "nif", nullable = false, length = 9)
    private String nif;
    @Basic(optional = false)
    @Column(name = "ordre", nullable = false)
    private int ordre;

    public PreferenciesPK() {
    }

    public PreferenciesPK(String nif, int ordre) {
        this.nif = nif;
        this.ordre = ordre;
    }

    public String getNif() {
        return nif;
    }

    public void setNif(String nif) {
        this.nif = nif;
    }

    public int getOrdre() {
        return ordre;
    }

    public void setOrdre(int ordre) {
        this.ordre = ordre;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (nif != null ? nif.hashCode() : 0);
        hash += (int) ordre;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PreferenciesPK)) {
            return false;
        }
        PreferenciesPK other = (PreferenciesPK) object;
        if ((this.nif == null && other.nif != null) || (this.nif != null && !this.nif.equals(other.nif))) {
            return false;
        }
        if (this.ordre != other.ordre) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entitiats.PreferenciesPK[ nif=" + nif + ", ordre=" + ordre + " ]";
    }
    
}
