package test.question3.util;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.temporal.ChronoUnit;
import java.util.Date;

public class DateTimeUtils {
    public static long yearDiffFromNow(final Date date) {
        final LocalDateTime now = LocalDateTime.now();
        final LocalDateTime passDate = date.toInstant()
                .atZone(ZoneId.systemDefault())
                .toLocalDateTime();

        return passDate.until(now, ChronoUnit.YEARS);
    }
}
