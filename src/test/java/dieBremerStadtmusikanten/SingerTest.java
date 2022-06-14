package dieBremerStadtmusikanten;

import org.junit.jupiter.api.Test;

import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SingerTest {
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
        Set<Singer> chorus = Set.of(cat, dog, donkey);
        Director director = new Director("Director", chorus);
        String song = director.startSing();
        assertEquals(32, song.length());
    }
    @Test
    public void DirectorMakesPetsStopSinging(){
        Cat cat = new  Cat("Tin");
        Dog dog = new  Dog("Sira");
        Donkey donkey = new Donkey("Burro");
        Set<Singer> chorus = Set.of(cat, dog, donkey);
        Director director = new Director("Director", chorus);
        String song = director.stopSing();
        assertEquals("   ", song);
    }
    @Test
    public void ComicCharacterSings(){
        ComicCharacter character = new ComicCharacter("Dondald Duck");
        character.sing();
        String msg = character.isSinging();
        assertEquals("The comic character Dondald Duck sings: lalala", msg);
    }

    @Test
    public void ComicCharacterStopSinging(){
        ComicCharacter character = new ComicCharacter("Dondald Duck");
        character.stopSinging();
        String msg = character.isSinging();
        assertEquals("The comic character Dondald Duck doesn't want to sing.", msg);
    }

    @Test
    public void DirectorMakesThemSing(){
        Cat cat = new  Cat("Tin");
        Dog dog = new  Dog("Sira");
        Donkey donkey = new Donkey("Burro");
        ComicCharacter donald = new ComicCharacter("Dondald Duck");
        donald.setSound("quack-quack");
        ComicCharacter minnie = new ComicCharacter("Minnie Mouse");
        minnie.setSound("quick-quick");
        Set<Singer> chorus = Set.of(cat, dog, donkey, donald, minnie);
        Director director = new Director("Director", chorus);
        String song = director.startSing();
        assertEquals(56,song.length());
    }
    @Test
    public void DonkeyCantSingBcIsSick(){
        Donkey donkey = new Donkey("Burro");
        donkey.getSick();
        donkey.sing();
        String msg = donkey.isSinging();
        assertEquals("The donkey Burro can't sing bc is sick.",msg);
    }
}