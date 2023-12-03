/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.practica02_ordonezkellyj;


import java.util.ArrayList;

public class Biblioteca {

  private String nombre;
  private String direccion;
  private ArrayList<Libro> listaLibros;
  private ArrayList<Usuario> listaUsuarios;

  public Biblioteca(String nombre, String direccion) {
    this.nombre = nombre;
    this.direccion = direccion;
    this.listaLibros = new ArrayList<>();
    this.listaUsuarios = new ArrayList<>();
  }

  public void agregarLibro(Libro libro) {
    this.listaLibros.add(libro);
  }

  public void registrarUsuario(Usuario usuario) {
    this.listaUsuarios.add(usuario);
  }

  public Libro buscarLibro(String titulo) {
    for (Libro libro : this.listaLibros) {
      if (libro.getTitulo().equals(titulo)) {
        return libro;
      }
    }
    return null;
  }

  public void prestarLibro(Libro libro, Usuario usuario) {
    if (libro.isDisponible()) {
      Prestamo prestamo = new Prestamo(libro, usuario);
      usuario.agregarPrestamo(prestamo);
      libro.prestar();
      System.out.println("Préstamo realizado con éxito.");
    } else {
      System.out.println("El libro no está disponible.");
    }
  }

  @Override
  public String toString() {
    return "Biblioteca{"
        + "nombre='" + nombre
        + ", direccion='" + direccion
        + ", listaLibros=" + listaLibros
        + ", listaUsuarios=" + listaUsuarios
        + '}';
  }

  public ArrayList<Usuario> getListaUsuarios() {
    return this.listaUsuarios;
  }

    public void devolverLibro(Libro libro, Usuario usuario) {
        if (usuario.getListaPrestamos().contains(new Prestamo(libro, usuario))) {
            usuario.devolverLibro(libro);
            System.out.println("Libro devuelto con éxito.");
        }
    }
}
