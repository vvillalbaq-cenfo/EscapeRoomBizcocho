package main;

import utilitarios.Utils;

public class MainEscapeRoom {
    // Declaración array de pistas
    static String[] pistas = new String[7];

    // Declaración para cuando los cuartos estan completados
    static boolean cuartoRojoCompleto = false;
    static boolean cuartoAzulCompleto = false;
    static boolean cuartoVerdeCompleto = false;
    static boolean cuartoAmarilloCompleto = false;
    static boolean cuartoCianCompleto = false;
    static boolean cuartoMagentaCompleto = false;
    static boolean cuartoFinalCompleto = false;

    static String nombreUsuario = "";

    public static void main(String[] args) {
        bienvenida();
        solicitarNombreUsuario();

        String[] opcionesMenu = { 
            "Reglas del Juego", 
            "Inventario", 
            "Cuarto Rojo", 
            "Cuarto Verde",
            "Cuarto Amarillo", 
            "Cuarto Azul", 
            "Cuarto Magenta", 
            "Cuarto Cian", 
            "Cuarto Final" 
        };
        
        String opcion = "";
        int opcionSeleccionada;
        boolean finalDelJuego = false;

        do {
            Utils.limpiarConsola();
            opcionSeleccionada = Utils.seleccionarElementoTexto("MENU", opcionesMenu) - 1;
            opcion = opcionesMenu[opcionSeleccionada];
            System.out.println("Usted escogió la opción " + opcion);

            switch (opcion) {
                case "Reglas del Juego":
                    mostrarReglas();
                    break;
                    
                case "Inventario":
                    mostrarInventario();
                    break;
                    
                case "Cuarto Rojo":
                    procesarCuartoRojo();
                    break;
                    
                case "Cuarto Verde":
                    procesarCuartoVerde();
                    break;
                    
                case "Cuarto Amarillo":
                    procesarCuartoAmarillo();
                    break;
                    
                case "Cuarto Azul":
                    procesarCuartoAzul();
                    break;
                    
                case "Cuarto Magenta":
                    procesarCuartoMagenta();
                    break;
                    
                case "Cuarto Cian":
                    procesarCuartoCian();
                    break;
                    
                case "Cuarto Final":
                    procesarCuartoFinal();
                    break;
            }
            
            // Verificar si el juego ha terminado
            finalDelJuego = verificarFinDelJuego();
            
        } while (!finalDelJuego);

        mostrarMensajeFinal();
    }
//Reglas del Juego
    private static void mostrarReglas() {
        System.out.println("Este es un juego de escape room donde debes resolver acertijos y encontrar pistas para escapar de diferentes cuartos.");
        System.out.println("Cada cuarto tiene sus propios desafíos y debes completar todos para ganar el juego. Cada cuarto tiene un tiempo límite de 10 minutos.");
        System.out.println("Debes encontrar las llaves o códigos necesarios para avanzar al siguiente cuarto.");
        System.out.println("Recuerda que el tiempo es limitado y cada acción que tomes consumirá tiempo.");
        System.out.println("Debes estar atento a las pistas que encuentres en cada cuarto. Para abrir las cajas fuertes y conseguir los códigos para abrir la puerta final.");
        System.out.println("Además, debes de revisar como mínimo un cuarto, un objeto y tener mínimo una pista resuelta para poder salir del hotel.");
        System.out.println("Si consumes los 10 minutos, un gas mortífero te aniquilará. Recuerda que tienes un máximo de 3 vidas por cuarto. Si superas este límite, perderás el juego.");
        System.out.println("¡Buena suerte, " + nombreUsuario + "!");
        Utils.pausar();
    }
//procesar Cuarto Rojo
    private static void procesarCuartoRojo() {
        if (!cuartoRojoCompleto) {
            verMapaCuartoRojo();
            Utils.pausar();
            Utils.establecerColorBlanco();
            String pistaObtenida = interaccionCuartoRojo();
            if (pistaObtenida != null) {
                pistas[0] = pistaObtenida;
                cuartoRojoCompleto = true;
            }
        } else {
            System.out.println("Ya has completado el cuarto rojo.");
            Utils.pausar();
        }
    }
// Procesar Cuarto Verde
    private static void procesarCuartoVerde() {
        if (!cuartoRojoCompleto) {
            System.out.println("Debes completar el cuarto rojo antes de ingresar al cuarto verde.");
            Utils.pausar();
            return;
        }
        
        if (!cuartoVerdeCompleto) {
            verMapaCuartoVerde();
            Utils.pausar();
            Utils.establecerColorBlanco();
            String pistaObtenida = interaccionCuartoVerde();
            if (pistaObtenida != null) {
                pistas[1] = pistaObtenida;
                cuartoVerdeCompleto = true;
            }
        } else {
            System.out.println("Ya has completado el cuarto verde.");
            Utils.pausar();
        }
    }
// Procesar Cuarto Amarillo
    private static void procesarCuartoAmarillo() {
        if (!cuartoVerdeCompleto) {
            System.out.println("Debes completar el cuarto verde antes de ingresar al cuarto amarillo.");
            Utils.pausar();
            return;
        }
        
        if (!cuartoAmarilloCompleto) {
            verMapaCuartoAmarillo();
            Utils.pausar();
            Utils.establecerColorBlanco();
            String pistaObtenida = interaccionCuartoAmarillo();
            if (pistaObtenida != null) {
                pistas[2] = pistaObtenida;
                cuartoAmarilloCompleto = true;
            }
        } else {
            System.out.println("Ya has completado el cuarto amarillo.");
            Utils.pausar();
        }
    }
// Procesar Cuarto Azul
    private static void procesarCuartoAzul() {
        if (!cuartoAmarilloCompleto) {
            System.out.println("Debes investigar primero los cuartos anteriores antes de desbloquear este cuarto");
            Utils.pausar();
            return;
        }
        
        if (!cuartoAzulCompleto) {
            verMapaCuartoAzul();
            Utils.pausar();
            Utils.establecerColorBlanco();
            String pistaObtenida = interaccionCuartoAzul();
            if (pistaObtenida != null) {
                pistas[3] = pistaObtenida;
                cuartoAzulCompleto = true;
            }
        } else {
            System.out.println("Ya has completado el cuarto azul.");
            Utils.pausar();
        }
    }
// Procesar Cuarto Magenta
    private static void procesarCuartoMagenta() {
        if (!cuartoAzulCompleto) {
            System.out.println("Debes completar el cuarto azul antes de ingresar al cuarto magenta.");
            Utils.pausar();
            return;
        }
        
        if (!cuartoMagentaCompleto) {
            verMapaCuartoMagenta();
            Utils.pausar();
            Utils.establecerColorBlanco();
            String pistaObtenida = interaccionCuartoMagenta();
            if (pistaObtenida != null) {
                pistas[4] = pistaObtenida;
                cuartoMagentaCompleto = true;
            }
        } else {
            System.out.println("Ya has completado el cuarto magenta.");
            Utils.pausar();
        }
    }
//Procesar Cuarto Cian
    private static void procesarCuartoCian() {
        if (!cuartoMagentaCompleto) {
            System.out.println("Debes completar el cuarto magenta antes de ingresar al cuarto cian.");
            Utils.pausar();
            return;
        }
        
        if (!cuartoCianCompleto) {
            verMapaCuartoCian();
            Utils.pausar();
            Utils.establecerColorBlanco();
            String pistaObtenida = interaccionCuartoCian();
            if (pistaObtenida != null) {
                pistas[5] = pistaObtenida;
                cuartoCianCompleto = true;
            }
        } else {
            System.out.println("Ya has completado el cuarto cian.");
            Utils.pausar();
        }
    }

