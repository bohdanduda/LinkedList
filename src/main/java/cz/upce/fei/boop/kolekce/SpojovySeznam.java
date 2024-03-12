package cz.upce.fei.boop.kolekce;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class SpojovySeznam<E> implements Seznam<E> {
    private Prvek<E> prvniPrvek;
    private Prvek<E> aktualniPrvek;
    private int velikost;

    @Override
    public void nastavPrvni() throws KolekceException {
        ValidaceSeznamu.zvalidujDelku(this.jePrazdny());

        this.aktualniPrvek = this.prvniPrvek;
    }

    @Override
    public void nastavPosledni() throws KolekceException {
        ValidaceSeznamu.zvalidujDelku(this.jePrazdny());

        Prvek<E> posledniPrvek = this.prvniPrvek;
        while (posledniPrvek.dalsiPrvek != null) {
            posledniPrvek = posledniPrvek.dalsiPrvek;
        }

        this.aktualniPrvek = posledniPrvek;
    }

    @Override
    public void dalsi() throws KolekceException {
        ValidaceSeznamu.zvalidujExistenciDalsihoPrvku(this.jeDalsi());

        this.aktualniPrvek = this.aktualniPrvek.dalsiPrvek;
    }

    @Override
    public boolean jeDalsi() {
        return this.aktualniPrvek == null || this.aktualniPrvek.dalsiPrvek != null;
    }

    @Override
    public void vlozPrvni(E data) {
        Prvek<E> novyPrvek = new Prvek<>(data);

        novyPrvek.dalsiPrvek = this.prvniPrvek;
        this.prvniPrvek = novyPrvek;

        velikost++;
    }

    @Override
    public void vlozPosledni(E data) {
        Prvek<E> novyPrvek = new Prvek<>(data);

        if (this.jeSeznamPrazdny()) {
            this.prvniPrvek = novyPrvek;
            velikost++;
        } else {
            Prvek<E> dosavadniPosledniPrvek = this.prvniPrvek;

            while (dosavadniPosledniPrvek.dalsiPrvek != null) {
                dosavadniPosledniPrvek = dosavadniPosledniPrvek.dalsiPrvek;
            }

            dosavadniPosledniPrvek.dalsiPrvek = novyPrvek;
            velikost++;
        }
    }

    @Override
    public void vlozZaAktualni(E data) throws KolekceException {
        ValidaceSeznamu.zvalidujDelku(this.jePrazdny());

        Prvek<E> novyPrvek = new Prvek<>(data);

        novyPrvek.dalsiPrvek = aktualniPrvek.dalsiPrvek;
        aktualniPrvek.dalsiPrvek = novyPrvek;

        velikost++;
    }

    @Override
    public boolean jePrazdny() {
        return velikost == 0;
    }

    @Override
    public E dejPrvni() throws KolekceException {
        ValidaceSeznamu.zvalidujDelku(this.jePrazdny());

        return prvniPrvek.data;
    }

    @Override
    public E dejPosledni() throws KolekceException {
        ValidaceSeznamu.zvalidujDelku(this.jePrazdny());

        Prvek<E> posledni = this.prvniPrvek;
        while (posledni.dalsiPrvek != null) {
            posledni = posledni.dalsiPrvek;
        }

        return posledni.data;
    }

    @Override
    public E dejAktualni() throws KolekceException {
        ValidaceSeznamu.zvalidujDelku(this.jePrazdny());

        return aktualniPrvek.data;
    }

    @Override
    public E dejZaAktualnim() throws KolekceException {
        ValidaceSeznamu.zvalidujDelku(this.jePrazdny());
        ValidaceSeznamu.zvalidujExistenciDalsihoPrvku(this.jeDalsi());

        return aktualniPrvek.dalsiPrvek.data;
    }

    @Override
    public E odeberPrvni() throws KolekceException {
        ValidaceSeznamu.zvalidujDelku(this.jePrazdny());

        E odebranyPrvek = prvniPrvek.data;
        prvniPrvek = prvniPrvek.dalsiPrvek;
        velikost--;
        return odebranyPrvek;
    }

    @Override
    public E odeberPosledni() throws KolekceException {
        ValidaceSeznamu.zvalidujDelku(this.jePrazdny());

        Prvek<E> aktualniPrvek = this.prvniPrvek;
        Prvek<E> prvekPredAktualnim = null;

        while (aktualniPrvek.dalsiPrvek != null) {
            prvekPredAktualnim = aktualniPrvek;
            aktualniPrvek = aktualniPrvek.dalsiPrvek;
        }

        E odebranyPrvek = aktualniPrvek.data;

        if (prvekPredAktualnim == null) {
            this.prvniPrvek = null;
            this.aktualniPrvek = null;
        } else {
            prvekPredAktualnim.dalsiPrvek = null;
            this.aktualniPrvek = prvekPredAktualnim;
        }

        this.velikost--;
        return odebranyPrvek;
    }

    @Override
    public E odeberAktualni() throws KolekceException {
        ValidaceSeznamu.zvalidujDelku(this.jePrazdny());

        E odebranyPrvek = this.aktualniPrvek.data;

        if (this.aktualniPrvek == this.prvniPrvek) {
            this.prvniPrvek = this.prvniPrvek.dalsiPrvek;
            this.aktualniPrvek = this.prvniPrvek;
        } else {
            Prvek<E> prvekPredAktualnim = najdiPredchoziPrvek(aktualniPrvek);
            prvekPredAktualnim.dalsiPrvek = this.aktualniPrvek.dalsiPrvek;
            this.aktualniPrvek = prvekPredAktualnim;
        }

        this.velikost--;

        return odebranyPrvek;
    }

    @Override
    public E odeberZaAktualnim() throws KolekceException {
        ValidaceSeznamu.zvalidujDelku(this.jePrazdny());
        ValidaceSeznamu.zvalidujExistenciDalsihoPrvku(this.jeDalsi());

        E odebranyPrvek = aktualniPrvek.dalsiPrvek.data;

        this.aktualniPrvek.dalsiPrvek = this.aktualniPrvek.dalsiPrvek.dalsiPrvek;
        this.velikost--;

        return odebranyPrvek;
    }

    @Override
    public int size() {
        return velikost;
    }

    @Override
    public void zrus() {
        prvniPrvek = null;
        aktualniPrvek = null;
        velikost = 0;
    }

    @Override
    public Iterator<E> iterator() {
        return new LinkedListIterator();
    }

    private boolean jeSeznamPrazdny() {
        return velikost == 0;
    }

    private Prvek<E> najdiPredchoziPrvek(Prvek<E> target) {
        Prvek<E> aktualniPrvek = this.prvniPrvek;
        Prvek<E> predchoziPrvek = null;

        while (aktualniPrvek != null && aktualniPrvek != target) {
            predchoziPrvek = aktualniPrvek;
            aktualniPrvek = aktualniPrvek.dalsiPrvek;
        }

        return predchoziPrvek;
    }

    private class LinkedListIterator implements Iterator<E> {

        private Prvek<E> iteratorCurrent;

        LinkedListIterator() {
            iteratorCurrent = prvniPrvek;
        }

        @Override
        public boolean hasNext() {
            return iteratorCurrent != null;
        }

        @Override
        public E next() {
            if (!hasNext()) {
                throw new NoSuchElementException();
            }
            E data = iteratorCurrent.data;
            iteratorCurrent = iteratorCurrent.dalsiPrvek;
            return data;
        }
    }
}