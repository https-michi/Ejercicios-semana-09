/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ejerciciosSemana09.ejercicio03;

import java.util.Date;
import java.util.List;

/**
 *
 * @author snowden
 */
public class Pedido {

    private Date fecha;
    private boolean estado;
    private Cliente cliente;
    private Personal atendidoPor;
    private List<PedidoDetalle> detalles;

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public boolean isEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Personal getAtendidoPor() {
        return atendidoPor;
    }

    public void setAtendidoPor(Personal atendidoPor) {
        this.atendidoPor = atendidoPor;
    }

    public List<PedidoDetalle> getDetalles() {
        return detalles;
    }

    public void setDetalles(List<PedidoDetalle> detalles) {
        this.detalles = detalles;
    }

    public void agregarProducto(Producto producto, int cantidad, double importe) {
        PedidoDetalle detalle = new PedidoDetalle(this, producto, cantidad, importe);
        detalles.add(detalle);
        System.out.println("Producto agregado: " + producto.getCategoria().getTipo()
                + " | Cantidad: " + cantidad
                + " | Importe: " + importe);
    }

    public double calcularTotal() {
        double total = 0;
        for (PedidoDetalle d : detalles) {
            total += d.calcularSubtotal();
        }
        System.out.println("Total calculado del pedido: S/ " + total);
        return total;
    }

}