    //Cambiar segun lo que se ocupe realizar en el cuarto final ver que incorpora el cuarto final sino crear una clase como creadas con los otros cuartos
    private static void procesarCuartoFinal() {
        if (!todosLosCuartosCompletados()) {
            System.out.println("Debes completar todos los cuartos anteriores antes de acceder al cuarto final.");
            Utils.pausar();
            return;
        }
        
        if (!cuartoFinalCompleto) {
            System.out.println("¡Bienvenido al cuarto final!");
            cuartoFinalCompleto = true;
        } else {
            System.out.println("Ya has completado el cuarto final.");
            Utils.pausar();
        }
    }

    private static boolean todosLosCuartosCompletados() {
        return cuartoRojoCompleto && cuartoVerdeCompleto && cuartoAmarilloCompleto && 
               cuartoAzulCompleto && cuartoMagentaCompleto && cuartoCianCompleto;
    }

    private static boolean verificarFinDelJuego() {
        return cuartoFinalCompleto;
    }

    private static void mostrarMensajeFinal() {
        System.out.println("¡Felicidades, has salido del cuarto! ¡Bienvenido a BK! Toma tu corona y tu juego adicional.");
        System.out.println("Redirigiendo a: https://www.burgerking.co.cr");
    }

 //Interacción con el cuarto rojo
    public static String interaccionCuartoRojo() {
        String[] opcionesMenu = { "Camara en la esquina del Cuarto", "Escritorio", "Lampara", "Caja Fuerte", "Salir" };
        String opcion = "";
        int opcionSeleccionada;
        int tiempo = 10;
        int vidasActuales = 3;
        boolean camaraFalsa = false, cajaFuerte = false, lampara = false, escritorio = false;
        boolean cajaAbierta = false, salirCuarto = false;

        while (!salirCuarto && vidasActuales > 0 && tiempo > 0 && !cajaAbierta) {
            verMapaCuartoRojo();
            Utils.establecerColorBlanco();
            opcionSeleccionada = Utils.seleccionarElementoTexto("MENU", opcionesMenu) - 1;
            opcion = opcionesMenu[opcionSeleccionada];
            System.out.println("Usted escogió la opción " + opcion);

            switch (opcion) {
                case "Camara en la esquina del Cuarto":
                    if (!camaraFalsa) {
                        System.out.println("No funciona esta cámara, pero detrás de ella hay una marca en la pared: una letra O dentro de un círculo y parece apuntar hacia el escritorio.");
                        camaraFalsa = true;
                    } else {
                        System.out.println("Ya revisaste la cámara, no hay nada más que hacer aquí.");
                    }
                    tiempo--;
                    Utils.pausar();
                    break;

                case "Escritorio":
                    if (!escritorio) {
                        System.out.println("Luz y sombra muestran el camino hacia la caja fuerte. A veces las cosas se toman al revés.");
                        escritorio = true;
                    } else {
                        System.out.println("Ya revisaste el escritorio.");
                    }
                    tiempo--;
                    Utils.pausar();
                    break;

                case "Lampara":
                    if (!lampara) {
                        System.out.println("Al encender la lámpara, proyecta un código: 247 en la pared.");
                        lampara = true;
                    } else {
                        System.out.println("Ya revisaste la lámpara.");
                    }
                    tiempo--;
                    Utils.pausar();
                    break;

                case "Caja Fuerte":
                    String resultado = procesarCajaFuerte(742, "O", vidasActuales, tiempo);
                    if (resultado != null) {
                        return resultado;
                    }
                    break;

                case "Salir":
                    salirCuarto = Utils.leerBoolean("¿Deseas salir del cuarto rojo? Si sales sin revisar elementos, pierdes una vida. (true/false)");
                    if (salirCuarto) {
                        vidasActuales = procesarSalida(camaraFalsa, escritorio, lampara, cajaAbierta, vidasActuales, "rojo");
                    }
                    tiempo--;
                    break;
            }
        }

        if (vidasActuales <= 0) {
            System.out.println("Has perdido todas las vidas. Fin del juego.");
            return null;
        }
        
        if (tiempo <= 0) {
            System.out.println("Se acabó el tiempo. El gas mortífero te ha vencido.");
            return null;
        }

        return null;
    }
// Interacción con el cuarto azul
    public static String interaccionCuartoAzul() {
        String[] opcionesMenu = { "Vaso", "Encendedor", "Papiro", "Caja Fuerte", "Salir" };
        String opcion = "";
        int opcionSeleccionada;
        int tiempo = 10;
        int vidasActuales = 3;
        boolean vaso = false, encendedor = false, papiro = false;
        boolean cajaAbierta = false, salirCuarto = false;

        while (!salirCuarto && vidasActuales > 0 && tiempo > 0 && !cajaAbierta) {
            verMapaCuartoAzul();
            Utils.establecerColorBlanco();
            System.out.println("Bienvenido al cuarto azul, ¿qué sorpresas podrás encontrar acá?");
            opcionSeleccionada = Utils.seleccionarElementoTexto("MENU", opcionesMenu) - 1;
            opcion = opcionesMenu[opcionSeleccionada];
            System.out.println("Usted escogió la opción " + opcion);

            switch (opcion) {
                case "Vaso":
                    if (!vaso) {
                        System.out.println("El vaso está con un líquido pero no parece tener nada.");
                        if (encendedor && papiro) {
                            System.out.println("Al calentar el vaso con el encendedor, puedes ver el código 843");
                        }
                        vaso = true;
                    } else {
                        System.out.println("Ya revisaste el vaso, no hay nada más que hacer aquí.");
                    }
                    tiempo--;
                    Utils.pausar();
                    break;

                case "Encendedor":
                    if (!encendedor) {
                        System.out.println("No tiene nada fuera de lo normal, pero puede ser útil.");
                        encendedor = true;
                    } else {
                        System.out.println("Ya revisaste el encendedor.");
                    }
                    tiempo--;
                    Utils.pausar();
                    break;

                case "Papiro":
                    if (!papiro) {
                        System.out.println("Encuentras un papiro, al extenderlo, puedes ver que dice muy borroso: El número más caliente.");
                        papiro = true;
                    } else {
                        System.out.println("Ya revisaste el papiro.");
                    }
                    tiempo--;
                    Utils.pausar();
                    break;

                case "Caja Fuerte":
                    String resultado = procesarCajaFuerte(843, "P", vidasActuales, tiempo);
                    if (resultado != null) {
                        return resultado;
                    }
                    break;

                case "Salir":
                    salirCuarto = Utils.leerBoolean("¿Deseas salir del cuarto azul? Si sales sin revisar elementos, pierdes una vida. (true/false)");
                    if (salirCuarto) {
                        vidasActuales = procesarSalida(vaso, encendedor, papiro, cajaAbierta, vidasActuales, "azul");
                    }
                    tiempo--;
                    break;
            }
        }

        return manejarFinCuarto(vidasActuales, tiempo);
    }
// Interacción con el cuarto amarillo
    public static String interaccionCuartoAmarillo() {
        String[] opcionesMenu = { "Estanteria", "Espejo", "Audifonos", "Caja Fuerte", "Salir" };
        String opcion = "";
        int opcionSeleccionada;
        int tiempo = 10;
        int vidasActuales = 3;
        boolean estanteria = false, espejo = false, audifonos = false;
        boolean cajaAbierta = false, salirCuarto = false;

        while (!salirCuarto && vidasActuales > 0 && tiempo > 0 && !cajaAbierta) {
            verMapaCuartoAmarillo();
            Utils.establecerColorBlanco();
            opcionSeleccionada = Utils.seleccionarElementoTexto("MENU", opcionesMenu) - 1;
            opcion = opcionesMenu[opcionSeleccionada];
            System.out.println("Usted escogió la opción " + opcion);

            switch (opcion) {
                case "Estanteria":
                    if (!estanteria) {
                        System.out.println("Tiene un libro con una página marcada: \"Los reflejos engañan, pero a veces son la clave para ver lo que está oculto\".");
                        estanteria = true;
                    } else {
                        System.out.println("Ya revisaste la estantería, no hay nada más que hacer aquí.");
                    }
                    tiempo--;
                    Utils.pausar();
                    break;

                case "Espejo":
                    if (!espejo) {
                        System.out.println("El espejo refleja la combinación en la pared 539");
                        espejo = true;
                    } else {
                        System.out.println("Ya revisaste el espejo.");
                    }
                    tiempo--;
                    Utils.pausar();
                    break;

                case "Audifonos":
                    if (!audifonos) {
                        System.out.println("Al ponerte los audífonos, escuchas un mensaje: Izquierda, derecha, izquierda");
                        audifonos = true;
                    } else {
                        System.out.println("Ya revisaste los audífonos.");
                    }
                    tiempo--;
                    Utils.pausar();
                    break;

                case "Caja Fuerte":
                    String resultado = procesarCajaFuerte(935, "W", vidasActuales, tiempo);
                    if (resultado != null) {
                        return resultado;
                    }
                    break;

                case "Salir":
                    salirCuarto = Utils.leerBoolean("¿Deseas salir del cuarto amarillo? Si sales sin revisar elementos, pierdes una vida. (true/false)");
                    if (salirCuarto) {
                        vidasActuales = procesarSalida(estanteria, espejo, audifonos, cajaAbierta, vidasActuales, "amarillo");
                    }
                    tiempo--;
                    break;
            }
        }

        return manejarFinCuarto(vidasActuales, tiempo);
    }
// Interacción con el cuarto magenta
    public static String interaccionCuartoMagenta() {
        String[] opcionesMenu = {
            "Cerradura electrónica",
            "Caja de acertijo",
            "Nota bajo la baldosa",
            "Caja Fuerte",
            "Salir"
        };
        String opcion = "";
        int opcionSeleccionada;
        int tiempo = 10;
        int vidasActuales = 3;
        boolean cerradura = false, acertijo = false, notaBaldosa = false;
        boolean cajaAbierta = false, salirCuarto = false;

        while (!salirCuarto && vidasActuales > 0 && tiempo > 0 && !cajaAbierta) {
            verMapaCuartoMagenta();
            Utils.establecerColorBlanco();
            opcionSeleccionada = Utils.seleccionarElementoTexto("MENU", opcionesMenu) - 1;
            opcion = opcionesMenu[opcionSeleccionada];
            System.out.println("Usted escogió la opción " + opcion);

            switch (opcion) {
                case "Cerradura electrónica":
                    if (!cerradura) {
                        System.out.println("La cerradura electrónica parece necesitar una combinación basada en pistas anteriores.");
                        cerradura = true;
                    } else {
                        System.out.println("Ya revisaste la cerradura.");
                    }
                    tiempo--;
                    Utils.pausar();
                    break;

                case "Caja de acertijo":
                    if (!acertijo) {
                        System.out.println("La caja muestra un enigma en números romanos: 'V + X + III'");
                        acertijo = true;
                    } else {
                        System.out.println("Ya revisaste la caja de acertijo.");
                    }
                    tiempo--;
                    Utils.pausar();
                    break;

                case "Nota bajo la baldosa":
                    if (!notaBaldosa) {
                        System.out.println("La nota dice: 'Multiplica por 3'.");
                        notaBaldosa = true;
                    } else {
                        System.out.println("Ya revisaste debajo de la baldosa.");
                    }
                    tiempo--;
                    Utils.pausar();
                    break;

                case "Caja Fuerte":
                    String resultado = procesarCajaFuerte(54, "P", vidasActuales, tiempo);
                    if (resultado != null) {
                        return resultado;
                    }
                    break;

                case "Salir":
                    salirCuarto = Utils.leerBoolean("¿Deseas salir del cuarto magenta? Si sales sin revisar elementos, pierdes una vida. (true/false)");
                    if (salirCuarto) {
                        vidasActuales = procesarSalida(cerradura, acertijo, notaBaldosa, cajaAbierta, vidasActuales, "magenta");
                    }
                    tiempo--;
                    break;
            }
        }

        return manejarFinCuarto(vidasActuales, tiempo);
    }
// Interacción con el cuarto verde
    public static String interaccionCuartoVerde() {
        String[] opcionesMenu = {
            "Bote de pintura",
            "Peluche rasgado",
            "Radio antigua",
            "Caja Fuerte",
            "Salir"
        };
        String opcion = "";
        int opcionSeleccionada;
        int tiempo = 10;
        int vidasActuales = 3;
        boolean pintura = false, peluche = false, radio = false;
        boolean cajaAbierta = false, salirCuarto = false;

        while (!salirCuarto && vidasActuales > 0 && tiempo > 0 && !cajaAbierta) {
            verMapaCuartoVerde();
            Utils.establecerColorBlanco();
            opcionSeleccionada = Utils.seleccionarElementoTexto("MENU", opcionesMenu) - 1;
            opcion = opcionesMenu[opcionSeleccionada];
            System.out.println("Usted escogió la opción " + opcion);

            switch (opcion) {
                case "Bote de pintura":
                    if (!pintura) {
                        System.out.println("Debajo del bote aparece un número parcialmente cubierto: 71.");
                        pintura = true;
                    } else {
                        System.out.println("Ya revisaste el bote de pintura.");
                    }
                    tiempo--;
                    Utils.pausar();
                    break;

                case "Peluche rasgado":
                    if (!peluche) {
                        System.out.println("Dentro del peluche hay una nota que dice: 'El número que falta es igual a la expresión 12^0'.");
                        peluche = true;
                    } else {
                        System.out.println("Ya revisaste el peluche.");
                    }
                    tiempo--;
                    Utils.pausar();
                    break;

                case "Radio antigua":
                    if (!radio) {
                        System.out.println("Al encender la radio, escuchas: 'Gira derecha dos veces, luego izquierda.'");
                        radio = true;
                    } else {
                        System.out.println("Ya revisaste la radio.");
                    }
                    tiempo--;
                    Utils.pausar();
                    break;

                case "Caja Fuerte":
                    String resultado = procesarCajaFuerte(701, "H", vidasActuales, tiempo);
                    if (resultado != null) {
                        return resultado;
                    }
                    break;

                case "Salir":
                    salirCuarto = Utils.leerBoolean("¿Deseas salir del cuarto verde? Si sales sin revisar elementos, pierdes una vida. (true/false)");
                    if (salirCuarto) {
                        vidasActuales = procesarSalida(pintura, peluche, radio, cajaAbierta, vidasActuales, "verde");
                    }
                    tiempo--;
                    break;
            }
        }

        return manejarFinCuarto(vidasActuales, tiempo);
    }
// Interacción con el cuarto cian
    public static String interaccionCuartoCian() {
        String[] opcionesMenu = { "Impresora", "Caja de Discos", "Maleta", "Caja Fuerte", "Salir" };
        String opcion = "";
        int opcionSeleccionada;
        int tiempo = 10;
        int vidasActuales = 3;
        boolean impresora = false, cajaDeDiscos = false, maleta = false;
        boolean cajaAbierta = false, salirCuarto = false;

        while (!salirCuarto && vidasActuales > 0 && tiempo > 0 && !cajaAbierta) {
            verMapaCuartoCian();
            Utils.establecerColorBlanco();
            opcionSeleccionada = Utils.seleccionarElementoTexto("MENU", opcionesMenu) - 1;
            opcion = opcionesMenu[opcionSeleccionada];
            System.out.println("Usted escogió la opción " + opcion);

            switch (opcion) {
                case "Impresora":
                    if (!impresora) {
                        System.out.println("Al activarla, imprime una hoja con la frase: Si escapar deseas, toca escuchar la verdad");
                        impresora = true;
                    } else {
                        System.out.println("Ya revisaste la impresora, no hay nada más que hacer aquí.");
                    }
                    tiempo--;
                    Utils.pausar();
                    break;

                case "Caja de Discos":
                    if (!cajaDeDiscos) {
                        System.out.println("La caja de discos tiene un disco con la pista: La verdad se oculta en la imaginación del viajero");
                        cajaDeDiscos = true;
                    } else {
                        System.out.println("Ya revisaste la caja de discos.");
                    }
                    tiempo--;
                    Utils.pausar();
                    break;

                case "Maleta":
                    if (!maleta) {
                        System.out.println("Al abrir la maleta, encuentras una nota que dice: Soy un pato solo, junto a mi primo el balón y su hermano el flaco");
                        maleta = true;
                    } else {
                        System.out.println("Ya revisaste la maleta.");
                    }
                    tiempo--;
                    Utils.pausar();
                    break;

                case "Caja Fuerte":
                    String resultado = procesarCajaFuerte(201, "E", vidasActuales, tiempo);
                    if (resultado != null) {
                        return resultado;
                    }
                    break;

                case "Salir":
                    salirCuarto = Utils.leerBoolean("¿Deseas salir del cuarto cian? Si sales sin revisar elementos, pierdes una vida. (true/false)");
                    if (salirCuarto) {
                        vidasActuales = procesarSalida(impresora, cajaDeDiscos, maleta, cajaAbierta, vidasActuales, "cian");
                    }
                    tiempo--;
                    break;
            }
        }

        return manejarFinCuarto(vidasActuales, tiempo);
    }

