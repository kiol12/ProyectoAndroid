package com.example.evaluaciont1_jgs.datos;

import java.io.Serializable;

public class Resultado {

    private String fecha;
    private String fase;
    private String equipo1;
    private String equipo2;
    private int goles1;
    private int goles2;

    public Resultado(String fecha, String fase, String equipo1, int goles1 ,String equipo2, int goles2){

       this.fecha = fecha;
       this.fase = fase;
       this.equipo1 = equipo1;
       this.equipo2 = equipo2;
       this.goles1 = goles1;
       this.goles2 = goles2;
    }

    public String getFecha() {
        return fecha;
    }

    public String getFase() {
        return fase;
    }

    public String getEquipo1() {
        return equipo1;
    }

    public String getEquipo2() {
        return equipo2;
    }

    public int getGoles1() {
        return goles1;
    }

    public int getGoles2() {
        return goles2;
    }
}
