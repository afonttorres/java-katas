package dieBremerStadtmusikanten;

public class Dog implements Pet{
    private String name;
    private String sound = "Boop-boop";
    private boolean isSinging;
    public Dog(String name) {
        this.name = name;
    }

    //GETTER
    public String getName(){
        return this.name;
    }
    public String getSound(){
        return this.sound;
    }
    @Override
    public String sing() {
        this.isSinging = true;
        return this.sound;
    }

    @Override
    public String stopSinging() {
        this.isSinging = false;
        return "";
    }

    @Override
    public String isSinging(){
        String msg = "The dog "+this.name;
        if(this.isSinging)  msg+=" sings: "+this.sound;
        if(!this.isSinging) msg+=" doesn't want to sing.";
        return msg;
    }
}