    // Método para procesar cajas fuertes
    private static String procesarCajaFuerte(int codigoCorrecto, String pistaLetra, int vidasActuales, int tiempo) {
        System.out.println("La caja fuerte está cerrada con un código de 3 dígitos.");
        boolean sabeClave = Utils.leerBoolean("¿Sabes el código de la caja fuerte? (true/false)");

        if (!sabeClave) {
            System.out.println("Mejor busca más pistas antes de intentar abrirla.");
            Utils.pausar();
            return null;
        }

        while (vidasActuales > 0) {
            int codigoCaja = Utils.leerEntero("Escribe el código de la caja fuerte de 3 dígitos:");
            if (codigoCaja == codigoCorrecto) {
                System.out.println("¡Correcto! La caja fuerte se ha abierto. Encuentras una nota con la letra " + pistaLetra);
                Utils.pausar();
                System.out.println("Saliste del cuarto con la pista: " + pistaLetra);
                return pistaLetra;
            } else {
                vidasActuales--;
                if (vidasActuales > 0) {
                    System.out.println("Código incorrecto. Te quedan " + vidasActuales + " intentos.");
                    Utils.pausar();
                } else {
                    System.out.println("¡Fallaste todos los intentos! Has perdido todas tus vidas. Fin del juego.");
                    Utils.pausar();
                    return null;
                }
            }
        }
        return null;
    }
// Método para procesar la salida de un cuarto
    private static int procesarSalida(boolean obj1, boolean obj2, boolean obj3, boolean cajaAbierta, int vidasActuales, String nombreCuarto) {
        if (!obj1 && !obj2 && !obj3) {
            System.out.println("Saliste del cuarto " + nombreCuarto + " sin revisar ningún objeto. Pierdes una vida.");
            vidasActuales--;
        } else if (obj1 && obj2 && obj3 && !cajaAbierta) {
            System.out.println("Revisaste todos los objetos del cuarto " + nombreCuarto + ", pero no abriste la caja fuerte.");
            vidasActuales--;
        } else if ((obj1 && !obj2 && !obj3) || (!obj1 && obj2 && !obj3) || (!obj1 && !obj2 && obj3)) {
            System.out.println("Revisaste solo un objeto del cuarto " + nombreCuarto + ". Pierdes una vida.");
            vidasActuales--;
        }
        Utils.pausar();
        return vidasActuales;
    }

