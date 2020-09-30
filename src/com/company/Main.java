package com.company;

import javax.swing.*;
import java.io.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;
//import java.util.UUID;

public class Main extends JFrame {

    public static void main(String[] args) {
//        Osoba osoba = new Osoba("Adam", "Jakiś");
        Reżyser reżyser = new Reżyser("Adam", "Hoffman");
        System.out.println(reżyser);

        List<Aktor> aktor = new ArrayList<>();
        aktor.add(new Aktor("Sylvester", "Stalone", 53));
        aktor.add(new Aktor("Arnold", "Scharceneger"));
        aktor.add(new Aktor("Jean-Claude", "VanDamme"));
        aktor.add(new Aktor("Chuck", "Norris"));
        aktor.add(new Aktor("Steven", "Sigal"));
        System.out.println(aktor.get(1).toString());
        System.out.println(aktor.get(2));
        for (Aktor a:aktor)
            System.out.println(Integer.toHexString(a.hashCode()) );
//        UUID u = new UUID();

        Scenarzysta scenarzysta = new Scenarzysta("scenarzysta", "pierwszy");
        System.out.println(scenarzysta);

        List<Aktor> obsada = new ArrayList<>();
        obsada.add(aktor.get(1));
        obsada.add(aktor.get(2));

        Film film1 = new Film(12,"tytuł", 2010, reżyser, scenarzysta, obsada);

        Wypożyczenie wyp1 = new Wypożyczenie(film1, new Klient( 3, "Gurek", "Kowalski"), new Date(), new Date());
        Wypożyczenie wyp2 = new Wypożyczenie(film1, new Klient( 4, "Gurek", "Kowalski"), new Date(), null);

        // czy do wyprzyczeń zastosować tablicę? czy może listę?
        Wypożyczenie wyporzyczenia[] = new Wypożyczenie[200];
        wyporzyczenia[0] = wyp1;
        wyporzyczenia[1] = wyp2;
        System.out.println(wyporzyczenia[1]);

        // Persystencja
//        obsługaPliku(wyp1);
//        obsługaPliku(wyp2);
        zapisAktorów(aktor);
        zapisWyporzyczeń(wyporzyczenia);

        odczytAktorów();

        Main m = new Main();
        m.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        m.setSize(400, 300);
        m.setTitle("Project");
        m.setVisible(true);

    }

    private static void odczytAktorów() {
    /*    try {
            FileReader file = new FileReader("aktors.txt");
            file.read();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }*/
        try {
            FileInputStream fis = new FileInputStream("aktors.txt");
            Scanner scanner = new Scanner(fis);
            Aktor newAktor;
            List<Aktor> aktor = new ArrayList<>();

            while (scanner.hasNext()) {
                System.out.println(scanner.nextInt());
//                System.out.println(scanner.next());
//                System.out.println(scanner.next());
//                System.out.println(scanner.nextInt());

                newAktor = new Aktor(scanner.next(), scanner.next(), scanner.nextInt() );
                aktor.add(newAktor);
                System.out.println(newAktor.String());
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    private static void zapisWyporzyczeń(Wypożyczenie[] wyporzyczenia) {
        try {
            FileWriter file = new FileWriter("wyporzyczenia.txt");
            for (int i = 0; i < wyporzyczenia.length; i++)
                if (wyporzyczenia[i] != null)
                    file.write(i + wyporzyczenia[i].String());
            file.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void zapisAktorów(List<Aktor> aktor) {
        try {
            FileWriter file = new FileWriter("aktors.txt");
//            file.write(String.valueOf(aktor));        //  1'st method
//            for (Aktor a:aktor)                       //  2,nd method
//                file.write(String.valueOf(a) + "\n");
            for (int i = 0; i < aktor.size(); i++)
                file.write(i + aktor.get(i).String());
            file.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void obsługaPliku(Wypożyczenie wyp) {
        try {
            FileWriter file = new FileWriter("file.txt", true);
//            file.write("test zapisu\n");
//            file.write(String.valueOf(reżyser));
            file.write(String.valueOf(wyp) + '\n');
            file.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

//  GUI? Swing(?)
//  formatki:
//  - dodania wyporzyczenia
//  - dodania nowego filmu
//  - dodania nowego: rerzysera, scenarzysty, aktora, klienta
//  Jak ma być realizowana persystencja? plik? napewno nie DB!
//  Czego urzyć jako identyfikatory? hashCode (?), GUID (?), własne Id (?)

//  Skaruz: czego urzyć jako identyfikator obiektu przy zapisie do pliku?
//  chodzi o wyporzyczenia, filmy, osoby, etc.
//  nie możemy explicite zapisywać obiektów jako String

//  1. jakaś logika
//  2. persystencja (obsługa plików)
//  3. GUI (Swing)