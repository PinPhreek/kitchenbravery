package its.kitchen.modes;

public class ParameterRandom {

    private static int maxSteps = 0;
    private static int maxIngredients = 0;

    public ParameterRandom(int maxIngredients, int maxSteps){

        if (maxIngredients > 0)
            ParameterRandom.maxIngredients = maxIngredients;
        if (maxSteps > 0)
            ParameterRandom.maxSteps = maxSteps;
        init();
    }
    public ParameterRandom(){
        if (maxSteps > 0 && maxIngredients > 0)
            init();
    }

    private void init(){

        /**
         * this method is currently empty.
         * here can initiational stuff go
         * */

    }

    public void generateRecipe(){
        if (maxIngredients < 1 || maxSteps <1) {
            System.err.println("Invalid number of ingredients or steps!\nAborting!");
            return;
        }



    }

    public int getMaxIngredients() {
        return maxIngredients;
    }

    public void setMaxIngredients(int maxIngredients) {
        if (maxIngredients > 0)
            ParameterRandom.maxIngredients = maxIngredients;
    }

    public int getMaxSteps() {
        return maxSteps;
    }

    public void setMaxSteps(int maxSteps) {
        if (maxSteps > 0)
            ParameterRandom.maxSteps = maxSteps;
    }
}
