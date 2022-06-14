package dieBremerStadtmusikanten;

import org.junit.jupiter.api.Test;

import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;

class PetTest {
    @Test
    public void PetHasInitValues(){
        Cat cat = new Cat("Tin");
        String name = cat.getName();
        String sound = cat.getSound();
        assertEquals("Tin",name);
        assertEquals("meow-meow", sound);
    }
    @Test
    public void CatSings(){
        Cat cat = new Cat("Tin");
        String sound = cat.sing();
        assertEquals("meow-meow", sound);
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
        assertEquals("The cat Tin sings: meow-meow", msg);
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
        assertEquals("The dog Sira sings: boop-boop", msg);
    }
    @Test
    public void DogStopSingingMsg(){
        Dog dog = new  Dog("Sira");
        dog.stopSinging();
        String msg = dog.isSinging();
        assertEquals("The dog Sira doesn't want to sing.", msg);
    }

    @Test
    public void DonkeySingMsg(){
        Donkey donkey = new Donkey("Burro");
        donkey.sing();
        String msg = donkey.isSinging();
        assertEquals("The donkey Burro sings: eeeeh-aaaah", msg);
    }
    @Test
    public void DonkeyStopSingingMsg(){
        Donkey donkey = new Donkey("Burro");
        donkey.stopSinging();
        String msg = donkey.isSinging();
        assertEquals("The donkey Burro doesn't want to sing.", msg);
    }
    @Test
    public void DirectorMakesPetsSing(){
        Cat cat = new  Cat("Tin");
        Dog dog = new  Dog("Sira");
        Donkey donkey = new Donkey("Burro");
        Set<Pet> chorus = Set.of(cat, dog, donkey);
        Director director = new Director("Director", chorus);
        String song = director.startSing();
        assertEquals("boop-boop meow-meow eeeeh-aaaah", song);
    }
    @Test
    public void DirectorMakesPetsStopSinging(){
        Cat cat = new  Cat("Tin");
        Dog dog = new  Dog("Sira");
        Donkey donkey = new Donkey("Burro");
        Set<Pet> chorus = Set.of(cat, dog, donkey);
        Director director = new Director("Director", chorus);
        String song = director.stopSing();
        assertEquals("   ", song);
    }
}