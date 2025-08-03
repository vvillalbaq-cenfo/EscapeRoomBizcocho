package main;
import utilitarios.Utils;

public class MainEscapeRoom {
    public static void main(String[] args) {
       
        String[] opcionesMenu = { "Crear Usuario", "Reglas del Juego", "Cuarto Rojo", "Cuarto Verde", "Cuarto Amarillo", "Cuarto Azul", "Cuarto Magenta", "Cuarto Cian", "Cuarto Final"};
        String opcion = "";
        String nombreUsuario = "";
        int opcionSeleccionada;
        int n;
        boolean finalDelJuego = false, validacionNombreUsuario = false;

        do {
            Utils.limpiarConsola();
            opcionSeleccionada = Utils.seleccionarElementoTexto("MENU", opcionesMenu) - 1;
            opcion = opcionesMenu[opcionSeleccionada];
            System.out.println("Usted escogio la opción " + opcion);

            switch (opcion) {
                case "Crear Usuario":
                    if (validacionNombreUsuario == false) {
                    nombreUsuario = Utils.leerString("Ingrese su nombre de usuario:");
                    System.out.println("Usuario " + nombreUsuario + " creado exitosamente.");
                    Utils.pausar();
                    validacionNombreUsuario = true;
                    Utils.limpiarConsola();

                        
                    } else {
                    System.out.println("Ya existe un usuario creado: " + nombreUsuario);
                    System.out.println("Si desea cambiar el nombre de usuario, por favor reinicie el juego.");
                    Utils.pausar();
                    Utils.limpiarConsola();
                        
                    } 
                    break;
                case "Reglas del Juego":
                if (validacionNombreUsuario == true) {
                    System.out.println("Este es un juego de escape room donde debes resolver acertijos y encontrar pistas para escapar de diferentes cuartos.");
                    System.out.println("Cada cuarto tiene sus propios desafíos y debes completar todos para ganar el juego. Cada cuarto tiene un tiempo límite de 10 minutos.");
                    System.out.println("Debes encontrar las llaves o códigos necesarios para avanzar al siguiente cuarto.");
                    System.out.println("Recuerda que el tiempo es limitado y cada acción que tomes consumirá tiempo.");
                    System.out.println("Debes estar atento a las pistas que encuentres en cada cuarto. Para abrir las cajas fuertes y conseguir los códigos para abrir la puerta final.");
                    System.out.println("Además, debes de revisar como minimo un cuarto, un objeto y tener minumo una pista resuelta para poder salir del hotel.");
                    System.out.println("Si consumes los 10 minutos, un gas mortífero te aniquilará. Recuerda que tienes un máximo de 3 vidas por cuarto. Si superas este límite, perderás el juego.");
                    System.out.println("¡Buena suerte, " + nombreUsuario + "!");
                    Utils.pausar();
                    Utils.limpiarConsola();
                } else {
                    System.out.println("Debes crear un usuario primero para poder ver las reglas del juego.");
                    System.out.println("Por favor, regresa al menú principal y crea un usuario.");
                    Utils.pausar();
                    Utils.limpiarConsola();
                }

                    break;
                case "Cuarto Rojo":
                    
                    break;
                case "Cuarto Verde":

                    break;
                case "Cuarto Amarillo":

                    break;
                case "Cuarto Azul":

                    break;
                case "Cuarto Magenta":

                    break;
                case "Cuarto Cian":

                    break;
                case "Cuarto Final":

                    break;
                case "Salir":
                    System.out.println("CIAO");
                    break;
            }
            Utils.limpiarConsola();
        } while (!"Salir".equalsIgnoreCase(opcion));  //Final del juego

    }

}

