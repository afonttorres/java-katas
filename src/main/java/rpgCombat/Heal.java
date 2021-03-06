package rpgCombat;

public class Heal {
    private Character healer;
    private Character target;
    private double distance(){
        return this.field().calcDistance(healer.getPosition(), target.getPosition());
    }
    private Field field(){
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


    public Heal(Character healer){
        this.healer = healer;
    }

    public void on(Character target){
        this.target = target;
        if(this.field() != this.target.getField()) return;

        if(this.healer == this.target){
            this.healer.getsHealed(this.healer);
            System.out.println(this.healer.getName()+" healed");
        }
        if(this.areAlies() && this.areOnRange() && this.target.getIsAlive()){
            this.healer.heals(this.target);
            System.out.println(this.target.getName()+" healed");

        }else{
            System.out.println(this.target.getName()+" couldn't be healed");
            System.out.println("Is healer == target? "+(this.healer == this.target));
            System.out.println("Are alies? "+this.areAlies());
            System.out.println("Are on range? "+this.areOnRange());
            System.out.println("Is target alive? "+this.target.getIsAlive());
        }
    }
}
