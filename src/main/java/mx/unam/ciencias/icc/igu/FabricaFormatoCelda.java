package mx.unam.ciencias.icc.igu;

import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.util.Callback;

/**
 * Clase para fabricar el formato de celdas en una tabla.
 */
public class FabricaFormatoCelda<S, T>
    implements Callback<TableColumn<S, T>, TableCell<S, T>> {

    /* Clase interna para sobrecargar la definición de texto de la celda. */
    private class Celda extends TableCell<S, T> {
        @Override public void updateItem(T elemento, boolean vacio) {
            // Aquí va su código.
        }
    }

    /* El formato de la celda. */
    private String formato;

    /**
     * Regresa el formato de la celda.
     * @return el formato de la celda.
     */
    public String getFormato() {
        // Aquí va su código.
    }

    /**
     * Define el formato de la celda.
     * @param formato el formato de la celda.
     */
    public void setFormato(String formato) {
        // Aquí va su código.
    }

    /* Regresa el texto correspondiente al elemento. */
    private String getTexto(T elemento) {
        // Aquí va su código.
    }

    /**
     * Sobrecarga el método que define el texto en la celda dependiendo del
     * valor dentro de la misma.
     * @param columna la columa de la celda.
     */
    @Override public TableCell<S, T> call(TableColumn<S, T> columna) {
        // Aquí va su código.
    }
}
