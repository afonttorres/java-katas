package dieBremerStadtmusikanten;

public class ComicCharacter implements Singer {
    private String name;
    private String sound = "lalala";
    private boolean isSick = false;
    private String msg;

    public ComicCharacter(String name){
        this.name = name;
        this.msg = "The comic character "+this.name;
    }

    public void setSound(String sound){
        this.sound = sound;
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
