//package interview.nespresso._2;
//
//
//import interview.nespresso._1.Clipper;
//import interview.nespresso._1.Race;
//import interview.nespresso._1.Ship;
//import org.junit.Test;
//
//import static org.junit.Assert.assertTrue;
//
//public class RaceTest {
//
//    // Speed of a ship is its displacement divided by number of mast: the lower the value, the faster the ship
//    @Test
//    public void fastestShouldWin() {
//
//        interview.nespresso._1.Ship a = new interview.nespresso._1.Ship(20000, 2); // 20000 tons of displacement, 2 masts
//        interview.nespresso._1.Ship b = new interview.nespresso._1.Ship(7500, 1);
//
//        Race race = new Race(a, b);
//        assertTrue(race.winner().isEqualTo(b));
//    }
//    // a clipper goes 20% faster than a standard ship.
//
//    @Test
//    public void clipperGoesFaster() {
//
//        interview.nespresso._1.Ship a = new interview.nespresso._1.Ship(20000, 2);
//        interview.nespresso._1.Ship b = new interview.nespresso._1.Ship(7500, 1);
//        Clipper c = new Clipper(18000, 2);
//
//        Race race = new Race(a, b, c);
//        assertTrue(race.winner().isEqualTo(c));
//    }
//
//
//    // any ship can carry cannons, each cannons grant 0.5% cumulative penalty to speed
//    @Test
//    public void armedShipAreUsuallySlower() {
//
//        interview.nespresso._1.Ship a = new interview.nespresso._1.Ship(7800, 1, 16);  // 7800 tons of displacement, 1 masts, 16 cannons
//        interview.nespresso._1.Ship b = new interview.nespresso._1.Ship(8000, 1);
//
//        Race race = new Race(a, b);
//        assertTrue(race.winner().isEqualTo(b));
//    }
//
//
//}
