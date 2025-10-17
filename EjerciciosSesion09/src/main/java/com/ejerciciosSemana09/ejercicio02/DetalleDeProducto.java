/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ejerciciosSemana09.ejercicio02;

/**
 *
 * @author COREI5 8VA
 */
public class DetalleDeProducto {

    private Producto producto;
    private MateriaPrima materiaPrima;
    private int cantidadUsada;

    public DetalleDeProducto(Producto producto, MateriaPrima materiaPrima, int cantidadUsada) {
        this.producto = producto;
        this.materiaPrima = materiaPrima;
        this.cantidadUsada = cantidadUsada;
    }

    public Producto getProducto() {
        return producto;
    }

    public void setProducto(Producto producto) {
        this.producto = producto;
    }

    public MateriaPrima getMateriaPrima() {
        return materiaPrima;
    }

    public void setMateriaPrima(MateriaPrima materiaPrima) {
        this.materiaPrima = materiaPrima;
    }

    public int getCantidadUsada() {
        return cantidadUsada;
    }

    public void setCantidadUsada(int cantidadUsada) {
        this.cantidadUsada = cantidadUsada;
    }

    @Override
    public String toString() {
        return "Producto: " + producto.getNombre()
                + ", Materia Prima: " + materiaPrima.getNombre()
                + ", Cantidad usada: " + cantidadUsada;
    }
}
