/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ejerciciosSemana09.ejercicio02;

/**
 *
 * @author COREI5 8VA
 */
public class Producto {

    private int idProducto;
    private String nombre;
    private int cantidadFabricada;
    private double costoFabricacion;

    public Producto(int idProducto, String nombre, int cantidadFabricada, double costoFabricacion) {
        this.idProducto = idProducto;
        this.nombre = nombre;
        this.cantidadFabricada = cantidadFabricada;
        this.costoFabricacion = costoFabricacion;
    }

    public int getIdProducto() {
        return idProducto;
    }

    public void setIdProducto(int idProducto) {
        this.idProducto = idProducto;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getCantidadFabricada() {
        return cantidadFabricada;
    }

    public void setCantidadFabricada(int cantidadFabricada) {
        this.cantidadFabricada = cantidadFabricada;
    }

    public double getCostoFabricacion() {
        return costoFabricacion;
    }

    public void setCostoFabricacion(double costoFabricacion) {
        this.costoFabricacion = costoFabricacion;
    }

    @Override
    public String toString() {
        return nombre + " (ID: " + idProducto + ")";
    }
}
