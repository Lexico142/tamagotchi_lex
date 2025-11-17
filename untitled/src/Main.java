import java.util.Scanner;

public class Main {

    public static int energia = 50;
    public static int cambioEnergia = 0;
    public static int hambre = 50;
    public static int cambioHambre = 0;
    public static int felicidad = 50;
    public static int cambioFelicidad = 0;
    public static int dinero = 0;
    public static int cambioDinero = 0;

    public static int comida1 = 0;
    public static int comida2 = 0;
    public static int comida3 = 0;
    public static int comida4 = 0;

    public static boolean licenciaConducir = false;
    public static boolean cursoCocina = false;

    public static String nombre;
    public static String skin;


    public static void main(String[] args) throws InterruptedException {
        Scanner src = new Scanner(System.in);

        boolean bucleInicial = true;
        boolean salir = false;

        System.out.println("==================================");
        System.out.println("==== Bienvenido/a a Tamagotchi ===");
        System.out.println("==================================\n");

        while (!salir) {
            while (bucleInicial) {
                System.out.println("Introduce el número correspondiente a tu opción");
                System.out.println("1. Empezar");
                System.out.println("2. Tutorial");
                System.out.println("3. Salir\n");

                int opcion = src.nextInt();

                switch (opcion) {
                    case 1:
                        bucleInicial = false;
                        break;
                    case 2:
                        tutorial();
                        bucleInicial = false;
                        break;
                    case 3:
                        System.out.println("Saliendo del programa...");
                        Thread.sleep(500);
                        bucleInicial = false;
                        salir = true;
                        break;
                    default:
                        System.out.println("Elige un número válido.");
                        break;

                }
                Thread.sleep(500);
            }

            if (salir) {
                break;
            }

            boolean activo = true;
            while (activo) {

                System.out.println("\n¿Cómo llamarás a tu mascota?");
                src.nextLine();
                nombre = src.nextLine();

                System.out.println("\n¿Cómo quieres que sea tu mascota?");
                System.out.println("[1] \uD83D\uDE3C");
                System.out.println("[2] \uD83D\uDC36");
                System.out.println("[3] \uD83E\uDD8A");
                System.out.println("[4] \uD83D\uDE49");
                System.out.println("[5] \uD83D\uDC14");
                System.out.println("[6] \uD83D\uDC3C");

                int opcion = src.nextInt();
                switch (opcion){
                    case 1:
                        skin = "😼";
                        break;
                    case 2:
                        skin = "\uD83D\uDC36";
                        break;
                    case 3:
                        skin = "\uD83E\uDD8A";
                        break;
                    case 4:
                        skin = "\uD83D\uDE49";
                        break;
                    case 5:
                        skin = "\uD83D\uDC14";
                        break;
                    case 6:
                        skin = "\uD83D\uDC3C";
                        break;
                }

                System.out.println("Tu mascota ahora se llama " + nombre + " y es " + skin + "!");
                System.out.println("¿Quieres modificarlo? (true/false)");

                activo = src.nextBoolean();
                Thread.sleep(2000);

                boolean vivo = true;
                while (vivo) {

                    mostrarMenu();

                    if (hambre <= 0 || felicidad <= 0 || energia <= 0){
                        Thread.sleep(1000);
                        System.out.println("Oh no! " + nombre + " se ha muerto.");
                        Thread.sleep(1000);
                        System.out.println("Te gustaría crear otra mascota? (true/false)");

                        vivo = src.nextBoolean();
                        activo = vivo;
                        break;

                    }

                    int opcionMenu = src.nextInt();

                    switch (opcionMenu) {
                        case 1:
                            darComer(src);
                            break;
                        case 2:
                            jugar(src);
                            break;
                        case 3:
                            dormir();
                            break;
                        case 4:
                            tienda(src);
                            break;
                        case 5:
                            verEstado();
                            break;
                        case 6:
                            trabajar(src);
                            break;
                        case 0:
                            vivo = false;
                            salir = true;
                            break;
                        default:
                            System.out.println("Elige un número válido");
                            break;
                    }
                }


            }

        }

    }




