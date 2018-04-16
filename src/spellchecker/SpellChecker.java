package spellchecker;

import java.util.Scanner;

import spellchecker.HashTable.ProbingType;

public class SpellChecker {
	public static void main(String[] args) {
		SpellChecker spellchecker = new SpellChecker();
		int InitialTablesize = 53;
		
		System.out.println("With 100 words");
		HashTable h1 = new HashTable(InitialTablesize, "list_1.txt", ProbingType.LINEAR);
		spellchecker.searchWord(h1);
		System.out.println("Program 1 exited\n\n");
		
		HashTable h2 = new HashTable(InitialTablesize, "list_1.txt", ProbingType.QUADRATIC);
		spellchecker.searchWord(h2);
		System.out.println("Program 2 exited\n\n");
		
		System.out.println("Adding 10 more words (110 words) ");
		HashTable h3 = new HashTable(InitialTablesize, "list_2.txt", ProbingType.LINEAR);
		spellchecker.searchWord(h3);
		System.out.println("Program 3 exited\n\n");
		
		HashTable h4 = new HashTable(InitialTablesize, "list_2.txt", ProbingType.QUADRATIC);
		spellchecker.searchWord(h4);
		System.out.println("Program 4 exited");
		System.out.println("All programs terminated");
	}
	public void searchWord(HashTable h) {
		Scanner input = new Scanner(System.in);
		String line;
		System.out.print("Enter word : (Enter \":q\" to terminate program) ");
		while ((line = input.nextLine()) != null) {
			System.out.println("");
			if (line.equals(":q") || line.equals(":Q")) {
				return;
			}
			h.spellcheck(line.toLowerCase());
			System.out.print("Enter word : (Enter \":q\" to terminate program) ");
		}
		input.close();
	}
}
