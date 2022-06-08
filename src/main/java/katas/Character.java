package katas;

public class Character {
    private int maxHealth = 1000;
    private int health = 1000;
    private  int level = 1;
    private boolean isAlive(){
        return this.health >= 1;
    }
    private int attackPower = 50;
    private int healingPower = 50;

    private int maxRange;
    private String name;
    public Character(String name){
        this.name = name;
    }

    public Character self = this;
    public int getMaxHealth(){
        return this.maxHealth;
    }
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

    public void setMaxRange(int val){
        this.maxRange = val;
    }

    public void setLevel(int level){
        this.level = level;
    }

    public void setAttackPower(int val){
        this.attackPower = val;
    }

    public void setHealingPower(int val){
        this.healingPower = val;
    }
/*
    - If the target is 5 or more Levels above the attacker, Damage is reduced by 50%
    - If the target is 5 or more Levels below the attacker, Damage is increased by 50%

 */

    public  void getsHurt(Character interactor){
        if(interactor != self){
            double damage;
            if(interactor.getLevel() >= (this.getLevel()+5)){
                damage = interactor.getAttackPower() * 1.5;
            }else if(interactor.getLevel() <= this.getLevel()-5){
                damage = interactor.getAttackPower() * 0.5;
            }else{
                damage = interactor.getAttackPower();
            }

            System.out.println(damage);

            if(this.health <= damage || this.health < 0){
                this.health = 0;
            }else{
                this.health -= damage;
            }
        }
    }

    public void getsHealed(Character interactor){
        if(interactor == self){
            this.health += this.getHealingPower();
            if(this.health > this.maxHealth){
                this.health = this.maxHealth;
            }
        }

    }

    public void attacks(Character interactor){
        if(interactor != self){
            interactor.getsHurt(self);
        }
    }


}
