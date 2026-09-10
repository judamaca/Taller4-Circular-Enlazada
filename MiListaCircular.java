import java.util.Arrays;

public class MiListaCircular implements ListInterface {
    Node cabeza;

    // 1
    @Override
    public boolean isEmpty() {
        return this.cabeza == null;
    }

    // 2
    @Override
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
    @Override
    public void clear() {
        this.cabeza = null;
        return;
    }

    // 4
    @Override
    public Object getHead() {
        if (this.cabeza == null) {
            return null;
        }
        return this.cabeza.dato;
    }

    // 5
    @Override
    public Object getTail() {
        if (this.cabeza == null) return null;
        Node iterador = this.cabeza;
        while (iterador.siguiente != null && iterador.siguiente != cabeza) {
            iterador = iterador.siguiente;
        }
        if (iterador == null) return null;
        return iterador.dato;
    }

    // 6
    @Override
    public Object get(Node node) {
        if (this.cabeza == null || node == null) {
            return null;
        }
        return node.dato;
    }

    // 7
    @Override
    public Node search(Object object) {
        if (cabeza == null) return null;
        Node actual = this.cabeza;
        do {
            if (actual == null) return null;
            if (actual.dato == null ? object == null : actual.dato.equals(object)) {
                return actual;
            }
            actual = actual.siguiente;
        } while (actual != cabeza && actual != null);
        return null;
    }

    // 8
    @Override
    public boolean add(Object object) {
        Node newNode = new Node(object);
        if (this.cabeza == null) {
            newNode.siguiente = newNode;
            this.cabeza = newNode;
            return true;
        }
        Node iterador = this.cabeza;
        while (iterador.siguiente != null && iterador.siguiente != cabeza) {
            iterador = iterador.siguiente;
        }
        if (iterador == null) {
            return false;
        }
        iterador.siguiente = newNode;
        newNode.siguiente = cabeza;
        return true;
    }

    // 9
    @Override
    public boolean insert(Node node, Object object) {
        if (this.cabeza == null || node == null) {
            return false;
        }
        Node newNode = new Node(object);
        newNode.siguiente = node.siguiente;
        node.siguiente = newNode;
        return true;
    }

    // 10
    @Override
    public boolean insert(Object objectRef, Object object) {
        if (this.cabeza == null) {
            return false;
        }
        Node actual = this.cabeza;
        do {
            if (actual == null) return false;
            if (actual.dato != null && actual.dato.equals(objectRef)) {
                Node newNode = new Node(object);
                newNode.siguiente = actual.siguiente;
                actual.siguiente = newNode;
                return true;
            }
            actual = actual.siguiente;
        } while (actual != cabeza && actual != null);
        return false;
    }

    // 11
    @Override
    public boolean insertHead(Object object) {
        Node nuevaCabeza = new Node(object);

        if (this.cabeza != null) {
            Node iterador = this.cabeza;
            while (iterador != null && iterador.siguiente != null && iterador.siguiente != cabeza) {
                iterador = iterador.siguiente;
            }
            if (iterador == null) {
                return false;
            }
            nuevaCabeza.siguiente = cabeza;
            iterador.siguiente = nuevaCabeza;
            this.cabeza = nuevaCabeza;
            return true;
        }
        nuevaCabeza.siguiente = nuevaCabeza;
        this.cabeza = nuevaCabeza;
        return true;
    }


    // 12
    @Override
    public boolean insertTail(Object object) {
        Node nuevaCabeza = new Node(object);
        if (this.cabeza != null) {
            Node iterador = this.cabeza;
            while (iterador != null && iterador.siguiente != null && iterador.siguiente != cabeza) {
                iterador = iterador.siguiente;
            }
            if (iterador == null) {
                return false;
            }
            nuevaCabeza.siguiente = cabeza;
            iterador.siguiente = nuevaCabeza;
            return true;
        }
        nuevaCabeza.siguiente = nuevaCabeza;
        this.cabeza = nuevaCabeza;
        return true;
    }

    // 13
    @Override
    public boolean set(Node node, Object object) {
        if (this.cabeza == null || node == null) {
            return false;
        }
        Node actual = this.cabeza;
        do {
            if (actual == null) return false;
            if (actual == node) {
                actual.dato = object;
                return true;
            }
            actual = actual.siguiente;
        } while (actual != cabeza && actual != null);
        return false;
    }

