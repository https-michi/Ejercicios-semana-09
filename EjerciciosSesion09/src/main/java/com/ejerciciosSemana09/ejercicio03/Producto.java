/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ejerciciosSemana09.ejercicio03;

import java.util.List;

/**
 *
 * @author snowden
 */
public class Producto {

    private String nombre;
    private double precio;
    private String estado;
    private Categoria categoria;
    private List<PedidoDetalle> detalles;

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }

    public Producto() {
    }

    public Producto(String nombre, double precio, String estado, Categoria categoria, List<PedidoDetalle> detalles) {
        this.nombre = nombre;
        this.precio = precio;
        this.estado = estado;
        this.categoria = categoria;
        this.detalles = detalles;
    }

    public void aplicarDescuento() {
        System.out.println("Se ha aplicado un descuento al producto de la categoria "
                + (categoria != null ? categoria.getTipo() : "sin categoria"));
    }

}
