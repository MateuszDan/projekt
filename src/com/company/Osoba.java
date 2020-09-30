package com.company;

public class Osoba {
    protected final String imię;
    protected final String nazwisko;

    public Osoba(String imię, String nazwisko) {
        this.imię = imię;
        this.nazwisko = nazwisko;
    }

    @Override
    public String toString() {
        return "imię='" + imię + "', nazwisko='" + nazwisko + '\'';
    }

}
