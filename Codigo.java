import java.util.Random;
import java.util.Scanner;

public class AdivinaElNumero {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Random random = new Random();
        boolean jugarNuevamente = true;
        int intentosTotales = 0;
        int mejorIntento1 = Integer.MAX_VALUE;
        int mejorIntento2 = Integer.MAX_VALUE;
        int mejorIntento3 = Integer.MAX_VALUE;

        do {
            int numeroSecreto = random.nextInt(100) + 1;
            int intentos = 0;
            int intentoUsuario;

            System.out.println("¡Bienvenido al juego de adivinar el número!");
            System.out.println("Estoy pensando en un número entre 1 y 100.");

            while (true) {
                try {
                    System.out.print("¿Cuál es tu suposición? ");
                    intentoUsuario = sc.nextInt();
                    intentos++;

                    if (intentoUsuario < numeroSecreto) {
                        System.out.println("Muy bajo. Inténtalo de nuevo.");
                    } else if (intentoUsuario > numeroSecreto) {
                        System.out.println("Muy alto. Inténtalo de nuevo.");
                    } else {
                        System.out.println("¡Felicidades! Adivinaste el número en " + intentos + " intentos.");
                        if (intentos <= mejorIntento1) {
                            mejorIntento3 = mejorIntento2;
                            mejorIntento2 = mejorIntento1;
                            mejorIntento1 = intentos;
                        } else if (intentos <= mejorIntento2) {
                            mejorIntento3 = mejorIntento2;
                            mejorIntento2 = intentos;
                        } else if (intentos <= mejorIntento3) {
                            mejorIntento3 = intentos;
                        }
                        break;
                    }
                } catch (java.util.InputMismatchException e) {
                    System.out.println("Por favor, ingresa un número válido.");
                    sc.next();
                }
            }

            System.out.print("¿Quieres volver a jugar? (s/n): ");
            String respuesta = sc.next().toLowerCase();
            jugarNuevamente = respuesta.equals("s");
            intentosTotales++;
        } while (jugarNuevamente);

        System.out.println("Gracias por jugar. ¡Hasta luego!");
        sc.close();

        System.out.println("1º mejor intento: " + (mejorIntento1 == Integer.MAX_VALUE ? "N/A" : mejorIntento1 + " intentos."));
        System.out.println("2º mejor intento: " + (mejorIntento2 == Integer.MAX_VALUE ? "N/A" : mejorIntento2 + " intentos."));
        System.out.println("3º mejor intento: " + (mejorIntento3 == Integer.MAX_VALUE ? "N/A" : mejorIntento3 + " intentos."));
        System.out.println("Intentos totales: " + intentosTotales);
    }
}
