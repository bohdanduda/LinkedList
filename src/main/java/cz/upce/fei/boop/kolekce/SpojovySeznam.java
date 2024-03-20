package cz.upce.fei.boop.kolekce;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class SpojovySeznam<E> implements Seznam<E> {
    private Prvek<E> prvniPrvek;
    private Prvek<E> aktualniPrvek;
    private Prvek<E> posledniPrvek;
    private int velikost;

    private static final String SEZNAM_JE_PRAZDNY_ERROR_MSG = "Seznam je prázdný!";
    private static final String DALSI_PRVEK_NEEXISTUJE_ERROR_MSG = "Další prvek neexistuje!";
    private static final String PRVEK_MA_HODNOTU_NULL_ERROR_MSG = "Prvek nesmí mít hodnotu null!";
    private static final String AKTUALNI_PRVEK_MA_HODNOTU_NULL_ERROR_MSG = "Aktuální prvek nesmí mít hodnotu null!";

    public E getGadzo() {
        return this.posledniPrvek.data;
    }

    private static class Prvek<E> {
        public E data;
        public Prvek<E> dalsiPrvek;

        public Prvek(E data) {
            this.data = data;
            this.dalsiPrvek = null;
        }
    }

    @Override
    public void nastavPrvni() throws KolekceException {
        this.zvalidujZdaNeniSeznamPrazdny();

        this.aktualniPrvek = this.prvniPrvek;
    }

    @Override
    public void nastavPosledni() throws KolekceException {
        this.zvalidujZdaNeniSeznamPrazdny();

        this.nastavHodnotuPoslednimuPrvku();
        this.aktualniPrvek = this.posledniPrvek;
    }

    @Override
    public void dalsi() throws KolekceException {
        this.zvalidujHodnotuAktualnihoPrvku();
        this.zvalidujExistenciDalsihoPrvku();

        this.aktualniPrvek = this.aktualniPrvek.dalsiPrvek;
    }

    @Override
    public boolean jeDalsi() throws KolekceException {
        this.zvalidujHodnotuAktualnihoPrvku();

        return this.aktualniPrvek.dalsiPrvek != null;
    }

    @Override
    public void vlozPrvni(E data) {
        Prvek<E> novyPrvek = new Prvek<>(data);
        this.zvalidujHodnotuPrvku(novyPrvek);

        Prvek<E> docasnyPrvek = this.prvniPrvek;

        this.prvniPrvek = novyPrvek;
        novyPrvek.dalsiPrvek = docasnyPrvek;

        this.velikost++;
    }

    @Override
    public void vlozPosledni(E data) {
        Prvek<E> novyPrvek = new Prvek<>(data);
        this.zvalidujHodnotuPrvku(novyPrvek);

        if (this.jeSeznamPrazdny()) {
            this.prvniPrvek = novyPrvek;
            this.velikost++;

            return;
        }

        this.nastavHodnotuPoslednimuPrvku();

        this.posledniPrvek.dalsiPrvek = novyPrvek;
        this.velikost++;

        this.posledniPrvek = this.posledniPrvek.dalsiPrvek;
    }

    @Override
    public void vlozZaAktualni(E data) throws KolekceException {
        this.zvalidujZdaNeniSeznamPrazdny();
        this.zvalidujHodnotuAktualnihoPrvku();

        Prvek<E> novyPrvek = new Prvek<>(data);
        this.zvalidujHodnotuPrvku(novyPrvek);

        novyPrvek.dalsiPrvek = aktualniPrvek.dalsiPrvek;
        this.aktualniPrvek.dalsiPrvek = novyPrvek;

        this.velikost++;
    }

    @Override
    public boolean jePrazdny() {
        return this.velikost == 0;
    }

    @Override
    public E dejPrvni() throws KolekceException {
        this.zvalidujZdaNeniSeznamPrazdny();

        return prvniPrvek.data;
    }

    @Override
    public E dejPosledni() throws KolekceException {
        this.zvalidujZdaNeniSeznamPrazdny();

        this.nastavHodnotuPoslednimuPrvku();

        return this.posledniPrvek.data;
    }

    @Override
    public E dejAktualni() throws KolekceException {
        this.zvalidujZdaNeniSeznamPrazdny();
        this.zvalidujHodnotuAktualnihoPrvku();

        return aktualniPrvek.data;
    }

    @Override
    public E dejZaAktualnim() throws KolekceException {
        this.zvalidujZdaNeniSeznamPrazdny();
        this.zvalidujHodnotuAktualnihoPrvku();
        this.zvalidujExistenciDalsihoPrvku();

        return aktualniPrvek.dalsiPrvek.data;
    }

    @Override
    public E odeberPrvni() throws KolekceException {
        this.zvalidujZdaNeniSeznamPrazdny();

        E odebranyPrvek = prvniPrvek.data;
        this.prvniPrvek = prvniPrvek.dalsiPrvek;
        this.velikost--;

        return odebranyPrvek;
    }

    @Override
    public E odeberPosledni() throws KolekceException {
        this.zvalidujZdaNeniSeznamPrazdny();

        this.nastavHodnotuPoslednimuPrvku();

        Prvek<E> odebranyPrvek = this.posledniPrvek;

        if (this.posledniPrvek == this.aktualniPrvek) {
            this.aktualniPrvek = null;
        }

        this.posledniPrvek = this.najdiPredchoziPrvek(this.posledniPrvek);

        return odebranyPrvek.data;
    }

    @Override
    public E odeberAktualni() throws KolekceException {
        this.zvalidujZdaNeniSeznamPrazdny();
        this.zvalidujHodnotuAktualnihoPrvku();

        Prvek<E> odebranyPrvek = this.aktualniPrvek;

        if (this.aktualniPrvek == this.prvniPrvek) {
            this.prvniPrvek = this.prvniPrvek.dalsiPrvek;
            this.aktualniPrvek = this.prvniPrvek;
        } else {
            Prvek<E> prvekPredAktualnim = najdiPredchoziPrvek(aktualniPrvek);
            prvekPredAktualnim.dalsiPrvek = this.aktualniPrvek.dalsiPrvek;
            this.aktualniPrvek = prvekPredAktualnim;
        }

        this.aktualniPrvek = null;
        this.velikost--;

        return odebranyPrvek.data;
    }

    @Override
    public E odeberZaAktualnim() throws KolekceException {
        this.zvalidujZdaNeniSeznamPrazdny();
        this.zvalidujHodnotuAktualnihoPrvku();
        this.zvalidujExistenciDalsihoPrvku();

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
        this.prvniPrvek = null;
        this.posledniPrvek = null;
        this.aktualniPrvek = null;
        this.velikost = 0;
    }

    @Override
    public Iterator<E> iterator() {
        return new LinkedListIterator();
    }

    private boolean jeSeznamPrazdny() {
        return velikost == 0;
    }

    private Prvek<E> najdiPredchoziPrvek(Prvek<E> hledanyPrvek) {
        Prvek<E> aktualniPrvek = this.prvniPrvek;
        Prvek<E> predchoziPrvek = null;

        while (aktualniPrvek != null && aktualniPrvek != hledanyPrvek) {
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

    private void nastavHodnotuPoslednimuPrvku() {
        if (this.posledniPrvek != null && posledniPrvek.dalsiPrvek == null) {
            return;
        }

        if (this.posledniPrvek == null) {
            this.posledniPrvek = prvniPrvek;

            while (this.posledniPrvek.dalsiPrvek != null) {
                this.posledniPrvek = this.posledniPrvek.dalsiPrvek;
            }

            return;
        }

        while (this.posledniPrvek.dalsiPrvek != null) {
            this.posledniPrvek = this.posledniPrvek.dalsiPrvek;
        }
    }

    private void zvalidujZdaNeniSeznamPrazdny() throws KolekceException {
        if (this.jeSeznamPrazdny()) {
            throw new KolekceException(SEZNAM_JE_PRAZDNY_ERROR_MSG);
        }
    }

    private void zvalidujExistenciDalsihoPrvku() throws KolekceException {
        if (!this.jeDalsi()) {
            throw new KolekceException(DALSI_PRVEK_NEEXISTUJE_ERROR_MSG);
        }
    }

    private void zvalidujHodnotuPrvku(Prvek<E> prvek) throws NullPointerException {
        if (prvek == null) {
            throw new NullPointerException(PRVEK_MA_HODNOTU_NULL_ERROR_MSG);
        }
    }

    private void zvalidujHodnotuAktualnihoPrvku() throws KolekceException {
        if (this.aktualniPrvek == null) {
            throw new KolekceException(AKTUALNI_PRVEK_MA_HODNOTU_NULL_ERROR_MSG);
        }
    }
}
