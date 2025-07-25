package main;

import utilitarios.Utils;

public class CodigoCuartoDos {
  public static void main(String[] args) {
    Utils.limpiarConsola();

    // Variables de juego
    double tiempo = 15;
    int nivelActual = 2;
    int intentosCaja = 5;
    int codigoCaja = 0;
    boolean camaraFalsa = false, escritorio = false, colchon = false, cajaFuerte = false, sabeCodigoCaja = false;
    boolean puertaMetalica = false, botellaAgua = false, rasgaduraColchon = false;
    boolean pared = false, pizarra = false, lamparaEncendida = true;
    String informeMedico = "", notaMojada = "", codigoParcial = "";

    System.out.println("Te despiertas en un cuarto oscuro...");
    System.out.println("Tienes 10 minutos para escapar antes de que el gas tóxico te mate.");
    Utils.limpiarConsola();

    while (tiempo > 0 && !puertaMetalica) {
      System.out.println("\nNivel " + nivelActual + " | Tiempo restante: " + tiempo + " minutos");
      System.out.println("¿Qué quieres examinar?");
      System.out.println("1. Cámara");
      System.out.println("2. Escritorio");
      System.out.println("3. Colchón");
      System.out.println("4. Pared");
      System.out.println("5. Botella de Agua");
      System.out.println("6. Caja Fuerte");
      System.out.println("7. Pizarra");
      System.out.println("0. Esperar");

      int opcion = Utils.leerEntero("Elige una opción (0-7):");
        Utils.limpiarConsola();

      switch (opcion) {
        case 1:
          if (!camaraFalsa) {
            System.out.println("Examinas la cámara. Está rota. Detrás hay una flecha al escritorio y la letra 'O'.");
            camaraFalsa = true;
            codigoParcial += "O";
          } else {
            System.out.println("Ya examinaste la cámara.");
          }
          tiempo -= 0.5;
          break;
        
        case 2:
          if (!escritorio) {
            System.out.println("Encuentras un folder, una caja fuerte, una llave, una lámpara vieja y una botella de agua.");
            escritorio = true;
            informeMedico = "Paciente #W3792 Fecha: 12/04";
            System.out.println("El folder contiene: " + informeMedico);
          } else {
            System.out.println("Ya examinaste el escritorio.");
          }
          tiempo -= 0.5;
          break;

        case 3:
          if (!colchon) {
            System.out.println("Examinas el colchón. Parece rasgado. Hay una nota, pero no puedes leerla sin luz.");
            colchon = true;
          } else {
            System.out.println("Ya examinaste el colchón.");
          }

          if (!rasgaduraColchon && lamparaEncendida) {
            System.out.println("Con la luz de la lámpara ves una línea: 'Busca lo que está roto'. Encuentras la letra 'E'.");
            rasgaduraColchon = true;
            codigoParcial += "E";
          }
          tiempo -= 0.5;
          break;

        case 4:
          if (!pared) {
            System.out.println("Encuentras una grieta con una anotación: 'El agua revela la verdad y te regalo una (R)'.");
            pared = true;
            codigoParcial += "R";
          } else {
            System.out.println("Ya examinaste la pared.");
          }
          tiempo -= 0.5;
          break;

        case 5:
          if (!botellaAgua) {
            System.out.println("Tomas la botella de agua. Contiene una nota mojada que dice '29 - P'.");
            botellaAgua = true;
            notaMojada = "29P";
            codigoParcial += "P";
            System.out.println("Nota mojada encontrada: " + notaMojada);
          } else {
            System.out.println("Ya revisaste la botella de agua.");
          }
          tiempo -= 0.5;
          break;

        case 6:
          if (!cajaFuerte) {
            boolean cajaAbierta = false;
            do {
                sabeCodigoCaja = Utils.leerBoolean("¿Sabes el código de la caja fuerte? (4 dígitos)");
                
              if (sabeCodigoCaja == true) {
                codigoCaja = Utils.leerEntero("Escribe el código de la caja fuerte (4 dígitos):");
                if (codigoCaja == 2973) {
                  System.out.println("¡Felicidades! Has abierto la caja fuerte.");
                  cajaAbierta = true;
                } else {
                  intentosCaja--;
                  System.out.println("Código incorrecto. Te quedan " + intentosCaja + " intentos.");
                }                
              } else {
                System.out.println("Código incorrecto.");
               }
                 
            } while (intentosCaja > 0 && !cajaAbierta && !sabeCodigoCaja);{
              }
            

            if (!puertaMetalica && intentosCaja == 0) {
              System.out.println("Se agotaron los intentos. La caja fuerte permanece cerrada.");
            }

            cajaFuerte = true;
          } else {
            System.out.println("Ya intentaste abrir la caja fuerte.");
          }
          tiempo -= 0.5;
          break;

        case 7:
          if (!pizarra) {
            System.out.println("Encuentras una pizarra con el código '2973 (bigc)'.");
            pizarra = true;
          } else {
            System.out.println("Ya examinaste la pizarra.");
          }
          tiempo -= 0.5;
          break;

        case 0:
          System.out.println("Decides esperar un momento. El tiempo pasa.");
          tiempo -= 0.5;
          break;

        default:
          System.out.println("Opción no válida. Intenta nuevamente.");
          break;
      }
    }
    Utils.limpiarConsola();
    System.out.println();
    if (puertaMetalica) {
      System.out.println("Oh! Oh! De la caja fuerte sale un gas que te hace sentir mareado y te desmayas.");
      System.out.println("Código recolectado: " + codigoParcial);
    } else {
      System.out.println("Tiempo agotado! Game Over! El Bizcocho te ha atrapado! Entró el gas mortífero y te aniquiló.");
    }
  }
}