    // Método para manejar el fin de un cuarto
    private static String manejarFinCuarto(int vidasActuales, int tiempo) {
        if (vidasActuales <= 0) {
            System.out.println("Has perdido todas las vidas. Fin del juego.");
            Utils.pausar();
            return null;
        }
        
        if (tiempo <= 0) {
            System.out.println("Se acabó el tiempo. El gas mortífero te ha vencido.");
            Utils.pausar();
            return null;
        }
        
        return null;
    }

    // Métodos para mostrar mapas de cuartos
    public static void verMapaCuartoRojo() {
        Utils.establecerColorRojo();
        System.out.println("        Mapa del Cuarto Rojo - Escape Room");
        System.out.println("                   ┌──────────────────┐   ");
        System.out.println("  Puerta Principal │Cámara Fotográfica│   ");
        System.out.println("                   │                  │   ");
        System.out.println("                   ├───────┬──────────┤   ");
        System.out.println("                   │Lámpara│Escritorio│   ");
        System.out.println("                   │       │          │   ");
        System.out.println("                   ├───────┴──────────┤   ");
        System.out.println("                   │  Caja Fuerte     │   ");
        System.out.println("                   └──────┬───────────┘   ");
        System.out.println("                          │               ");
        System.out.println("            Puerta a siguiente cuarto     ");
    }

