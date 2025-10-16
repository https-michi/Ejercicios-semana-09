/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ejerciciosSemana09.ejercicio03;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author snowden
 */
public class DatosEstaticos {

    public static final List<Producto> PRODUCTOS = new ArrayList<>();
    public static final List<Cliente> CLIENTES = new ArrayList<>();
    public static final List<Personal> PERSONAL = new ArrayList<>();

    static {
        Categoria electronics = new Categoria();
        electronics.setTipo("Electronics");

        Categoria home = new Categoria();
        home.setTipo("Home");

        Categoria kitchen = new Categoria();
        kitchen.setTipo("Kitchen");

        Categoria gaming = new Categoria();
        gaming.setTipo("Gaming");

        PRODUCTOS.add(new Producto("Smart TV 55\"", 2100.0, "Available", electronics, null));
        PRODUCTOS.add(new Producto("Laptop Pro 16\"", 4500.0, "Available", electronics, null));
        PRODUCTOS.add(new Producto("Wireless Headphones", 320.0, "Available", electronics, null));
        PRODUCTOS.add(new Producto("Bluetooth Speaker", 250.0, "Available", electronics, null));
        PRODUCTOS.add(new Producto("Smartphone X15", 2800.0, "Available", electronics, null));
        PRODUCTOS.add(new Producto("Gaming Console Z", 3800.0, "Available", gaming, null));
        PRODUCTOS.add(new Producto("Mechanical Keyboard", 520.0, "Available", gaming, null));
        PRODUCTOS.add(new Producto("RGB Gaming Mouse", 190.0, "Available", gaming, null));
        PRODUCTOS.add(new Producto("Air Fryer", 750.0, "Available", kitchen, null));
        PRODUCTOS.add(new Producto("Microwave Oven", 640.0, "Available", kitchen, null));
        PRODUCTOS.add(new Producto("Coffee Maker", 390.0, "Available", kitchen, null));
        PRODUCTOS.add(new Producto("Blender MaxMix 500", 350.0, "Available", kitchen, null));
        PRODUCTOS.add(new Producto("Iron SteamPro", 220.0, "Available", home, null));
        PRODUCTOS.add(new Producto("Vacuum Cleaner 3000", 560.0, "Available", home, null));
        PRODUCTOS.add(new Producto("Air Conditioner 12000 BTU", 2600.0, "Available", home, null));
        PRODUCTOS.add(new Producto("Ceiling Lamp Set", 180.0, "Available", home, null));

        ClienteNatural c1 = new ClienteNatural();
        c1.setNombres("John");
        c1.setApellidos("Miller");
        c1.setDni("101010101");
        c1.setEmail("john.miller@email.com");
        CLIENTES.add(c1);

        ClienteNatural c2 = new ClienteNatural();
        c2.setNombres("Emily");
        c2.setApellidos("Clark");
        c2.setDni("202020202");
        c2.setEmail("emily.clark@email.com");
        CLIENTES.add(c2);

        ClienteNatural c3 = new ClienteNatural();
        c3.setNombres("Michael");
        c3.setApellidos("Anderson");
        c3.setDni("303030303");
        c3.setEmail("michael.anderson@email.com");
        CLIENTES.add(c3);

        ClienteNatural c4 = new ClienteNatural();
        c4.setNombres("Sophia");
        c4.setApellidos("Johnson");
        c4.setDni("404040404");
        c4.setEmail("sophia.johnson@email.com");
        CLIENTES.add(c4);

        ClienteNatural c5 = new ClienteNatural();
        c5.setNombres("David");
        c5.setApellidos("Brown");
        c5.setDni("505050505");
        c5.setEmail("david.brown@email.com");
        CLIENTES.add(c5);

        Puesto seller = new Puesto();
        seller.setDescripcion("Sales Representative");
        seller.setSueldo(2500);

        Puesto manager = new Puesto();
        manager.setDescripcion("Store Manager");
        manager.setSueldo(3800);

        Puesto assistant = new Puesto();
        assistant.setDescripcion("Assistant");
        assistant.setSueldo(2200);

        Personal p1 = new Personal();
        p1.setNombre("Jessica");
        p1.setApellido("Smith");
        p1.setPuesto(seller);
        PERSONAL.add(p1);

        Personal p2 = new Personal();
        p2.setNombre("Andrew");
        p2.setApellido("Cooper");
        p2.setPuesto(manager);
        PERSONAL.add(p2);

        Personal p3 = new Personal();
        p3.setNombre("Laura");
        p3.setApellido("Scott");
        p3.setPuesto(seller);
        PERSONAL.add(p3);

        Personal p4 = new Personal();
        p4.setNombre("William");
        p4.setApellido("Turner");
        p4.setPuesto(assistant);
        PERSONAL.add(p4);

        Personal p5 = new Personal();
        p5.setNombre("Natalie");
        p5.setApellido("Evans");
        p5.setPuesto(seller);
        PERSONAL.add(p5);
    }
}
