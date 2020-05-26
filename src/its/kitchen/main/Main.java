package its.kitchen.main;

import java.util.ArrayList;

import its.kitchen.ingredients.Ingredient;
import its.kitchen.io.Load;

public class Main {

	public static void main(String[] args) {
		int i = 0;
		for (i = 0; i < args.length; i++) {
			System.out.println(args[i]);
		}
		ArrayList<Ingredient> ingerdients = Load.readIngredients("D:\\ingr.txt");
		for (i = 0; i < ingerdients.size(); i++) {
			System.out.println(ingerdients.get(i).name + " " +  ingerdients.get(i).type + " " + ingerdients.get(i).isVegetarian() + " " + ingerdients.get(i).isVegan());
		}
	}
	
}
