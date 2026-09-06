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

    // 11
    public boolean insertHead(Object object) {
        Node nuevaCabeza = new Node(object);

        if (this.cabeza != null) {
            nuevaCabeza.siguiente = cabeza;
            nuevaCabeza.anterior = cabeza.anterior;
            cabeza.anterior.siguiente = nuevaCabeza;
            cabeza.anterior = nuevaCabeza;
            this.cabeza = nuevaCabeza;
            return true;
        }
        nuevaCabeza.siguiente = nuevaCabeza;
        nuevaCabeza.anterior = nuevaCabeza;
        this.cabeza = nuevaCabeza;
        return true;
    }


    // 12
    public boolean insertTail(Object object) {
        Node nuevaCabeza = new Node(object);
        if (this.cabeza != null) {
            nuevaCabeza.siguiente = cabeza;
            nuevaCabeza.anterior = cabeza.anterior;
            cabeza.anterior.siguiente = nuevaCabeza;
            cabeza.anterior = nuevaCabeza;
            return true;
        }
        nuevaCabeza.siguiente = nuevaCabeza;
        nuevaCabeza.anterior = nuevaCabeza;
        this.cabeza = nuevaCabeza;
        return true;
    }

    // 13
    public boolean set(Node node, Object object) {
        if (this.cabeza == null || node == null) {
            return false;
        }
        Node actual = this.cabeza;
        do {
            if (actual == node) {
                actual.dato = object;
                return true;
            }
            actual = actual.siguiente;
        } while (actual != cabeza);
        return false;
    }

    // 14
    public boolean remove(Node node) {
        if (this.cabeza == null || node == null) {
            return false;
        }
        Node actual = this.cabeza;
        do {
            if (actual == node) {
                if (this.cabeza.siguiente == this.cabeza) {
                    this.cabeza = null;
                    return true;
                }
                actual.anterior.siguiente = actual.siguiente;
                actual.siguiente.anterior = actual.anterior;

                if (actual == this.cabeza) {
                    this.cabeza = actual.siguiente;
                }
                return true;
            }
            actual = actual.siguiente;
        } while (actual != cabeza);
        return false;
    }

    // 15
    public boolean contains(Object object) {
        if (this.cabeza == null) {
            return false;
        }
        Node actual = this.cabeza;
        do {
            if (actual.dato == object || (actual.dato != null && actual.dato.equals(object))) {
                return true;
            }
            actual = actual.siguiente;
        } while (actual != cabeza);
        return false;
    }

    // 16
    public Object[] toArray() {
        if (this.cabeza == null) return new Object[0];

        Node iterador = this.cabeza;
        int contador = 0;
        do {
            iterador = iterador.siguiente;
            contador++;
        } while (iterador != cabeza);

        Object[] arreglo = new Object[contador];
        int i = 0;
        iterador = this.cabeza;
        do {
            arreglo[i] = iterador.dato;
            iterador = iterador.siguiente;
            i++;
        } while (iterador != cabeza);
        return arreglo;
    }

    // 17
    public Object[] toArray(Object[] object) {
        if (this.cabeza == null) {
            return object;
        }

        int tamaño = 0;
        Node iterador = this.cabeza;
        do {
            tamaño++;
            iterador = iterador.siguiente;
        } while (iterador != this.cabeza);

        Object[] resultado = object;
        if (object == null || object.length < tamaño) {
            resultado = new Object[tamaño];
        }

        iterador = this.cabeza;
        int i = 0;
        do {
            resultado[i] = iterador.dato;
            iterador = iterador.siguiente;
            i++;
        } while (iterador != this.cabeza);

        // 4. Marca opcional de finalización si el arreglo era más grande que la lista
        if (resultado.length > tamaño) {
            resultado[tamaño] = null;
        }
        return resultado;
    }

    // 18
    public MiListaCircular subList(Node from, Node to) {
        MiListaCircular newList = new MiListaCircular();
        if (this.cabeza == null || from == null || to == null) {
            return newList;
        }

        Node actual = this.cabeza;
        do {
            if (actual == from) break;
            actual = actual.siguiente;
        } while (actual != cabeza);

        if (actual != from) {
            return newList;
        }

        boolean finAlcanzado = false;

        do {
            newList.add(actual.dato);
            if (actual == to) {
                finAlcanzado = true;
                break;
            }
            actual = actual.siguiente;
        } while (actual != from);

        if (!finAlcanzado) {
            return new MiListaCircular();
        }
        return newList;
    }

    // 19
    public MiListaCircular sortList() {
        if (this.cabeza == null || this.cabeza.siguiente == this.cabeza) {
            return this;
        }
        Object[] arreglo = this.toArray();

        Arrays.sort(arreglo);
        Node actual = this.cabeza;
        int i = 0;
        do {
            actual.dato = arreglo[i];
            i++;
            actual = actual.siguiente;
        } while (actual != cabeza);
        return this;
    }

}
