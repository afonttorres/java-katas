package katas;

public class Thing {
    //VARS
    private int health = 1000;
    private boolean isDestroyed(){
        return health <= 0;
    }
    private String name;
    private Coord position;
    private Field field;

    public Thing(String name, Coord position, Field field){
        this.name = name;
        this.position = position;
        this.field = field;
    }
    //GETTERS
    public int getHealth(){
        return this.health;
    }
    public boolean getIsDestroyed(){
        return this.isDestroyed();
    }
    public String getName(){
        return this.name;
    }
    public Coord getPosition(){
        return this.position;
    }
    public Field getField(){
        return this.field;
    }
    //SETTERS
    public void eraseFromField(){
        this.position = new Coord(-1,-1);
    }
    //METHODS
    public void getsHurt(Character attacker){
        this.health -= attacker.getAttackPower();
        if(this.health <= 0) {
            this.health = 0;
            eraseFromField();
        }
    }
}
