package mainstructure.taskmanager;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class DateTime {
    private LocalDate date;
    private LocalTime time;

    public DateTime(LocalDate date) {
        this.date = date;
        this.time = null;
    }

    public DateTime(LocalTime time) {
        this.time = time;
    }

    public DateTime(LocalDate date, LocalTime time) {
        this.date = date;
        this.time = time;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public void setTime(LocalTime time) {
        this.time = time;
    }

    public String toString() {
        return (date == null ? "" : date.format(DateTimeFormatter.ofPattern("dd MMM yyyy")))
                + ' ' + (time == null ? "" : time.toString());
    }
}
