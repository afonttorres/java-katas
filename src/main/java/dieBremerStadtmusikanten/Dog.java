package dieBremerStadtmusikanten;

public class Dog implements Singer {
    private String name;
    private String sound = "boop-boop";
    private boolean isSick = false;
    private String msg;
    public Dog(String name) {
        this.name = name;
        this.msg = "The dog "+this.name;
    }

    //GETTER
    public String getName(){
        return this.name;
    }
    //METHODS
    @Override
    public String sing() {
        if(isSick) return "";
        msg+=" sings: "+this.sound;
        return this.sound;
    }

    @Override
    public String stopSinging() {
        if(isSick) return "";
        this.msg+=" doesn't want to sing.";
        return "";
    }

    @Override
    public String isSinging() {
        return msg;
    }
    @Override
    public void getSick(){
        this.isSick = true;
        this.msg+=" can't sing bc is sick.";
    }
}
