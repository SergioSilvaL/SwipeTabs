package com.tecnologiassilva.swipetabs.Recycler;

/**
 * Created by Sergio on 8/5/2016.
 */

public class Maestro {


    Maestro(){}

    private String Maestro_Nombre;
    private String Maestro_Carrera;
    private int Maestro_foto;
    private float Maestro_rating;

    public Maestro(String maestro_Nombre, String maestro_Carrera,int maestro_foto, float maestro_rating) {
        Maestro_Nombre = maestro_Nombre;
        Maestro_Carrera=maestro_Carrera;
        Maestro_foto = maestro_foto;
        Maestro_rating = maestro_rating;
    }

    public float getMaestro_rating() {
        return Maestro_rating;
    }

    public void setMaestro_rating(float maestro_rating) {
        Maestro_rating = maestro_rating;
    }

    public String getMaestro_Carrera() {
        return Maestro_Carrera;
    }

    public void setMaestro_Carrera(String maestro_Carrera) {
        Maestro_Carrera = maestro_Carrera;
    }

    public String getMaestro_Nombre() {
        return Maestro_Nombre;
    }

    public void setMaestro_Nombre(String maestro_Nombre) {
        Maestro_Nombre = maestro_Nombre;
    }

    public int getMaestro_foto() {
        return Maestro_foto;
    }

    public void setMaestro_foto(int maestro_foto) {
        Maestro_foto = maestro_foto;
    }
}