    public static void tutorial() {
        System.out.println("\n================");
        System.out.println("=== TUTORIAL ===");
        System.out.println("================");
        System.out.println("Cuida de tu mascota.");
        System.out.println("- Dale de comer para que no pase hambre.");
        System.out.println("- Juega con él para que sea feliz y ganar dinero.");
        System.out.println("- Duerme para recuperar energía.");
        System.out.println("- Puedes trabajar para conseguir dinero, pero el estado de tu mascota decaerá.");
        System.out.println("- Vigila sus estadísticas. Si alguna llega a 0, perdiste.");

    }

    public static void mostrarMenu() {

        if (energia > 100) energia = 100;
        if (hambre > 100) hambre = 100;
        if (felicidad > 100) felicidad = 100;
        if (dinero > 100) dinero = 100;

        System.out.println("\n==============================");
        System.out.println(skin + " " + nombre + " " + skin + "\n");
        System.out.println("Energía: " + energia + " | Hambre: " + hambre + " | Felicidad: " + felicidad + " | Dinero: " + dinero);
        System.out.println("[1] Dar de comer");
        System.out.println("[2] Jugar");
        System.out.println("[3] Dormir");
        System.out.println("[4] Tienda");
        System.out.println("[5] Ver estado");
        System.out.println("[6] Trabajar");
        System.out.println("[0] Salir");
        System.out.println("==============================");


    }

    public static void darComer(Scanner src) throws InterruptedException {
        System.out.println("Tienes esta cantidad de comida, ¿cuál le vas a dar a " + nombre + "?");
        System.out.println("[1] Pienso Básico: " + comida1);
        System.out.println("[2] Manzana Energética: " + comida2);
        System.out.println("[3] Golosina: " + comida3);
        System.out.println("[4] Comida Misteriosa: " + comida4);
        System.out.println("[0] Ver efectos");
        System.out.println("[9] Volver");

        int opcion = src.nextInt();
        switch (opcion) {
            case 0:
                System.out.println("--- EFECTOS DE LA COMIDA ---");
                System.out.println("[1] Pienso Básico: Sacia mucho el hambre, pero gasta algo de energía.");
                System.out.println("[2] Manzana Energética: Sacia un poco el hambre y da energía.");
                System.out.println("[3] Golosina: Sacia muy poco, pero da mucha felicidad.");
                System.out.println("[4] Comida Misteriosa: ??? (Puede ser bueno o malo)");
                System.out.println("----------------------------");
               Thread.sleep(6000);
                break;

            case 1:
                if (comida1 > 0) {
                    comida1--;
                    cambioHambre = (int) (Math.random() * (40 - 20 + 1) + 20);
                    cambioEnergia = (int) (Math.random() * (20) + 1);

                    hambre += cambioHambre;
                    energia -= cambioEnergia;

                    System.out.println("==========================================================");
                    System.out.println("¡Ñam! " + nombre + " ha comido Pienso Básico.");
                    System.out.println("Hambre +" + cambioHambre + " | Energía -" + cambioEnergia);
                } else {
                    System.out.println("No te queda Pienso Básico. Ve a la tienda.");
                }
                break;

            case 2:
                if (comida2 > 0) {
                    comida2--;
                    cambioHambre = (int) (Math.random() * (20 - 10 + 1) + 10);
                    cambioEnergia = (int) (Math.random() * (25 - 15 + 1) + 15);

                    hambre += cambioHambre;
                    energia += cambioEnergia;

                    System.out.println("==========================================================");
                    System.out.println("¡Qué refrescante! " + nombre + " ha comido una Manzana.");
                    System.out.println("Hambre +" + cambioHambre + " | Energía +" + cambioEnergia);
                } else {
                    System.out.println("No te quedan Manzanas Energéticas. Ve a la tienda.");
                }
                break;

            case 3:
                if (comida3 > 0) {
                    comida3--;
                    cambioHambre = (int) (Math.random() * (10 - 5 + 1) + 5);
                    cambioFelicidad = (int) (Math.random() * (30 - 20 + 1) + 20);

                    hambre += cambioHambre;
                    felicidad += cambioFelicidad;

                    System.out.println("==========================================================");
                    System.out.println("¡Qué rico! A " + nombre + " le ha encantado la Golosina.");
                    System.out.println("Hambre +" + cambioHambre + " | Felicidad +" + cambioFelicidad);
                } else {
                    System.out.println("No te quedan Golosinas. Ve a la tienda.");
                }
                break;

            case 4:
                if (comida4 > 0) {
                    comida4--;

                    cambioHambre = (int) (Math.random() * (50 - (-10) + 1) - 10);
                    cambioFelicidad = (int) (Math.random() * (30 - (-20) + 1) - 20);
                    cambioEnergia = (int) (Math.random() * (20 - (-10) + 1) - 10);

                    hambre += cambioHambre;
                    felicidad += cambioFelicidad;
                    energia += cambioEnergia;

                    System.out.println("==========================================================");
                    System.out.println(nombre + " mira la comida con desconfianza... y se la come.");
                    System.out.println("Hambre " + (cambioHambre >= 0 ? "+" : "") + cambioHambre);
                    System.out.println("Felicidad " + (cambioFelicidad >= 0 ? "+" : "") + cambioFelicidad);
                    System.out.println("Energía " + (cambioEnergia >= 0 ? "+" : "") + cambioEnergia);
                } else {
                    System.out.println("No te queda Comida Misteriosa. Ve a la tienda.");
                }
                break;

            case 9:
                System.out.println("Vuelves al menú principal.");
                break;

            default:
                System.out.println("Elige una opción válida.");
                break;
        }

    }

