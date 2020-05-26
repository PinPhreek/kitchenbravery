package its.kitchen.io;

import java.io.*;
import java.util.*;

import its.kitchen.ingredients.Ingredient;

public class Load {

	public static ArrayList<Ingredient> readIngredients(String path) {//Don't care about / and \

		String s = null, name = null;
		boolean inIngredient = false;
		int type = 0;
		ArrayList<Ingredient> data = new ArrayList<>();
		try {
			Scanner sc = new Scanner(new File(path));
			
			while(sc.hasNextLine()) {
				s = sc.nextLine();
				if(s.isEmpty())
					continue;
				if(s.contains("<Ingredient>")) {
					inIngredient = true;
					continue;
				}
				if(inIngredient) {
					if(s.contains("<name>") && s.contains("</name>")) {
						name = s.replace("<name>", "").replace("</name>", "");
					}
					else if (s.contains("<type>") && s.contains("</type>")) {
						type = Ingredient.convertFood(s.replace("<type>", "").replace("</type>", ""));
					}
					else if(s.contains("</Ingredient>")) {
						data.add(new Ingredient(name, type));
						inIngredient = false;
					}
				}
				
			}
			
			sc.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		return data;
	}
	
}
/*
<Ingredient>
	<name>Cucumber</name>
	<type>VEGETABLE</type>
</Ingredient>
*/