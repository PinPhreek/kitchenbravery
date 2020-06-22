package its.kitchen.step;

public class Bake extends Step{

    private int degreesC = 0;
    private int degreesF = 0;
    private int time = 0;

    public Bake(){
        super("bake");
    }
    public int convertC2F(int c){
        return c * (9/5)+32;
    }
    public int convertF2C(int f){
        return ((f - 32) * (5 / 9));
    }
    public String convertSeconds(){
        int minutes = time / 60;
        int secs    = time % 60;
        int hours   = time / 360;

        return hours + "h " + minutes + "m " + secs + "s";
    }

    public int getDegreesC() {return degreesC;}
    public void setDegreesC(int degreesC) {this.degreesC = degreesC;}
    public int getDegreesF() {return degreesF;}
    public void setDegreesF(int degreesF) {this.degreesF = degreesF;}
    public int getTime() {return time;}
    public void setTime(int time) {this.time = time;}
}
