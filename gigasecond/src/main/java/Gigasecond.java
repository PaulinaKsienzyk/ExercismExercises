import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Duration;

class Gigasecond {

    private static final Duration GIGASECOND = Duration.ofSeconds((long)Math.pow(10,9));
    private final LocalDateTime moment;

    Gigasecond(LocalDateTime moment) {
        this.moment = moment;
    }

    Gigasecond(LocalDate moment) {
        this(moment.atStartOfDay());
    }

    LocalDateTime getDateTime() {
        return this.moment.plusSeconds(GIGASECOND.getSeconds());
    }

}
