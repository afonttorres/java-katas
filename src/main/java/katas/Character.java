package katas;

import java.util.ArrayList;
import java.util.List;

public class Character {
    //VARS
    private int maxHealth = 1000;
    private int health = maxHealth;
    private  int level = 1;
    private boolean isAlive(){
        return this.health >= 1;
    }
    private int attackPower = 50;
    private int healingPower = 50;
    private int maxRange = 2;
    private int levelDiff = 5;
    private double damageIncrease = 1.5;
    private double damageReduction = .5;
    private Coord position = new Coord(0,0);
    private List<Faction> factions = new ArrayList<>();
    private Field field;
    private String name;
    public Character(String name){
        this.name = name;
    }
    public Character self = this;

    //GETTERS
    public int getMaxHealth(){return this.maxHealth;}
    public int getHealth(){
        return this.health;
    }
    public int getLevel(){
        return this.level;
    }
    public boolean getIsAlive(){
        return this.isAlive();
    }
    public String getName(){
        return this.name;
    }
    public int getAttackPower(){
        return this.attackPower;
    }
    public int getHealingPower(){
        return this.healingPower;
    }
    public int getMaxRange(){
        return this.maxRange;
    }
    public Field getField(){
        return this.field;
    }
    public Coord getPosition(){
        return this.position;
    }
    public List<Faction> getFactions(){
        //factions.forEach(faction -> System.out.println(faction.getName()));
        return this.factions;
    }

    //SETTERS
    public void setMaxRange(int val){
        this.maxRange = val;
    }

    public void setHealth(int val){this.health = val;}
    public void setLevel(int level){
        this.level = level;
    }

    public void setAttackPower(int val){
        this.attackPower = val;
    }

    public void setHealingPower(int val){
        this.healingPower = val;
    }
    public void setField(Field field){
        this.field = field;
    }
    public void setPosition(Coord position){
        System.out.println(this.name+"'s position: "+"("+position.getX()+","+position.getY()+")");
        this.position = position;
        this.position.setContent(this);
        this.field.placeContent(this.position);
    }
    private double setDamage(Character target){
        double damage = target.getAttackPower();
        if(target.getLevel() >= (this.getLevel()+this.levelDiff)){
            damage = target.getAttackPower() * this.damageIncrease;
        }
        if(target.getLevel() <=( this.getLevel()-this.levelDiff)){
            damage = target.getAttackPower() * this.damageReduction;
        }
        return  damage;
    }

    //METHODS
    private void getsHurt(Character target){
        if(target == self) return;
        double damage = setDamage(target);
        System.out.println("Attack power went from "+target.getAttackPower()+" to: " +damage+".");
        this.health -= damage;
        if(this.health <= damage || this.health < 0){
            this.health = 0;
            this.removeFromFactionsAndField();
        }
    }
    public void attacks(Character target){
        if(target == self) return;
        target.getsHurt(self);
    }
    public void getsHealed(Character target){
        if(target != self) return;
        if(this.health <= 0) return;
        this.health += this.healingPower;
        if(this.health > this.maxHealth){
            this.health = this.maxHealth;
        }
    }
    public void heals(Character target){
        if(target == self) return;
        if(target.getHealth() <= 0) return;

        int targetsHealth = target.getHealth();
        targetsHealth += this.healingPower;
        if(targetsHealth > target.getMaxHealth()){
            targetsHealth = target.getMaxHealth();
        }
        target.setHealth(targetsHealth);
    }
    public void becomeFactionMember(Faction faction){
        faction.addMember(self);
    }

    public void getOutOfFaction(Faction faction){
        faction.removeMember(self);
        this.factions.remove(faction);
    }
    public void addFaction(Faction faction){
        this.factions.add(faction);
    }
    public void removeFaction(Faction faction){
        this.factions.remove(faction);
    }

    public void removeFromField(){
        this.position.removeFromContent(this);
        this.position = new Coord(-1,-1);
    }
    public void removeFromFactions(){
        for(int i = 0; i < this.factions.size(); i++){
            getOutOfFaction(factions.get(i));
        }
    }
    //WHEN CHARACTER DIES
    public void removeFromFactionsAndField(){
        this.removeFromField();
        this.removeFromFactions();
    }
}
