import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        System.out.println("Введите первое число:");
        int numberOne = new Scanner(System.in).nextInt();
        System.out.println("Введите второе число:");
        int numberTwo = new Scanner(System.in).nextInt();

        System.out.println("Сумма чисел: " + (numberOne + numberTwo));
        System.out.println("Разность чисел: " + (numberOne - numberTwo));
        System.out.println("Произведение чисел: " + (numberOne * numberTwo));
        System.out.println("Частное чисел: " + ((double)numberOne / numberTwo));
    }
}
