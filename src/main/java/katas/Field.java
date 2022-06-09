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
        boolean isCoordOnField = false;
        for(Coord coord: this.fieldCoords){
            if(coord.getY() == position.getY() && coord.getX() == position.getX()) isCoordOnField = true;
       }return  isCoordOnField;
    }

    public double calcDistance(Character charA, Character charB){
        Coord charAPos = charA.getPosition();
        Coord charBPos = charB.getPosition();

        if(!isCoordOnField(charAPos) || !isCoordOnField(charBPos)) return -1;
        int x2 = charBPos.getX();
        int x1 = charAPos.getX();
        int y2 = charBPos.getY();
        int y1 = charAPos.getY();

        double d = Math.sqrt(Math.pow((x2-x1),2) + Math.pow((y2-y1), 2));
        return Math.floor(d*100.0)/100.0;
    }
}
