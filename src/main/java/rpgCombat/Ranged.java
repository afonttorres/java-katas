package rpgCombat;

public class Ranged extends Character{
    private int range = 20;
    public Ranged(String name) {
        super(name);
        setMaxRange(this.range);
    }

}
