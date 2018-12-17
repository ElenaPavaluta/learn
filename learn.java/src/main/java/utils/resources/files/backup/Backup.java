package utils.resources.files.backup;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.function.Function;

import static java.util.Arrays.asList;
import static java.util.stream.Collectors.toMap;
import static utils.resources.files.Resources.DELETE_IF_EXISTS;
import static utils.resources.files.backup.BackupLocation.IQ_NESPRESSO_NAVAL_BATTLE;
import static utils.resources.files.backup.BackupLocation.IQ_NESPRESSO_TOURNAMENT;

class Backup {
    private List <BackupLocation> locations = asList(IQ_NESPRESSO_NAVAL_BATTLE, IQ_NESPRESSO_TOURNAMENT);
    private Function <BackupLocation, Path> TO_BACKUP_PATH = loc -> Paths.get(loc.toSrcMainJavaLocation(), "backup");
    private Function <BackupLocation, Runnable> TO_RUNNABLE = loc -> Files.exists(TO_BACKUP_PATH.apply(loc)) ? new Restore(loc) : new CreateBackup(loc);
    private ExecutorService exec;


    public static void main(String[] args) throws InterruptedException {
        new Backup().run();
    }


    void run() throws InterruptedException {
        try {
            exec = Executors.newCachedThreadPool();
            locations.stream()
                    .map(TO_RUNNABLE)
                    .forEach(exec::submit);
        } finally {
            if (exec != null) {
                exec.shutdown();
                exec.awaitTermination(10, TimeUnit.SECONDS);
            }
        }
    }

    class CreateBackup implements Runnable {
        Function <Path, List <String>> TO_LIST = p -> {
            try {
                return Files.readAllLines(p);
            } catch (IOException e) {
                e.printStackTrace();
            }
            return null;
        };
        private BackupLocation backupLocation;
        private Path backup;

        CreateBackup(final BackupLocation backupLocation) {
            this.backupLocation = backupLocation;
            backup = TO_BACKUP_PATH.apply(backupLocation);
        }

        @Override
        public void run() {
            try {
                final Map <String, List <String>> map = mapFiles();
                saveFiles(map);
                deleteFiles(map);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        private void deleteFiles(final Map <String, List <String>> map) {
            map.keySet().stream()
                    .map(Paths::get)
                    .forEach(DELETE_IF_EXISTS);
        }

        private void saveFiles(final Map <String, List <String>> map) throws IOException {
            backup = Files.createFile(backup);
            try (ObjectOutputStream oos = new ObjectOutputStream(new BufferedOutputStream(new FileOutputStream(backup.toFile())))) {
                oos.writeObject(map);
            }
        }

        private Map <String, List <String>> mapFiles() throws IOException {
            DELETE_IF_EXISTS.accept(backup);
            return Files.find(backupLocation.toSrcMainJavaPackagePath(), 1, (p, bfa) -> bfa.isRegularFile())
                    .collect(toMap(Path::toString, TO_LIST));
        }
    }

    class Restore implements Runnable {
        private BackupLocation backupLocation;
        private Path backup;

        Restore(final BackupLocation backupLocation) {
            this.backupLocation = backupLocation;
            backup = TO_BACKUP_PATH.apply(backupLocation);
        }


        @Override
        public void run() {
            try (ObjectInputStream ois = new ObjectInputStream(new BufferedInputStream(new FileInputStream(backup.toFile())))) {
                final Map <String, List <String>> map = (Map <String, List <String>>) ois.readObject();
                map.keySet().stream()
                        .forEach(k -> createAndPopulateFile(map, k));
            } catch (IOException | ClassNotFoundException e) {
                e.printStackTrace();

            }
            DELETE_IF_EXISTS.accept(backup);
        }

        private void createAndPopulateFile(final Map <String, List <String>> map, final String k) {
            try {
                Path path = Paths.get(k);
                path = Files.createFile(path);
                writeFile(map.get(k), path);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        private void writeFile(final List <String> lst, final Path path) throws IOException {
            try (BufferedWriter bw = Files.newBufferedWriter(path)) {
                for (int i = 0; i < lst.size(); i++) {
                    bw.write(lst.get(i));
                    if (i != lst.size() - 1) {
                        bw.newLine();
                    }
                }
            }
        }
    }
}