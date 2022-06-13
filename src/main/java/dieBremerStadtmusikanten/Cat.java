package dieBremerStadtmusikanten;

public class Cat extends Pet{
    private String sound = "Meow-meow";
    public Cat(String name) {
        super(name);
    }

    //GETTER
    public String getSound(){
        return this.sound;
    }

    @Override
    public String sing() {
        return "The cat "+this.getName() +" sings: "+this.sound;
    }

    @Override
    public String stopSinging() {
        return "The cat "+this.getName() +" doesn't want to sing.";
    }

    @Override
    public String aksPetToDo(String func) {
        if(func == "sing") return String.valueOf(this.sing());
        if(func == "stop") return String.valueOf(this.stopSinging()) ;
        return func;
    }


}
