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
    public void CatSings(){
        Cat cat = new Cat("Tin");
        String sound = cat.sing();
        assertEquals("Meow-meow", sound);
    }
    @Test
    public void CatDoesntSing(){
        Cat cat = new  Cat("Tin");
        String sound = cat.stopSinging();
        assertEquals("", sound);
    }
    @Test
    public void CatSingsMsg(){
        Cat cat = new  Cat("Tin");
        cat.sing();
        String msg = cat.isSinging();
        assertEquals("The cat Tin sings: Meow-meow", msg);
    }
    @Test
    public void CatStopSingingMsg(){
        Cat cat = new  Cat("Tin");
        cat.stopSinging();
        String msg = cat.isSinging();
        assertEquals("The cat Tin doesn't want to sing.", msg);
    }
    @Test
    public void DogSingsMsg(){
        Dog dog = new  Dog("Sira");
        dog.sing();
        String msg = dog.isSinging();
        assertEquals("The dog Sira sings: Boop-boop", msg);
    }
    @Test
    public void DogStopSingingMsg(){
        Dog dog = new  Dog("Sira");
        dog.stopSinging();
        String msg = dog.isSinging();
        assertEquals("The dog Sira doesn't want to sing.", msg);
    }
}