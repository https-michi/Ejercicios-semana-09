/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ejerciciosSemana09.ejercicio03;

/**
 *
 * @author snowden
 */
public class ClienteJuridico extends Cliente {

    private String ruc;
    private String razonSocial;
    private String fax;
    private String contacto;

    public String getRuc() {
        return ruc;
    }

    public void setRuc(String ruc) {
        this.ruc = ruc;
    }

    public String getRazonSocial() {
        return razonSocial;
    }

    public void setRazonSocial(String razonSocial) {
        this.razonSocial = razonSocial;
    }

    public String getFax() {
        return fax;
    }

    public void setFax(String fax) {
        this.fax = fax;
    }

    public String getContacto() {
        return contacto;
    }

    public void setContacto(String contacto) {
        this.contacto = contacto;
    }

    @Override
    public void realizarPedido() {
        System.out.println("El cliente juridico " + razonSocial + " con RUC " + ruc + " ha realizado un pedido.");
    }

    @Override
    public String toString() {
        return ruc;
    }

}
