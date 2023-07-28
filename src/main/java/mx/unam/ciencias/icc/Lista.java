
package mx.unam.ciencias.icc;

import java.util.Comparator;
import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * <p>Clase para listas genéricas doblemente ligadas.</p>
 *
 * <p>Las listas nos permiten agregar elementos al inicio o final de la lista,
 * eliminar elementos de la lista, comprobar si un elemento está o no en la
 * lista, y otras operaciones básicas.</p>
 *
 * <p>Las listas implementan la interfaz {@link Iterable}, y por lo tanto se
 * pueden recorrer usando la estructura de control <em>for-each</em>. Las listas
 * no aceptan a <code>null</code> como elemento.</p>
 *
 * @param <T> El tipo de los elementos de la lista.
 */
public class Lista<T> implements Iterable<T> {

    /* Clase interna privada para nodos. */
    private class Nodo {
        /* El elemento del nodo. */
        private T elemento;
        /* El nodo anterior. */
        private Nodo anterior;
        /* El nodo siguiente. */
        private Nodo siguiente;

        /* Construye un nodo con un elemento. */
        private Nodo(T elemento) {
            this.elemento = elemento; 
        }
    }

    /* Clase interna privada para iteradores. */
    private class Iterador implements IteradorLista<T> {
        /* El nodo anterior. */
        private Nodo anterior;
        /* El nodo siguiente. */
        private Nodo siguiente;

        /* Construye un nuevo iterador. */
        private Iterador() {
            start(); 
        }

        /* Nos dice si hay un elemento siguiente. */
        @Override public boolean hasNext() {
            return siguiente != null; 
        }

        /* Nos da el elemento siguiente. */
        @Override public T next() {
            if(!hasNext())
                throw new NoSuchElementException(); 
            anterior = siguiente; 
            siguiente = siguiente.siguiente; 
            return anterior.elemento;    
        }

        /* Nos dice si hay un elemento anterior. */
        @Override public boolean hasPrevious() {
            return anterior != null; 
        }

        /* Nos da el elemento anterior. */
        @Override public T previous() {
            if(!hasPrevious())
                throw new NoSuchElementException(); 
            siguiente = anterior; 
            anterior = anterior.anterior; 
            return siguiente.elemento; 
        }

        /* Mueve el iterador al inicio de la lista. */
        @Override public void start() {
            anterior = null; 
            siguiente = cabeza; 
        }

        /* Mueve el iterador al final de la lista. */
        @Override public void end() {
            siguiente = null; 
            anterior = rabo; 
        }
    }

    /* Primer elemento de la lista. */
    private Nodo cabeza;
    /* Último elemento de la lista. */
    private Nodo rabo;
    /* Número de elementos en la lista. */
    private int longitud;

   /**
     * Regresa la longitud de la lista.
     * @return la longitud de la lista, el número de elementos que contiene.
     */
    public int getLongitud() {
        return longitud; 
    }

    /**
     * Nos dice si la lista es vacía.
     * @return <code>true</code> si la lista es vacía, <code>false</code> en
     *         otro caso.
     */
    public boolean esVacia() {
        if(cabeza == null)
            return true; 

        return false;         
    }

    /**
     * Agrega un elemento al final de la lista. Si la lista no tiene elementos,
     * el elemento a agregar será el primero y último.
     * @param elemento el elemento a agregar.
     * @throws IllegalArgumentException si <code>elemento</code> es
     *         <code>null</code>.
     */
    public void agregaFinal(T elemento) {
        if (elemento == null)
            throw new IllegalArgumentException();

        Nodo nodo = new Nodo(elemento);
        longitud++; 
        if(esVacia()){
            cabeza = nodo; 
            rabo = nodo;
        }
        else{
            rabo.siguiente = nodo; 
            nodo.anterior = rabo; 
            rabo = nodo; 
        }
        return; 
    }

    /**
     * Agrega un elemento al inicio de la lista. Si la lista no tiene elementos,
     * el elemento a agregar será el primero y último.
     * @param elemento el elemento a agregar.
     * @throws IllegalArgumentException si <code>elemento</code> es
     *         <code>null</code>.
     */
    public void agregaInicio(T elemento) {

        if (elemento == null)
            throw new IllegalArgumentException();

        Nodo nodo = new Nodo(elemento); 
        longitud++; 
        if(esVacia()){
            cabeza = nodo; 
            rabo = nodo;
        }
        else{
            cabeza.anterior = nodo; 
            nodo.siguiente = cabeza; 
            cabeza = nodo;
        }
        return;         
    }

