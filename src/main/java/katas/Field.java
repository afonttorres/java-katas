package katas;

import java.util.ArrayList;
import java.util.List;

public class Field {
    private int scale = 1;
    private int width = 10*scale;
    private int height = 10*scale;
    private int xLimit = this.width;
    private int yLimit = this.height;
    private String name;
    private List<Coord> fieldCoords;

    public Field(String name){
        this.name = name;
        this.fieldCoords = createCoords();
    }
    //CreateCoords
    public List<Coord> createCoords(){
        List<Coord> coords = new ArrayList<>();
        for(int y = 0; y<= this.height; y++){
            for(int x = 0; x <= this.width; x++){
                Coord coord = new Coord(x, y);
                coords.add(coord.getCoord());
            }
        }

        return coords;
    }

    public List<Coord> getCoords(){
        return this.fieldCoords;
    }
    public String getName(){return this.name;}

     public boolean isCoordOnField(Coord position) {
        if(position == null) return false;
        for(Coord coord: this.fieldCoords){
            if(coord.getY() == position.getY() && coord.getX() == position.getX()) return true;
       }return  false;
    }


    public void placeContent(Coord position){
        System.out.println(position);
        if(!isCoordOnField(position)) return;
        for (int i = 0; i < this.fieldCoords.size(); i++){
            if(this.fieldCoords.get(i).getX() == position.getX() && this.fieldCoords.get(i).getY() == position.getY()){
                if(this.fieldCoords.get(i).getContent().size() >= this.fieldCoords.get(i).getMaxContent()) {
                    System.out.println("Position "+"("+position.getX()+","+ position.getY()+")"+" is already taken.");
                    this.castElement(position);
                    return;
                }
                for(Object data: position.getContent()){
                    this.fieldCoords.get(i).setContent(data);
                }
            }
        }
    }

    public double calcDistance(Coord coordA, Coord coordB){

        if(!isCoordOnField(coordA) || !isCoordOnField(coordB)) return -1;
        int x2 = coordB.getX();
        int x1 = coordA.getX();
        int y2 = coordB.getY();
        int y1 = coordA.getY();

        double d = Math.sqrt(Math.pow((x2-x1),2) + Math.pow((y2-y1), 2));
        return Math.floor(d*100.0)/100.0;
    }

    public void castElement(Coord position){
        String simpleName = position.getContent().get(0).getClass().getCanonicalName();
        if(simpleName != "katas.Character" && simpleName != "katas.Thing" ) return;
        if (simpleName == "katas.Character"){
            Character character = (Character) position.getContent().get(0);
            removeFromField(character);
        }
        if(simpleName == "katas.Thing"){
            Thing thing = (Thing) position.getContent().get(0);
            removeFromField(thing);
        }
    }

    public void removeFromField(Character character){
        character.setPosition(new Coord(-1,-1));
        System.out.println(character.getName()+" is out of field.");
    }
    public void removeFromField(Thing thing){
        thing.removeFromField();
        System.out.println(thing.getName()+" has been erased from field.");
    }

}
