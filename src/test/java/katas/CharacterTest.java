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
        fiona.attacks(shrek);
        int result = shrek.getHealth();
        assertEquals( 950, result);
    }

    //CHARACTER CAN'T HURT HIMSELF
    @Test
    public void characterCantHurtHimselfIT2(){
        Character shrek = new Character("Shrek");
        shrek.attacks(shrek);
        int result = shrek.getHealth();
        assertEquals( 1000, result);
    }

    //CHARACTER CAN'T HEAL CHARACTER
    @Test
    public void characterCantHealCharacterIT2(){
        Character shrek = new Character("Shrek");
        Character fiona = new Character("Fiona");
        fiona.attacks(shrek);
        shrek.getsHealed(fiona);
        int result = shrek.getHealth();
        assertEquals( 950, result);
    }

    //CHARACTER CAN HEAL HIMSELF
    @Test
    public void characterCanHealHimselfIT2(){
        Character shrek = new Character("Shrek");
        Character fiona = new Character("Fiona");
        fiona.attacks(shrek);
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
        fiona.attacks(shrek);
        int result = shrek.getHealth();
        assertEquals( 925, result);
    }

    //CHARACTER ATTACK POWER GETS RAISED
    @Test
    public void charactersAttackPowerGetsReducedByOponentLevel(){
        Character shrek = new Character("Shrek");
        Character fiona = new Character("Fiona");
        shrek.setLevel(6);//mec
        fiona.attacks(shrek);
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
        Field field = new Field("Far far away");
        List<Coord> res = field.getCoords();
        assertEquals(121, res.size());
    }

    //Just a console print
    @Test
    public void gettingFieldCoords(){
        Field field = new Field("Far far away");
        List<Coord> coords = field.getCoords();
        int result = field.getCoords().size();
        assertEquals(121, result);
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

    @Test
    public void fieldContainsCharPosition(){
        Melee shrek = new Melee("Shrek");
        Field field = new Field("Far far away");
        shrek.setField(field);
        boolean isCharInField = field.isCoordOnField(shrek.getPosition());
        assertEquals(true, isCharInField);
    }

    @Test
    public void fieldDoesntContainCharPosition(){
        Ranged fiona = new Ranged("Fiona");
        Field field = new Field("Far far away");
        fiona.setPosition(2,15);
        fiona.setField(field);
        boolean isCharInField = field.isCoordOnField(fiona.getPosition());
        assertEquals(false,isCharInField );
    }

    @Test
    public void calcDistance(){
        Ranged fiona = new Ranged("Fiona");
        Melee shrek = new Melee("Shrek");
        Field field = new Field("Far far away");
        fiona.setField(field);
        fiona.setPosition(5,2);
        shrek.setField(field);
        shrek.setPosition(8,4);
        double result = field.calcDistance(fiona.getPosition(), shrek.getPosition());
        assertEquals(3.6, result);
    }

    @Test
    public void attackerCanAttackTarget(){
        Ranged fiona = new Ranged("Fiona");
        Melee shrek = new Melee("Shrek");
        Field field = new Field("Far far away");
        fiona.setPosition(5,2);
        shrek.setPosition(8,4);
        fiona.setField(field);
        shrek.setField(field);
        Attack attack = new Attack(fiona);
        attack.on(shrek);
        boolean canAttack = shrek.getHealth() == 950;
        assertEquals(true, canAttack);
    }

    @Test
    public void attackerCantAttackTarget(){
        Ranged fiona = new Ranged("Fiona");
        Melee shrek = new Melee("Shrek");
        Field field = new Field("Far far away");
        fiona.setPosition(5,2);
        shrek.setPosition(8,4);
        fiona.setField(field);
        shrek.setField(field);
        Attack attack = new Attack(shrek);
        attack.on(fiona);
        boolean canAttack = fiona.getHealth() == 950;
        assertEquals(false, canAttack);
    }

    @Test
    public void attackerAttacksTarget(){
        Ranged fiona = new Ranged("Fiona");
        Melee shrek = new Melee("Shrek");
        Field field = new Field("Far far away");
        fiona.setPosition(5,2);
        shrek.setPosition(8,4);
        fiona.setField(field);
        shrek.setField(field);
        Attack fionaAttacksShrek = new Attack(fiona);
        fionaAttacksShrek.on(shrek);
        int targetHealth = shrek.getHealth();
        assertEquals(950, targetHealth);
    }

    @Test
    public void attackerAttacksTargetButDoesntHurtHim(){
        Ranged fiona = new Ranged("Fiona");
        Melee shrek = new Melee("Shrek");
        Field field = new Field("Far far away");
        fiona.setPosition(5,2);
        shrek.setPosition(8,4);
        fiona.setField(field);
        shrek.setField(field);
        Attack shrekAttacksFiona = new Attack(shrek);
        shrekAttacksFiona.on(fiona);
        int targetHealth = fiona.getHealth();
        assertEquals(1000, targetHealth);
    }

    @Test
    public void factionCanBeCreated(){
        Faction faction = new Faction("Shrek & Co");
        String factionName = faction.getName();
        assertEquals("Shrek & Co", factionName);
    }

    @Test
    public void factionDoesntContainMember(){
        Faction faction = new Faction("Shrek & Co");
        Ranged shrek = new Ranged("Shrek");
        boolean isShrekMember = faction.containsMember(shrek);
        assertEquals(false, isShrekMember);
    }

    @Test
    public void addingMemberToFaction(){
        Faction faction = new Faction("Shrek & Co");
        Ranged shrek = new Ranged("Shrek");
        faction.addMember(shrek);
        boolean isShrekMember = faction.containsMember(shrek);
        assertEquals(true, isShrekMember);
    }

    @Test
    public void cantAddMemberIfBelongsToFaction(){
        Faction faction = new Faction("Shrek & Co");
        Ranged shrek = new Ranged("Shrek");
        faction.addMember(shrek);
        faction.addMember(shrek);
        boolean isShrekMember = faction.containsMember(shrek);
        assertEquals(true, isShrekMember);
    }

    @Test
    public void characterBelongsToFaction(){
        Faction faction = new Faction("Shrek & Co");
        Ranged shrek = new Ranged("Shrek");
        faction.addMember(shrek);
        List<Faction> shrekFactions = shrek.getFactions();
        assertEquals(1, shrekFactions.size());
    }

    @Test
    public void addingCharacterTo2Factions(){
        Faction shrekAndCo = new Faction("Shrek & Co");
        Faction duloc = new Faction("Duloc");
        Ranged shrek = new Ranged("Shrek");
        shrekAndCo.addMember(shrek);
        duloc.addMember(shrek);
        boolean shrekBelongsToshrekAndCo = shrekAndCo.containsMember(shrek);
        boolean shrekBelongsToDuloc = duloc.containsMember(shrek);
        assertEquals(true, shrekBelongsToshrekAndCo);
        assertEquals(true, shrekBelongsToDuloc);
    }

    @Test
    public void characterBelongsTo2Factions(){
        Faction shrekAndCo = new Faction("Shrek & Co");
        Faction duloc = new Faction("Duloc");
        Ranged shrek = new Ranged("Shrek");
        shrekAndCo.addMember(shrek);
        duloc.addMember(shrek);
        List<Faction> shrekFactions = shrek.getFactions();
        assertEquals(2, shrekFactions.size());
    }

    @Test
    public void throwingOutMemberFromFaction(){
        Faction shrekAndCo = new Faction("Shrek & Co");
        Ranged shrek = new Ranged("Shrek");
        shrekAndCo.addMember(shrek);
        shrekAndCo.removeMember(shrek);
        boolean shrekBelongs = shrekAndCo.containsMember(shrek);
        List<Faction> shrekFactions = shrek.getFactions();
        assertEquals(false, shrekBelongs);
        assertEquals(0, shrekFactions.size());
    }

    @Test
    public void charactersAreAllies(){
        Faction shrekAndCo = new Faction("Shrek & Co");
        Ranged shrek = new Ranged("Shrek");
        Ranged fiona = new Ranged("Fiona");
        shrekAndCo.addMember(shrek);
        shrekAndCo.addMember(fiona);
        boolean areAlies = shrekAndCo.areAllies(shrek, fiona);
        assertEquals(true, areAlies);
    }

    @Test
    public void AttackBetweenAlies(){
        Faction shrekAndCo = new Faction("Shrek & Co");
        Ranged shrek = new Ranged("Shrek");
        Ranged fiona = new Ranged("Fiona");
        shrekAndCo.addMember(shrek);
        shrekAndCo.addMember(fiona);
        Field battlefield = new Field("Far far away");
        fiona.setField(battlefield);
        shrek.setField(battlefield);
        Attack shrekAttacksFiona = new Attack(shrek);
        shrekAttacksFiona.on(fiona);
        boolean areAlies = fiona.getHealth() == 1000;
        assertEquals(true, areAlies);
    }

    @Test
    public void AttackBetweenEnemies(){
        Faction shrekAndCo = new Faction("Shrek & Co");
        Faction fionaAndCo = new Faction("Fiona & Co");
        Ranged shrek = new Ranged("Shrek");
        Ranged fiona = new Ranged("Fiona");
        shrekAndCo.addMember(shrek);
        fionaAndCo.addMember(fiona);
        Field battlefield = new Field("Far far away");
        fiona.setField(battlefield);
        shrek.setField(battlefield);
        Attack shrekAttacksFiona = new Attack(shrek);
        shrekAttacksFiona.on(fiona);
        boolean areAlies = fiona.getHealth() == 1000;
        assertEquals(false, areAlies);
    }

    @Test
    public void AttackOnBetweenAlies(){
        Faction shrekAndCo = new Faction("Shrek & Co");
        Ranged shrek = new Ranged("Shrek");
        Ranged fiona = new Ranged("Fiona");
        shrekAndCo.addMember(shrek);
        shrekAndCo.addMember(fiona);
        Field battlefield = new Field("Far far away");
        fiona.setField(battlefield);
        shrek.setField(battlefield);
        Attack shrekAttacksFiona = new Attack(shrek);
        shrekAttacksFiona.on(fiona);
        int fionasHealth = fiona.getHealth();
        assertEquals(1000, fionasHealth);
    }
    @Test
    public void AttackOnBetweenEnemies(){
        Faction shrekAndCo = new Faction("Shrek & Co");
        Faction fionaAndCo = new Faction("Fiona & Co");
        Ranged shrek = new Ranged("Shrek");
        Ranged fiona = new Ranged("Fiona");
        shrekAndCo.addMember(shrek);
        fionaAndCo.addMember(fiona);
        Field battlefield = new Field("Far far away");
        fiona.setField(battlefield);
        shrek.setField(battlefield);
        Attack shrekAttacksFiona = new Attack(shrek);
        shrekAttacksFiona.on(fiona);
        int fionasHealth = fiona.getHealth();
        assertEquals(950, fionasHealth);
    }

    @Test
    public void AttackOnBetweenAliesInFaction1(){
        Faction shrekAndCo = new Faction("Shrek & Co");
        Faction fionaAndCo = new Faction("Fiona & Co");
        Ranged shrek = new Ranged("Shrek");
        Ranged fiona = new Ranged("Fiona");
        shrekAndCo.addMember(shrek);
        shrekAndCo.addMember(fiona);
        fionaAndCo.addMember(fiona);
        Field battlefield = new Field("Far far away");
        fiona.setField(battlefield);
        shrek.setField(battlefield);
        Attack shrekAttacksFiona = new Attack(shrek);
        shrekAttacksFiona.on(fiona);
        int fionasHealth = fiona.getHealth();
        assertEquals(1000, fionasHealth);
    }

    @Test
    public void charactersWithoutFactionCanAttack(){
        Character shrek = new Character("Shrek");
        Character fiona = new Character("Fiona");
        Field battlefield = new Field("Far far away");
        fiona.setField(battlefield);
        shrek.setField(battlefield);
        Attack shrekAttacksFiona = new Attack(shrek );
        shrekAttacksFiona.on(fiona);
        int fionasHealth = fiona.getHealth();
        assertEquals(950, fionasHealth);
    }

    @Test
    public void characterIsCreatedWithoutFaction(){
        Character shrek = new Character("Shrek");
        int shrekFactions = shrek.getFactions().size();
        assertEquals(0, shrekFactions);
    }

    @Test
    public void aliesCanHealEachOtherAfterAttack(){
        Ranged shrek = new Ranged("Shrek");
        Ranged fiona = new Ranged("Fiona");
        Ranged hadaMadrina = new Ranged("Hada Madrina");
        Faction shrekAndCo = new Faction("Shrek & Co");
        shrekAndCo.addMember(shrek);
        shrekAndCo.addMember(fiona);
        Field battlefield = new Field("Far far away");
        fiona.setField(battlefield);
        shrek.setField(battlefield);
        hadaMadrina.setField(battlefield);
        Attack hadaMadrinaAttacksShrek = new Attack(hadaMadrina);
        hadaMadrinaAttacksShrek.on(shrek);
        Heal fionaHealsShrek = new Heal(fiona);
        fionaHealsShrek.on(shrek);
        int shreksHealth = shrek.getHealth();
        assertEquals(1000, shreksHealth);

    }

    @Test
    public void enemiesCantHealEachOtherAfterAttack(){
        Ranged shrek = new Ranged("Shrek");
        Ranged hadaMadrina = new Ranged("Hada Madrina");
        Faction shrekAndCo = new Faction("Shrek & Co");
        shrekAndCo.addMember(shrek);
        Field battlefield = new Field("Far far away");
        shrek.setField(battlefield);
        hadaMadrina.setField(battlefield);
        Attack hadaMadrinaAttacksShrek = new Attack(hadaMadrina);
        hadaMadrinaAttacksShrek.on(shrek);
        Heal hadaMadrinaHealsShrek = new Heal(hadaMadrina);
        hadaMadrinaHealsShrek.on(shrek);
        int shreksHealth = shrek.getHealth();
        assertEquals(950, shreksHealth);

    }

    @Test
    public void characterCanHealHimself(){
        Ranged shrek = new Ranged("Shrek");
        Ranged hadaMadrina = new Ranged("Hada Madrina");
        Field battlefield = new Field("Far far away");
        shrek.setField(battlefield);
        hadaMadrina.setField(battlefield);
        Attack hadaMadrinaAttacksShrek = new Attack(hadaMadrina);
        hadaMadrinaAttacksShrek.on(shrek);
        Heal shrekHealsHimself = new Heal(shrek);
        shrekHealsHimself.on(shrek);
        int shreksHealth = shrek.getHealth();
        assertEquals(1000, shreksHealth);
    }

    @Test
    public void thingsCanBeCreated(){
        Field field = new Field("Far far away");
        Thing tree = new Thing("Tree", new Coord(2,2), field);
        String name = tree.getName();
        int health = tree.getHealth();
        boolean status = tree.getIsDestroyed();
        String position = "("+tree.getPosition().getX()+","+tree.getPosition().getY()+")";
        String fieldName = tree.getField().getName();
        assertEquals("Tree", name);
        assertEquals(1000, health);
        assertEquals(false, status);
        assertEquals("(2,2)", position);
        assertEquals("Far far away", fieldName);
    }

    @Test
    public void thingsCanBeHurted(){
        Field field = new Field("Far far away");
        Thing tree = new Thing("Tree", new Coord(2,2), field);
        Ranged shrek = new Ranged("Shrek");
        shrek.setField(field);
        Attack shrekAttacksTree = new Attack(shrek);
        shrekAttacksTree.on(tree);
        int treeHealth = tree.getHealth();
        assertEquals(950, treeHealth);
    }

    @Test
    public void thingsCanBeDestroyed(){
        Field field = new Field("Far far away");
        Thing tree = new Thing("Tree", new Coord(2,2), field);
        Ranged shrek = new Ranged("Shrek");
        shrek.setField(field);
        shrek.setAttackPower(1000);
        Attack shrekAttacksTree = new Attack(shrek);
        shrekAttacksTree.on(tree);
        boolean treeIsDestroyed = tree.getIsDestroyed();
        boolean treeIsntOnField = field.isCoordOnField(tree.getPosition());
        System.out.println("("+tree.getPosition().getX()+","+tree.getPosition().getY()+")");
        assertEquals(true, treeIsDestroyed);
        assertEquals(false, treeIsntOnField);
    }
}