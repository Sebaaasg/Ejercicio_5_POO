// @author Sebastian_Garcia
// @version 1.0
// @fecha 06/10/2025
// Descripción: Clase para representar un proceso de CPU.

public class ProcesoCPU extends Proceso {
    
    // CONSTRUCTOR
    public ProcesoCPU(int procesoId, String nombre){
        super(procesoId, nombre);
    }

    @Override
    public String ejecutar(){
        return "PROCESO ID: " + this.procesoId + " (" + this.nombre + "): CALCULOS COMPLEJOS HECHOS CON EXITO";
    }
}
