package mx.unam.ciencias.icc.igu;

/**
 * Clase abstracta para controladores del contenido de diálogo con formas con
 * datos de estudiantes que se aceptan o rechazan.
 */
public abstract class ControladorFormaEstudiante extends ControladorForma {

    /** El valor del nombre. */
    protected String nombre;
    /** El valor del número de cuenta. */
    protected int cuenta;
    /** El valor del promedio. */
    protected double promedio;
    /** El valor de la edad. */
    protected int edad;

    /**
     * Verifica que el nombre sea válido.
     * @param nombre el nombre a verificar.
     * @return <code>true</code> si el nombre es válido; <code>false</code> en
     *         otro caso.
     */
    protected boolean verificaNombre(String nombre) {
        if (nombre == null || nombre.isEmpty())
            return false;

        this.nombre = nombre;
        return true;
    }

    /**
     * Verifica que el número de cuenta sea válido.
     * @param cuenta el número de cuenta a verificar.
     * @return <code>true</code> si el número de cuenta es válido;
     *         <code>false</code> en otro caso.
     */
    protected boolean verificaCuenta(String cuenta) {
        if(cuenta == null || cuenta.isEmpty())
            return false;
        try{
            this.cuenta = Integer.parseInt(cuenta);
        }
        catch(NumberFormatException nfe){
            return false; 
        }
        return true; 
    }

    /**
     * Verifica que el promedio sea válido.
     * @param promedio el promedio a verificar.
     * @return <code>true</code> si el promedio es válido; <code>false</code> en
     *         otro caso.
     */
    protected boolean verificaPromedio(String promedio) {
        if (promedio == null || promedio.isEmpty())
            return false;

        try {
            this.promedio = Double.parseDouble(promedio);
        } catch (NumberFormatException nfe) {
            return false;
        }

        return true;
    }

    /**
     * Verifica que la edad sea válida.
     * @param edad la edad a verificar.
     * @return <code>true</code> si la edad es válida; <code>false</code> en
     *         otro caso.
     */
    protected boolean verificaEdad(String edad) {
        if (edad == null || edad . isEmpty ())
            return false;
        try {
            this.edad = Integer.parseInt(edad);
        } catch (NumberFormatException nfe) {
            return false;
        }

        return true;
    }
}
