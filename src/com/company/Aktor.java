package com.company;

public class Aktor extends Osoba {
    private int wiek;

    public Aktor(String imię, String nazwisko) {
        super(imię, nazwisko);
    }

    public Aktor(String imię, String nazwisko, int w) {
        super(imię, nazwisko);
        wiek = w;
    }

    @Override
    public String toString() {
        return super.toString() + ", wiek=" + wiek;
    }

    public String String() {
        return " " + imię + ' ' + nazwisko + ' ' + wiek + '\n';
    }
}
