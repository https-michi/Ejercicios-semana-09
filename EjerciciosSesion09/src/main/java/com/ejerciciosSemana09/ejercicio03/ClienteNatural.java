/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ejerciciosSemana09.ejercicio03;

/**
 *
 * @author snowden
 */
import java.util.Date;

public class ClienteNatural extends Cliente {

    private String apellidos;
    private String nombres;
    private Date fechaNac;
    private String dni;
    private String sexo;

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public Date getFechaNac() {
        return fechaNac;
    }

    public void setFechaNac(Date fechaNac) {
        this.fechaNac = fechaNac;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    @Override
    public void realizarPedido() {
        System.out.println("El cliente natural " + nombres + " " + apellidos + " ha realizado un pedido.");
    }

    @Override
    public String toString() {
        return nombres + " " + apellidos;
    }

}
