package tool;

import java.time.Instant;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.time.temporal.TemporalAccessor;
import java.util.Locale;

public final class DateFormatter {

    private DateFormatter() {}

    public static String toFrenchDate(String dateTest) {
        TemporalAccessor temporalAccessor = DateTimeFormatter.ISO_INSTANT.parse(dateTest);
        Instant dateTime = Instant.from(temporalAccessor);

        return DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss")
                .withLocale(Locale.FRANCE)
                .withZone( ZoneId.of("UTC") )
                .format(dateTime);
    }
}
