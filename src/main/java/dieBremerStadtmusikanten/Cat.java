package dieBremerStadtmusikanten;

public class Cat implements Pet{
    private String name;
    private String sound = "Meow-meow";
    private boolean isSinging;
    public Cat(String name) {
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
        String msg = "The cat "+this.name;
        if(this.isSinging)  msg+=" sings: "+this.sound;
        if(!this.isSinging) msg+=" doesn't want to sing.";
        return msg;
    }

}
