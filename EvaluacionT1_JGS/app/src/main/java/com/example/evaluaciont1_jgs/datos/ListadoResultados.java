package com.example.evaluaciont1_jgs.datos;

import java.util.ArrayList;

import javax.xml.transform.Result;


public class ListadoResultados{

    private final ArrayList<Resultado> resultados ;

    public ListadoResultados(){
        this.resultados =  new ArrayList<Resultado>();

        cargarLista();
    }

    public void cargarLista() {
        resultados.add(new Resultado("Fase de grupos", "20/11/2022 17:00", "Qatar", 0, "Ecuador", 2));
        resultados.add(new Resultado("Fase de grupos", "21/11/2022 14:00", "Inglaterra", 6, "Irán", 2));
        resultados.add(new Resultado("Fase de grupos", "21/11/2022 17:00", "Senegal", 0, "Países Bajos", 2));
        resultados.add(new Resultado("Fase de grupos", "21/11/2022 20:00", "Estados Unidos", 1, "Gales", 1));
        resultados.add(new Resultado("Fase de grupos", "22/11/2022 11:00", "Argentina", 1, "Arabia Saudí", 2));
        resultados.add(new Resultado("Fase de grupos", "22/11/2022 14:00", "Dinamarca", 0, "Túnez", 0));
        resultados.add(new Resultado("Fase de grupos", "22/11/2022 17:00", "México", 0, "Polonia", 0));
        resultados.add(new Resultado("Fase de grupos", "22/11/2022 20:00", "Francia", 4, "Australia", 1));
        resultados.add(new Resultado("Fase de grupos", "23/11/2022 11:00", "Marruecos", 0, "Croacia", 0));
        resultados.add(new Resultado("Fase de grupos", "23/11/2022 14:00", "Alemania", 1, "Japón", 2));
        resultados.add( new Resultado("Fase de grupos", "23/11/2022 17:00", "España", 7, "Costa Rica", 0));
        resultados.add(new Resultado("Fase de grupos", "23/11/2022 20:00", "Bélgica", 1, "Canadá", 0));
        resultados.add( new Resultado("Fase de grupos", "24/11/2022 11:00", "Suiza", 1, "Camerún", 0));
        resultados.add(new Resultado("Fase de grupos", "24/11/2022 14:00", "Uruguay", 0, "Corea del Sur", 0));
        resultados.add(new Resultado("Fase de grupos", "24/11/2022 17:00", "Portugal", 3, "Ghana", 2));
        resultados.add(new Resultado("Fase de grupos", "24/11/2022 20:00", "Brasil", 2, "Serbia", 0));
        resultados.add(new Resultado("Fase de grupos", "25/11/2022 11:00", "Gales", 0, "Irán", 2));
        resultados.add(new Resultado("Fase de grupos", "25/11/2022 14:00", "Qatar", 1, "Senegal", 3));
        resultados.add(new Resultado("Fase de grupos", "25/11/2022 17:00", "Países Bajos", 1, "Ecuador", 1));
        resultados.add(new Resultado("Fase de grupos", "25/11/2022 20:00", "Inglaterra", 0, "Estados Unidos", 0));
        resultados.add(new Resultado("Fase de grupos", "26/11/2022 11:00", "Túnez", 0, "Australia", 1));
        resultados.add(new Resultado("Fase de grupos", "26/11/2022 14:00", "Polonia", 2, "Arabia Saudí", 0));
        resultados.add(new Resultado("Fase de grupos", "26/11/2022 17:00", "Francia", 2, "Dinamarca", 1));
        resultados.add(new Resultado("Fase de grupos", "26/11/2022 20:00", "Argentina", 2, "México", 0));
        resultados.add(new Resultado("Fase de grupos", "27/11/2022 11:00", "Japón", 0, "Costa Rica", 1));
        resultados.add(new Resultado("Fase de grupos", "27/11/2022 14:00", "Bélgica", 0, "Marruecos", 2));
        resultados.add(new Resultado("Fase de grupos", "27/11/2022 17:00", "Croacia", 4, "Canadá", 1));
        resultados.add(new Resultado("Fase de grupos", "27/11/2022 20:00", "España", 1, "Alemania", 1));
        resultados.add(new Resultado("Fase de grupos", "28/11/2022 11:00", "Camerún", 3, "Serbia", 3));
        resultados.add(new Resultado("Fase de grupos", "28/11/2022 14:00", "Corea del Sur", 2, "Ghana", 3));
        resultados.add(new Resultado("Fase de grupos", "28/11/2022 17:00", "Brasil", 1, "Suiza", 0));
        resultados.add(new Resultado("Fase de grupos", "28/11/2022 20:00", "Portugal", 2, "Uruguay", 0));
    }


    public void addResultado(String fecha, String fase, String equipo1, String equipo2, int goles1, int goles2){
        resultados.add(new Resultado(fecha, fase, equipo1, goles1, equipo2, goles2));
    }

    public  ArrayList<Resultado> getLista() {
        return resultados;
    }

    public Resultado devolverPais(String pais){
        for(Resultado r: resultados){
            if (pais.equals(r.getEquipo1()) ||
                    pais.equals(r.getEquipo2()) ){
                return  r;
            }
        }
        return  null;
    }

}
