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

}
