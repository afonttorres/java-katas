package dieBremerStadtmusikanten;

public class Cat implements Singer {
    private String name;
    private String sound = "meow-meow";
    private boolean isSick = false;
    private String msg;
    public Cat(String name) {
        this.name = name;
        this.msg = "The cat "+this.name;
    }

    //GETTER
    public String getName(){
        return this.name;
    }
    @Override
    public String sing() {
        if(isSick) {
            this.msg+=" can't sing bc is sick.";
            return "";
        }
        msg+=" sings: "+this.sound;
        return this.sound;
    }

    @Override
    public String stopSinging() {
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
    }

}
