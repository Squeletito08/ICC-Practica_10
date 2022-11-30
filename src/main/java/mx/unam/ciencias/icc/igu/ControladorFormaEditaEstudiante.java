package mx.unam.ciencias.icc.igu;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import mx.unam.ciencias.icc.Estudiante;

/**
 * Clase para el controlador del contenido del diálogo para editar y crear
 * estudiantes.
 */
public class ControladorFormaEditaEstudiante
    extends ControladorFormaEstudiante {

    /* La entrada verificable para el nombre. */
    @FXML private EntradaVerificable entradaNombre;
    /* La entrada verificable para el número de cuenta. */
    @FXML private EntradaVerificable entradaCuenta;
    /* La entrada verificable para el promedio. */
    @FXML private EntradaVerificable entradaPromedio;
    /* La entrada verificable para la edad. */
    @FXML private EntradaVerificable entradaEdad;

    /* El estudiante creado o editado. */
    private Estudiante estudiante;

    /* Inicializa el estado de la forma. */
    @FXML private void initialize() {
        // Aquí va su código.
    }

    /* Manejador para cuando se activa el botón aceptar. */
    @FXML private void aceptar(ActionEvent evento) {
        // Aquí va su código.
    }

    /* Actualiza al estudiante, o lo crea si no existe. */
    private void actualizaEstudiante() {
        // Aquí va su código.
    }

    /**
     * Define el estudiante del diálogo.
     * @param estudiante el nuevo estudiante del diálogo.
     */
    public void setEstudiante(Estudiante estudiante) {
        // Aquí va su código.
    }

    /**
     * Regresa el estudiante del diálogo.
     * @return el estudiante del diálogo.
     */
    public Estudiante getEstudiante() {
        // Aquí va su código.
    }

    /**
     * Define el verbo del botón de aceptar.
     * @param verbo el nuevo verbo del botón de aceptar.
     */
    public void setVerbo(String verbo) {
        // Aquí va su código.
    }

    /**
     * Define el foco incial del diálogo.
     */
    @Override public void defineFoco() {
        // Aquí va su código.
    }

    /* Verifica que los cuatro campos sean válidos. */
    private void verificaEstudiante() {
        // Aquí va su código.
    }

    /**
     * Verifica que el número de cuenta sea válido.
     * @param cuenta el número de cuenta a verificar.
     * @return <code>true</code> si el número de cuenta es válido;
     *         <code>false</code> en otro caso.
     */
    @Override protected boolean verificaCuenta(String cuenta) {
        // Aquí va su código.
    }

    /**
     * Verifica que el promedio sea válido.
     * @param promedio el promedio a verificar.
     * @return <code>true</code> si el promedio es válido; <code>false</code> en
     *         otro caso.
     */
    @Override protected boolean verificaPromedio(String promedio) {
        // Aquí va su código.
    }

    /**
     * Verifica que la edad sea válida.
     * @param edad la edad a verificar.
     * @return <code>true</code> si la edad es válida; <code>false</code> en
     *         otro caso.
     */
    @Override protected boolean verificaEdad(String edad) {
        // Aquí va su código.
    }
}
