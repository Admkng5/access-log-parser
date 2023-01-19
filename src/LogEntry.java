import java.time.LocalDateTime;

public class LogEntry {

    final String ipAddress;
    final LocalDateTime dateTime;
    final HttpMethod requestMethod;
    final String requestPath;
    final int responseCode;
    final int responseSize;
    final String refererPage;
    final String userAgent;
    enum HttpMethod {GET, POST, PUT, DELETE}

    LogEntry(String string) {
        LogParser.parserString(string);
        this.ipAddress = LogParser.ipAddress;
        this.dateTime = LogParser.dateTime;
        this.requestMethod = HttpMethod.valueOf(LogParser.requestMethod);
        this.requestPath = LogParser.requestPath;
        this.responseCode = LogParser.responseCode;
        this.responseSize = LogParser.responseSize;
        this.refererPage = LogParser.refererPage;
        this.userAgent = LogParser.userAgent;
    }

    public String getIpAddress() {
        return ipAddress;
    }

    public LocalDateTime getDateTime() {
        return dateTime;
    }

    public String getRequestPath() {
        return requestPath;
    }

    public int getResponseCode() {
        return responseCode;
    }

    public int getResponseSize() {
        return responseSize;
    }

    public String getRefererPage() {
        return refererPage;
    }

    public String getUserAgent() {
        return userAgent;
    }
}
