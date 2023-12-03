/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.practica02_ordonezkellyj;

import java.util.Date;

public class Prestamo {

    private Libro libro;
    private Usuario usuario;
    private Date fechaPrestamo;
    private Date fechaDevolucion;

    public Prestamo(Libro libro, Usuario usuario) {
        this.libro = libro;
        this.usuario = usuario;
        this.fechaPrestamo = new Date();
        this.fechaDevolucion = null;
    }

    public Libro getLibro() {
        return this.libro;
    }

    public void setLibro(Libro libro) {
        this.libro = libro;
    }

    public Usuario getUsuario() {
        return this.usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public Date getFechaPrestamo() {
        return this.fechaPrestamo;
    }

    public void setFechaPrestamo(Date fechaPrestamo) {
        this.fechaPrestamo = fechaPrestamo;
    }

    public Date getFechaDevolucion() {
        return this.fechaDevolucion;
    }

    public void setFechaDevolucion(Date fechaDevolucion) {
        this.fechaDevolucion = fechaDevolucion;
    }

    public int calcularDiasPrestamo() {
        return (int) ((this.fechaDevolucion.getTime() - this.fechaPrestamo.getTime()) / (1000 * 60 * 60 * 24));
    }

    public boolean esPrestamoVigente() {
        return this.fechaDevolucion == null;
    }

    @Override
    public String toString() {
        return "Prestamo{"
                + "libro=" + libro
                + ", usuario=" + usuario
                + ", fechaPrestamo=" + fechaPrestamo
                + ", fechaDevolucion=" + fechaDevolucion
                + '}';
    }
}
