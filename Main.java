void main() {
    MiListaCircular lista = new MiListaCircular();

    System.out.println("isEmpty(): " + lista.isEmpty());
    System.out.println("getSize(): " + lista.getSize());

    System.out.println("\n--- INSERCIONES ---");
    System.out.println("add(20): " + lista.add(20));
    System.out.println("insertHead(10): " + lista.insertHead(10));
    System.out.println("insertTail(40): " + lista.insertTail(40));

    Node n10 = lista.search(10);
    System.out.println("insert(Node n10, 15): " + lista.insert(n10, 15));

    System.out.println("insert(ObjectRef 20, 30): " + lista.insert(20, 30));

    System.out.println("\n--- ESTADO Y CONSULTAS ---");
    System.out.println("isEmpty(): " + lista.isEmpty());
    System.out.println("getSize(): " + lista.getSize());
    System.out.println("getHead(): " + lista.getHead());
    System.out.println("getTail(): " + lista.getTail());

    Node n20 = lista.search(20);
    System.out.println("search(20) encontrado: " + (n20 != null));
    System.out.println("get(Node n20): " + lista.get(n20));
    System.out.println("contains(30): " + lista.contains(30));
    System.out.println("contains(99): " + lista.contains(99));

    System.out.println("\n--- MODIFICACIÓN Y REMOCIÓN ---");
    Node n30 = lista.search(30);
    System.out.println("set(Node n30, 35): " + lista.set(n30, 35));
    System.out.println("get(Node n30): " + lista.get(n30));

    Node n15 = lista.search(15);
    System.out.println("remove(Node n15): " + lista.remove(n15));

    System.out.println("\n--- EXPANSIÓN: ARREGLOS Y SUBLISTA ---");
    System.out.print("toArray(): ");
    for (Object e : lista.toArray()) {
        System.out.print(e + " ");
    }
    System.out.println();

    Object[] miArreglo = new Object[lista.getSize()];
    Object[] resToArr = lista.toArray(miArreglo);
    System.out.println("toArray(Object[]) longitud: " + resToArr.length);

    Node inicio = lista.search(10);
    Node fin = lista.search(35);
    MiListaCircular sub = lista.subList(inicio, fin);
    System.out.print("subList(10, 35): ");
    for (Object e : sub.toArray()) {
        System.out.print(e + " ");
    }
    System.out.println();

    System.out.println("\n--- ORDENAMIENTO ---");
    lista.sortList();
    System.out.print("sortList(): ");
    for (Object e : lista.toArray()) {
        System.out.print(e + " ");
    }
    System.out.println();

    System.out.println("\n--- LIMPIEZA ---");
    lista.clear();
    System.out.println("clear() ejecutado.");
    System.out.println("isEmpty(): " + lista.isEmpty());
    System.out.println("getSize(): " + lista.getSize());

}