    public static void jugar(Scanner src) throws InterruptedException {
        System.out.println("¿Qué juego quieres jugar?");
        System.out.println("[1] Piedra, papel, tijeras");
        System.out.println("[2] Dados");
        System.out.println("[9] Volver");

        int opcion = src.nextInt();
        boolean activo = true;

        while (activo) {
            switch (opcion) {
                case 1:
                    piedraPapelTijeras(src);
                    activo = false;
                    break;
                case 2:
                    dados(src);
                    activo = false;
                    break;
                case 9:
                    activo = false;
                    break;
                default:
                    System.out.println("Elige una opción válida");
                    opcion = src.nextInt();
            }
        }
    }

    public static void dormir() {
        cambioFelicidad = (int) (Math.random() * (20) + 1);
        felicidad -= cambioFelicidad;

        cambioEnergia = (int) (Math.random() * (50 - 30 + 1) + 30);
        energia += cambioEnergia;

        System.out.println("Has dormido y te has recuperado!");
        System.out.println("Energia +" + cambioEnergia + " | Felicidad -" + cambioFelicidad);
    }


    public static void tienda(Scanner src) {
        System.out.println("\n--- TIENDA ---");
        System.out.println("Tienes " + dinero + " monedas.");
        System.out.println("¿Qué quieres comprar?");
        System.out.println("[1] Pienso Básico (10 monedas)");
        System.out.println("[2] Manzana Energética (20 monedas)");
        System.out.println("[3] Golosina (30 monedas)");
        System.out.println("[4] Comida Misteriosa (50 monedas)");
        System.out.println("[5] Matriculación a una Autoescuela (50 monedas)");
        System.out.println("[6] Libro de cocina (70 monedas)");
        System.out.println("[0] Salir de la tienda");

        int opcion = src.nextInt();
        switch (opcion) {
            case 1:
                if (dinero >= 10) {
                    dinero -= 10;
                    comida1++;
                    System.out.println("Has comprado Pienso Básico. Tienes: " + comida1);
                } else {
                    System.out.println("¡No tienes suficiente dinero!");
                }
                break;
            case 2:
                if (dinero >= 20) {
                    dinero -= 20;
                    comida2++;
                    System.out.println("Has comprado Manzana Energética. Tienes: " + comida2);
                } else {
                    System.out.println("¡No tienes suficiente dinero!");
                }
                break;
            case 3:
                if (dinero >= 30) {
                    dinero -= 30;
                    comida3++;
                    System.out.println("Has comprado una Golosina. Tienes: " + comida3);
                } else {
                    System.out.println("¡No tienes suficiente dinero!");
                }
                break;
            case 4:
                if (dinero >= 50) {
                    dinero -= 50;
                    comida4++;
                    System.out.println("Has comprado Comida Misteriosa. Tienes: " + comida4);
                } else {
                    System.out.println("¡No tienes suficiente dinero!");
                }
                break;
            case 5:
                if (dinero >= 50) {
                    dinero -= 50;
                    licenciaConducir = true;
                    System.out.println("Te apuntaste a la autoescuela y te sacaste el carnet de conducir! Ya puedes trabajar de repartidor.");
                } else {
                    System.out.println("¡No tienes suficiente dinero!");
                }
                break;
            case 6:
                if (dinero >= 70) {
                    dinero -= 70;
                    cursoCocina = true;
                    System.out.println("Has comprado el libro y te ilumina. Ya puedes trabajar de cocinero.");
                } else {
                    System.out.println("¡No tienes suficiente dinero!");
                }
                break;

            case 0:
                System.out.println("Sales de la tienda.");
                break;
            default:
                System.out.println("Opción no válida.");
                break;
        }
    }

