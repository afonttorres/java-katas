package katas;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class CharacterTest {

    //ITERATION 1//
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

    //ITERATION 3
    //MELEE CAN BE CREATED
    @Test
    public void meleeCanBeCreated(){
        Melee shrek = new Melee("Shrek");
        String result = shrek.getName();
        assertEquals("Shrek",result);
    }

    //MELEE HAS MAXRANGE
    @Test
    public void meleeHasMaxRange(){
        Melee shrek = new Melee("Shrek");
        int result = shrek.getMaxRange();
        assertEquals(2,result);
    }

    //RANGED CAN BE CREATED
    @Test
    public void rangedCanBeCreated(){
        Ranged shrek = new Ranged("Shrek");
        String result = shrek.getName();
        assertEquals("Shrek",result);
    }

    //RANGED HAS MAXRANGE
    @Test
    public void rangedHasMaxRange(){
        Ranged shrek = new Ranged("Shrek");
        int result = shrek.getMaxRange();
        assertEquals(20,result);
    }

    //MELEE KILLS RANGED
    @Test
    public void meleeAttacksRanged(){
        Melee shrek = new Melee("Shrek");
        Ranged fiona = new Ranged("Fiona");
        shrek.setAttackPower(1000);
        shrek.attacks(fiona);
        int result = fiona.getHealth();
        boolean isAlive = fiona.getIsAlive();
        assertEquals(false, isAlive);
        assertEquals(0, result);
    }

    @Test
    public void coordCanBeCreated(){
        Coord coord = new Coord(0,0);
        int xRes = coord.getX();
        int yRes = coord.getY();
        assertEquals(0,xRes );
        assertEquals(0, yRes);
    }

    @Test
    public void creatingFieldCoords(){
        Field field = new Field();
        field.createCoords();
        List<Coord> res = field.getCoords();
        assertEquals(121, res.size());
    }

    //Just a console print
    @Test
    public void gettingFieldCoords(){
        Field field = new Field();
        field.createCoords();
        List<Coord> res = field.getCoords();
        for(Coord coord: res){
            System.out.println(coord.getX()+","+coord.getY());
        }

    }

    @Test
    public void meleeHasInitPosition(){
        Melee shrek = new Melee("Shrek");
        int xRes = shrek.getPosition().getX();
        int yRes = shrek.getPosition().getY();
        assertEquals(0, xRes);
        assertEquals(0, yRes);
        System.out.println("("+xRes+","+yRes+")");
    }

}