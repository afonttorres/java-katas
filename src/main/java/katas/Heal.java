package katas;

public class Heal {
    private Character healer;
    private Character target;
    private double distance(){
        return this.field().calcDistance(healer, target);
    }
    private Field field(){
        //if(healer.getField() != target.getField()) return;
        return healer.getField();
    }
    private boolean areAlies(){
        for(Faction faction : healer.getFactions()){
            if(faction.areAllies(healer, target)) return true;
        }
        return false;
    }
    private boolean areOnRange(){
        return this.distance() <= healer.getMaxRange();
    }
    private boolean outOfField() { return this.distance()< 0;}


    public Heal(Character healer, Character target){
        this.healer = healer;
        this.target = target;
    }

    public void on(){
        if(this.healer == this.target){
            this.healer.getsHealed(this.healer);
            System.out.println(this.healer.getName()+" healed");
        }
        if(this.areAlies() && this.areOnRange() && this.target.getIsAlive()){
            this.healer.heals(this.target);
            System.out.println(this.target.getName()+" healed");
            //System.out.println(this.distance();

        }else{
            System.out.println(this.target.getName()+" couldn't be healed");
            System.out.println("Is healer == target? "+(this.healer == this.target));
            System.out.println("Are alies? "+this.areAlies());
            System.out.println("Are on range? "+this.areOnRange());
            System.out.println("Is target alive? "+this.target.getIsAlive());
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
