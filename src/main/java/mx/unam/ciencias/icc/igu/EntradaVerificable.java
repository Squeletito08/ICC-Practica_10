package mx.unam.ciencias.icc.igu;

import javafx.scene.control.TextField;

/**
 * Clase para entradas verificables.
 */
public class EntradaVerificable extends TextField {

    /* El verificador de la entrada. */
    private Verificador verificador;

    /**
     * Define el estado inicial de una entrada verificable.
     */
    public EntradaVerificable() {
        // Aquí va su código.
    }

    /**
     * Define el verificador de la entrada.
     * @param verificador el nuevo verificador de la entrada.
     */
    public void setVerificador(Verificador verificador) {
        // Aquí va su código.
    }

    /**
     * Nos dice si la entrada es válida.
     * @return <code>true</code> si la entrada es válida, <code>false</code> en
     *         otro caso.
     */
    public boolean esValida() {
        // Aquí va su código.
    }
}
