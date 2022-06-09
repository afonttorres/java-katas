package katas;

import java.util.ArrayList;
import java.util.List;

public class Field {
    private int scale = 1;
    private int width = 10*scale;
    private int height = 10*scale;
    private int xLimit = this.width;
    private int yLimit = this.height;
    private List<Coord> fieldCoords;

    //CreateCoords
    public void createCoords(){
        List<Coord> coords = new ArrayList<>();
        for(int y = 0; y<= this.height; y++){
            for(int x = 0; x <= this.width; x++){
                Coord coord = new Coord(x, y);
                coords.add(coord.getCoord());
            }
        }

        this.fieldCoords = coords;
    }

    public List<Coord> getCoords(){
        return this.fieldCoords;
    }

     public boolean isCharPositonInField(Coord o) {
        boolean isEqual =false;
        if (o == null) {
            isEqual = false;
        }
       for(Coord coord: this.fieldCoords){
           if(coord.getY() == o.getY() && coord.getX() == o.getX()){
               isEqual = true;
           }
       }
       return isEqual;
    }

    public double calcDistance(Coord charAPosition, Coord charBPosition){
        double distance = -1;
        if(isCharPositonInField(charAPosition) && isCharPositonInField(charBPosition)){
            //System.out.println("A: ("+charAPosition.getX()+","+charAPosition.getY()+")");
            //System.out.println("B: ("+charBPosition.getX()+","+charBPosition.getY()+")");
            int x2 = charBPosition.getX();
            int x1 = charAPosition.getX();
            int y2 = charBPosition.getY();
            int y1 = charAPosition.getY();

            double d = Math.sqrt(Math.pow((x2-x1),2) + Math.pow((y2-y1), 2));
              distance = Math.floor(d*100.0)/100.0;
        }else{
            System.out.println("Character is not in field");
        }
        return  distance;
    }
}
