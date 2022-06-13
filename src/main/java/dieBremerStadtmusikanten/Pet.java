package dieBremerStadtmusikanten;

public abstract class Pet {
    private String name;

    public Pet(String name){
        this.name = name;
    }

    //GETTERS
    public String getName(){
        return this.name;
    }

    //METHODS
    public abstract String sing();
    public abstract String stopSinging();

    public abstract String aksPetToDo(String func);
}
