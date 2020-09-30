package com.company;

import java.util.Date;

public class Wypożyczenie {
    private final Film film ;
    private final Klient klient;
    private final Date dataWyp;
    private final Date dataZwr;

    public Wypożyczenie(Film film, Klient klient, Date dataWyporzyczenia, Date dataZwrotu) {
        this.film = film;
        this.klient = klient;
        dataWyp = dataWyporzyczenia;
        dataZwr = dataZwrotu;
    }

    @Override
    public String toString() {
        return "Wypożyczenie{" +
                "film=" + film +
                ", klient=" + klient +
                ", dataWyp=" + dataWyp +
                ", dataZwr=" + dataZwr +
                '}';
    }

    public String String() {
        return " " + film.getID() + ' ' + klient.getID() + ' ' + dataWyp + ' ' + dataZwr + '\n';
    }
}
