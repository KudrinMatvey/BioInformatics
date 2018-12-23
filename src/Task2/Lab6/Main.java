import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int a = scanner.nextInt();
        long b = 0;
        for (int i = 0; i < a - 1 ; i++) {
            b += a;
        }
        System.out.println(b);
    }
}
