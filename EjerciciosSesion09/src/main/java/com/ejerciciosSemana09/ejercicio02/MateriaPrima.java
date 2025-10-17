/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ejerciciosSemana09.ejercicio02;

/**
 *
 * @author COREI5 8VA
 */
public class MateriaPrima {

    private int idMateriaPrima;
    private String nombre;

    public MateriaPrima(int idMateriaPrima, String nombre) {
        this.idMateriaPrima = idMateriaPrima;
        this.nombre = nombre;
    }

    public int getIdMateriaPrima() {
        return idMateriaPrima;
    }

    public void setIdMateriaPrima(int idMateriaPrima) {
        this.idMateriaPrima = idMateriaPrima;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @Override
    public String toString() {
        return nombre + " (ID: " + idMateriaPrima + ")";
    }
}
