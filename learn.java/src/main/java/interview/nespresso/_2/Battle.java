package interview.nespresso._2;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

class Battle {
    private ExecutorService exec = null;
    private Side side;
    private Side otherSide;

    Side side(Ship... ships) {
        side = new Side(ships);
        return side;
    }

    private void fight() {
        try {
            exec = Executors.newCachedThreadPool();
            while (!oneSideIsDefeated()) {
                side.addFireBonus(otherSide);
                otherSide.addFireBonus(side);
                side.fire(exec, otherSide);
                otherSide.fire(exec, side);
            }
        } finally {
            if (exec != null) {
                exec.shutdownNow();
            }
        }
    }

    private boolean oneSideIsDefeated() {
        return side.isDefeated() || otherSide.isDefeated();
    }

    class Side {
        private List <Ship> ships;
        private CombatStrategy strategy = CombatStrategy.FIRE_TO_ALL_SEQUENTIALLY;

        Side(Ship... ships) {
            this.ships = Arrays.asList(ships);
        }

        Battle against(Ship... ships) {
            otherSide = new Side(ships);
            fight();
            return Battle.this;
        }

        void addFireBonus(final Side otherSide) {
            double fireBonus = 0;
            ships.stream()
                    .filter(Ship::isActive)
                    .forEach(s -> s.addFireBonus(fireBonus));
        }

        void setStrategy(final Side otherSide) {
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
