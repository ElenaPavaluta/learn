package books.thinkigInJava._4ThEdition.chapters.generics.mixins.usingTheDecoratorPattern;

import java.time.LocalDateTime;
import java.time.ZoneOffset;

class TimeStamped extends Decorator {
    private final long timeStamp;

    public TimeStamped(Basic basic) {
        super(basic);
        this.timeStamp = LocalDateTime.now().toEpochSecond(ZoneOffset.UTC);
    }

    public long getTimeStamp() {
        return timeStamp;
    }
}
