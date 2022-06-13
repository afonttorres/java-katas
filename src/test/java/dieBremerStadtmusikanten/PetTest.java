package dieBremerStadtmusikanten;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PetTest {
    @Test
    public void PetHasInitValues(){
        Cat cat = new Cat("Tin");
        String name = cat.getName();
        String sound = cat.getSound();
        assertEquals("Tin",name);
        assertEquals("Meow-meow", sound);
    }
    @Test
    public void PetSings(){
        Cat cat = new Cat("Tin");
        String sound = cat.sing();
        assertEquals("The cat Tin sings: Meow-meow", sound);
    }
    @Test
    public void PetDoesntSing(){
        Cat cat = new  Cat("Tin");
        String sound = cat.stopSinging();
        assertEquals("The cat Tin doesn't want to sing.", sound);
    }
    @Test
    public void PetSingsFromPetition(){
        Cat cat = new  Cat("Tin");
        String song = cat.aksPetToDo("sing");
        assertEquals("The cat Tin sings: Meow-meow", song);
    }
    @Test
    public void PetStopSingingFromPetition(){
        Cat cat = new  Cat("Tin");
        String song = cat.aksPetToDo("stop");
        assertEquals("The cat Tin doesn't want to sing.", song);
    }

}