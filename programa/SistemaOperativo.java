// @author Sebastian_Garcia
// @version 1.0
// @fecha 06/10/2025
// Descripción: Clase principal del modelo. Gestiona la lista de los procesos del sistema

import java.util.ArrayList;

public class SistemaOperativo {
    
    private ArrayList<Proceso> colaDeProcesos;
    private int proximoPid;

    public SistemaOperativo(){
        this.colaDeProcesos = new ArrayList<>();
        this.proximoPid = 101; // numero para identificar el # de proceso
    }

    // MÉTODO: registro de procesos en el sistema
    public void registrarProceso(int tipo, String nombre) throws ProcesoInvalidoException {
        if (nombre == null || nombre.trim().isEmpty()) {
            // Se lanza una excepción si el nombre está vacío
            throw new ProcesoInvalidoException("EL NOMBRE DEL PROCESO NO PUEDE ESTAR VACÍO");
        }

        Proceso nuevoProceso;
        switch (tipo) {
            case 1:
                nuevoProceso = new ProcesoCPU(proximoPid, nombre);
                break;
            case 2:
                nuevoProceso = new ProcesoIO(proximoPid, nombre);
                break;
            case 3:
                nuevoProceso = new Daemon(proximoPid, nombre);
                break;
            default:
                // Se lanza una excepción si el tipo no es válido
                throw new ProcesoInvalidoException("El tipo de proceso seleccionado no es válido.");
        }

        colaDeProcesos.add(nuevoProceso);
        proximoPid++;
    }

    // MÉTODO: ejecuta todos los procesos de la lista
    public ArrayList<String> ejecutarProcesos() {
        ArrayList<String> resultados = new ArrayList<>();
        if (colaDeProcesos.isEmpty()) {
            resultados.add("No hay procesos en la cola para ejecutar.");
            return resultados;
        }

        // bucle para ejecutar cada uno de los procesos
        for (Proceso p : colaDeProcesos) {
            resultados.add(p.ejecutar());
        }
        
        return resultados;
    }
}
