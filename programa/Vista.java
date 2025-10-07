// @author Sebastian_Garcia
// @version 1.0
// @fecha 06/10/2025
// Descripción: Clase para manejar toda la interacción con el cliente

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;


public class Vista {
    private Scanner scanner;

    // CONSTRUCTOR
    public Vista(){
        this.scanner = new Scanner(System.in);
    }

    public int mostrarMenu(){
        System.out.println("\n SISTEMA OPERATIVO ");
        System.out.println("-1. Registrar nuevo proceso -");
        System.out.println("-2. Correr todos los procesos en la cola-");
        System.out.println("-3. Salir -");
        System.out.println("SELECCIONE UNA OPCION: ");
        int opcion = 0;

        try {
            opcion = scanner.nextInt();
        } catch (InputMismatchException e) {
            System.out.println("ERROR: ingrese un número");
            opcion = -1; // opcion no valida
        } finally {
            scanner.nextLine();
        }
        return opcion;
    }

    public int elegirTipoProceso() {
        int tipo = 0;
        boolean entradaValida = false;
        // Bucle do-while con bandera
        do {
            try {
                System.out.println("Seleccione el tipo de proceso a registrar:");
                System.out.println("1. Proceso de CPU (Proceso Compilación)");
                System.out.println("2. Proceso de I/O (Proceso Lectura de disco)");
                System.out.println("3. Daemon (Proceso segundo plano)");
                System.out.print("Tipo: ");
                tipo = scanner.nextInt();
                if (tipo >= 1 && tipo <= 3) {
                    entradaValida = true;
                } else {
                    System.out.println("Error: El tipo debe ser 1, 2 o 3");
                }
            } catch (InputMismatchException e) {
                System.out.println("Error: Ingrese un número válido");
            } finally {
                scanner.nextLine(); // Limpiar buffer
            }
        } while (!entradaValida);
        return tipo;
    }

    public String solicitarDatosProceso() {
        System.out.print("Ingrese el nombre del proceso: ");
        return scanner.nextLine();
    }

    public void mostrarResultados(ArrayList<String> resultados) {
        System.out.println("\n--- RESULTADOS DE EJECUCIÓN ---");
        for (String resultado : resultados) {
            System.out.println(resultado);
        }
        System.out.println("------------------------------------");
    }

    public void mostrarMensaje(String mensaje) {
        System.out.println("\n" + mensaje);
    }
}
