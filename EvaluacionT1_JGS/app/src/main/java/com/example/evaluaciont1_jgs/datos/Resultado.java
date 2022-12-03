package com.example.evaluaciont1_jgs.datos;

import java.io.Serializable;

public class Resultado {

    private String fecha;
    private String fase;
    private String equipo1;
    private String equipo2;
    private int goles1;
    private int goles2;

    public Resultado(String fecha, String fase, String equipo1, String equipo2, int goles1, int goles2){

       this.fecha = fecha;
       this.fase = fase;
       this.equipo1 = equipo1;
       this.equipo2 = equipo2;
       this.goles1 = goles1;
       this.goles2 = goles2;
    }


}
