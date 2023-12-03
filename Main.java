/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.practica02_ordonezkellyj;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Biblioteca biblioteca = new Biblioteca("Biblioteca Central", "Avenida 54");
        Scanner scanner = new Scanner(System.in);
        int opcion;

        do {
            System.out.println("Bienvenido al Sistema de Gestión de Biblioteca");
            System.out.println("1. Agregar Libro");
            System.out.println("2. Registrar Usuario");
            System.out.println("3. Buscar Libro");
            System.out.println("4. Llevar Libro");
            System.out.println("5. Devolver Libro");
            System.out.println("6. Salir");
            System.out.print("Ingrese una opción: ");
            opcion = scanner.nextInt();
            scanner.nextLine();

            switch (opcion) {
                case 1 ->
                    agregarLibro(biblioteca, scanner);
                case 2 ->
                    registrarUsuario(biblioteca, scanner);
                case 3 ->
                    buscarLibro(biblioteca, scanner);
                case 4 ->
                    prestarLibro(biblioteca, scanner);
                case 5 ->
                    devolverLibro(biblioteca, scanner);
                case 6 ->
                    System.out.println("Se ha salido del programa con exito.");
                default ->
                    System.out.println("Opción no válida. Por favor intente de nuevo.");
            }
        } while (opcion != 6);

        scanner.close();
    }

    private static void agregarLibro(Biblioteca biblioteca, Scanner scanner) {
        System.out.print("Ingrese el título del libro: ");
        String titulo = scanner.nextLine();
        System.out.print("Ingrese el autor del libro: ");
        String autor = scanner.nextLine();
        System.out.print("Ingrese el año de publicación del libro: ");
        int año = scanner.nextInt();
        scanner.nextLine();

        Libro libro = new Libro(titulo, autor, año);
        biblioteca.agregarLibro(libro);
        System.out.println("Libro agregado con éxito.");
    }

    private static void registrarUsuario(Biblioteca biblioteca, Scanner scanner) {
        System.out.print("Ingrese el nombre del usuario: ");
        String nombre = scanner.nextLine();
        System.out.print("Ingrese la identificación del usuario: ");
        String identificacion = scanner.nextLine();
        System.out.print("Ingrese el correo del usuario: ");
        String correo = scanner.nextLine();

        Usuario usuario = new Usuario(nombre, identificacion, correo);
        biblioteca.registrarUsuario(usuario);
        System.out.println("Usuario registrado con éxito.");
    }

    private static void buscarLibro(Biblioteca biblioteca, Scanner scanner) {
        System.out.print("Ingrese el título del libro a buscar: ");
        String titulo = scanner.nextLine();
        Libro libroEncontrado = biblioteca.buscarLibro(titulo);

        if (libroEncontrado != null) {
            System.out.println("Libro encontrado:");
            System.out.println(libroEncontrado);
        } else {
            System.out.println("Libro no encontrado.");
        }
    }

    private static void prestarLibro(Biblioteca biblioteca, Scanner scanner) {
        System.out.print("Ingrese el título del libro a prestar: ");
        String tituloLibro = scanner.nextLine();
        Libro libro = biblioteca.buscarLibro(tituloLibro);

        if (libro != null) {
            System.out.print("Ingrese la identificación del usuario que solicita el préstamo: ");
            String identificacionUsuario = scanner.nextLine();
            Usuario usuario = null;

            for (Usuario u : biblioteca.getListaUsuarios()) {
                if (u.getIdentificacion().equals(identificacionUsuario)) {
                    usuario = u;
                    break;
                }
            }

            if (usuario != null) {
                biblioteca.prestarLibro(libro, usuario);
                System.out.println("Préstamo realizado con éxito.");
            } else {
                System.out.println("Usuario no encontrado.");
            }
        } else {
            System.out.println("Libro no encontrado.");
        }
    }

    private static void devolverLibro(Biblioteca biblioteca, Scanner scanner) {
        System.out.print("Ingrese el título del libro a devolver: ");
        String tituloLibro = scanner.nextLine();
        Libro libro = biblioteca.buscarLibro(tituloLibro);

        if (libro != null) {
            System.out.print("Ingrese la identificación del usuario que devuelve el libro: ");
            String identificacionUsuario = scanner.nextLine();
            Usuario usuario = null;

            for (Usuario u : biblioteca.getListaUsuarios()) {
                if (u.getIdentificacion().equals(identificacionUsuario)) {
                    usuario = u;
                    break;
                }
            }

            if (usuario != null) {
                biblioteca.devolverLibro(libro, usuario);
                System.out.println("Devolución realizada con éxito.");
            } else {
                System.out.println("Usuario no encontrado.");
            }
        } else {
            System.out.println("Libro no encontrado.");
        }
    }
}
