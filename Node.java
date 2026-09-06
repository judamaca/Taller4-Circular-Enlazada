public class Node {
    Node anterior;
    Object dato;
    Node siguiente;

    public Node(Object dato) {
        this.anterior = null;
        this.dato = dato;
        this.siguiente = null;
    }
}