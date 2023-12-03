/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.practica02_ordonezkellyj;


import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;

public class Usuario extends Persona {

    private String correo;
    private final List<Prestamo> listaPrestamos;

    public Usuario(String nombre, String identificacion, String correo) {
        super(nombre, identificacion);
        this.correo = correo;
        this.listaPrestamos = new ArrayList<>();
    }

    public String getCorreo() {
        return this.correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public List<Prestamo> getListaPrestamos() {
        return Collections.unmodifiableList(new ArrayList<>(this.listaPrestamos));
    }

    public void agregarPrestamo(Prestamo prestamo) {
        this.listaPrestamos.add(prestamo);
    }

    public void solicitarPrestamo(Libro libro) {
        Prestamo prestamo = new Prestamo(libro, this);
        this.listaPrestamos.add(prestamo);
        libro.prestar();
    }

    public void devolverLibro(Libro libro) {
        for (Prestamo prestamo : this.listaPrestamos) {
            if (prestamo.getLibro().equals(libro) && prestamo.esPrestamoVigente()) {
                prestamo.getLibro().devolver();
                prestamo.setFechaDevolucion(new Date());
            }
        }
    }

    @Override
    public void mostrarInformacion() {
        System.out.println("Nombre: " + this.getNombre());
        System.out.println("Identificación: " + this.getIdentificacion());
        System.out.println("Correo: " + this.getCorreo());
        System.out.println("Préstamos:");
        for (Prestamo prestamo : this.listaPrestamos) {
            System.out.println("Libro: " + prestamo.getLibro().getTitulo());
            System.out.println("Fecha préstamo: " + prestamo.getFechaPrestamo());
            System.out.println("Fecha devolución: " + prestamo.getFechaDevolucion());
        }
    }
}
