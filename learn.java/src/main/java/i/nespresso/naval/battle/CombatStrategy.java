<<<<<<< HEAD:learn.java/src/main/java/i/nespresso/naval/battle/CombatStrategy.java
package i.nespresso.naval.battle;
=======
package interview.nespresso.naval.battle;
>>>>>>> f9512583f6e3f84a65c6cf88802e5598dffefe73:learn.java/src/main/java/i/nespresso/naval/battle/CombatStrategy.java

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.ExecutorService;

import static java.util.stream.Collectors.toCollection;

enum CombatStrategy {

    FIRE_TO_FIRST_STANDING_SHIP {
        @Override
        void fire(final Battle.Side side, final Battle.Side other, final ExecutorService exec) {
            if (!other.isDefeated()) {
                final Ship target = other.ships().stream()
                        .filter(Ship::isActive)
                        .findFirst()
                        .get();
                side.ships()
                        .forEach(s -> exec.submit(() -> s.fireTo(target)));
            }
        }
    },
    FIRE_TO_ALL_SEQUENTIALLY {
        @Override
        void fire(final Battle.Side side, final Battle.Side other, final ExecutorService exec) {
            if (!other.isDefeated()) {
                final List <Ship> target = other.ships().stream()
                        .filter(Ship::isActive)
                        .collect(toCollection(CopyOnWriteArrayList::new));
                side.ships()
                        .forEach(s -> target.forEach(t -> exec.submit(() -> s.fireTo(t))));
            }
        }
    };

    abstract void fire(Battle.Side side, Battle.Side other, ExecutorService exec);

}
