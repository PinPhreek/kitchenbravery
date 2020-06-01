package its.kitchen.main;

import java.util.ArrayList;

import its.kitchen.ingredients.Ingredient;
import its.kitchen.io.Load;

public class Main {

	public static String data_version = null;
	public static String version = "0.1_testing";
	
	public static void main(String[] args) {
		int i = 0;
		for (i = 0; i < args.length; i++) {
			System.out.println(args[i]);
		}
		ArrayList<Ingredient> ingerdients = Load.readIngredients("/home/max/ingr.txt");
		for (i = 0; i < ingerdients.size(); i++) {
			ingerdients.get(i).displayIngredient();
		}
	}
	
}