    /**
     * Inserta un elemento en un índice explícito.
     *
     * Si el índice es menor o igual que cero, el elemento se agrega al inicio
     * de la lista. Si el índice es mayor o igual que el número de elementos en
     * la lista, el elemento se agrega al fina de la misma. En otro caso,
     * después de mandar llamar el método, el elemento tendrá el índice que se
     * especifica en la lista.
     * @param i el índice dónde insertar el elemento. Si es menor que 0 el
     *          elemento se agrega al inicio de la lista, y si es mayor o igual
     *          que el número de elementos en la lista se agrega al final.
     * @param elemento el elemento a insertar.
     * @throws IllegalArgumentException si <code>elemento</code> es
     *         <code>null</code>.
     */
    public void inserta(int i, T elemento) {
        if(elemento == null)
            throw new IllegalArgumentException();  

        if (i < 1){
            agregaInicio(elemento);
        }
        else if(i > longitud - 1){
            agregaFinal(elemento);
        }
        else{
            Nodo nodoAux;
            nodoAux = buscaNodo(i);

            if(nodoAux == null)
                return; 

            Nodo nodoE = new Nodo(elemento);

            longitud++; 

            Nodo nodoAuxAnterior = nodoAux.anterior; 

            nodoAux.anterior = nodoE; 
            nodoE.siguiente = nodoAux; 
            nodoAuxAnterior.siguiente = nodoE; 
            nodoE.anterior = nodoAuxAnterior;
        return;
        }        
    }

    /**
     * Elimina un elemento de la lista. Si el elemento no está contenido en la
     * lista, el método no la modifica.
     * @param elemento el elemento a eliminar.
     */
    public void elimina(T elemento) {
        if(elemento == null)
            return;
        if(esVacia())
            return; 

        Nodo nodo = buscaNodo(elemento);

        if(nodo == null)
            return;

        eliminaNodo(nodo);
        return;         
    }

    // metodo buscaNodo que recibe como parametro un entero
    private Nodo buscaNodo(int i){

        if(esVacia())
            return null; 
        
        if(i < 0 || i > longitud - 1)
            return null; 

        Nodo nodo; 
        int contador = 0; 
        nodo = cabeza; 
        while(contador < i){
            contador++;
            nodo = nodo.siguiente;
        }
        return nodo; 
    }

    // metodo buscaNodo que recibe como parametro un Estudiante 
    private Nodo buscaNodo(Object e){
        if(e == null)
            return null; 

        if(esVacia())
            return null;        

        Nodo aux;
        aux = cabeza;  

        while(aux != null && !aux.elemento.equals(e)){
            aux = aux.siguiente; 
        }
        return aux; 
    }


    private void eliminaNodo(Nodo nodo){

        longitud--; 

        if(cabeza == rabo){
            cabeza = null; 
            rabo = null; 
        }
        else if(nodo == cabeza){
            cabeza.siguiente.anterior = null; 
            cabeza = nodo.siguiente;  
        }
        else if(nodo == rabo){
            rabo.anterior.siguiente = null; 
            rabo = nodo.anterior;
        }
        else{
            nodo.siguiente.anterior = nodo.anterior; 
            nodo.anterior.siguiente = nodo.siguiente;    
        }
        return; 
    }


    /**
     * Elimina el primer elemento de la lista y lo regresa.
     * @return el primer elemento de la lista antes de eliminarlo.
     * @throws NoSuchElementException si la lista es vacía.
     */
    public T eliminaPrimero() {
        if(esVacia())
            throw new NoSuchElementException();

        T aux = cabeza.elemento; 
        eliminaNodo(cabeza);
        return aux;     
    }

    /**
     * Elimina el último elemento de la lista y lo regresa.
     * @return el último elemento de la lista antes de eliminarlo.
     * @throws NoSuchElementException si la lista es vacía.
     */
    public T eliminaUltimo() {
        if(esVacia())
            throw new NoSuchElementException();

        T aux = rabo.elemento;
        eliminaNodo(rabo);
        return aux;         
    }

    /**
     * Nos dice si un elemento está en la lista.
     * @param elemento el elemento que queremos saber si está en la lista.
     * @return <code>true</code> si <code>elemento</code> está en la lista,
     *         <code>false</code> en otro caso.
     */
    public boolean contiene(T elemento) {
        return buscaNodo(elemento) != null;
    }

