//package interview.nespresso._2;
//
//import interview.nespresso._1.Battle;
//import interview.nespresso._1.Ship;
//import org.junit.Test;
//
//import static org.junit.Assert.assertTrue;
//
//
//public class BattleTest {
//
//
//    // each ship has :
//    // hull has 1 hit point per ton of displacement
//    // 100 hit point per canon
//    // 1000 hit point per mast
//
//    // each canon does 200p damage
//
//    // this is a global fight, damages are not localized, nor impact dynamically ship statistics
//    // fight last until one side is sunk
//    // damages happens simultaneously
//
//    @Test
//    public void fight() {
//        interview.nespresso._1.Ship a = new interview.nespresso._1.Ship(7500, 1, 16);
//        interview.nespresso._1.Ship b = new interview.nespresso._1.Ship(12000, 1, 16);
//
//        interview.nespresso._1.Battle battle = new interview.nespresso._1.Battle().side(a).against(b);
//
//        assertTrue(battle.isInTheWinningSide(b));
//    }
//
//    // when the battle is not even in terms of number of ship
//    // each ship of the outnumbering team gains an 15 % bonus per additional ship to it's damages.
//    // each ship always target the same opponent until it's sunk (once sunk it can not participate to the fight anymore,
//    // nor count for the presence & calculation of the bonus)
//    @Test
//    public void packfight() {
//        interview.nespresso._1.Ship a = new interview.nespresso._1.Ship(65000, 3, 64);
//        interview.nespresso._1.Ship b = new interview.nespresso._1.Ship(23000, 1, 24);
//        interview.nespresso._1.Ship c = new interview.nespresso._1.Ship(23000, 1, 24);
//        interview.nespresso._1.Ship d = new interview.nespresso._1.Ship(23000, 1, 24);
//
//        interview.nespresso._1.Battle battle = new interview.nespresso._1.Battle().side(a).against(b, c, d);
//        assertTrue(battle.isInTheWinningSide(b));
//        assertTrue(battle.isInTheWinningSide(c));
//        assertTrue(battle.isInTheWinningSide(d));
//    }
//
//
//    // this one comes for free as control group for next one :D
//    @Test
//    public void packfightLightBoat() {
//        interview.nespresso._1.Ship a = new interview.nespresso._1.Ship(65000, 3, 64);
//        interview.nespresso._1.Ship b = new interview.nespresso._1.Ship(15000, 1, 24);
//        interview.nespresso._1.Ship c = new interview.nespresso._1.Ship(15000, 1, 24);
//        interview.nespresso._1.Ship d = new interview.nespresso._1.Ship(15000, 1, 24);
//
//        interview.nespresso._1.Battle battle = new interview.nespresso._1.Battle().side(a).against(b, c, d);
//        assertTrue(battle.isInTheWinningSide(a));
//    }
////
//    // damages are now localized and a applied in this order :
//// first mast are destroyed, then cannons, then the hull
//    // destroyed part of the ship changes it's characteristics :
//    // a destroyed mast reduce overall ship speed
//    // a destroyed canon can not fire anymore thus it's ship does less damages
//    // a full destroyed hull means the ship has sunk
//    @Test
//    public void packfightLightBoatLocalized() {
//        interview.nespresso._1.Ship a = new interview.nespresso._1.Ship(65000, 3, 64);
//        interview.nespresso._1.Ship b = new interview.nespresso._1.Ship(23000, 1, 24);
//        interview.nespresso._1.Ship c = new interview.nespresso._1.Ship(23000, 1, 24);
//        interview.nespresso._1.Ship d = new interview.nespresso._1.Ship(23000, 1, 24);
//
//        interview.nespresso._1.Battle battle = new interview.nespresso._1.Battle(interview.nespresso._1.Battle.LOCALIZED_DAMAGES).side(a).against(b, c, d);
//        assertTrue(battle.isInTheWinningSide(b));
//        assertTrue(battle.isInTheWinningSide(c));
//        assertTrue(battle.isInTheWinningSide(d));
//    }
//
//}