package katas;

import java.util.ArrayList;
import java.util.List;

public class Faction {

    private List<Character> members = new ArrayList<>();
    private String name;

    public Faction (String name){
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public boolean containsMember(Character newMember){
        return this.members.contains(newMember);
    }
    public void addMember(Character newMember){
        if(!containsMember(newMember)){
            newMember.addFaction(this);
            members.add(newMember);
            System.out.println(newMember.getName()+" added to faction: "+this.name+".");
        }else{
            System.out.println("This member belongs to "+this.name+" already.");
        }
    }
    public void removeMember(Character member){
        if(containsMember(member)){
            member.removeFaction(this);
            this.members.remove(member);
            System.out.println(member.getName()+" removed from faction: "+this.name+".");
        }else{
            System.out.println("This member doesn't belong to "+this.name+".");
        }
    }

    public boolean areAllies(Character character1, Character character2){
        return (this.members.contains(character1) && this.members.contains(character2));
    }
    public List<Character> getMembers(){
        return this.members;
    }
}