    public static void verEstado() {

        System.out.println("\n==============================");
        System.out.println(skin + " " + nombre + " " + skin + "\n");
        System.out.println("Energía: " + energia + " | Hambre: " + hambre + " | Felicidad: " + felicidad + " | Dinero: " + dinero);

        if (felicidad > 70 && hambre > 40 && energia > 50 ) System.out.println(nombre + " está feliz y activo.");
        else if (energia <= 30 && felicidad <= 30 && hambre <= 30) System.out.println(nombre + " está en las últimas...");
        else if (hambre <= 30) System.out.println(nombre + " tiene hambre, deberías darle de comer.");
        else if (energia <= 30) System.out.println(nombre + " está muy cansado, necesita dormir.");
        else if (felicidad <= 30) System.out.println(nombre + " está triste, juega con él.");
        else if (energia > 70 && hambre > 50) System.out.println(nombre + " está hiperactivo.");

    }

    static void piedraPapelTijeras(Scanner src) throws InterruptedException {
        System.out.println("Introduce tu jugada");
        System.out.println("1 - Piedra");
        System.out.println("2 - Papel");
        System.out.println("3 - Tijera");
        src.nextLine();

        int jugada = src.nextInt();
        int jugadaIA = (int) (Math.random() * 3) + 1;
        String nombreJugadaIA;
        if (jugadaIA == 1) nombreJugadaIA = "Piedra";
        else if (jugadaIA == 2) nombreJugadaIA = "Papel";
        else nombreJugadaIA = "Tijera";

        System.out.print(nombre + "ha sacado... ");
        Thread.sleep(2000);
        System.out.println(nombreJugadaIA);

        while (true){
            if (jugada == jugadaIA) {
                System.out.println("Empate, vuelve a jugar.");

            } else if (jugada == 1 && jugadaIA == 3 || jugada == 2 && jugadaIA == 1 || jugada == 3 && jugadaIA == 2) {
                System.out.println("Has ganado!");

                cambioFelicidad = (int) (Math.random() * (30 - 10 + 1) + 10);
                cambioDinero = (int) (Math.random() * (40 - 20 + 1) + 20);
                cambioEnergia = (int) (Math.random() * (30 - 10 + 1) + 10);

                felicidad += cambioFelicidad;
                dinero += cambioDinero;
                energia -= cambioEnergia;

                System.out.println("Resultados: Felicidad +" + cambioFelicidad + " | Dinero +" + cambioDinero + " | Energía -" + cambioEnergia);
                break;
            } else {
                cambioFelicidad = (int) (Math.random() * (20 + 1) + 1);
                System.out.println("Has perdido! -" + cambioFelicidad);
                felicidad -= cambioFelicidad;
                break;
            }
        }
    }

