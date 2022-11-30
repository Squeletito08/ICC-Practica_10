package mx.unam.ciencias.icc.igu;

import java.io.IOException;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Modality;
import javafx.stage.Stage;
import mx.unam.ciencias.icc.Estudiante;

/**
 * Clase para diálogos con formas para editar estudiantes.
 */
public class DialogoEditaEstudiante extends Stage {

    /* Vista de la forma para agregar/editar estudiantes. */
    private static final String EDITA_ESTUDIANTE_FXML =
        "fxml/forma-edita-estudiante.fxml";

    /* El controlador. */
    private ControladorFormaEditaEstudiante controlador;

    /**
     * Define el estado inicial de un diálogo para estudiante.
     * @param escenario el escenario al que el diálogo pertenece.
     * @param estudiante el estudiante; puede ser <code>null</code> para agregar
     *                   un estudiante.
     * @throws IOException si no se puede cargar el archivo FXML.
     */
    public DialogoEditaEstudiante(Stage escenario,
                                  Estudiante estudiante) throws IOException {
        // Aquí va su código.
    }

    /**
     * Nos dice si el usuario activó el botón de aceptar.
     * @return <code>true</code> si el usuario activó el botón de aceptar,
     *         <code>false</code> en otro caso.
     */
    public boolean isAceptado() {
        // Aquí va su código.
    }

    /**
     * Regresa el estudiante del diálogo.
     * @return el estudiante del diálogo.
     */
    public Estudiante getEstudiante() {
        // Aquí va su código.
    }
}
