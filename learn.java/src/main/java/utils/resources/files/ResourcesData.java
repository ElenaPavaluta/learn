package utils.resources.files;

import java.nio.file.attribute.FileTime;
import java.time.*;
import java.time.temporal.ChronoUnit;

public enum ResourcesData {

    THIS_MONTH {
        @Override
        public Instant instant() {
            LocalDateTime ldt = LocalDateTime.now();
            ldt = ldt.minus(ldt.getDayOfMonth(), ChronoUnit.DAYS);

            return ZonedDateTime.of(ldt, ZoneId.systemDefault()).toInstant();
        }
    },
    THIS_YEAR {
        @Override
        public Instant instant() {
            LocalDate ld = LocalDate.now();
            ld = ld.minusMonths(ld.getMonthValue() - 1);
            ld = ld.minusDays(ld.getDayOfMonth() - 1);

            LocalTime lt = LocalTime.now();

            return ZonedDateTime.of(ld, lt, ZoneId.systemDefault()).toInstant();
        }
    };


    public abstract Instant instant();

    public FileTime fileTime() {
        return FileTime.from(instant());
    }

}
