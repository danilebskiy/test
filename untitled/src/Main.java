
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.print("Введите выражение: ");
            String input = scanner.nextLine();
            try {
                System.out.println("Результат " + calc(input));
            } catch (Exception e) {
                System.out.println("throws Exception");
                break;
            }
        }

    }

    public static String calc(String input) {
        String[] parts = input.split(" ");
        if (parts.length != 3) {
            throw new IllegalArgumentException("Неверный формат операции");
        }
        int a = Integer.parseInt(parts[0]);
        int b = Integer.parseInt(parts[2]);
        if (a < 1 || a > 10 || b < 1 || b > 10) {
            throw new IllegalArgumentException("Числа должны быть от 1 до 10");
        }
        String operator = parts[1];
        return switch (operator) {
            case "+" -> Integer.toString(a + b);
            case "-" -> Integer.toString(a - b);
            case "*" -> Integer.toString(a * b);
            case "/" -> Integer.toString(a / b);
            default -> throw new IllegalArgumentException("Неверный оператор");
        };
    }
}
