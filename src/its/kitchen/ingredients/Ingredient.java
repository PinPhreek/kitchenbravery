package its.kitchen.ingredients;

public class Ingredient {

	public String name = null;
	public int type = 0;
	
	public Ingredient(String name, int type) {
		this.name = name;
		this.type = type;
	}
	
	public boolean isVegetarian() { //good stuff
		return !(type == TYPE_MEAT || type == TYPE_SAUSAGE || type == TYPE_FISH);
	}
	
	public boolean isVegan() {
		return !(type < 3  || type == TYPE_CHEESE || type > 9);
	}
	public static int convertFood(String input) {
		
		if (input.contains("MEAT")) return TYPE_MEAT;
		else if(input.contains("SAUSAGE")) return TYPE_SAUSAGE;
		else if(input.contains("VEGETABLE")) return TYPE_VEGETABLE;
		else if(input.contains("FRUIT")) return TYPE_FRUIT;
		else if(input.contains("MUSHROOM")) return TYPE_MUSHROOM;
		else if(input.contains("BREAD")) return TYPE_BREAD;
		else if(input.contains("CHEESE")) return TYPE_SPICE;
		else if(input.contains("SWEET")) return TYPE_SPICE;
		else if(input.contains("MILKPRODUCT")) return TYPE_MILKPRODUCT;
		else if(input.contains("FISH")) return TYPE_FISH;
		else return 0;
		
	}
	
	public void displayIngredient() {
		System.out.printf("%-20s | %2d\n", this.name, this.type);
	}
	
	//Meat
	public static final int TYPE_MEAT = 1;
	public static final int TYPE_SAUSAGE = 2;
	
	//green stuff
	public static final int TYPE_VEGETABLE = 3;
	public static final int TYPE_FRUIT = 4;
	public static final int TYPE_MUSHROOM = 5;
	
	//other stuff
	public static final int TYPE_BREAD = 6;
	public static final int TYPE_CHEESE = 7;
	public static final int TYPE_SPICE = 8;
	
	//sugar section
	public static final int TYPE_SWEET = 9;
	public static final int TYPE_MILKPRODUCT = 10;
	
	//fish
	public static final int TYPE_FISH = 11;
	
}
