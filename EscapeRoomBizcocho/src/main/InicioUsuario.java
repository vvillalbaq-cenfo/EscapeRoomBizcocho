package main;

import utilitarios.Utils;

public class InicioUsuario {
    public static void main(String[] args) {
        // Limpiar la consola
        Utils.limpiarConsola();

        // Entrada de Bienvenida
        System.out.println("Bienvenido al Escape Room Bizcocho");
        System.out.println("Por favor, ingresa tu nombre de usuario:");
        String nombreUsuario = Utils.leerString(""); // Solicita el nombre
        

        // Validar entrada Y Salida de Bienvenida
        if (nombreUsuario == null || nombreUsuario.isEmpty()) {
            System.out.println("El nombre de usuario no puede estar vacío. Por favor, intenta de nuevo.");
        } else { 
            System.out.println("¡Hola " + nombreUsuario + "! Estas preparado para lograr escpar del Bizcocho?");
            //boolean inicioPrograma = true;
        }
      
        
    }
}