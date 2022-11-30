package mx.unam.ciencias.icc.igu;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Tooltip;
import mx.unam.ciencias.icc.CampoEstudiante;

/**
 * Clase para el controlador del contenido del diálogo para buscar estudiantes.
 */
public class ControladorFormaBuscaEstudiantes
    extends ControladorFormaEstudiante {

    /* El combo del campo. */
    @FXML private ComboBox<CampoEstudiante> opcionesCampo;
    /* El campo de texto para el valor. */
    @FXML private EntradaVerificable entradaValor;

    /* Inicializa el estado de la forma. */
    @FXML private void initialize() {
        // Aquí va su código.
    }

    /* Revisa el valor después de un cambio. */
    @FXML private void revisaValor(ActionEvent evento) {
        // Aquí va su código.
    }

    /* Manejador para cuando se activa el botón aceptar. */
    @FXML private void aceptar(ActionEvent evento) {
        // Aquí va su código.
    }

    /* Verifica el valor. */
    private boolean verificaValor(String valor) {
        // Aquí va su código.
    }

    /* Obtiene la pista. */
    private Tooltip getTooltip() {
        // Aquí va su código.
    }

    /**
     * Regresa el valor ingresado.
     * @return el valor ingresado.
     */
    public Object getValor() {
        // Aquí va su código.
    }

    /**
     * Regresa el campo seleccionado.
     * @return el campo seleccionado.
     */
    public CampoEstudiante getCampo() {
        // Aquí va su código.
    }

    /**
     * Define el foco incial del diálogo.
     */
    @Override public void defineFoco() {
        // Aquí va su código.
    }
}
