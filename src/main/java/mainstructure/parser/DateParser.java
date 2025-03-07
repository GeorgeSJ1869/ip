package mainstructure.parser;

import java.time.LocalDate;
import java.time.format.DateTimeParseException;

public class DateParser {
    public static LocalDate parse(String input) throws DateTimeParseException {
        LocalDate date;
        String processed = input.replaceAll("\\D", " ").trim().replaceAll(" +", "-");
        System.out.println(processed);
        date = LocalDate.parse(processed);
        return date;
    }
}
