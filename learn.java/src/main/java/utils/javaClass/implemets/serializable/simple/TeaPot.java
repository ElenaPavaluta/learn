package utils.javaClass.implemets.serializable.simple;

import java.io.Serializable;
import java.time.LocalDateTime;

public class TeaPot implements Serializable{

    private LocalDateTime localDateTime;
    private Tea tea;

    public TeaPot( Tea tea) {
        localDateTime = LocalDateTime.now();
        this.tea = tea;
    }

    public LocalDateTime getLocalDateTime() {
        return localDateTime;
    }

    public void setLocalDateTime(LocalDateTime localDateTime) {
        this.localDateTime = localDateTime;
    }


    public Tea getTea() {
        return tea;
    }

    public void setTea(Tea tea) {
        this.tea = tea;
    }

    @Override
    public String toString() {
        return "TeaPot{" +
                "localDateTime=" + localDateTime +
                ", tea=" + tea +
                '}';
    }
}
