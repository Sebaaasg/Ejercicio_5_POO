// @author Sebastian_Garcia
// @version 1.0
// @fecha 06/10/2025
// Descripción: Clase para representar un proceso de tipo Daemon que se ejecuta en segundo plano.

public class Daemon extends Proceso {
    
    // CONSTRUCTOR 
    public Daemon(int procesoId, String nombre){
        super(procesoId, nombre);
    }

    @Override
    public String ejecutar(){
        return "PROCESO ID: " + this.procesoId + " (" + this.nombre + "): (DAEMON) MONITOREANDO SISTEMA DE FORMA EXITOSA";
    }
}
