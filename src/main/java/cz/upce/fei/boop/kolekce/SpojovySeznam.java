package cz.upce.fei.boop.kolekce;

import java.util.Iterator;

public class SpojovySeznam implements Seznam{
    @Override
    public void nastavPrvni() throws KolekceException {

    }

    @Override
    public void nastavPosledni() throws KolekceException {

    }

    @Override
    public void dalsi() throws KolekceException {

    }

    @Override
    public boolean jeDalsi() {
        return false;
    }

    @Override
    public void vlozPrvni(Object data) {

    }

    @Override
    public void vlozPosledni(Object data) {

    }

    @Override
    public void vlozZaAktualni(Object data) throws KolekceException {

    }

    @Override
    public boolean jePrazdny() {
        return false;
    }

    @Override
    public Object dejPrvni() throws KolekceException {
        return null;
    }

    @Override
    public Object dejPosledni() throws KolekceException {
        return null;
    }

    @Override
    public Object dejAktualni() throws KolekceException {
        return null;
    }

    @Override
    public Object dejZaAktualnim() throws KolekceException {
        return null;
    }

    @Override
    public Object odeberPrvni() throws KolekceException {
        return null;
    }

    @Override
    public Object odeberPosledni() throws KolekceException {
        return null;
    }

    @Override
    public Object odeberAktualni() throws KolekceException {
        return null;
    }

    @Override
    public Object odeberZaAktualnim() throws KolekceException {
        return null;
    }

    @Override
    public int size() {
        return 0;
    }

    @Override
    public void zrus() {

    }

    @Override
    public Iterator iterator() {
        return null;
    }
}
