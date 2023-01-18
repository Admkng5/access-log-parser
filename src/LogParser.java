import java.io.*;
import java.util.Scanner;

public class LogParser {

    static String ipAddress;
    static String dateTime;
    static String requestMethod;
    static String requestPath;
    static int responceCode;
    static int dataSize;
    static String refererPage;
    static String userAgent;
    static String searchBot;
    static int googleBotNumber = 0;
    static int yandexBotNumber = 0;
    static int requestsNumber = 0;

    public static void logParser() {
        System.out.println("Укажите путь к файлу: ");
        String path = new Scanner(System.in).nextLine();

        File file = new File(path);
        boolean fileExists = file.exists();
        if (!fileExists) {
            System.out.println("Указанный файл " + path + " не существует!");
            return;
        }

        boolean isDirectory = file.isDirectory();
        if (isDirectory) {
            System.out.println("Указанный файл " + path + " является директорией!");
            return;
        }

        try {
            FileReader fileReader = new FileReader(path);
            BufferedReader reader = new BufferedReader(fileReader);
            String line = reader.readLine();
            while ((line = reader.readLine()) != null) {
                requestsNumber++;
                String subString;
                int length = line.length();
                try {
                    if (length > 1024)
                        throw new TooBigLine("Слишком длинная строка в файле, более 1024 символов.");
                } catch (TooBigLine e) {
                    System.out.println(e.getMessage());
                }
                ipAddress = splitString(line, " ", 0);
                dateTime = splitString(splitString(line, "\\[", 1), "\\]", 0);
                subString = splitString(line, "\"", 1);
                requestMethod = splitString(subString, " ", 0);
                requestPath = splitString(subString, " ", 1);
                responceCode = Integer.parseInt(splitString(line, " ", 8));
                dataSize = Integer.parseInt(splitString(line, " ", 9));
                refererPage = splitString(line, "\"", 3);
                userAgent= splitString(line, "\"", 5);
                System.out.println(userAgent);
                if(userAgent.indexOf("(") == -1)
                    continue;

                if(userAgent.contains("Googlebot"))
                    googleBotNumber++;
                if(userAgent.contains("YandexBot"))
                    yandexBotNumber++;
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            System.out.println("Файл не найден!");
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("Невозможно прочитать файл, возможно нет прав на чтение.");
        }
    }

    public static String splitString(String string, String splitterSymbol, int index) {
        return string.split(splitterSymbol, 0)[index];
    }

    public static float getGoogleBotPart() {
        return (float) googleBotNumber/requestsNumber;
    }

    public static float getYandexBotPart() {
        return (float) yandexBotNumber/requestsNumber;
    }

}
