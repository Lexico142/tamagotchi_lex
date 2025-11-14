import java.sql.SQLOutput;
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

    public static String nombre;
    public static String skin;


    static void main(String[] args) throws InterruptedException {
        Scanner src = new Scanner(System.in);

        boolean bucleInicial = true;
        boolean salir = false;
        int comida1 = 0;
        int comida2 = 0;
        int comida3 = 0;
        int comida4 = 0;

        System.out.println("==================================");
        System.out.println("==== Bienvenido/a a Tamagochi ====");
        System.out.println("==================================\n");

        while(!salir) {
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

            while (true) {

                boolean nombreSeguro;

                System.out.println("\n¿Cómo llamarás a tu mascota?");
                src.nextLine();
                nombre = src.nextLine();
                System.out.println("¿Estás seguro de que quieres llamarlo " + nombre + "? (true/false)" );
                nombreSeguro = src.nextBoolean();
                if (nombreSeguro) break;

            }

            while (true) {

                boolean skinSeguro;

                System.out.println("\n¿Cómo quieres que sea tu mascota? (Introduce un emoji)");
                src.nextLine();
                skin = src.nextLine();
                System.out.println("¿Estás seguro de que quieres que tenga este aspecto: " + skin + "? (true/false)" );
                skinSeguro = src.nextBoolean();
                if (skinSeguro) break;

            }

            System.out.println("Tu mascota ahora se llama " + nombre + " y es " + skin + "!");
            boolean vivo = true;
            while(vivo){
                mostrarMenu();
                src.nextLine();
                int opcion = src.nextInt();

                switch(opcion){
                    case 1:
                        darComer(comida1,comida2,comida3,comida4,src);
                        break;
                    case 2:
                        jugar(src);
                        break;
                    case 3:
                        dormir();
                        break;
                    case 4:
                        tienda();
                        break;
                    case 5:
                        verEstado();
                        break;
                    case 6:
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



    public static void tutorial(){

    }

    public static void mostrarMenu(){
        System.out.println("\n==============================");
        System.out.println(skin + " " + nombre + " " + skin + "\n");
        System.out.println("Energía: " +  energia + " | Hambre: " + hambre + " | Felicidad: " + felicidad + " | Dinero: " + dinero);
        System.out.println("[1] Dar de comer");
        System.out.println("[2] Jugar");
        System.out.println("[3] Dormir");
        System.out.println("[4] Tienda");
        System.out.println("[5] Ver estado");
        System.out.println("[6] Salir");
        System.out.println("==============================");

    }

    public static void darComer(int comida1, int comida2, int comida3, int comida4, Scanner src){
        System.out.println("Tienes esta cantidad de comida, cuál le vas a dar a " + nombre + "?");
        System.out.println("[1] Comida1: " + comida1);
        System.out.println("[2] Comida1: " + comida2);
        System.out.println("[3] Comida1: " + comida3);
        System.out.println("[4] Comida1: " + comida4);
        System.out.println("[0] Ver efectos");

        src.nextLine();
        int opcion = src.nextInt();
        switch (opcion){
            case 1:
                cambioHambre  = (int) (Math.random() * (40 - 20 + 1) + 20);
                cambioEnergia = (int) (Math.random() * (20) + 1);


                System.out.println("==========================================================");
                System.out.println("Hambre +" + cambioHambre + " | Energía -" + cambioEnergia);
                break;

        }

    }

    public static void jugar(Scanner src) throws InterruptedException {

        System.out.println("¿Qué juego quieres jugar?");
        System.out.println("[1] Piedra, papel, tijeras");
        System.out.println("[2] Dados");


        int opcion = src.nextInt();

        switch (opcion){
            case 1:
                piedraPapelTijeras(src);
                break;
            case 2:
                dados(src);
                break;
        }

    }

    public static void dormir(){
        cambioFelicidad = (int) (Math.random() * (20) + 1);
        felicidad -= cambioFelicidad;

        cambioEnergia = (int) (Math.random() * (50 - 30 + 1) + 30);
        energia += cambioEnergia;

        System.out.println("Has dormido y te has recuperado!");
        System.out.println("Energia +" + cambioEnergia + " | Felicidad -" + cambioFelicidad);
    }

    public static void tienda(){

    }

    public static void verEstado(){

    }

    static void piedraPapelTijeras(Scanner src) {
        System.out.println("Introduce tu jugada");
        System.out.println("1 - Piedra");
        System.out.println("2 - Papel");
        System.out.println("3 - Tijera");

        src.nextLine();
        int jugada = src.nextInt();
        int jugadaIA = (int) (Math.random() * 2) + 1;
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

    static void dados(Scanner src) throws InterruptedException {
        while(true) {
            System.out.println("Escribe para tirar tu primer dado");
            src.nextLine();
            String tirar = src.next();
            Thread.sleep(1000);
            int jugadorDado1 = (int) (Math.random() * 6) + 1;
            int iaDado1 = (int) (Math.random() * 6) + 1;
            System.out.println("Dado 1: " + jugadorDado1);
            Thread.sleep(1000);
            System.out.println(nombre + " está tirando y ha sacado un...");
            Thread.sleep(1000);
            System.out.println("Dado 1: " + iaDado1);

            System.out.println("Escribe para tirar tu segundo dado");
            src.nextLine();
            tirar = src.next();
            Thread.sleep(1000);
            int jugadorDado2 = (int) (Math.random() * 6) + 1;
            int iaDado2 = (int) (Math.random() * 6) + 1;
            System.out.println("Dado 2: " + jugadorDado2);
            Thread.sleep(1000);
            System.out.println(nombre + " está tirando y ha sacado un...");
            Thread.sleep(1000);
            System.out.println("Dado 2: " + iaDado2);
            int totalJugador = jugadorDado1 + jugadorDado2;
            int totalIA = iaDado1 + iaDado2;

            System.out.println("Tu puntiación es: " + totalJugador);
            System.out.println("La puntuación de " + nombre + " es: " + totalIA);

            if (totalJugador > totalIA) {
                System.out.println("Has ganado!");
                cambioFelicidad = (int) (Math.random() * (30 - 10 + 1) + 10);
                cambioDinero = (int) (Math.random() * (40 - 20 + 1) + 20);
                cambioEnergia = (int) (Math.random() * (30 - 10 + 1) + 10);

                felicidad += cambioFelicidad;
                dinero += cambioDinero;
                energia -= cambioEnergia;

                System.out.println("Resultados: Felicidad +" + cambioFelicidad + " | Dinero +" + cambioDinero + " | Energía -" + cambioEnergia);
                Thread.sleep(5000);
                break;
            } else if (totalJugador < totalIA) {
                cambioFelicidad = (int) (Math.random() * (20 + 1) + 1);
                System.out.println("Has perdido! Felicidad -" + cambioFelicidad);
                felicidad -= cambioFelicidad;
                Thread.sleep(5000);
                break;
            } else {
                System.out.println("Empataste, juega de nuevo!");
                Thread.sleep(3000);
            }
        }

    }


}


