package katas;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CharacterTest {

    //ITERATION ONE//
    //HEALT, ISALIVE & LEVEL DEFAULT//
    @Test
    public void charactersHealthStarts1000(){
        Character shrek = new Character("Shrek");
        int result = shrek.getHealth();
        assertEquals(1000,result);
    }

    @Test
    public void characterIsAlive(){
        Character shrek = new Character("Shrek");
        boolean result = shrek.getIsAlive();
        assertEquals(true,result);
    }

    @Test
    public void charactersLevelIs1(){
        Character shrek = new Character("Shrek");
        int result = shrek.getLevel();
        assertEquals(1,result);
    }

    //NAME, ATTACKPOWER & HEALINGPOWER//
    @Test
    public void characterHasName(){
        Character shrek = new Character("Shrek");
        String result = shrek.getName();
        assertEquals("Shrek",result);
    }

    @Test
    public void characterHasAttackPower(){
        Character shrek = new Character("Shrek");
        int result = shrek.getAttackPower();
        assertEquals(50,result);
    }

    @Test
    public void characterHasHealingPower(){
        Character shrek = new Character("Shrek");
        int result = shrek.getHealingPower();
        assertEquals(50,result);
    }

    //HURT//
    /*@Test
    public void characterGetsHurt(){
        Character shrek = new Character("Shrek", 50, 50);
        shrek.getsHurt(100);
        int result = shrek.getHealth();
        assertEquals(900,result);
    }

    @Test
    public void charactersDamageExceedsHealth(){
        Character shrek = new Character("Shrek", 50, 50);
        shrek.getsHurt(900);
        shrek.getsHurt(101);
        int healthRes = shrek.getHealth();
        boolean isAliveRes = shrek.getIsAlive();
        assertEquals(0,healthRes);
        assertEquals(false, isAliveRes);
    }

    //Fails bc there's no interactor
    @Test
    public void characterDies(){
        Character shrek = new Character("Shrek", 50, 50);
        shrek.getsHurt(1000);
        int healthRes = shrek.getHealth();
        boolean isAliveRes = shrek.getIsAlive();
        assertEquals(0,healthRes);
        assertEquals(false, isAliveRes);
    }

    //HEAL//
    //Fails bc there's no interactor
    @Test
    public void characterGetsHealed(){
        Character shrek = new Character("Shrek", 50, 50);
        shrek.getsHurt(200);
        shrek.getsHealed(100);
        int healthRes = shrek.getHealth();
        boolean isAliveRes = shrek.getIsAlive();
        assertEquals(900,healthRes);
        assertEquals(true, isAliveRes);
    }

    //Fails bc there's no interactor
    @Test
    public void deadCharacterCantBeHealed(){
        Character shrek = new Character("Shrek", 50, 50);
        shrek.getsHurt(1000);
        shrek.getsHealed(100);
        int healthRes = shrek.getHealth();
        boolean isAliveRes = shrek.getIsAlive();
        assertEquals(0,healthRes);
        assertEquals(false, isAliveRes);
    }

    //Doesn't fail even if there's no interactor bc result is always 1000
    @Test
    public void characterCantExceedMaxHealth(){
        Character shrek = new Character("Shrek", 50, 50);
        shrek.getsHurt(200);
        shrek.getsHealed(300);
        int result = shrek.getHealth();
        assertEquals(1000,result);
    }

    //CHARACTER HURTS CHARACTER// - comment after iteration 2
    //Fails bc there's no interactor
    @Test
    public void characterHurtsCharacterIT1(){
        Character shrek = new Character("Shrek", 50, 50);
        Character fiona = new Character("Fiona", 50, 50);
        shrek.getsHurt(fiona.getAttackPower());
        int result = shrek.getHealth();
        assertEquals(950, result);
    }

    //CHARACTER HURTS AND HEALS CHARACTER// - comment after iteration 2
    //Fails bc there's no interactor
    @Test
    public void characterHurtsAndHealsCharacterIT1(){
        Character shrek = new Character("Shrek", 50, 50);
        Character fiona = new Character("Fiona", 50, 50);
        shrek.getsHurt(fiona.getAttackPower());
        shrek.getsHealed(fiona.getHealingPower());
        int result = shrek.getHealth();
        assertEquals(1000, result);
    }
     */

    //ITERATION 2
    //CHARACTER CAN HURT CHARACTER
    @Test
    public void characterHurtsCharacterIT2(){
        Character shrek = new Character("Shrek");
        Character fiona = new Character("Fiona");
        shrek.getsHurt(fiona);
        int result = shrek.getHealth();
        assertEquals( 950, result);
    }

    //CHARACTER CAN'T HURT HIMSELF
    @Test
    public void characterCantHurtHimselfIT2(){
        Character shrek = new Character("Shrek");
        shrek.getsHurt(shrek);
        int result = shrek.getHealth();
        assertEquals( 1000, result);
    }

    //CHARACTER CAN'T HEAL CHARACTER
    @Test
    public void characterCantHealCharacterIT2(){
        Character shrek = new Character("Shrek");
        Character fiona = new Character("Fiona");
        shrek.getsHurt(fiona);
        shrek.getsHealed(fiona);
        int result = shrek.getHealth();
        assertEquals( 950, result);
    }

    //CHARACTER CAN HEAL HIMSELF
    @Test
    public void characterCanHealHimselfIT2(){
        Character shrek = new Character("Shrek");
        Character fiona = new Character("Fiona");
        shrek.getsHurt(fiona);
        shrek.getsHealed(shrek);
        int result = shrek.getHealth();
        assertEquals( 1000, result);
    }

    //CHARACTER ATTACK POWER GETS REDUCED
    @Test
    public void charactersAttackPowerGetsRaisedByOponentLevel(){
        Character shrek = new Character("Shrek");
        Character fiona = new Character("Fiona");
        fiona.setLevel(6);//mec
        shrek.getsHurt(fiona);
        int result = shrek.getHealth();
        assertEquals( 925, result);
    }

    //CHARACTER ATTACK POWER GETS RAISED
    @Test
    public void charactersAttackPowerGetsReducedByOponentLevel(){
        Character shrek = new Character("Shrek");
        Character fiona = new Character("Fiona");
        shrek.setLevel(6);//mec
        shrek.getsHurt(fiona);
        int result = shrek.getHealth();
        assertEquals( 975, result);
    }

}