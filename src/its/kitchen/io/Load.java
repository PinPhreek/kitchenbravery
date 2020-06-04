package its.kitchen.io;

import java.io.*;
import java.util.*;

import its.kitchen.ingredients.Ingredient;
import its.kitchen.main.Main;

public class Load {
 
	public static ArrayList<Ingredient> readIngredients(String path) {//Don't care about / and \

		String s = null, s2 = null /*for some nice switcheroo*/, name = null;
		boolean inIngredients = false, inHeader = false;
		int type = 0;
		ArrayList<Ingredient> data = new ArrayList<>();
		try {
			Scanner sc = new Scanner(new File(path));
			
			while(sc.hasNextLine()) {
				if(inIngredients && inHeader) {
					System.err.println("Mal-formated config-file!\nAbortig.\n");
					System.exit(-1);
				}
				s = sc.nextLine().replace("\t", "").replace(" ", "");
				if(s.isEmpty())
					continue;
				//s = s.toLowerCase();
				s2 = s.replace("_", " ");
				s = s2;/*Don't even ask...*/
				if(s.equalsIgnoreCase("<header>")) {
					inHeader = true;
					continue;
				}
				if(inHeader) {//Version und so
					if(s.equalsIgnoreCase("</header>")) {
						inHeader = false;
					}
					else if(s.contains("<version>") && s.contains("</version>")) {
						Main.data_version = s.replace("<version>", "").replace("</version>", "");
					}
					else if(s.equalsIgnoreCase("</header>")) {
						inHeader = false;
					}
					continue;
				}
				if(s.contains("<ingredients>")) {
					inIngredients = true;
					continue;
				}
				if(inIngredients) {
					if(s.contains("<type")) {
						type = Ingredient.convertFood(s.split("=")[1].replace(">", ""));
					}
					if(s.contains("<name>") && s.contains("</name>")) {
						name = s.replace("<name>", "").replace("</name>", "");
						data.add(new Ingredient(name, type));
					}
					else if (s.contains("</type>")) {
						type = 0;
					}
					else if(s.contains("</ingredients>")) {
						inIngredients = false;
					}
				}
				
			}
			
			sc.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			System.exit(-1);
		}
		return data;
	}
	
}
/*
<Ingredient>
	<type=VEGETABLE>
		<name>Cucumber</name>
		<name>Carrot</name>
	</type>
</Ingredient>
*/