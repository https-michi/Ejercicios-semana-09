/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ejerciciosSemana09.ejercicio03;

import com.ejerciciosSemana09.ejercicio03.Puesto;
import java.util.Date;
import java.util.List;

/**
 *
 * @author snowden
 */
public class Personal {

    private String apellido;
    private String nombre;
    private String dni;
    private Date fechaNacimiento;
    private Puesto puesto;

    private List<Personal> aCargo;

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public Date getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(Date fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public Puesto getPuesto() {
        return puesto;
    }

    public void setPuesto(Puesto puesto) {
        this.puesto = puesto;
    }

    public List<Personal> getaCargo() {
        return aCargo;
    }

    public void setaCargo(List<Personal> aCargo) {
        this.aCargo = aCargo;
    }

    public void atenderPedido(Pedido pedido) {
        System.out.println("El personal " + nombre + " " + apellido + " esta atendiendo el pedido del cliente.");
    }

    @Override
    public String toString() {
        return nombre + " " + apellido + " (" + puesto.getDescripcion() + ")";
    }

}
