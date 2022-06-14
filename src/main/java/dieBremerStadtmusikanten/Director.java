package dieBremerStadtmusikanten;

import java.util.HashSet;
import java.util.Set;

public class Director {
    private String name;
    Set<Pet> chorus = new HashSet<>();
    public Director(String name, Set<Pet> chorus){
        this.name = name;
        this.chorus = chorus;
    }
    //GETTERS
    public String getName(){return this.name;}

    public String startSing(){
        String song = "";
        for (Pet pet:this.chorus){
            song+=pet.sing()+" ";
        }
        System.out.println(song);
        return song;
    }

    public String stopSing(){
        String song = "";
        for (Pet pet:this.chorus){
            song+=pet.stopSinging()+" ";
        }
        System.out.println(song);
        return song;
    }
}
