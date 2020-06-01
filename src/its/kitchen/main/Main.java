package its.kitchen.main;

import java.util.ArrayList;

import its.kitchen.ingredients.Ingredient;
import its.kitchen.io.Load;

public class Main {

	public static String data_version = null;
	public static String version = "0.1_testing";
	public static String dataPath = "ingredients.txt";
	
	public static ArrayList<Ingredient> ingerdients;
	
	public static int mode = 1;
	
	public static boolean verbose = false;
	
	public static void main(String[] args) {
		int i = 0;
		/**
		 * -f Specifies the data-file. If not present, look in current directory for ingredients.txt.
		 * -m Specifies the mode, this program should use.
		 * -v Specifies if the user wants more output.
		 * -s Specifies the maximum number of steps, the user wants to make.
		 * -i Specifies the maximum number of ingredients, the user wants to use.
		 * -h displays a help-page.
		 * */
		for (i = 0; i < args.length; i++) {
			if(args[i].equals("-h")) {
				
				System.out.println("Kitchen Bravery v." + version + " help.");
				System.out.printf ("%-2s %s\n", "-f", "Specifies the data-file. If not present, look in current directory for ingredients.txt.");
				System.out.printf ("%-2s %s\n", "-m", "Specifies the mode, this program should use.");
				System.out.printf ("%-2s %s\n", "-v", "Enables verbose output");
				System.out.printf ("%-2s %s\n", "-s", "How much steps you want to do at maximum.");
				System.out.printf ("%-2s %s\n", "-i", "How many ingredients you want to use.");
				System.out.printf ("%-2s %s\n", "-h", "Displays this help message.");
				
				System.exit(0);
			}
			else if(args[i].equals("-f")) {
				if(i+1 >= args.length) {
					System.err.println("No file specified!\n");
				}
				else {
					dataPath = args[i+1];
					i++;
				}
			}
			else if(args[i].equals("-m")) {
				if(i + 1 >= args.length) {
					System.err.println("No mode specified!\nUsing default.");
				}
				else {
					/*HIER CODE EINFÜGEN*/
				}
			}
			else if(args[i].equals("-v")) {
				verbose = true;
			}
			else if(args[i].equals("-s")) {
				if (i+1 >= args.length) {
					System.err.println("No number of steps specified!\nGoing with maximum 5 steps.");
				}
				else {
					/*HIER CODE EINFÜGEN*/
				}
			}
			System.out.println(args[i]);
		}
		ingerdients = Load.readIngredients(dataPath);
		for (i = 0; i < ingerdients.size(); i++) {
			ingerdients.get(i).displayIngredient();
		}
	}
	
	public static final int MODE_COMPLETELY_RANDOM = 0;
	public static final int MODE_PARAMETER_RANDOM  = 1;
	public static final int MODE_LYING_AROUND      = 2;
	
}
