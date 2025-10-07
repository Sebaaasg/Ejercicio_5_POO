// @author Sebastian_Garcia
// @version 1.0
// @fecha 06/10/2025
// Descripción: Clase abstracta para todos los procesos del sistema

public abstract class Proceso {
    // ATRIBUTOS
    protected int procesoId;
    protected String nombre;

    // CONSTRUCTOR
    public Proceso(int procesoId, String nombre){
        this.procesoId = procesoId;
        this.nombre = nombre;
    }

    // MÉTODO: para obligar que las subclases tengan que implementarlo
    public abstract String ejecutar();

    // GETTERS
    public int getProcesoId(){
        return procesoId;
    }
    public String getNombre(){
        return nombre;
    }

    // SOBREESCRIBIR: para obtener información importante del proceso
    @Override
    public String toString(){
        String tipo = this.getClass().getSimpleName();
        return "PROCESO ID: " + procesoId + ", NOMBRE: " + nombre + ", TIPO: " + tipo;
    }
}


