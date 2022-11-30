package mx.unam.ciencias.icc.igu;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;

/**
 * Clase para el controlador del diálogo para conectar al servidor.
 */
public class ControladorFormaConectar extends ControladorForma {

    /* El campo verificable para la dirección. */
    @FXML private EntradaVerificable entradaDireccion;
    /* El campo verificable para el puerto. */
    @FXML private EntradaVerificable entradaPuerto;

    /* La dirección. */
    private String direccion;
    /* El puerto. */
    private int puerto;

    /* Inicializa el estado de la forma. */
    @FXML private void initialize() {
        // Aquí va su código.
    }

    /* Manejador para cuando se activa el botón conectar. */
    @FXML private void conectar(ActionEvent evento) {
        // Aquí va su código.
    }

    /* Determina si los campos son válidos. */
    private void conexionValida() {
        // Aquí va su código.
    }

    /* Verifica que la dirección sea válido. */
    private boolean verificaDireccion(String s) {
        // Aquí va su código.
    }

    /* Verifica que el puerto sea válido. */
    private boolean verificaPuerto(String p) {
        // Aquí va su código.
    }

    /**
     * Regresa la dirección del diálogo.
     * @return la dirección del diálogo.
     */
    public String getDireccion() {
        // Aquí va su código.
    }

    /**
     * Regresa el puerto del diálogo.
     * @return el puerto del diálogo.
     */
    public int getPuerto() {
        // Aquí va su código.
    }

    /**
     * Define el foco incial del diálogo.
     */
    @Override public void defineFoco() {
        // Aquí va su código.
    }
}
