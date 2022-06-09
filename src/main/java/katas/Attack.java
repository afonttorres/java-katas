package katas;

public class Attack {
    private Character attacker;
    private Character target;
    private double distance;
    private Field field;
    private boolean areAlies = false;
    private boolean areOnRange = false;
    private boolean outOfField = false;



    public  Attack(Character attacker, Character target){
        if(attacker.getField() != target.getField()) return;
        this.field = attacker.getField();
        this. distance = this.field.calcDistance(attacker, target);
        this.attacker = attacker;
        this.target = target;

        if(this.distance <0) {this.outOfField = true; return;}
        //if(attacker.getFactions().size() <= 0) return;
        attacker.getFactions().forEach(faction -> {
            if(faction.areAllies(attacker, target)){
                this.areAlies = true;
            }
        });

        if(this.distance >= attacker.getMaxRange()) return;
        this.areOnRange = true;


    }
    public void on(){
        if(this.areOnRange && !this.areAlies){
            attacker.attacks(target);
            System.out.println(target.getName()+" attacked by "+attacker.getName());
            //System.out.println(this.distance);
        }else{
            System.out.println(target.getName()+" couldn't be attacked by "+attacker.getName());
            System.out.println("Are alies? "+areAlies);
            System.out.println("Are on range? "+areOnRange);
            System.out.println("Some of them isn't inside field? "+this.outOfField);
        }
    }

    public boolean getAreOnRange(){
        return this.areOnRange;
    }
    public boolean getAreAlies(){
        return this.areAlies;
    }
    public boolean getOutOfField(){return this.outOfField;}
}
