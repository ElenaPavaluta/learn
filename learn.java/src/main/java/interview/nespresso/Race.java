package interview.nespresso;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static interview.nespresso.Ship.COMPARE_BY_SPEED;
import static java.util.stream.Collectors.toList;

class Race {
    private final List <Ship> ships;

    Race(Ship... others) {
        ships = Arrays.stream(others)
                .filter(o -> o instanceof Ship)
                .map(o ->(Ship) o)
                .collect(toList());
    }

    Ship winner() {
        return ships.stream()
                .sorted()
                .findFirst()
                .orElse(null);

    }
}
