package katas;

public class Attack {
    private Character attacker;
    private Character target;
    private double distance(){
        return this.field().calcDistance(attacker, target);
    }
    private Field field(){
        //if(attacker.getField() != target.getField()) return;
        return attacker.getField();
    }
    private boolean areAlies(){
        for(Faction faction : attacker.getFactions()){
            if(faction.areAllies(attacker, target)) return true;
        }
        return false;
    }
    private boolean areOnRange(){
        return this.distance() <= attacker.getMaxRange();
    }
    private boolean outOfField() { return this.distance()< 0;}



    public  Attack(Character attacker, Character target){
        this.attacker = attacker;
        this.target = target;
    }
    public void on(){

        if(this.areOnRange() && !this.areAlies()){
            this.attacker.attacks(this.target);
            System.out.println(this.target.getName()+" attacked by "+this.attacker.getName());
        }else{
            System.out.println(this.target.getName()+" couldn't be attacked by "+this.attacker.getName());
            System.out.println("Are alies? "+this.areAlies());
            System.out.println("Are on range? "+this.areOnRange());
            System.out.println("Some of them isn't inside field? "+this.outOfField());
        }
    }

    public boolean getAreOnRange(){
        return this.areOnRange();
    }
    public boolean getAreAlies(){
        return this.areAlies();
    }
    public boolean getOutOfField(){return this.outOfField();}
}
