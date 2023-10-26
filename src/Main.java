import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws FileNotFoundException {
        SpellChecker spellChecker = new SpellChecker();
        spellChecker.load("dictionaries/most_common.txt");
    	Scanner in = new Scanner (System.in);

    	while (true) {
            System.out.print("Enter a word here: ");
            String word = in.nextLine();
            System.out.println("Did you mean one of these?");
            spellChecker.suggest(word);
            System.out.println("----");
        }
    }
}