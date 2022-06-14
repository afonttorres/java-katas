package rpgCombat;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class CharacterTest {

    //ITERATION 1//
    //DEFAULT VALUES//
    @Test
    void CharacterHasInitProps(){
        Character shrek = new Character("Shrek");
        int health = shrek.getHealth();
        int level = shrek.getLevel();
        int attackPower = shrek.getAttackPower();
        int healingPower = shrek.getHealingPower();
        int maxRange = shrek.getMaxRange();
        boolean isAlive = shrek.getIsAlive();
        String name = shrek.getName();
        assertEquals(1000, health);
        assertEquals(1, level);
        assertEquals(50, attackPower);
        assertEquals(50,healingPower);
        assertEquals(2, maxRange);
        assertEquals(true, isAlive);
        assertEquals("Shrek", name);
    }

    //ITERATION 2
    @Test
    public void CharacterHurtsCharacter(){
        Character shrek = new Character("Shrek");
        Character fiona = new Character("Fiona");
        fiona.attacks(shrek);
        int result = shrek.getHealth();
        assertEquals( 950, result);
    }

    @Test
    public void CharacterCantHurtHimself(){
        Character shrek = new Character("Shrek");
        shrek.attacks(shrek);
        int result = shrek.getHealth();
        assertEquals( 1000, result);
    }

    @Test
    public void CharacterCantHealCharacter(){
        Character shrek = new Character("Shrek");
        Character fiona = new Character("Fiona");
        fiona.attacks(shrek);
        shrek.getsHealed(fiona);
        int result = shrek.getHealth();
        assertEquals( 950, result);
    }

    @Test
    public void CharacterCanHealHimself(){
        Character shrek = new Character("Shrek");
        Character fiona = new Character("Fiona");
        fiona.attacks(shrek);
        shrek.getsHealed(shrek);
        int result = shrek.getHealth();
        assertEquals( 1000, result);
    }

    @Test
    public void CharactersAttackPowerGetsRaisedByOponentLevel(){
        Character shrek = new Character("Shrek");
        Character fiona = new Character("Fiona");
        fiona.setLevel(6);//mec
        fiona.attacks(shrek);
        int result = shrek.getHealth();
        assertEquals( 925, result);
    }

    @Test
    public void CharactersAttackPowerGetsReducedByOponentLevel(){
        Character shrek = new Character("Shrek");
        Character fiona = new Character("Fiona");
        shrek.setLevel(6);//mec
        fiona.attacks(shrek);
        int result = shrek.getHealth();
        assertEquals( 975, result);
    }

    //ITERATION 3
    @Test
    public void MeleeCanBeCreated(){
        Melee shrek = new Melee("Shrek");
        String name = shrek.getName();
        int maxRange = shrek.getMaxRange();
        assertEquals("Shrek",name);
        assertEquals(2,maxRange);
    }
    @Test
    public void RangedCanBeCreated(){
        Ranged shrek = new Ranged("Shrek");
        String name = shrek.getName();
        int maxRange = shrek.getMaxRange();
        assertEquals("Shrek",name);
        assertEquals(20,maxRange);

    }

    @Test
    public void MeleeAttacksRanged(){
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
    public void CoordCanBeCreated(){
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
    public void MeleeHasInitPosition(){
        Melee shrek = new Melee("Shrek");
        int xRes = shrek.getPosition().getX();
        int yRes = shrek.getPosition().getY();
        assertEquals(0, xRes);
        assertEquals(0, yRes);
        System.out.println("("+xRes+","+yRes+")");
    }

    @Test
    public void FieldContainsCharPosition(){
        Melee shrek = new Melee("Shrek");
        Field field = new Field("Far far away");
        shrek.setField(field);
        boolean isCharInField = field.isCoordOnField(shrek.getPosition());
        assertEquals(true, isCharInField);
    }

    @Test
    public void FieldDoesntContainCharPosition(){
        Ranged fiona = new Ranged("Fiona");
        Field field = new Field("Far far away");
        fiona.setField(field);
        fiona.setPosition(new Coord(2,15));

        boolean isCharInField = field.isCoordOnField(new Coord(2,15));

        assertEquals(false,isCharInField );
    }

    @Test
    public void calcDistance(){
        Ranged fiona = new Ranged("Fiona");
        Melee shrek = new Melee("Shrek");
        Field field = new Field("Far far away");
        fiona.setField(field);
        fiona.setPosition(new Coord(5,2));
        shrek.setField(field);
        shrek.setPosition(new Coord(8,4));
        double result = field.calcDistance(fiona.getPosition(), shrek.getPosition());
        assertEquals(3.6, result);
    }

    @Test
    public void AttackerCanAttackTarget(){
        Ranged fiona = new Ranged("Fiona");
        Melee shrek = new Melee("Shrek");
        Field field = new Field("Far far away");
        fiona.setField(field);
        shrek.setField(field);
        fiona.setPosition(new Coord(5,2));
        shrek.setPosition(new Coord(8,4));
        Attack attack = new Attack(fiona);
        attack.on(shrek);
        boolean canAttack = shrek.getHealth() == 950;
        assertEquals(true, canAttack);
    }

    @Test
    public void AttackerCantAttackTarget(){
        Ranged fiona = new Ranged("Fiona");
        Melee shrek = new Melee("Shrek");
        Field field = new Field("Far far away");
        fiona.setField(field);
        shrek.setField(field);
        fiona.setPosition(new Coord(5,2));
        shrek.setPosition(new Coord(8,4));


        Attack attack = new Attack(shrek);
        attack.on(fiona);
        boolean canAttack = fiona.getHealth() == 950;
        assertEquals(false, canAttack);
    }

    @Test
    public void AttackerAttacksTarget(){
        Ranged fiona = new Ranged("Fiona");
        Melee shrek = new Melee("Shrek");
        Field field = new Field("Far far away");
        fiona.setField(field);
        shrek.setField(field);

        fiona.setPosition(new Coord(5,2));
        shrek.setPosition(new Coord(8,4));

        Attack fionaAttacksShrek = new Attack(fiona);
        fionaAttacksShrek.on(shrek);
        int targetHealth = shrek.getHealth();
        assertEquals(950, targetHealth);
    }

    @Test
    public void AttackerAttacksTargetButDoesntHurtHim(){
        Ranged fiona = new Ranged("Fiona");
        Melee shrek = new Melee("Shrek");
        Field field = new Field("Far far away");
        fiona.setField(field);
        shrek.setField(field);
        fiona.setPosition(new Coord(5,2));
        shrek.setPosition(new Coord(8,4));
        Attack shrekAttacksFiona = new Attack(shrek);
        shrekAttacksFiona.on(fiona);
        int targetHealth = fiona.getHealth();
        assertEquals(1000, targetHealth);
    }

    @Test
    public void FactionCanBeCreated(){
        Faction faction = new Faction("Shrek & Co");
        String factionName = faction.getName();
        assertEquals("Shrek & Co", factionName);
    }

    @Test
    public void FactionDoesntContainMember(){
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
    public void CharacterBelongsToFaction(){
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
    public void CharacterBelongsTo2Factions(){
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
    public void CharactersAreAllies(){
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
    public void CharactersWithoutFactionCanAttack(){
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
    public void CharacterIsCreatedWithoutFaction(){
        Character shrek = new Character("Shrek");
        int shrekFactions = shrek.getFactions().size();
        assertEquals(0, shrekFactions);
    }

    @Test
    public void AliesCanHealEachOtherAfterAttack(){
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
    public void EnemiesCantHealEachOtherAfterAttack(){
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
    public void CharacterCanStillHealHimself(){
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
    public void ThingsCanBeCreated(){
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
    public void ThingsCanBeHurted(){
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
    public void ThingsCanBeDestroyed(){
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

    @Test
    public void ThingsCanAttackCharacter(){
        Field field = new Field("Far far away");
        Thing tree = new Thing("Tree", new Coord(2,2), field);
        Ranged shrek = new Ranged("Shrek");
        shrek.setField(field);
        //Attack treeAttacksShrek = new Attack(tree);
        //treeAttacksShrek.on(shrek);
        int shrekHealth = shrek.getHealth();
        assertEquals(1000, shrekHealth);
    }

    @Test
    public void CharacterDiesAndGetRemovedFromFactionsAndField(){
        Field field = new Field("Far far away");
        Ranged shrek = new Ranged("Shrek");
        shrek.setField(field);
        Ranged fiona = new Ranged("Fiona");
        fiona.setField(field);
        Faction shreks = new Faction("Shreks");
        shrek.becomeFactionMember(shreks);
        Attack fionaAttacks = new Attack(fiona);
        fiona.setAttackPower(1000);
        fionaAttacks.on(shrek);

        boolean isAlive = shrek.getIsAlive();
        int enrolledFactions = shrek.getFactions().size();
        boolean factionContainsHim = shreks.containsMember(shrek);
        boolean isOnField = field.isCoordOnField(shrek.getPosition());
        assertEquals(false, isAlive);
        assertEquals(0, enrolledFactions);
        assertEquals(false, factionContainsHim);
        assertEquals(false, isOnField);

    }

    @Test
    public void CoordHasContent(){
        Field field = new Field("Far far away");
        Coord position = new Coord(2,2);
        Thing tree = new Thing("Tree", position, field);
        int contentSize = tree.getPosition().getContent().size();
        assertEquals(1, contentSize);
    }

    @Test
    public void CoordCanHave3Things(){
        Field field = new Field("Far far away");
        Coord position = new Coord(2,2);
        Thing tree = new Thing("Tree", position, field);
        Thing rock = new Thing("Rock1", position, field);
        Thing rock2 = new Thing("Rock2", position, field);
        int contentSize = tree.getPosition().getContent().size();
        assertEquals(3, contentSize);
    }
    @Test
    public void CoordCanOnlyHave3Things(){
        Field field = new Field("Far far away");
        Coord position = new Coord(2,2);
        Thing tree1 = new Thing("Tree1", position, field);
        Thing tree2 = new Thing("Tree2", position, field);
        Thing rock = new Thing("Rock1", position, field);
        Thing rock2 = new Thing("Rock2", position, field);

        int contentSize = field.getCoordContent(position).size();
        assertEquals(3, contentSize);
    }

    @Test
    public void CoordCantContentSameThing(){
        Field field = new Field("Far far away");
        Coord position = new Coord(2,2);
        Thing tree1 = new Thing("Tree1", position, field);
        position.setContent(tree1);
        int contentSize = field.getCoordContent( new Coord(2,2)).size();
        assertEquals(1, contentSize);
    }

    @Test
    public void CoordHasCharacter(){
        Field field = new Field("Far far away");
        Character shrek = new Character("Shrek");
        shrek.setField(field);
        shrek.setPosition(new Coord(2,2));
        int contentSize = field.getCoordContent(new Coord(2,2)).size();
        assertEquals(1, contentSize);
    }

    @Test
    public void CoordCanHaveToCharacters(){
        Field field = new Field("Far far away");
        Character shrek = new Character("Shrek");
        Character fiona = new Character("Fiona");
        Coord position = new Coord(2,2);
        shrek.setField(field);
        fiona.setField(field);
        shrek.setPosition(position);
        fiona.setPosition(position);
        int contentSize = field.getCoordContent(position).size();
        assertEquals(2, contentSize);
    }

    @Test
    public void CoordCanHaveBothCharsAndThings(){
        Field field = new Field("Far far away");
        Character shrek = new Character("Shrek");
        Coord position = new Coord(2,2);
        Thing tree = new Thing("Tree", position, field);
        shrek.setField(field);
        shrek.setPosition(position);
        int contentSize = field.getCoordContent(position).size();
        assertEquals(2, contentSize);
    }

    @Test
    public void CoordCanHaveBothCharsAndThingsButNotExceedMaxContent(){
        Field field = new Field("Far far away");
        Character shrek = new Character("Shrek");
        Character fiona = new Character("Fiona");
        shrek.setField(field);
        fiona.setField(field);

        Coord position = new Coord(2,2);
        Thing tree = new Thing("Tree", position, field);
        Thing rock = new Thing("Rock", position, field);

        shrek.setPosition(position);
        fiona.setPosition(position);

        int contentSize = position.getContent().size();
        System.out.println(field.getCoordContent(position));
        assertEquals(3, contentSize);
    }

    @Test
    public void placingThingsOnField(){
        Field field = new Field("Far far away");
        Character shrek = new Character("Shrek");
        shrek.setField(field);
        Character fiona = new Character("Fiona");
        fiona.setField(field);
        Coord position = new Coord(2,2);
        shrek.setPosition(position);
        fiona.setPosition(position);
        int coordContentSize = field.getCoordContent(position).size();
        assertEquals(2, coordContentSize);
    }

    @Test
    public void placingContentOnFieldFromDifPosition(){
        Field field = new Field("Far far away");
        Character shrek = new Character("Shrek");
        Character fiona = new Character("Fiona");
        Character burro = new Character("Burro");
        shrek.setField(field);
        fiona.setField(field);
        burro.setField(field);
        shrek.setPosition(new Coord(2,2));
        fiona.setPosition(new Coord(2,2));
        burro.setPosition(new Coord(2,2));
        int coordContentSize = field.getCoordContent(new Coord(2,2)).size();
        assertEquals(3, coordContentSize);
    }

    @Test
    public void cantPlaceMoreContentThanMaxContent(){
        Field field = new Field("Far far away");
        Character shrek = new Character("Shrek");
        Character fiona = new Character("Fiona");
        Character burro = new Character("Burro");
        Character pinocho = new Character("Pinocho");
        shrek.setField(field);
        fiona.setField(field);
        burro.setField(field);
        pinocho.setField(field);
        shrek.setPosition(new Coord(2,2));
        fiona.setPosition(new Coord(2,2));
        burro.setPosition(new Coord(2,2));
        pinocho.setPosition(new Coord(2,2));

        int coordContentSize = field.getCoordContent(new Coord(2,2)).size();
        assertEquals(3, coordContentSize);
    }

    @Test
    public void placingThingsAndChars(){
        Field field = new Field("Far far away");
        Character shrek = new Character("Shrek");
        Character fiona = new Character("Fiona");
        Thing tree = new Thing("Tree", new Coord(2,2), field);
        shrek.setField(field);
        fiona.setField(field);
        shrek.setPosition(new Coord(2,2));
        fiona.setPosition(new Coord(2,2));

        int coordContentSize = field.getCoordContent(new Coord(2,2)).size();
        assertEquals(3, coordContentSize);
    }

    @Test
    public void getFieldContent(){
        Field field = new Field("Far far away");
        Character shrek = new Character("Shrek");
        Character fiona = new Character("Fiona");
        Thing tree = new Thing("Tree", new Coord(2,2), field);
        Thing rock = new Thing("Rock", new Coord(3,3), field);
        shrek.setField(field);
        fiona.setField(field);
        shrek.setPosition(new Coord(2,2));
        fiona.setPosition(new Coord(2,2));
        int fieldContent = field.getFieldContent().size();
        int c22Content = field.getCoordContent(new Coord(2,2)).size();
        int c33Content = field.getCoordContent(new Coord(3,3)).size();
        assertEquals(4, fieldContent);
        assertEquals(3, c22Content);
        assertEquals(1, c33Content);
    }

}