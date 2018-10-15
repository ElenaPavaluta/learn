package oc.p.tests.chapters._15.q._33;

import java.util.Map;
import java.util.stream.Stream;

import static java.util.stream.Collectors.groupingBy;
import static java.util.stream.Collectors.summingInt;

class Ballot {
    private String name ;
    private int judgeNumber;
    private int score;

    Ballot(String name, int judgeNumber, int score) {
        this.name = name;
        this.judgeNumber = judgeNumber;
        this.score = score;
    }

    String getName() {
        return name;
    }

    int getJudgeNumber() {
        return judgeNumber;
    }

    int getScore() {
        return score;
    }
}

class Speaking{
    static void m(){
        Stream<Ballot> ballots = Stream.of(
                new Ballot("Mario", 1, 10),
                new Ballot("Christina", 1, 8),
                new Ballot("Mario", 2, 9),
                new Ballot("Christina", 2, 8)
        );
        Map<String, Integer> scores = ballots.collect(
                groupingBy(Ballot::getName, summingInt(Ballot::getScore)));
        System.out.println(scores.get("Mario"));
    }

    public static void main(String[] args) {
        m();
    }
}
