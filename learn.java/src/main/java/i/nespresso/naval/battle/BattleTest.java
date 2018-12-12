package i.nespresso.naval.battle;


import org.junit.Test;

import static org.junit.Assert.assertTrue;


public class BattleTest {


    // each ship has :
    // hull has 1 hit point per ton of displacement
    // 100 hit point per canon
    // 1000 hit point per mast

    // each canon does 200p damage

    // this is a global fight, damages are not localized, nor impact dynamically ship statistics
    // fight last until one side is sunk
    // damages happens simultaneously

    @Test
    public void fight() {
        Ship a = new Ship("a", 7500, 1, 16);
        Ship b = new Ship("b", 12000, 1, 16);

        Battle battle = new Battle().side(a).against(b);

        assertTrue(battle.isInTheWinningSide(b));
    }

    // when the battle is not even in terms of number of ship
    // each ship of the outnumbering team gains an 15 % bonus per additional ship to it's damages.
    // each ship always target the same opponent until it's sunk (once sunk it can not participate to the fight anymore,
    // nor count for the presence & calculation of the bonus)
    @Test
    public void packfight() {
        Ship a = new Ship("a", 65000, 3, 64);
        Ship b = new Ship("b", 23000, 1, 24);
        Ship c = new Ship("c", 23000, 1, 24);
        Ship d = new Ship("d", 23000, 1, 24);

        Battle battle = new Battle().side(a).against(b, c, d);
        assertTrue(battle.isInTheWinningSide(b));
        assertTrue(battle.isInTheWinningSide(c));
        assertTrue(battle.isInTheWinningSide(d));
    }


    // this one comes for free as control group for next one :D
    @Test
    public void packfightLightBoat() {
        Ship a = new Ship("a", 65000, 3, 64);
        Ship b = new Ship("b",15000, 1, 24);
        Ship c = new Ship("c", 15000, 1, 24);
        Ship d = new Ship("d", 15000, 1, 24);

        Battle battle = new Battle().side(a).against(b, c, d);
        assertTrue(battle.isInTheWinningSide(a));
    }
//
    // damages are now localized and a applied in this order :
// first mast are destroyed, then cannons, then the hull
    // destroyed part of the ship changes it's characteristics :
    // a destroyed mast reduce overall ship speed
    // a destroyed canon can not fire anymore thus it's ship does less damages
    // a full destroyed hull means the ship has sunk
//    @Test
//    public void packfightLightBoatLocalized() {
//        Ship a = new Ship(65000, 3, 64);
//        Ship b = new Ship(23000, 1, 24);
//        Ship c = new Ship(23000, 1, 24);
//        Ship d = new Ship(23000, 1, 24);
//
//        Battle battle = new Battle(Battle.LOCALIZED_DAMAGES).side(a).against(b, c, d);
//        assertTrue(battle.isInTheWinningSide(b));
//        assertTrue(battle.isInTheWinningSide(c));
//        assertTrue(battle.isInTheWinningSide(d));
//    }

}