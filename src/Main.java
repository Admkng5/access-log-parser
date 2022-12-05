import java.io.File;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        int counterFiles = 0;

        while(true) {
            System.out.println("Укажите путь к файлу: ");
            String path = new Scanner(System.in).nextLine();

            File file = new File(path);
            boolean fileExists = file.exists();
            if(!fileExists) {
                System.out.println("Указанный файл " + path + " не существует! Укажите еще раз.");
                continue;
            }

            boolean isDirectory = file.isDirectory();
            if(isDirectory) {
                System.out.println("Указанный файл " + path + " является директорией! Укажите файл.");
                continue;
            }
            else {
                counterFiles++;
                System.out.println("Путь указан верно");
                System.out.println("Это файл номер " + counterFiles);
            }

        }
    }
}
