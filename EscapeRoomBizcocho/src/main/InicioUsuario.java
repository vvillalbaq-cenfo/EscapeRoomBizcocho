package main;

import utilitarios.utils;

public class InicioUsuario {
    public static void main(String[] args) {
        // Limpiar la consola
        utils.limpiarConsola();

        // variables
        String nombreUsuario = utils.leerTexto();
        boolean inicioJuego = false;
        // Entrada de usuario
        System.out.println("Bienvenido al Escape Room Bizcocho");
        System.out.println("Por favor, ingresa tu nombre de usuario:");

        // Validar entrada Y Salida de Bienvenida 
        if (nombreUsuario.isEmpty()) {
            System.out.println("El nombre de usuario no puede estar vacío. Por favor, intenta de nuevo.");
        } else {
            System.out.println("¡Hola " + nombreUsuario + "! Estas preparado para lograr escpar del Bizcocho?");
            inicioJuego = true;
        }
      
    }
}