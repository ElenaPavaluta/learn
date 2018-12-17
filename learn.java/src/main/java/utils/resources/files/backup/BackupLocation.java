package utils.resources.files.backup;

import java.io.File;
import java.nio.file.Path;
import java.nio.file.Paths;

import static utils.resources.files.Resources.SRC_MAIN_JAVA;
import static utils.resources.files.Separation.SLASH;

enum BackupLocation {
    IQ_NESPRESSO_NAVAL_BATTLE("iq.nespresso.naval.battle"),
    IQ_NESPRESSO_TOURNAMENT("iq.nespresso.tournament");

    String location;

    BackupLocation(final String srcMainJavaLocation) {
        this.location = srcMainJavaLocation;
    }

    Path toSrcMainJavaPackagePath() {
        return Paths.get(SLASH.separationOf(SRC_MAIN_JAVA), SLASH.separationOf(location));
    }

    String toSrcMainJavaLocation() {
        return SLASH.separationOf(SRC_MAIN_JAVA) + File.separator + SLASH.separationOf(location);
    }
}
