package its.kitchen.modes;

import java.util.ArrayList;
import java.util.Random;

import its.kitchen.ingredients.Ingredient;
import its.kitchen.main.Main;

public class CompletelyRandom {

	static Random r = new Random();
	
	public static void generateRecipe() {
		
		int maxIngredents = 0;
		int maxSteps      = 0;
		ArrayList<Ingredient> data2 = new ArrayList<Ingredient>();
		
		do {
			maxIngredents = r.nextInt(Main.ingerdients.size());
			if (maxIngredents == 0)continue;
			maxSteps      = r.nextInt(maxIngredents);
		}while(maxSteps == 0);
		System.out.println(maxIngredents + " " + maxSteps);
		
		int j = 0;
		boolean found = false;
		
		do {
			
			j = r.nextInt(Main.ingerdients.size());
			for(int i = 0; i < data2.size(); i++) {
				if(Main.ingerdients.get(j).name.equals(data2.get(i).name)) {
					found = true;
					break;
				}
			}
			if(!found) data2.add(Main.ingerdients.get(j));
			found = false;
			
		}while(maxIngredents > data2.size());
		
		for(int i = 0; i < data2.size(); i++) {
			System.out.println(data2.get(i).name);
		}
	}
	
}
