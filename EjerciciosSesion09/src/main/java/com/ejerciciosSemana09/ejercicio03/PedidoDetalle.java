/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ejerciciosSemana09.ejercicio03;

/**
 *
 * @author snowden
 */
public class PedidoDetalle {

    private int cantidad;
    private double importe;
    private Pedido pedido;
    private Producto producto;

    public PedidoDetalle(Pedido pedido, Producto producto, int cantidad, double importe) {
        this.pedido = pedido;
        this.producto = producto;
        this.cantidad = cantidad;
        this.importe = importe;
    }

    public double calcularSubtotal() {
        return cantidad * importe;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public double getImporte() {
        return importe;
    }

    public void setImporte(double importe) {
        this.importe = importe;
    }

    public Pedido getPedido() {
        return pedido;
    }

    public void setPedido(Pedido pedido) {
        this.pedido = pedido;
    }

    public Producto getProducto() {
        return producto;
    }

    public void setProducto(Producto producto) {
        this.producto = producto;
    }
}
