import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {

        LogParser.logParser();
        System.out.println("GoogleBot: " + LogParser.googleBotNumber);
        System.out.println("YandexBot: " + LogParser.yandexBotNumber);
        System.out.println("Общее количество запросов: " + LogParser.requestsNumber);
        System.out.println("Доля запросов GoogleBot: " + LogParser.getGoogleBotPart());
        System.out.println("Доля запросов YandexBot: " + LogParser.getYandexBotPart());

//        System.out.println("Укажите путь к файлу: ");
//        String path = new Scanner(System.in).nextLine();
//        File file = new File(path);
//        FileReader fileReader = new FileReader(path);
//        BufferedReader reader = new BufferedReader(fileReader);
//        String line = reader.readLine();
//        while ((line = reader.readLine()) != null) {
//
//            LogEntry logParser = new LogEntry(line);
//            System.out.println(logParser.requestPath);
//        }
    }


}
