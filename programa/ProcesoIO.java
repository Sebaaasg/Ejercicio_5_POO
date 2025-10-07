// @author Sebastian_Garcia
// @version 1.0
// @fecha 06/10/2025
// Descripción: Clase para representar un proceso de I/O (entrada y salida).

public class ProcesoIO extends Proceso {
    
    // CONSTRUCTOR
    public ProcesoIO(int procesoId, String nombre){
        super(procesoId, nombre);
    }

    @Override
    public String ejecutar(){
        try{
            // Pausa el programa por 1 segundo 
            Thread.sleep(1000); // Para simular que esperamos una respuesta del hardware
        } catch (InterruptedException e)   {
            // Se maneja la interrupción del hilo
            Thread.currentThread().interrupt();
            return "PROCESO ID: " + this.procesoId + " (" + this.nombre + "): LA OPERACIÓN I/O FUE INTERRUMPIDA";
        }
        return "PROCESO ID: " + this.procesoId + " (" + this.nombre + "): OPERACIÓN I/O EXITOSA, SE HAN LEIDO LOS DATOS";
    }
}
