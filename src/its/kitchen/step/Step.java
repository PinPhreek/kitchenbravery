package its.kitchen.step;

public abstract class Step {

    private String name;

    public Step(String name){

        if (!name.equals("")) this.name = name;

    }

    public String getName() {
        return name;
    }
    public void setName(String name){
        if (!name.equals("")) this.name = name;
    }
}
