package main;

import utilitarios.Utils;

public class CodigoCuartoUno {
  public static void main(String[] args) {
    // Limpiar consola
    Utils.limpiarConsola();

    // Definicion de Variables
    int numeroSeleccion = 0, codigoCorrecto = 0000, numeroSeleccionEscritorio = 0;
    double tiempo = 15;
    boolean codigoCajaBoolean = false, loopEscritorio = false, camaraFalsa = false, cajaFuerte = false, llave = false,
        informeMedico = false, puertaMetalica = false;

    // Inicio del Juego Cuarto Uno
    while (tiempo > 0 && codigoCorrecto != 2973) {
      System.out.println(
          "Te despiertas en la cama. No sabes por qué estás aquí, ni cómo llegaste, solo tienes un leve dolor de cabeza.");
      System.out.println("Al caer en razón, identificas que estás en un cuarto. Ves los siguientes objetos:");
      System.out.println("Sobre el escritorio hay varios objetos.");
      System.out.println("Encima de la puerta, ves un reloj que dice " + tiempo
          + " min y cada acción que tomes te tomará 0.5 min en realizar.¡Si consumes los 15 min un gas mortífero te aniquilará! Suerte en tu travesía");

      for (; tiempo > 0 && codigoCorrecto != 2973; tiempo--) {
        System.out.println("Estos son los elementos que puedes revisar:");
        System.out.println("1. Puerta Metalica");
        System.out.println("2. Camara");
        System.out.println("3. Escritorio");

        numeroSeleccion = Utils.leerEntero("¿A qué objeto te quieres dirigir? (escribe el número).");

        // Validacion y seleccion de Elementos Habitacion
        switch (numeroSeleccion) {
          case 1:
            if (numeroSeleccion == 1) {
              if (puertaMetalica == false) {
                System.out.println(
                    "La puerta está cerrada con un código de 7 cifras. Debes encontrar las pistas para tu sorpresa especial y poder salir de este Escape Room.");
                puertaMetalica = true;
                tiempo = tiempo - 0.5;
                System.out.println("Te quedan " + tiempo + " minutos.");
              } else {
                System.out.println("La puerta sigue cerrada, necesitas el código correcto para abrirla.");
                tiempo = tiempo - 0.5;
              }
            }
            break;
          case 2:
            if (numeroSeleccion == 2) {
              if (camaraFalsa == false) {
                System.out.println(
                    "No funciona esta cámara, pero detrás de ella hay una marca en la pared es una flecha dentro de un círculo en forma de O y parece que apunta hacia el escritorio.");
                camaraFalsa = true;
                tiempo = tiempo - 0.5;
                System.out.println("Te quedan " + tiempo + " minutos.");
              } else {
                System.out.println("Ya revisaste la cámara, no hay nada más que hacer aquí.");
                tiempo = tiempo - 0.5;
              }
            }
            break;
          case 3:
            do {

              System.out.println("Estos son los elementos que puedes revisar en el escritorio:");
              System.out.println("1. Informe Médico");
              System.out.println("2. Llave");
              System.out.println("3. Caja Fuerte");

              numeroSeleccionEscritorio = Utils.leerEntero("¿A qué objeto te quieres dirigir? (escribe el número).");

              switch (numeroSeleccionEscritorio) {
                case 1:
                  if (numeroSeleccionEscritorio == 1) {
                    if (informeMedico == false) {
                      System.out.println(
                          "El informe médico dice: 'Paciente con amnesia temporal. Necesita encontrar pistas para recordar su identidad y salir del cuarto'.");
                      System.out.println("El informe médico incluye el número de paciente resaltado el cual es #W3792");
                      informeMedico = true;
                      tiempo = tiempo - 0.5;
                      System.out.println("Te quedan " + tiempo + " minutos.");
                      loopEscritorio = Utils.leerBoolean("¿Quieres seguir revisando el escritorio? (true/false)");

                    } else {
                      System.out.println("Ya revisaste el informe médico, no hay nada más que hacer aquí.");
                      loopEscritorio = Utils.leerBoolean("¿Quieres seguir revisando el escritorio? (true/false)");
                      tiempo = tiempo - 0.5;
                    }
                  }
                  break;
                case 2:
                  if (numeroSeleccionEscritorio == 2) {
                    if (llave == false) {
                      System.out.println("Encontraste la Llave, debajo de ella hay una nota con la letra H.");
                      llave = true;
                      tiempo = tiempo - 0.5;
                      System.out.println("Te quedan " + tiempo + " minutos.");
                      loopEscritorio = Utils.leerBoolean("¿Quieres seguir revisando el escritorio? (true/false)");
                    } else {
                      System.out.println("Ya revisaste la llave, no hay nada más que hacer aquí.");
                      loopEscritorio = Utils.leerBoolean("¿Quieres seguir revisando el escritorio? (true/false)");
                      tiempo = tiempo - 0.5;
                    }
                  }
                  break;
                case 3:
                  if (numeroSeleccionEscritorio == 3) {
                    if (cajaFuerte == false) {
                      System.out.println(
                          "Esta es una caja fuerte debajo del escritorio, está cerrada y necesita un código de 4 números para poder abrirla. Busca la llave para abrirla.");
                      cajaFuerte = true;
                      tiempo = tiempo - 0.5;
                      System.out.println("Te quedan " + tiempo + " minutos.");
                      loopEscritorio = Utils.leerBoolean("¿Quieres seguir revisando el escritorio? (true/false)");

                      if (loopEscritorio == false) {
                        codigoCajaBoolean = Utils.leerBoolean("Sabes cual es el codigo de la caja fuerte? (4 dígitos)");
                        if (codigoCajaBoolean == true) {
                          codigoCorrecto = Utils.leerEntero("Escribe el código de la caja fuerte (4 dígitos).");
                        } else {
                          System.out.println("No sabes el código de la caja fuerte, sigue buscando pistas.");
                          loopEscritorio = Utils.leerBoolean("¿Quieres seguir revisando el escritorio? (true/false)");
                          tiempo = tiempo - 0.5;
                        }
                      }
                    } else {
                      System.out.println("Ya revisaste la caja fuerte, no hay nada más que hacer aquí.");
                      tiempo = tiempo - 0.5;
                      loopEscritorio = Utils.leerBoolean("¿Quieres seguir revisando el escritorio? (true/false)");
                    }
                  }
                  break;

                default:
                  System.out.println("Opción no válida. Por favor, elige un número entre 1 y 3.");
                  loopEscritorio = Utils.leerBoolean("¿Quieres seguir revisando el escritorio? (true/false)");
                  break;
              }
            } while (loopEscritorio == true);

            break;
          default:
            System.out.println("Opción no válida. Por favor, elige un número entre 1 y 3.");
            break;
        }
      }
      if (tiempo == 0) {
        System.out
            .println("Tiempo agotado! Game Over! El Bizcocho te ha atrapado! Entró el gas mortífero y te aniquiló.");
      } else {
        System.out.println("Oh! Oh! De la caja fuerte sale un gas que te hace sentir mareado y te desmayas.");
      }
    }
  }
}