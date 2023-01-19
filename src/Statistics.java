import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;

public class Statistics {

    int totalTraffic;
    LocalDateTime minTime;
    LocalDateTime maxTime;
    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MMM/yyyy:HH:mm:ss Z", java.util.Locale.ENGLISH);

    Statistics() {
        this.totalTraffic = 0;
        this.minTime = LocalDateTime.parse("01/Jan/1970:00:00:00 +0300");
        this.maxTime = LocalDateTime.parse("01/Jan/1970:00:00:00 +0300");
    }

    public void addEntry(LogEntry logEntry) {
        totalTraffic += LogParser.responseSize;
        if(minTime.isAfter(LogParser.dateTime))
            minTime = LogParser.dateTime;
        if(maxTime.isBefore(LogParser.dateTime))
            maxTime = LogParser.dateTime;
    }

    public int getTrafficRate() {
        return (int) (totalTraffic / (ChronoUnit.HOURS.between(minTime, maxTime)));
    }
}