    /**
     * Regresa la reversa de la lista.
     * @return una nueva lista que es la reversa la que manda llamar el método.
     */
    public Lista<T> reversa() {
        Lista<T> listaReversa = new Lista<T>();

        Nodo auxiliar = cabeza; 
        
        int contador = 0; 
        while(contador < longitud){
            listaReversa.agregaInicio(auxiliar.elemento);
            auxiliar = auxiliar.siguiente;
            contador++;
        } 

        return listaReversa;  
    }

    /**
     * Regresa una copia de la lista. La copia tiene los mismos elementos que la
     * lista que manda llamar el método, en el mismo orden.
     * @return una copiad de la lista.
     */
    public Lista<T> copia() {
        Lista<T> listaCopia = new Lista<T>();

        Nodo auxiliar = cabeza; 

        int contador = 0; 
        while(contador < longitud){
            listaCopia.agregaFinal(auxiliar.elemento);
            auxiliar = auxiliar.siguiente;
            contador++;
        } 
        return listaCopia; 
    }

    /**
     * Limpia la lista de elementos, dejándola vacía.
     */
    public void limpia() {
        cabeza = null; 
        rabo = null; 
        longitud = 0;
        return;        
    }

    /**
     * Regresa el primer elemento de la lista.
     * @return el primer elemento de la lista.
     * @throws NoSuchElementException si la lista es vacía.
     */
    public T getPrimero() {
        if(esVacia())
            throw new NoSuchElementException();

        return cabeza.elemento;
    }

    /**
     * Regresa el último elemento de la lista.
     * @return el primer elemento de la lista.
     * @throws NoSuchElementException si la lista es vacía.
     */
    public T getUltimo() {
        if(esVacia())
            throw new NoSuchElementException();

        return rabo.elemento;
    }

    /**
     * Regresa el <em>i</em>-ésimo elemento de la lista.
     * @param i el índice del elemento que queremos.
     * @return el <em>i</em>-ésimo elemento de la lista.
     * @throws ExcepcionIndiceInvalido si <em>i</em> es menor que cero o mayor o
     *         igual que el número de elementos en la lista.
     */
    public T get(int i) {
        if(esVacia())
            throw new NoSuchElementException(); 

        if(i >= longitud || i < 0)
            throw new ExcepcionIndiceInvalido(); 

        Nodo auxiliar = buscaNodo(i);
        if(auxiliar == null)
            return null; 
        return auxiliar.elemento; 
    }

    /**
     * Regresa el índice del elemento recibido en la lista.
     * @param elemento el elemento del que se busca el índice.
     * @return el índice del elemento recibido en la lista, o -1 si el elemento
     *         no está contenido en la lista.
     */
    public int indiceDe(T elemento) {
        if(esVacia())
            return -1;   
       
        Nodo auxiliar;
        auxiliar = cabeza; 

        int contador = 0; 
        while(contador < longitud){
            if(auxiliar.elemento.equals(elemento))
                return contador; 
            auxiliar = auxiliar.siguiente;
            contador++; 
        }
        return -1;          
    }

    /**
     * Regresa una representación en cadena de la lista.
     * @return una representación en cadena de la lista.
     */
    @Override public String toString() {
        if(esVacia()){
            return "[]";
        }

        Nodo auxiliar = cabeza;

        StringBuffer sb = new StringBuffer();

        sb.append("[").append(auxiliar.elemento);

        if(auxiliar == null)
            return "[]";

        while(auxiliar != rabo){
            sb.append(", ");
            auxiliar = auxiliar.siguiente;   
            if(auxiliar == null)
                break;
            sb.append(auxiliar.elemento);
        }
        sb.append("]");

        return sb.toString();   
    }

    /**
     * Nos dice si la lista es igual al objeto recibido.
     * @param objeto el objeto con el que hay que comparar.
     * @return <code>true</code> si la lista es igual al objeto recibido;
     *         <code>false</code> en otro caso.
     */
    @Override public boolean equals(Object objeto) {
        if (objeto == null || getClass() != objeto.getClass())
            return false;
        @SuppressWarnings("unchecked") Lista<T> lista = (Lista<T>)objeto;

        if (lista == null || longitud != lista.longitud)
            return false;

        Lista<T>.Nodo n1 = cabeza;
        Lista<T>.Nodo n2 = lista.cabeza;
        while (n1 != null && n2 != null) {
            if (!n1.elemento.equals(n2.elemento))
                return false;
            n1 = n1.siguiente;
            n2 = n2.siguiente;
        }
        return true;
    }


