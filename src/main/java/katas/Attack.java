package katas;

public class Attack {
    private boolean canAttack;
    private Character attacker;
    private Character target;
    public Attack(Character attacker, Character target, double distance){
        if(distance <= attacker.getMaxRange()){
            this.canAttack = true;
            this.attacker = attacker;
            this.target = target;
        }else{
            this.canAttack = false;
            System.out.println("Character is not on range");
        }
    }

    public boolean getCanAttack(){
        return this.canAttack;
    }

    public void on(){
        if(this.canAttack){
            attacker.attacks(target);
        }
    }
}
