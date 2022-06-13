package katas;

import java.util.ArrayList;
import java.util.List;

public class Coord {
    private   int x;
    private int y;
    private List<Object> content = new ArrayList<>();
    private int maxContent = 3;

    public Coord self = this;

    public Coord (int x, int y){
        this.x = x;
        this.y = y;
    }

    public int getX(){
        return this.x;
    }

    public int getY(){
        return this.y;
    }

    public Coord getCoord(){
        return self;
    }
    public int getMaxContent(){return this.maxContent;}

    public List<Object> getContent(){return this.content;}

    public void setContent(Object o){
        //if (this.content.size()>=maxContent) return;
        if(this.content.contains(o)) return;
        this.content.add(o);
    }

    public void removeFromContent(Object o){
        if(!content.contains(o))return;
        content.remove(o);
    }
}
