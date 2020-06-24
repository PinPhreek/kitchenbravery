package its.kitchen.io;

import its.kitchen.ingredients.Ingredient;
import its.kitchen.main.Main;

public class Converter {

    public static Ingredient StingToIngredient(String s){//not really save

        for (int i = 0; i < Main.ingerdients.size(); i++) {
            if (s.equalsIgnoreCase(Main.ingerdients.get(i).name))return Main.ingerdients.get(i);
        }
        return null;//this hopefully never happens
    }
    public static String IngredientToString(Ingredient i){
        return i.name;
    }

}