    public static void verMapaCuartoAzul() {
        Utils.establecerColorAzul();
        System.out.println("          Mapa del Cuarto Azul - Escape Room");
        System.out.println("                   ┌────────────────────┐   ");
        System.out.println("  Puerta Principal │     Escritorio     │   ");
        System.out.println("                   │ ┌───────────────┐  │   ");
        System.out.println("                   │ │ Vaso          │  │   ");
        System.out.println("                   │ │ Encendedor    │  │   ");
        System.out.println("                   │ │ Papiro        │  │   ");
        System.out.println("                   │ └───────────────┘  │   ");
        System.out.println("                   ├────────────────────┤   ");
        System.out.println("                   │  Caja Fuerte       │   ");
        System.out.println("                   └────────┬───────────┘   ");
        System.out.println("                            │               ");
        System.out.println("            Puerta a siguiente cuarto       ");
    }

    public static void verMapaCuartoAmarillo() {
        Utils.establecerColorAmarillo();
        System.out.println("          Mapa del Cuarto Amarillo - Escape Room");
        System.out.println("                   ┌────────────────────┐   ");
        System.out.println("  Puerta Principal │     Escritorio     │   ");
        System.out.println("                   │ ┌───────────────┐  │   ");
        System.out.println("                   │ │ Estantería    │  │   ");
        System.out.println("                   │ │ Espejo        │  │   ");
        System.out.println("                   │ │ Auriculares   │  │   ");
        System.out.println("                   │ └───────────────┘  │   ");
        System.out.println("                   ├────────────────────┤   ");
        System.out.println("                   │  Caja Fuerte       │   ");
        System.out.println("                   └────────┬───────────┘   ");
        System.out.println("                            │               ");
        System.out.println("            Puerta a siguiente cuarto       ");
    }

