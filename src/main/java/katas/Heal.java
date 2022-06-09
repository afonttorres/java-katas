package katas;

public class Heal {

    private Character healer;
    private Character target;
    private double distance;
    private Field field;
    private boolean areOnRange = false;
    private boolean areAlies = false;
    private boolean outOfField = false;


    public Heal(Character healer, Character target){
        if(healer.getField() != target.getField()) return;
        this.field = healer.getField();
        this.distance = this.field.calcDistance(healer, target);
        this.healer = healer;
        this.target = target;

        if(distance <0) {this.outOfField = true; return;}
        //if(healer.getFactions().size()>0) return;
        healer.getFactions().forEach(faction -> {
            if(faction.areAllies(healer, target)){
                this.areAlies = true;
            }
        });

        if(distance >= healer.getMaxRange()) return;
        this.areOnRange = true;


    }

    public void on(){
        if(healer == target){
            healer.getsHealed(healer);
            System.out.println(healer.getName()+" healed");
        }
        if(areAlies && areOnRange && target.getIsAlive()){
            healer.heals(target);
            System.out.println(target.getName()+" healed");
            //System.out.println(this.distance);

        }else{
            System.out.println(target.getName()+" couldn't be healed");
            System.out.println("Is healer == target? "+(healer == target));
            System.out.println("Are alies? "+areAlies);
            System.out.println("Are on range? "+areOnRange);
            System.out.println("Is target alive? "+target.getIsAlive());
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
