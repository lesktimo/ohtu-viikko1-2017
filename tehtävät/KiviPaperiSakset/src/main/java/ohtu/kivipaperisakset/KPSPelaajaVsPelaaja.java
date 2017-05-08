package ohtu.kivipaperisakset;

import java.util.Scanner;

public class KPSPelaajaVsPelaaja extends PeliTemplate {

    public KPSPelaajaVsPelaaja(Scanner s) {
        super(s);
    }

    public void pelaa() {
        System.out.print("Ensimmäisen pelaajan siirto: ");
        ekanSiirto = scanner.nextLine();
        System.out.print("Toisen pelaajan siirto: ");
        tokanSiirto = scanner.nextLine();
        while (onkoOkSiirto(ekanSiirto) && onkoOkSiirto(tokanSiirto)) {
            tuomari.kirjaaSiirto(ekanSiirto, tokanSiirto);
            System.out.println(tuomari);
            System.out.println();
            System.out.print("Ensimmäisen pelaajan siirto: ");
            ekanSiirto = scanner.nextLine();
            System.out.print("Toisen pelaajan siirto: ");
            tokanSiirto = scanner.nextLine();
        }
        System.out.println();
        System.out.println("Kiitos!");
        System.out.println(tuomari);
    }
}