    // 14
    @Override
    public boolean remove(Node node) {
        if (this.cabeza == null || node == null) {
            return false;
        }

        if (this.cabeza.siguiente == this.cabeza) {
            this.cabeza = null;
            return true;
        }

        Node actual = this.cabeza;
        Node anterior = null;

        do {
            if (actual == null) return false;
            if (actual == node) {
                if (actual == this.cabeza) {
                    Node iterador = this.cabeza;
                    while (iterador != null && iterador.siguiente != null && iterador.siguiente != cabeza) {
                        iterador = iterador.siguiente;
                    }
                    if (iterador == null) {
                        return false;
                    }
                    this.cabeza = actual.siguiente;
                    iterador.siguiente = this.cabeza;
                } else {
                    anterior.siguiente = actual.siguiente;
                }
                return true;
            }
            anterior = actual;
            actual = actual.siguiente;
        } while (actual != cabeza && actual != null);
        return false;

    }

    // 15
    @Override
    public boolean contains(Object object) {
        if (this.cabeza == null) {
            return false;
        }
        Node actual = this.cabeza;
        do {
            if (actual == null) return false;
            if (actual.dato == object || (actual.dato != null && actual.dato.equals(object))) {
                return true;
            }
            actual = actual.siguiente;
        } while (actual != cabeza && actual != null);
        return false;
    }

    // 16
    @Override
    public Object[] toArray() {
        if (this.cabeza == null) return new Object[0];

        Node iterador = this.cabeza;
        int contador = 0;
        do {
            if (iterador == null) return new Object[0];
            iterador = iterador.siguiente;
            contador++;
        } while (iterador != cabeza && iterador != null);

        Object[] arreglo = new Object[contador];
        int i = 0;
        iterador = this.cabeza;
        do {
            if (iterador == null) break;
            arreglo[i] = iterador.dato;
            iterador = iterador.siguiente;
            i++;
        } while (iterador != cabeza && iterador != null);
        return arreglo;
    }

    // 17
    @Override
    public Object[] toArray(Object[] object) {
        if (this.cabeza == null) {
            return object;
        }

        int tamaño = 0;
        Node iterador = this.cabeza;
        do {
            if (iterador == null) return object;
            tamaño++;
            iterador = iterador.siguiente;
        } while (iterador != this.cabeza && iterador != null);

        Object[] resultado = object;
        if (object == null || object.length < tamaño) {
            resultado = new Object[tamaño];
        }

        iterador = this.cabeza;
        int i = 0;
        do {
            if (iterador == null) break;
            resultado[i] = iterador.dato;
            iterador = iterador.siguiente;
            i++;
        } while (iterador != this.cabeza && iterador != null);

        // 4. Marca opcional de finalización si el arreglo era más grande que la lista
        if (resultado.length > tamaño) {
            resultado[tamaño] = null;
        }
        return resultado;
    }

    // 18
    @Override
    public MiListaCircular subList(Node from, Node to) {
        MiListaCircular newList = new MiListaCircular();
        if (this.cabeza == null || from == null || to == null) {
            return newList;
        }

        Node actual = this.cabeza;
        do {
            if (actual == null) return newList;
            if (actual == from) break;
            actual = actual.siguiente;
        } while (actual != cabeza);

        if (actual != from) {
            return newList;
        }

        boolean finAlcanzado = false;

        do {
            if (actual == null) return newList;
            newList.add(actual.dato);
            if (actual == to) {
                finAlcanzado = true;
                break;
            }
            actual = actual.siguiente;
        } while (actual != from && actual != null);

        if (!finAlcanzado) {
            return new MiListaCircular();
        }
        return newList;
    }

    // 19
    @Override
    public MiListaCircular sortList() {
        if (this.cabeza == null || this.cabeza.siguiente == this.cabeza) {
            return this;
        }
        Object[] arreglo = this.toArray();

        Arrays.sort(arreglo);
        Node actual = this.cabeza;
        int i = 0;
        do {
            if (actual == null) return this;
            actual.dato = arreglo[i];
            i++;
            actual = actual.siguiente;
        } while (actual != cabeza && actual != null);
        return this;
    }

}
