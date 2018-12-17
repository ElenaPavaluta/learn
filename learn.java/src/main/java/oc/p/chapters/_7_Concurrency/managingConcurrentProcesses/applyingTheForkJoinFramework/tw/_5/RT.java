package oc.p.chapters._7_Concurrency.managingConcurrentProcesses.applyingTheForkJoinFramework.tw._5;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.attribute.BasicFileAttributes;
import java.nio.file.attribute.FileTime;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.temporal.ChronoUnit;
import java.util.List;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveTask;

import static java.util.stream.Collectors.toList;
import static utils.resources.files.Resources.SRC_MAIN_JAVA;
import static utils.resources.files.Separation.SLASH;

class RT extends RecursiveTask <Integer> {

    private Path startPath;
    private FileTime startTime;

    RT(final Path startPath) {
        this.startPath = startPath;
    }

    public static void main(String[] args) throws IOException {
        Path path = Paths.get(SLASH.separationOf(SRC_MAIN_JAVA));
        LocalDateTime localDateTime = LocalDateTime.now();
        localDateTime = localDateTime.minus(localDateTime.getDayOfMonth(), ChronoUnit.DAYS);
        FileTime fileTime = FileTime.from(ZonedDateTime.of(localDateTime, ZoneId.systemDefault()).toInstant());

//        ForkJoinTask <Integer> task = new RT(path);
        RT task = new RT(path);
        ForkJoinPool pool = new ForkJoinPool();
        System.out.println(pool.invoke(task));

        task.m();
    }

    void m() throws IOException {
        long count = Files.walk(startPath)
                .filter(Files::isRegularFile)
                .mapToInt(p -> 1)
                .summaryStatistics()
                .getCount();
        System.out.println(count);

    }

    @Override
    protected Integer compute() {
        int count = 0;
        BasicFileAttributes bfa = getBfa();
        if (bfa.isRegularFile()) {
            return ++count;
        } else {
            if (bfa.isDirectory()) {
                List <RT> list = list();
                list.forEach(RT::fork);
                return count += (int) list.stream()
                        .mapToInt(RT::join)
                        .summaryStatistics()
                        .getSum();
            }
        }
        return count;
    }

    private List <RT> list() {
        try {
            return Files.list(startPath)
                    .map(p -> new RT(p))
                    .collect(toList());
        } catch (IOException e) {
            System.out.println();
        }
        return null;
    }

    private BasicFileAttributes getBfa() {
        try {
            BasicFileAttributes bfa = Files.readAttributes(startPath, BasicFileAttributes.class);
            return bfa;
        } catch (IOException e) {
            System.out.println("Err on Files.readAttributes(startPath, BasicFileAttributes.class)");
        }
        return null;
    }
}