    public static void verMapaCuartoCian() {
        Utils.establecerColorCian();
        System.out.println("          Mapa del Cuarto Cian - Escape Room");
        System.out.println("                   ┌────────────────────┐   ");
        System.out.println("  Puerta Principal │     Escritorio     │   ");
        System.out.println("                   │ ┌───────────────┐  │   ");
        System.out.println("                   │ │ Impresora     │  │   ");
        System.out.println("                   │ │ Maleta        │  │   ");
        System.out.println("                   │ │ Caja de discos│  │   ");
        System.out.println("                   │ └───────────────┘  │   ");
        System.out.println("                   ├────────────────────┤   ");
        System.out.println("                   │  Caja Fuerte       │   ");
        System.out.println("                   └────────┬───────────┘   ");
        System.out.println("                            │               ");
        System.out.println("            Puerta a siguiente cuarto       ");
    }

    public static void verMapaCuartoMagenta() {
        Utils.establecerColorMangenta();
        System.out.println("                Mapa del Cuarto Magenta - Escape Room");
        System.out.println("                        ┌───────────────────────────┐");
        System.out.println("    Puerta Principal    │  Cerradura electrónica    │");
        System.out.println("                        ├───────────┬───────────────┤");
        System.out.println("                        │  Acertijo │  Nota Baldosa │");
        System.out.println("                        ├───────────┴───────────────┤");
        System.out.println("                        │        Caja Fuerte        │");
        System.out.println("                        └────────────┬──────────────┘");
        System.out.println("                      Puerta a siguiente cuarto");
    }

