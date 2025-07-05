package main;

import utilitarios.Utils;

public class CodigoCuartoUno {
  public static void main(String[] args) {
    // Limpiar consola
    Utils.limpiarConsola();

    // Definicion de Variables
    int tiempo = 0, numeroSeleccion = 0, codigoCorrecto = 0, numeroSeleccionEscritorio = 0;
    boolean codigoCajaBoolean = false, sistemaActivo = false;
    // Definir el sistema Activo en cada seleccion para cerrar el loop final 
    tiempo = 15;
    codigoCorrecto = 0000;

    // Inicio del Juego Cuarto Uno
    while (tiempo > 0 && codigoCorrecto != 2973) {
      System.out.println("Te despiertas en la cama. No sabes por qué estás aquí, ni cómo llegaste, solo tienes un leve dolor de cabeza.");
      System.out.println("Al caer en razón, identificas que estás en un cuarto. Ves los siguientes objetos:");
      System.out.println("Encima de la puerta, ves un reloj que dice 15 min y cada acción que tomes te tomará 1 min en realizar.¡Si consumes los 15 min un gas mortífero te aniquilará! Suerte en tu travesía");

      for (; tiempo > 0 && codigoCorrecto != 2973; tiempo--) {
        System.out.println("Estos son los elementos que puedes revisar:");
        System.out.println("1. Puerta Metalica");
        System.out.println("2. Camara");
        System.out.println("3. Escritorio");

        numeroSeleccion = Utils.leerEntero("¿A qué objeto te quieres dirigir? (escribe el número).");

        // Validacion y seleccion de Elementos Habitacion
        if (numeroSeleccion == 1) {
          System.out.println("La puerta está cerrada con un código de 7 cifras. Debes encontrar las pistas para tu sorpresa especial y poder salir de este Escape Room.");
          sistemaActivo = true;
        } 
        else if (numeroSeleccion == 2) {
          System.out.println("No funciona esta camara, pero dertras de ella hay una marca en la pared es una flecha dentro de un circulo en forma de O y parece que apunta hacia el escritorio.");
        } 
        else if (numeroSeleccion == 3) {
          System.out.println("En el escritorio hay varios objetos. Cual objeto quieres revisar primero?");
          System.out.println("1. Informe Medico");
          System.out.println("2. Llave");
          System.out.println("3. Caja Fuerte");

          numeroSeleccionEscritorio = Utils.leerEntero("Escribe el número del objeto que quieres revisar.");

          // Validacion y seleccion de Elementos Escritorio
          if (numeroSeleccionEscritorio == 1) {
            System.out.println("El informe médico dice: 'Paciente con amnesia temporal. Necesita encontrar pistas para recordar su identidad y salir del cuarto'.");
            System.out.println("El informe médico incluye el número de paciente resaltado el cual es #W3792");
          } 
          else if (numeroSeleccionEscritorio == 2) {
            System.out.println("Encontraste la Llave, debajo de ella hay una nota con la letra H.");
          } 
          else if (numeroSeleccionEscritorio == 3) {
            System.out.println("Esta es una caja fuerte debajo del escritorio, está cerrada y necesita un código de 4 números para poder abrirla. Busca la llave para abrirla.");
          } 
          else {
            System.out.println("El número ingresado no es válido. Por favor, ingresa un número entre 1 y 3.");
          }
        } 
        else {
          System.out.println("El número ingresado no es válido. Por favor, ingresa un número entre 1 y 3.");
        }
        if(sistemaActivo == true){

        }
      }

    }
  }
}