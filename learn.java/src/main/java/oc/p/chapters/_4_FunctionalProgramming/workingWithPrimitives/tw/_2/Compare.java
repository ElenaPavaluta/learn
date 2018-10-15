package oc.p.chapters._4_FunctionalProgramming.workingWithPrimitives.tw._2;

import java.util.DoubleSummaryStatistics;
import java.util.Optional;
import java.util.OptionalDouble;
import java.util.stream.DoubleStream;
import java.util.stream.Stream;

import static java.util.Comparator.naturalOrder;
import static java.util.stream.Collectors.*;

class Compare {
    static Stream <Double> sd;
    static DoubleStream ds;
    static DoubleSummaryStatistics dss;

    static void init() {
        sd = Stream.of(2.2, 3.3, 4.4);
        ds = DoubleStream.of(2.2, 3.3, 4.4);
    }

    static void m() {
        Optional <Double> first = sd.findFirst();
        OptionalDouble first1 = ds.findFirst();

        Optional <Double> any = sd.findAny();
        OptionalDouble any1 = ds.findAny();

        Optional <Double> min = sd.collect(minBy(naturalOrder()));
        OptionalDouble min1 = ds.min();
        double min2 = dss.getMin();

        Optional <Double> max = sd.max(naturalOrder());
        OptionalDouble max1 = ds.max();
        double max2 = dss.getMax();

        Double average = sd.collect(averagingDouble(Double::doubleValue));
        OptionalDouble average1 = ds.average();
        double average2 = dss.getAverage();

        Double sum = sd.collect(summingDouble(Double::doubleValue));
        double sum1 = ds.sum();
        double sum2 = dss.getSum();

        Long count = sd.collect(counting());
        long count1 = sd.count();
        long count2 = dss.getCount();
    }
}
