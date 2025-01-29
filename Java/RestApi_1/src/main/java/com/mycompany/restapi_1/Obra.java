package com.mycompany.restapi_1;

import java.io.Serializable;

public class Obra implements Serializable{
    private int ID_OBRA;
    private String TITOL;
    private String ANY;
    private String MODALITAT;
    private String AUTOR;

    public Obra(int ID_OBRA, String TITOL, String ANY, String MODALITAT, String AUTOR) {
        this.ID_OBRA = ID_OBRA;
        this.TITOL = TITOL;
        this.ANY = ANY;
        this.MODALITAT = MODALITAT;
        this.AUTOR = AUTOR;
    }

    public Obra() {
        super();
    }
        
    public int getID_OBRA() {
        return ID_OBRA;
    }

    public void setID_OBRA(int ID_OBRA) {
        this.ID_OBRA = ID_OBRA;
    }

    public String getTITOL() {
        return TITOL;
    }

    public void setTITOL(String TITOL) {
        this.TITOL = TITOL;
    }

    public String getANY() {
        return ANY;
    }

    public void setANY(String ANY) {
        this.ANY = ANY;
    }

    public String getMODALITAT() {
        return MODALITAT;
    }

    public void setMODALITAT(String MODALITAT) {
        this.MODALITAT = MODALITAT;
    }

    public String getAUTOR() {
        return AUTOR;
    }

    public void setAUTOR(String AUTOR) {
        this.AUTOR = AUTOR;
    }
}
