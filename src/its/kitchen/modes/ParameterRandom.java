package its.kitchen.modes;

public class ParameterRandom {

    private int maxSteps = 0;
    private int maxIngredients = 0;

    public ParameterRandom(int maxIngredients, int maxSteps){

        if (maxIngredients > 0)
            this.maxIngredients = maxIngredients;
        if (maxSteps > 0)
            this.maxSteps = maxSteps;
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

    public int getMaxIngredients() {
        return maxIngredients;
    }

    public void setMaxIngredients(int maxIngredients) {
        if (maxIngredients > 0)
            this.maxIngredients = maxIngredients;
    }

    public int getMaxSteps() {
        return maxSteps;
    }

    public void setMaxSteps(int maxSteps) {
        if (maxSteps > 0)
            this.maxSteps = maxSteps;
    }
}
