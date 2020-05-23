package com.example.p2ss14030;

public class Jugador {

    private String codequipo;
    private String codpais;
    private String codjugador;
    private  int edadingreso;
    private String esExtranjero;

    public Jugador() {
    }

    public Jugador(String codequipo, String codpais, String codjugador, int edadingreso, String esExtranjero) {
        this.codequipo = codequipo;
        this.codpais = codpais;
        this.codjugador = codjugador;
        this.edadingreso = edadingreso;
        this.esExtranjero = esExtranjero;
    }

    public String getCodequipo() {
        return codequipo;
    }

    public void setCodequipo(String codequipo) {
        this.codequipo = codequipo;
    }

    public String getCodpais() {
        return codpais;
    }

    public void setCodpais(String codpais) {
        this.codpais = codpais;
    }

    public String getCodjugador() {
        return codjugador;
    }

    public void setCodjugador(String codjugador) {
        this.codjugador = codjugador;
    }

    public int getEdadingreso() {
        return edadingreso;
    }

    public void setEdadingreso(int edadingreso) {
        this.edadingreso = edadingreso;
    }

    public String getEsExtranjero() {
        return esExtranjero;
    }

    public void setEsExtranjero(String esExtranjero) {
        this.esExtranjero = esExtranjero;
    }
}
