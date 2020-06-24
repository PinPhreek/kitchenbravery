package its.kitchen.modes;

import its.kitchen.ingredients.Ingredient;
import its.kitchen.io.Converter;
import its.kitchen.main.Main;

import java.util.ArrayList;

public class LyingAround {

    private ArrayList<Ingredient> data;

    public void addIngredient(Ingredient i){

        if (i.name.equals("") || i.type == Ingredient.TYPE_EMPTY) {
            System.err.println("Ingredient " + i.name + " is not valid!\nPlease check database-file: '" + Main.dataPath+"'");
            return;
        }
        data.add(i);

    }
    public void addIngredient(String s){

        if (s == null) {
            System.err.println("Can't add empty ingredient!");
            return;
        }
        data.add(Converter.StingToIngredient(s));

    }
    public LyingAround(){

        data = new ArrayList<>();

    }
}