    public static void verMapaCuartoVerde() {
        Utils.establecerColorVerde();
        System.out.println("                 Mapa del Cuarto Verde - Escape Room");
        System.out.println("                           ┌───────────────────────┐");
        System.out.println("      Puerta Principal     │  Bote de pintura      │");
        System.out.println("                           ├──────────┬────────────┤");
        System.out.println("                           │  Peluche │  Radio     │");
        System.out.println("                           ├──────────┴────────────┤");
        System.out.println("                           │    Caja Fuerte        │");
        System.out.println("                           └────────┬──────────────┘");
        System.out.println("                         Puerta a siguiente cuarto");
    }

    // Método para solicitar nombre de usuario
    static boolean validacionNombreUsuario = false;
    public static void solicitarNombreUsuario() {
        do {
            nombreUsuario = Utils.leerString("Ingrese su nombre de usuario:");
            if (nombreUsuario != null && !nombreUsuario.trim().isEmpty()) {
                validacionNombreUsuario = true;
                System.out.println("Usuario " + nombreUsuario + " creado exitosamente.");
                Utils.pausar();
            } else {
                System.out.println("El nombre de usuario no puede estar vacío. Intenta de nuevo.");
                Utils.pausar();
            }
            Utils.limpiarConsola();
        } while (!validacionNombreUsuario);
    }

