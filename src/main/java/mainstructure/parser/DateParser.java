package mainstructure.parser;

import java.time.LocalDate;
import java.time.format.DateTimeParseException;

/**
 * Contains a method to parse the date of a given input.
 */
public class DateParser {
    /**
     * Parses the date of a given input.
     * @param input the String where the date is parsed.
     * @return a <code>LocalDate</code> class.
     * @throws DateTimeParseException when no dates can be parsed.
     */
    public static LocalDate parse(String input) throws DateTimeParseException {
        LocalDate date;
        String processed = input.replaceAll("\\D", " ").trim().replaceAll(" +", "-");
        System.out.println(processed);
        date = LocalDate.parse(processed);
        return date;
    }
}
