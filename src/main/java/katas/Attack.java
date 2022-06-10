package katas;

public class Attack {
    private Character attacker;
    private Field field(){
        return attacker.getField();
    };
    private boolean areOnRange(){
        return this.distance <= attacker.getMaxRange();
    }
    private boolean outOfField() { return this.distance< 0;}
    private double distance;
    private boolean areAlies(Character target){
        for(Faction faction : attacker.getFactions()){
            if(faction.areAllies(attacker, target)) return true;
        }
        return false;
    }

    public  Attack(Character attacker){
        this.attacker = attacker;
    }
    public void on(Character target){
        if(target.getField() != this.field()) return;
        this.distance = this.field().calcDistance(attacker.getPosition(), target.getPosition());
        if(this.areOnRange() && !this.areAlies(target) && !this.outOfField()){
            System.out.println(target.getName()+" attacked by "+this.attacker.getName());
            this.attacker.attacks(target);
        }else{
            System.out.println(target.getName()+" couldn't be attacked by "+this.attacker.getName());
            System.out.println("Are alies? "+this.areAlies(target));
            System.out.println("Are on range? "+this.areOnRange());
            System.out.println("Some of them isn't inside field? "+this.outOfField());
        }
    }

    public void on(Thing target){
        this.distance = this.field().calcDistance(attacker.getPosition(), target.getPosition());
        if(this.areOnRange() && !this.outOfField()){
            target.getsHurt(this.attacker);
        }
    }
}
