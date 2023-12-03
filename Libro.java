/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.practica02_ordonezkellyj;


public class Libro implements Prestable {

    private String titulo;
    private String autor;
    private int año;
    private boolean disponible;
    private Usuario usuario;

    public Libro(String titulo, String autor, int año) {
        this.titulo = titulo;
        this.autor = autor;
        this.año = año;
        this.disponible = true;
    }

    public String getTitulo() {
        return this.titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getAutor() {
        return this.autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public int getAño() {
        return this.año;
    }

    public void setAño(int año) {
        this.año = año;
    }

    public boolean isDisponible() {
        return this.disponible;
    }

    public void setDisponible(boolean disponible) {
        this.disponible = disponible;
    }

    @Override
    public void prestar() {
        this.disponible = false;
    }

    @Override
    public void devolver() {
        this.disponible = true;
    }

    @Override
    public String toString() {
        return "Libro{"
                + "titulo='" + titulo
                + ", autor='" + autor
                + ", año=" + año
                + ", disponible=" + disponible
                + ", usuario=" + usuario
                + '}';
    }
}
