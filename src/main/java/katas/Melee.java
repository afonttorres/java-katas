package katas;

public class Melee extends Character{
    private int range = 2;
    public Melee(String name) {
        super(name);
        setMaxRange(this.range);
    }
}
