package ohtu.kivipaperisakset;

import java.util.Scanner;

public class KPSTekoaly extends PeliTemplate {

    private final Alypinta aly;

    public KPSTekoaly(Scanner s, Alypinta annettuAly) {
        super(s);
        aly = annettuAly;
    }

    public void pelaa() {
        System.out.print("Ensimmäisen pelaajan siirto: ");
        ekanSiirto = scanner.nextLine();
        tokanSiirto = aly.annaSiirto();
        System.out.println("Tietokone valitsi: " + tokanSiirto);
        while (onkoOkSiirto(ekanSiirto) && onkoOkSiirto(tokanSiirto)) {
            tuomari.kirjaaSiirto(ekanSiirto, tokanSiirto);
            System.out.println(tuomari);
            System.out.println();
            System.out.print("Ensimmäisen pelaajan siirto: ");
            ekanSiirto = scanner.nextLine();
            tokanSiirto = aly.annaSiirto();
            System.out.println("Tietokone valitsi: " + tokanSiirto);
            aly.asetaSiirto(ekanSiirto);
        }
        System.out.println();
        System.out.println("Kiitos!");
        System.out.println(tuomari);
    }
}
