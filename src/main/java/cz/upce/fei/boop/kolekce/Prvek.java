package cz.upce.fei.boop.kolekce;

public class Prvek<E> {
    public E data;
    public Prvek<E> dalsiPrvek;

    public Prvek(E data) {
        this.data = data;
        this.dalsiPrvek = null;
    }
}
