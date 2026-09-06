import java.util.Arrays;

public class MiListaCircular implements ListInterface {
    Node cabeza;

    // 1
    public boolean isEmpty() {
        return this.cabeza == null;
    }

    // 2
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

    // 3
    public void clear() {
        this.cabeza = null;
        return;
    }

    // 4
    public Object getHead() {
        if (this.cabeza == null) {
            return null;
        }
        return this.cabeza.dato;
    }

    // 5
    public Object getTail() {
        if (this.cabeza == null) {
            return null;
        }
        return cabeza.anterior.dato;
    }

    // 6
    public Object get(Node node) {
        if (this.cabeza == null || node == null) {
            return null;
        }
        return node.dato;
    }

    // 7
    public Node search(Object object) {
        Node actual = this.cabeza;
        do {
            if (actual.dato != null && actual.dato.equals(object)) {
                return actual;
            }
            actual = actual.siguiente;
        } while (actual != cabeza);
        return null;
    }

    // 8
    public boolean add(Object object) {
        Node newNode = new Node(object);
        if (this.cabeza == null) {
            newNode.siguiente = newNode;
            newNode.anterior = newNode;
            this.cabeza = newNode;
            return true;
        }
        newNode.siguiente = cabeza;
        newNode.anterior = cabeza.anterior;
        this.cabeza.anterior.siguiente = newNode;
        this.cabeza.anterior = newNode;
        return true;
    }

    // 9
    public boolean insert(Node node, Object object) {
        if (this.cabeza == null || node == null) {
            return false;
        }
        Node newNode = new Node(object);

        newNode.anterior = node;
        newNode.siguiente = node.siguiente;

        node.siguiente.anterior = newNode;
        node.siguiente = newNode;

        return true;
    }

    // 10
    public boolean insert(Object objectRef, Object object) {
        if (this.cabeza == null) {
            return false;
        }
        Node actual = this.cabeza;
        do {
            if (actual.dato != null && actual.dato.equals(objectRef)) {
                Node newNode = new Node(object);
                newNode.anterior = actual;
                newNode.siguiente = actual.siguiente;
                actual.siguiente.anterior = newNode;
                actual.siguiente = newNode;
                return true;
            }
            actual = actual.siguiente;
        } while (actual != cabeza);
        return false;
    }

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
