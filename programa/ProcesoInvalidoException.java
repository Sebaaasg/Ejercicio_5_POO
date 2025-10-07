// @author Sebastian_Garcia
// @version 1.0
// @fecha 06/10/2025
// Descripción: Clase para manejar los errores de forma personalizada al crear un proceso.

public class ProcesoInvalidoException extends Exception {
    public ProcesoInvalidoException(String message){
        super(message); // se envía el mensaje de error a la superclase
    }
}
