import java.util.Arrays;

public class MiListaCircular implements ListInterface {
    Node cabeza;

    public boolean isEmpty() {
        return this.cabeza == null;
    }

    public int getSize() {
        int contador = 0;
        if (this.cabeza == null) {
            return contador;
        }

        Node iterador = this.cabeza;

        do {
            contador++;
            iterador = iterador.siguiente;
        } while (iterador != cabeza);

        return contador;
    }

    public void clear() {
        this.cabeza = null;
        return;
    }

    public Object getHead() {
        if (this.cabeza == null) {
            return null;
        }
        return this.cabeza.dato;
    }

    public Object getTail() {
        if (this.cabeza == null) {
            return null;
        }
        return cabeza.anterior.dato;
    }

    public Object get(Node node) {
        if (this.cabeza == null || node == null) {
            return null;
        }
        return node.dato;
    }

    public Node search(Object object) {return null;}

    public boolean add(Object object) {return null;}

    public boolean insert(Node node, Object object) {return null;}

    public boolean insert(Object objectRef, Object object) {return null;}

    public boolean insertHead(Object object) {return null;}

    public boolean insertTail(Object object) {return null;}

    public boolean set(Node node, Object object) {return null;}

    public boolean remove(Node node) {return null;}

    public boolean contains(Object object) {return null;}

    public Object[] toArray() {return null;}

    public Object[] toArray(Object[] object) {return null;}

    public MiListaCircular subList(Node from, Node to) {return null;}

    public MiListaCircular sortList() {return null;}


}
