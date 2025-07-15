package main;

import utilitarios.Utils;

public class CodigoCuartoTres {
    public static void main(String[] args) {
        // Limpiar consola
        Utils.limpiarConsola();

        // Definicion de Variables
        int numeroSeleccion = 0, codigoCorrecto = 1111, numeroSeleccionEscritorio = 0;
        double tiempo = 15;
        boolean codigoCajaBoolean = false, loopEscritorio = false, silla = false, pizarra = false, fotoVieja = false,
                cajaFuerte = false, puertaMetalica = false;

        // Inicio del Juego Cuarto Uno
        System.out.println(
                "¡Hola Jugador! Bienvenido a nivel 03, el gas que te mando a dormir de nuevo. ¡Ahora debes buscar más pistas para salir de aquí!");
        System.out.println(
                "Los códigos decifrados del nivel 1 y nivel 2, los puedes ver en el menu de acertijos completos");
        System.out.println("Encima de la puerta, ves un reloj que dice " + tiempo
                + " min y cada acción que tomes te tomará 0.5 min en realizar.¡Si consumes los 15 min un gas mortífero te aniquilará! Suerte en tu travesía");
        Utils.limpiarConsola();

        // Inicio de Bucle principal
        while (tiempo > 0 && codigoCorrecto != 0000) {
            System.out.println("Estos son los elementos que puedes revisar:");
            System.out.printf("%-3s %-20s\n", "1.", "Puerta Metalica");
            System.out.printf("%-3s %-20s\n", "2.", "Silla");
            System.out.printf("%-3s %-20s\n", "3.", "Pizzarra");
            System.out.printf("%-3s %-20s\n", "4.", "Escritorio");

            numeroSeleccion = Utils.leerEntero("¿A qué objeto te quieres dirigir? (escribe el número).");
            Utils.limpiarConsola();
            // Validacion y seleccion de Elementos Habitacion
            switch (numeroSeleccion) {
                case 1:
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

                    break;
                case 2:
                    if (silla == false) {
                        System.out.println(
                                "Al inspeccionar esta silla, veo tallado en su respaldar lo siguiente: P-00");
                        silla = true;
                        tiempo = tiempo - 0.5;
                        System.out.println("Te quedan " + tiempo + " minutos.");
                    } else {
                        System.out.println("Ya revisaste la silla, no hay nada más que hacer aquí.");
                        tiempo = tiempo - 0.5;
                    }

                    break;
                case 3:
                    if (pizarra == false) {
                        System.out.println("Veo algo un poco borroso pero creo que está escrito un 00");
                        pizarra = true;
                        tiempo = tiempo - 0.5;
                        System.out.println("Te quedan " + tiempo + " minutos.");
                    } else {
                        System.out.println("Ya revisaste la pizarra, no hay nada más que hacer aquí.");
                        tiempo = tiempo - 0.5;
                    }

                    break;
                case 4:
                    do {

                        System.out.println("Estos son los elementos que puedes revisar en el escritorio:");
                        System.out.printf("%-3s %-20s\n", "1.", "Foto Vieja");
                        System.out.printf("%-3s %-20s\n", "2.", "Caja Fuerte");

                        numeroSeleccionEscritorio = Utils
                                .leerEntero("¿A qué objeto te quieres dirigir? (escribe el número).");
                        Utils.limpiarConsola();
                        switch (numeroSeleccionEscritorio) {
                            case 1:

                                if (fotoVieja == false) {
                                    System.out.println(
                                            "Le he dado vuelta a la foto vieja, dice lo siguiente: La respuesta está en la silla y la pizarra");
                                    fotoVieja = true;
                                    tiempo = tiempo - 0.5;
                                    System.out.println("Te quedan " + tiempo + " minutos.");
                                    loopEscritorio = Utils
                                            .leerBoolean("¿Quieres seguir revisando el escritorio? (true/false)");

                                } else {
                                    System.out
                                            .println("Ya revisaste la foto vieja, no hay nada más que hacer aquí.");
                                    loopEscritorio = Utils
                                            .leerBoolean("¿Quieres seguir revisando el escritorio? (true/false)");
                                    tiempo = tiempo - 0.5;
                                }

                                break;
                            case 2:
                                if (cajaFuerte == false) {
                                    System.out.println(
                                            "Solo veo que la caja cambió de nuevo la combinación y tiene esta nota encima");
                                    System.out.println("¿Sabes la clave de la puerta? Es una deliciosa opción");
                                    cajaFuerte = true;
                                    tiempo = tiempo - 0.5;
                                    System.out.println("Te quedan " + tiempo + " minutos.");
                                    loopEscritorio = Utils.leerBoolean("¿Quieres seguir revisando el escritorio? (true/false)");
                                    Utils.limpiarConsola();
                                    if (loopEscritorio == false) {
                                        codigoCajaBoolean = Utils.leerBoolean(
                                                "Sabes cual es el codigo de la caja fuerte? (4 dígitos)");
                                        if (codigoCajaBoolean == true) {
                                            codigoCorrecto = Utils
                                                    .leerEntero("Escribe el código de la caja fuerte (4 dígitos).");
                                        } else {
                                            System.out.println(
                                                    "No sabes el código de la caja fuerte, sigue buscando pistas.");
                                            loopEscritorio = Utils.leerBoolean(
                                                    "¿Quieres seguir revisando el escritorio? (true/false)");
                                            tiempo = tiempo - 0.5;
                                        }
                                    }
                                } else {
                                    System.out.println(
                                            "Ya revisaste la caja fuerte, no hay nada más que hacer aquí.");
                                    tiempo = tiempo - 0.5;
                                    loopEscritorio = Utils
                                            .leerBoolean("¿Quieres seguir revisando el escritorio? (true/false)");
                                }

                                break;

                            default:
                                System.out.println("Opción no válida. Por favor, elige un número entre 1 y 4.");
                                loopEscritorio = Utils
                                        .leerBoolean("¿Quieres seguir revisando el escritorio? (true/false)");
                                break;
                        }
                    } while (loopEscritorio == true);

                    break;
                default:
                    System.out.println("Opción no válida. Por favor, elige un número entre 1 y 4.");
                    break;
            }
        }
        if (tiempo <= 0) {
            System.out
                    .println(
                            "Tiempo agotado! Game Over! El Bizcocho te ha atrapado! Entró el gas mortífero y te aniquiló.");
        } else {
            System.out.println(
                    "¡Felicidades, haz salido del cuarto! ¡Bienvenido a BK! Toma tu corona y tu juego adicional");
        }

    }
}