    static void adivinaNumero(Scanner src) throws InterruptedException {

        int numero = (int) (Math.random() * 20 + 2);
        int intento = 0;
        int turnos = 0;
        System.out.println(nombre + ": Voy a pensar en un número del 1 al 20. Tienes 5 intentos...");
        Thread.sleep(1000);
        System.out.println("Ya lo tengo!");

        for (int i = 0; i < 5 ; i++) {
            System.out.println("Intento " + i);
            intento = src.nextInt();
            if (intento == numero){
                System.out.println("Acertaste!");
                cambioFelicidad = (int) (Math.random() * (30 - 10 + 1) + 10);
                cambioDinero = (int) (Math.random() * (40 - 20 + 1) + 20);
                cambioEnergia = (int) (Math.random() * (30 - 10 + 1) + 10);

                System.out.println("Resultados: Felicidad +" + cambioFelicidad + " | Dinero +" + cambioDinero + " | Energía -" + cambioEnergia);

            }
            else if (intento < numero) System.out.println("El número que he pensado es más grande.");
            else System.out.println("El número que he pensado es más pequeño.");
            turnos++;
        }

        if (turnos < 5){
            System.out.println("No lograste adivinar mi número en 5 intentos.");
            Thread.sleep(500);
            cambioFelicidad = (int) (Math.random() * (20 + 1) + 1);
            System.out.println("Has perdido! -" + cambioFelicidad);
            felicidad -= cambioFelicidad;
            Thread.sleep(1000);
        }


    }

    static void dados(Scanner src) throws InterruptedException {
        while (true) {
            System.out.println("Escribe 'tirar' para lanzar tus dados");
            src.nextLine();
            String tirar = src.next();

            if (!tirar.equalsIgnoreCase("tirar")) {
                System.out.println("Escribe 'tirar' para jugar.");
                continue;
            }

            System.out.println("Tirando tus dados...");
            Thread.sleep(1000);
            int jugadorDado1 = (int) (Math.random() * 6) + 1;
            int jugadorDado2 = (int) (Math.random() * 6) + 1;
            int totalJugador = jugadorDado1 + jugadorDado2;
            System.out.println("Has sacado un " + jugadorDado1 + " y un " + jugadorDado2 + ". Total: " + totalJugador);

            System.out.println(nombre + " está tirando sus dados...");
            Thread.sleep(1000);
            int iaDado1 = (int) (Math.random() * 6) + 1;
            int iaDado2 = (int) (Math.random() * 6) + 1;
            int totalIA = iaDado1 + iaDado2;
            System.out.println(nombre + " ha sacado un " + iaDado1 + " y un " + iaDado2 + ". Total: " + totalIA);


            if (totalJugador > totalIA) {
                System.out.println("¡Has ganado!");
                cambioFelicidad = (int) (Math.random() * (30 - 10 + 1) + 10);
                cambioDinero = (int) (Math.random() * (40 - 20 + 1) + 20);
                cambioEnergia = (int) (Math.random() * (30 - 10 + 1) + 10);

                felicidad += cambioFelicidad;
                dinero += cambioDinero;
                energia -= cambioEnergia;

                System.out.println("Resultados: Felicidad +" + cambioFelicidad + " | Dinero +" + cambioDinero + " | Energía -" + cambioEnergia);
                Thread.sleep(2000);
                break;
            } else if (totalJugador < totalIA) {
                cambioFelicidad = (int) (Math.random() * (20 + 1) + 1);
                System.out.println("¡Has perdido!");
                felicidad -= cambioFelicidad;
                System.out.println("Resultados: Felicidad -" + cambioFelicidad);
                Thread.sleep(2000);
                break;
            } else {
                System.out.println("¡Empate! Juega de nuevo.");
                Thread.sleep(2000);
            }
        }

    }

