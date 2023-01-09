import javax.imageio.IIOException;
import java.io.*;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        int counterLines = 0;
        int minLineLength = 0;
        int maxLineLength = 0;

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
            BufferedReader reader =
                    new BufferedReader(fileReader);
            String line = reader.readLine();
            minLineLength = line.length();
            while ((line = reader.readLine()) != null) {

                    int length = line.length();
                try {
                    if (length > 1024)
                            throw new TooBigLine("Слишком длинная строка в файле, более 1024 символов.");
                } catch (TooBigLine e) {
                    System.out.println(e.getMessage());
                }

                if (length < minLineLength)
                    minLineLength = length;
                if (length > maxLineLength)
                    maxLineLength = length;
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            System.out.println("Файл не найден!");
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("Невозможно прочитать файл, возможно нет прав на чтение.");
        }

        System.out.println("Общее количество строк в файле: " + counterLines);
        System.out.println("Длина самой длинной строки в файле: " + maxLineLength);
        System.out.println("Длина самой короткой строки в файле: " + minLineLength);


    }
}
