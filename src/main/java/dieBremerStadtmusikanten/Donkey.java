package dieBremerStadtmusikanten;

public class Donkey implements Pet{
    private String name;
    private String sound = "eeeeh-aaaah";
    private boolean isSinging;
    public Donkey(String name) {
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
    public String isSinging() {
        String msg = "The donkey "+this.name;
        if(this.isSinging)  msg+=" sings: "+this.sound;
        if(!this.isSinging) msg+=" doesn't want to sing.";
        return msg;
    }
}
