import java.util.Scanner;
import ohtu.Multiplier;

public class Main {
    public static void main(String[] args) {
	Scanner s = new Scanner(System.in);		
	System.out.print("Who are you? ");
	String nimi = s.nextLine();
	System.out.println("Now, I am become " + nimi 
					+", destroyer of the Worlds!");
	Multiplier nolla = new Multiplier(0);
	System.out.print("Gimme a number! ");
	int luku = s.nextInt();
	System.out.println("Given number multiplied by zero is " + 
					nolla.multipliedBy(luku) + "!");
    }
}
