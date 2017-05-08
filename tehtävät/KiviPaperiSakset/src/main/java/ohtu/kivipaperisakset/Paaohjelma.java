package ohtu.kivipaperisakset;

import java.util.Scanner;

public class Paaohjelma {

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        PeliTemplate peli;
        while (true) {
            System.out.println("\nValitse pelataanko"
                    + "\n (a) ihmistä vastaan "
                    + "\n (b) tekoälyä vastaan"
                    + "\n (c) parannettua tekoälyä vastaan"
                    + "\nmuilla valinnoilla lopetataan");

            String vastaus = scanner.nextLine();
            if (vastaus.endsWith("a")) {
                peliLoppuuTulostus();
                peli = new KPSPelaajaVsPelaaja(scanner);
                peli.pelaa();
            } else if (vastaus.endsWith("b")) {
                peliLoppuuTulostus();
                peli = new KPSTekoaly(scanner, new Tekoaly());
                peli.pelaa();
            } else if (vastaus.endsWith("c")) {
                peliLoppuuTulostus();
                peli = new KPSTekoaly(scanner, new TekoalyParannettu(20));
                peli.pelaa();
            } else {
                break;
            }
        }
    }

    private static void peliLoppuuTulostus() {
        System.out.println("peli loppuu kun pelaaja antaa virheellisen siirron eli jonkun muun kuin k, p tai s");
    }
}
