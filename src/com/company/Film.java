package com.company;

import java.util.List;

public class Film {
    private final int id;
    private final String tytul;
    private final int rok_produkcji;
    private final Reżyser rezyser;
    private final Scenarzysta scenarzysta;
    private final List<Aktor> listaAktorow;

    public Film(int id, String tutul, int rok_produkcji, Reżyser reżyser, Scenarzysta scenarzysta, List<Aktor> aktors) {
        this.id = id;
        this.tytul = tutul;
        this.rok_produkcji = rok_produkcji;
        this.rezyser = reżyser;
        this.scenarzysta = scenarzysta;
        listaAktorow = aktors;
    }

    @Override
    public String toString() {
        return "Film{" +
                "tytul='" + tytul + '\'' +
                ", rok_produkcji=" + rok_produkcji +
                ", rezyser=" + rezyser +
                ", scenarzysta=" + scenarzysta +
                ", listaAktorow=" + listaAktorow +
                '}';
    }

    public int getID() {
        return id;
    }
}
