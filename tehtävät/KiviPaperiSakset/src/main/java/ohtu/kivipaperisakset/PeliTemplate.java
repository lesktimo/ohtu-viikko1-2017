package ohtu.kivipaperisakset;

import java.util.Scanner;

public abstract class PeliTemplate {

    protected static Scanner scanner;
    protected static Tuomari tuomari;
    protected String ekanSiirto;
    protected String tokanSiirto;

    public PeliTemplate(Scanner s) {
        tuomari = new Tuomari();
        scanner = s;
    }

    public abstract void pelaa();

    protected static boolean onkoOkSiirto(String siirto) {
        return "k".equals(siirto) || "p".equals(siirto) || "s".equals(siirto);
    }
}
