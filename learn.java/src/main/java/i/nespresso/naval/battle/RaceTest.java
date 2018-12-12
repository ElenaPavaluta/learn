package interview.nespresso.naval.battle;


import org.junit.Test;

import static org.junit.Assert.assertTrue;

public class RaceTest {

    // Speed of a ship is its displacement divided by number of mast: the lower the value, the faster the ship
    @Test
    public void fastestShouldWin() {

        Ship a = new Ship("a", 20000, 2); // 20000 tons of displacement, 2 masts
        Ship b = new Ship("b", 7500, 1);

        Race race = new Race(a, b);
        assertTrue(race.winner().isEqualTo(b));
    }
    // a clipper goes 20% faster than a standard ship.

    @Test
    public void clipperGoesFaster() {

        Ship a = new Ship("s", 20000, 2);
        Ship b = new Ship("b", 7500, 1);
        Clipper c = new Clipper("c", 18000, 2);

        Race race = new Race(a, b, c);
        assertTrue(race.winner().isEqualTo(c));
    }


    // any ship can carry cannons, each cannons grant 0.5% cumulative penalty to speed
    @Test
    public void armedShipAreUsuallySlower() {

        Ship a = new Ship("a", 7800, 1, 16);  // 7800 tons of displacement, 1 masts, 16 cannons
        Ship b = new Ship("b", 8000, 1);

        Race race = new Race(a, b);
        assertTrue(race.winner().isEqualTo(b));
    }


}
