package interview.nespresso._2;

import java.util.List;
import java.util.stream.IntStream;

import static java.util.stream.Collectors.toList;

class Artillery {
    private int nbOfCannons;
    private List <Cannon> cannons;

    Artillery(final int nbOfCannons) {
        this.nbOfCannons = nbOfCannons;
        cannons = IntStream.rangeClosed(1, nbOfCannons)
                .mapToObj(i -> new Cannon())
                .collect(toList());
    }
}
