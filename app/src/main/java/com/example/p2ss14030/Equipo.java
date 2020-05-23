package com.example.p2ss14030;

public class Equipo {
    private String codequipo;
    private String nomequipo;
    private int escapitalino;
    private  int jugadoreslocales;
    private int jugadoresextran;


    public Equipo() {
    }

    public Equipo(String codequipo, String nomequipo, int escapitalino, int jugadoreslocales, int jugadoresextran) {
        this.codequipo = codequipo;
        this.nomequipo = nomequipo;
        this.escapitalino = escapitalino;
        this.jugadoreslocales = jugadoreslocales;
        this.jugadoresextran = jugadoresextran;
    }

    public String getCodequipo() {
        return codequipo;
    }

    public void setCodequipo(String codequipo) {
        this.codequipo = codequipo;
    }

    public String getNomequipo() {
        return nomequipo;
    }

    public void setNomequipo(String nomequipo) {
        this.nomequipo = nomequipo;
    }

    public int getEscapitalino() {
        return escapitalino;
    }

    public void setEscapitalino(int escapitalino) {
        this.escapitalino = escapitalino;
    }

    public int getJugadoreslocales() {
        return jugadoreslocales;
    }

    public void setJugadoreslocales(int jugadoreslocales) {
        this.jugadoreslocales = jugadoreslocales;
    }

    public int getJugadoresextran() {
        return jugadoresextran;
    }

    public void setJugadoresextran(int jugadoresextran) {
        this.jugadoresextran = jugadoresextran;
    }
}
