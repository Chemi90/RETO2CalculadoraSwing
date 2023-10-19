package org.example;


import org.example.ui.VentanaCalculadora;

/**
 * Clase con el punto de entrada principal para ejecutar la aplicación.
 *
 * @author Jose Miguel Ruiz Guevara, Alejandro Álvarez Mérida
 * @version 18/10/2023
 */
public class Main {
    public static void main(String[] args) {
        VentanaCalculadora ventanaCalculadora = new VentanaCalculadora();
        ventanaCalculadora.mostrar();
    }
}