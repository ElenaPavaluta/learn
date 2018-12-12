package interview.nespresso.naval.battle;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import static interview.nespresso.naval.battle.Ship.COMPARE_BY_SPEED;
import static java.util.stream.Collectors.toList;

class Race {

    private List <Ship> ships;

    Race(Ship a, Ship b, Ship... others) {
        ships = Stream.of(new Ship[]{a, b}, others)
                .flatMap(Arrays::stream)
                .filter(s -> s instanceof Ship)
                .collect(toList());
    }


    Ship winner() {
        return ships.stream()
                .sorted(COMPARE_BY_SPEED)
                .findFirst()
                .get();
    }
}
