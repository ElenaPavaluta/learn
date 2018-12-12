package i.nespresso.naval.battle;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.stream.Stream;

class Battle {
    private ExecutorService exec = null;
    private Side side;
    private Side otherSide;
    private boolean battleEnded = false;

    Battle() {
        exec = Executors.newCachedThreadPool();
    }

    Side side(Ship... ships) {
        side = new Side(ships);
        return side;
    }

    private synchronized void fight() {
        try {
            while (!oneSideIsDefeated()) {
                side.addFireBonus(otherSide);
                otherSide.addFireBonus(side);
                side.fire(exec, otherSide);
                otherSide.fire(exec, side);
            }
            TimeUnit.SECONDS.sleep(3);
        } catch (InterruptedException e) {
            System.out.println(e.getMessage());
        } finally {
            if (exec != null) {
                exec.shutdownNow();
            }
            battleEnded = true;
            notifyAll();
        }
    }

    private boolean oneSideIsDefeated() {
        return side.isDefeated() || otherSide.isDefeated();
    }

    synchronized boolean isInTheWinningSide(final Ship b) {
        while (!battleEnded) {
            try {
                wait();
            } catch (InterruptedException e) {
                System.out.println(e.getMessage());
            }
        }
        return Stream.of(side, otherSide)
                .filter(s -> !s.isDefeated())
                .map(side -> side.ships)
                .flatMap(List::stream)
                .anyMatch(s -> s.isEqualTo(b));
    }

    class Side {
        private List <Ship> ships;
        private CombatStrategy strategy = CombatStrategy.FIRE_TO_ALL_SEQUENTIALLY;

        Side(Ship... ships) {
            battleEnded = false;
            this.ships = Arrays.asList(ships);
        }

        Battle against(Ship... ships) {
            otherSide = new Side(ships);
            exec.submit(() -> fight());
            return Battle.this;
        }

        void addFireBonus(final Side otherSide) {
            int bonus = active(otherSide) - active(this);
            if (bonus > 0) {
                ships.stream()
                        .filter(Ship::isActive)
                        .forEach(s -> s.addFireBonus(bonus * 15 / 100));
            }
        }

        private int active(final Side side) {
            return (int) side.ships.stream()
                    .filter(Ship::isActive)
                    .count();
        }

        boolean isDefeated() {
            return ships.stream()
                    .allMatch(Ship::isDistroyed);
        }

        void fire(final ExecutorService exec, final Side otherSide) {
            strategy.fire(this, otherSide, exec);
        }

        List <Ship> ships() {
            return ships;
        }
    }
}
