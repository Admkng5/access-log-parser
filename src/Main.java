import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {

        LogParser.logParser();
        System.out.println("GoogleBot: " + LogParser.googleBotNumber);
        System.out.println("YandexBot: " + LogParser.yandexBotNumber);
        System.out.println("Общее количество запросов: " + LogParser.requestsNumber);
        System.out.println("Доля запросов GoogleBot: " + LogParser.getGoogleBotPart());
        System.out.println("Доля запросов YandexBot: " + LogParser.getYandexBotPart());

    }


}