    /**
     * Regresa un iterador para recorrer la lista en una dirección.
     * @return un iterador para recorrer la lista en una dirección.
     */
    @Override public Iterator<T> iterator() {
        return new Iterador();
    }

    /**
     * Regresa un iterador para recorrer la lista en ambas direcciones.
     * @return un iterador para recorrer la lista en ambas direcciones.
     */
    public IteradorLista<T> iteradorLista() {
        return new Iterador();
    }


    /**
     * Regresa una copia de la lista, pero ordenada. Para poder hacer el
     * ordenamiento, el método necesita una instancia de {@link Comparator} para
     * poder comparar los elementos de la lista.
     * @param comparador el comparador que la lista usará para hacer el
     *                   ordenamiento.
     * @return una copia de la lista, pero ordenada.
     */

    
    public Lista<T> mergeSort(Comparator<T> comparador) {
        if(longitud <= 1){
            return copia();

        }
        Lista<T> l1 = new Lista<T>(); 
        Nodo aux = cabeza; 
        Nodo mitad = buscaNodo((longitud-1)/2 + 1);

        while(aux != mitad){
            l1.agregaFinal(aux.elemento);
            aux = aux.siguiente; 
        }


        Lista<T> l2 = new Lista<T>(); 
        while(mitad != null){
            l2.agregaFinal(mitad.elemento);
            mitad = mitad.siguiente;
        }

        l1 = l1.mergeSort(comparador);
        l2 = l2.mergeSort(comparador);
        return mezcla(comparador,l1,l2);
    }


    private Lista<T> mezcla(Comparator<T> comparador, Lista<T> l1, Lista<T> l2){
        Lista<T> lista = new Lista<T>();
        Nodo i = l1.cabeza; 
        Nodo j = l2.cabeza; 

        while(i != null && j != null){
            if(comparador.compare(i.elemento,j.elemento) <= 0){
                lista.agregaFinal(i.elemento);
                i = i.siguiente; 
            }
            else{
                lista.agregaFinal(j.elemento);
                j = j.siguiente; 
            }
        }

        while(i != null){
            lista.agregaFinal(i.elemento);
            i = i.siguiente;
        }
        while(j != null){
            lista.agregaFinal(j.elemento);
            j = j.siguiente; 
        }

        return lista;   
    }

    /**
     * Regresa una copia de la lista recibida, pero ordenada. La lista recibida
     * tiene que contener nada más elementos que implementan la interfaz {@link
     * Comparable}.
     * @param <T> tipo del que puede ser la lista.
     * @param lista la lista que se ordenará.
     * @return una copia de la lista recibida, pero ordenada.
     */
    public static <T extends Comparable<T>>
    Lista<T> mergeSort(Lista<T> lista) {
        return lista.mergeSort((a, b) -> a.compareTo(b));
    }

    /**
     * Busca un elemento en la lista ordenada, usando el comparador recibido. El
     * método supone que la lista está ordenada usando el mismo comparador.
     * @param elemento el elemento a buscar.
     * @param comparador el comparador con el que la lista está ordenada.
     * @return <code>true</code> si el elemento está contenido en la lista,
     *         <code>false</code> en otro caso.
     */
    
    public boolean busquedaLineal(T elemento, Comparator<T> comparador) {
        Nodo aux = cabeza; 
        while(aux != null){
            if(comparador.compare(elemento,aux.elemento) < 0)
                return false;
            if(comparador.compare(elemento,aux.elemento) == 0)
                return true; 
            
            aux = aux.siguiente; 
        }
        return false;    
    }
    

    /**
     * Busca un elemento en una lista ordenada. La lista recibida tiene que
     * contener nada más elementos que implementan la interfaz {@link
     * Comparable}, y se da por hecho que está ordenada.
     * @param <T> tipo del que puede ser la lista.
     * @param lista la lista donde se buscará.
     * @param elemento el elemento a buscar.
     * @return <code>true</code> si el elemento está contenido en la lista,
     *         <code>false</code> en otro caso.
     */
    public static <T extends Comparable<T>>
    boolean busquedaLineal(Lista<T> lista, T elemento) {
        return lista.busquedaLineal(elemento, (a, b) -> a.compareTo(b));
    }
}