    public static void trabajar(Scanner src) throws InterruptedException {

        System.out.println("==============================");
        System.out.println("========== Trabajos ==========");
        System.out.println("==============================");

        System.out.println("[1] Camarero");
        System.out.println("[2] Repartidor");
        System.out.println("[3] Streamer");
        System.out.println("[4] Cocinero");
        System.out.println("[0] Volver");

        int opcion = src.nextInt();
        int chances = (int) (Math.random() * 100) + 1;

        switch (opcion){
            case 1:
                Thread.sleep(2000);
                if (chances > 80) {
                    System.out.println("Trabajas como camarero sobreexplotado para que te paguen entre 0 y nada.");
                    cambioDinero = (int) (Math.random() * (30 - 10 + 1) + 10);
                    cambioEstadoTrabajo();
                }
                else {
                    System.out.println("Se te caen las bandejas con la comida para 10 personas, tu jefe está rabiando y no te pagan.");
                }

                Thread.sleep(2000);
                break;
            case 2:
                Thread.sleep(2000);
                if (licenciaConducir){
                    if (chances > 90) {
                        System.out.println("Repartes pizzas de manera regular.");
                        cambioDinero = (int) (Math.random() * (50 - 20 + 1) + 10);
                        cambioEstadoTrabajo();
                    }
                    else {
                        System.out.println("Estrellas tu moto, tu jefe está rabiando y no te pagan.");
                    }

                } else {
                    System.out.println("No te has sacado la licencia de conducir, no puedes repartir.");
                }
                Thread.sleep(2000);
                break;

            case 3:
                Thread.sleep(2000);
                if (chances <= 10) {
                    System.out.println("Tu stream se hace increíblemente viral.");
                    cambioDinero = (int) (Math.random() * (70 - 50 + 1) + 50);
                    cambioEstadoTrabajo();
                }
                else if (chances <= 20) {
                    System.out.println("Otro streamer se fija en el tuyo y de alguna manera te hace publicidad.");
                    cambioDinero = (int) (Math.random() * (60 - 10 + 1) + 20);
                    cambioEstadoTrabajo();
                }
                else if (chances <= 80) {
                    System.out.println("Como la mayoría, has tenido un stream con 2 viewers. Siendo uno tu mamá y el otro una persona que se dejó el stream abierto sin darse cuenta.");
                    cambioDinero = (int) (Math.random() * (10) + 1);
                    cambioEstadoTrabajo();
                }
                else {
                    System.out.println("Ha entrado más gente de lo normal a tu stream.");
                    cambioDinero = (int) (Math.random() * (40 - 10 + 1) + 10);
                    cambioEstadoTrabajo();
                }

                break;

            case 4:
                Thread.sleep(2000);
                if (cursoCocina){
                    if (chances > 90) {
                        System.out.println("Trabajas de manera regular.");
                        cambioDinero = (int) (Math.random() * (60 - 20 + 1) + 10);
                        cambioEstadoTrabajo();
                    }
                    else {
                        System.out.println("Se te quema todo, y tu jefe está dando volteretas de la impresión.");
                    }
                } else {
                    System.out.println("Ni siquiera sabes cocinar, no puedes trabajar. Con un libro puede que aprendas.");
                }

            case 0:
                System.out.println("Volviendo al menú");
                Thread.sleep(2000);
                break;
            default:
                System.out.println("Introduce un número válido.");
                Thread.sleep(1000);
                break;
        }


    }
    public static void cambioEstadoTrabajo() throws InterruptedException {
        cambioFelicidad = (int) (Math.random() * (15) + 1);
        felicidad -= cambioFelicidad;

        cambioHambre = (int) (Math.random() * (15) + 1);
        hambre -= cambioHambre;

        cambioEnergia = (int) (Math.random() * (15) + 1);
        energia -= cambioEnergia;

        dinero += cambioDinero;

        System.out.println("Resultados: Felicidad -" + cambioFelicidad + " | Dinero +" + cambioDinero + " | Energía -" + cambioEnergia + " | Hambre -" + cambioHambre );

        Thread.sleep(2000);
    }



}