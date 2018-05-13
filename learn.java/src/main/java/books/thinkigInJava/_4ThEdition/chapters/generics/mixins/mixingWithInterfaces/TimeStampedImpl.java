package books.thinkigInJava._4ThEdition.chapters.generics.mixins.mixingWithInterfaces;

import java.time.LocalDateTime;
import java.time.ZoneOffset;

class TimeStampedImpl implements TimeStamped {
    private final long timeStamp;

    public TimeStampedImpl() {
        timeStamp = LocalDateTime.now().toEpochSecond(ZoneOffset.UTC);
    }

    @Override
    public long getStamp() {
        return timeStamp;
    }
}
