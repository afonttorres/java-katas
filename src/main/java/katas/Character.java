package katas;

public class Character {
    private int health = 1000;
    private  int level = 1;
    private boolean isAlive = this.health >= 1 ? true : false;

    private String name;
    private int attackPower = 50;
    private int healingPower = 50;

    public Character(String name){
        this.name = name;
    }

    public int getHealth(){
        return this.health;
    }
    public int getLevel(){
        return this.level;
    }
    public boolean getIsAlive(){
        return this.isAlive;
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

    public void setLevel(int level){
        this.level = level;
    }
/*
    - If the target is 5 or more Levels above the attacker, Damage is reduced by 50%
    - If the target is 5 or more Levels below the attacker, Damage is increased by 50%

 */

    public  void getsHurt(Character interactor){
        if(interactor!= null && interactor.getName() != this.name){
            double damage;
            if(interactor.getLevel() >= (this.getLevel()+5)){
                damage = interactor.getAttackPower() * 1.5;
            }else if(interactor.getLevel() <= this.getLevel()-5){
                damage = interactor.getAttackPower() * 0.5;
            }else{
                damage = interactor.getAttackPower();
            }

            System.out.println(damage);

            if(this.health <= damage){
                this.health = 0;
                this.isAlive = false;
            }else{
                this.health -= damage;
            }
        }
    }

    public void getsHealed(Character interactor){
        if(interactor!= null && interactor.getName() == this.name){
            if(this.health == 1000 && this.isAlive){
                this.health = interactor.getHealth();
            }
            if(this.health >0 && this.health<= (1000- interactor.getHealingPower()) && this.isAlive){
                this.health += interactor.getHealingPower();
            }
        }

    }


}
