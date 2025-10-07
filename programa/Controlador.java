// @author Sebastian_Garcia
// @version 1.0
// @fecha 06/10/2025
// Descripción: Clase que maneja el flujo de la aplicación, conectando la vista con el modelo

import java.util.ArrayList;

public class Controlador {
    private SistemaOperativo modelo;
    private Vista vista;

    // CONSTRUCTOR
    public Controlador(SistemaOperativo modelo, Vista vista) {
        this.modelo = modelo;
        this.vista = vista;
    }

    public static void main(String[] args) {
        SistemaOperativo modelo = new SistemaOperativo();
        Vista vista = new Vista();
        Controlador controlador = new Controlador(modelo, vista);
        controlador.iniciar();
    }

    public void iniciar() {
        boolean continuar = true;
        // Bucle principal
        do {
            int opcion = vista.mostrarMenu();
            switch (opcion) {
                case 1:
                    gestionarRegistro();
                    break;
                case 2:
                    gestionarEjecucion();
                    break;
                case 3:
                    continuar = false;
                    vista.mostrarMensaje("HA SALIDO");
                    break;
                default:
                    vista.mostrarMensaje("Opción no válida. Intente de nuevo.");
            }
        } while (continuar);
    }

    private void gestionarRegistro() {
        try {
            int tipo = vista.elegirTipoProceso();
            String nombre = vista.solicitarDatosProceso();
            
            // Llama al modelo para registrar el proceso.
            modelo.registrarProceso(tipo, nombre);
            
            vista.mostrarMensaje("Proceso '" + nombre + "' registrado con éxito");
        } catch (ProcesoInvalidoException e) {

            vista.mostrarMensaje("Error al registrar: " + e.getMessage());
        }
    }

    private void gestionarEjecucion() {
        vista.mostrarMensaje("Ejecutando todos los procesos encolados...");
        // Llama al modelo para que ejecute los procesos
        ArrayList<String> resultados = modelo.ejecutarProcesos();
        // Le pasa los resultados a la vista para que los muestre
        vista.mostrarResultados(resultados);
    }
}
