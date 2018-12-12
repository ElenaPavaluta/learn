package i.nespresso.naval.battle;

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
