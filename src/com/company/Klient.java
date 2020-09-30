package com.company;

public class Klient extends Osoba {
    private final int id;

    public Klient(int id, String imię, String nazwisko) {

        super(imię, nazwisko);
        this.id = id;
    }

    public int getID() {
        return id;
    }
}