    // Método para mostrar inventario
    public static void mostrarInventario() {
        System.out.println("═════════════════════════════");
        System.out.println("        INVENTARIO");
        System.out.println("═════════════════════════════");
        
        boolean tieneItems = false;
        if (cuartoRojoCompleto && pistas[0] != null) {
            System.out.println("✓ " + pistas[0]);
            tieneItems = true;
        }
        if (cuartoVerdeCompleto && pistas[1] != null) {
            System.out.println("✓ " + pistas[1]);
            tieneItems = true;
        }
        if (cuartoAmarilloCompleto && pistas[2] != null) {
            System.out.println("✓ " + pistas[2]);
            tieneItems = true;
        }
        if (cuartoAzulCompleto && pistas[3] != null) {
            System.out.println("✓ " + pistas[3]);
            tieneItems = true;
        }
        if (cuartoMagentaCompleto && pistas[4] != null) {
            System.out.println("✓ " + pistas[4]);
            tieneItems = true;
        }
        if (cuartoCianCompleto && pistas[5] != null) {
            System.out.println("✓ " + pistas[5]);
            tieneItems = true;
        }
        if (cuartoFinalCompleto && pistas[6] != null) {
            System.out.println("✓ " + pistas[6]);
            tieneItems = true;
        }
        
        if (!tieneItems) {
            System.out.println("No tienes pistas aún.");
        }
        
        System.out.println("═════════════════════════════");
        Utils.pausar();
    }

    // Bienvenida al juego
    public static void bienvenida() {
        Utils.limpiarConsola();
        Utils.establecerColorBlanco();
        System.out.println("═══════════════════════════════════════════════════════════");
        System.out.println("        ¡BIENVENIDO AL ESCAPE ROOM BIZCOCHO!               ");
        System.out.println("═══════════════════════════════════════════════════════════");
        System.out.println("                                                           ");
        System.out.println("                    ┌─────────────────┐                   ");
        System.out.println("                    │    BIZCOCHO     │                   ");
        System.out.println("                    │ 🍔ADVENTURE🍔  │                   ");
        System.out.println("                    └─────────────────┘                   ");
        System.out.println("                           │                             ");
        System.out.println("                           │                             ");
        System.out.println("                    Presiona ENTER                        ");
        System.out.println("                    para comenzar                         ");
        System.out.println("                                                           ");
        System.out.println("═══════════════════════════════════════════════════════════");
        Utils.pausar();
        Utils.limpiarConsola();
    }
}