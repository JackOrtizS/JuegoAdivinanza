import java.util.Random;
import java.util.Scanner;

public class JuegoAdivinaNumero {
    private final Random random;
    private final Scanner scanner;

    public JuegoAdivinaNumero(){
        this.random = new Random();
        this.scanner = new Scanner(System.in);
    }

    public void iniciarJuego(){
        mostrarMenu();
        int opcion = obtenerOpcion();

        switch (opcion) {
            case 1:
                jugarAdivinaNumero();
                break;
            case 2:
                System.out.println("Gracias por jugar. ¡Hasta luego!");
                break;
            default:
                System.out.println("Opción inválida. Por favor, elige una opción válida.");
                iniciarJuego();
                break;
        }
    }

    private void mostrarMenu() {
        System.out.println("""
                    ****************************************************************
                    *                                                              *
                    *           HOLA, BIENVENIDO AL JUEGO DE ADIVINANZA            *
                    *                                                              *
                    *                   POR FAVOR ELIGE UNA OPCIÓN                 *
                    *                                                              *
                    *   1: Adivinar el numero que piensa la maquina                *
                    *   2: Salir del juego                                         *
                    *                                                              *
                    ****************************************************************
                """);
    }

    private int obtenerOpcion() {
        System.out.print("Ingresa una opción: ");
        return scanner.nextInt();
    }

    private void jugarAdivinaNumero() {
        int numeroAleatorio = random.nextInt(100) + 1;
        int oportunidades = 1;

        while (oportunidades <= 7) {
            System.out.println("Número de intento: " + oportunidades);
            System.out.println("Ingresa el número que la máquina pensó: ");
            int opcionUsuario = scanner.nextInt();

            if (opcionUsuario > numeroAleatorio) {
                System.out.println("El número que has ingresado es mayor que el número pensado por la máquina");
            } else if (opcionUsuario < numeroAleatorio) {
                System.out.println("El número que has ingresado es menor que el número pensado por la máquina");
            } else {
                System.out.println("¡Felicidades, has ganado!");
                return;
            }

            oportunidades++;

            if (oportunidades > 7) {
                System.out.println("Has perdido el juego...");
                System.out.println("El número generado era: " + numeroAleatorio);
            }
        }
    }

    public static void main(String[] args) {
        JuegoAdivinaNumero juego = new JuegoAdivinaNumero();
        juego.iniciarJuego();
    }

}
