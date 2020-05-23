package com.example.p2ss14030;

public class Pais {
    private String codpais;
    private String nommpais;
    private String esdeSudamerica;

    public Pais() {
    }

    public Pais(String codpais, String nommpais, String esdeSudamerica) {
        this.codpais = codpais;
        this.nommpais = nommpais;
        this.esdeSudamerica = esdeSudamerica;
    }

    public String getCodpais() {
        return codpais;
    }

    public void setCodpais(String codpais) {
        this.codpais = codpais;
    }

    public String getNommpais() {
        return nommpais;
    }

    public void setNommpais(String nommpais) {
        this.nommpais = nommpais;
    }

    public String getEsdeSudamerica() {
        return esdeSudamerica;
    }

    public void setEsdeSudamerica(String esdeSudamerica) {
        this.esdeSudamerica = esdeSudamerica;
    }
}
