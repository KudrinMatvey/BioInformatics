package Lab3;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String string = scanner.next();
        int size = string.length();
        char[] charArray = string.toCharArray();
        char[] resultArray = new char[size];
        for (int i = 0; i < size; i++) {
            if (charArray[i] == 'A')
                resultArray[size - 1 - i] = 'T';
            else if (charArray[i] == 'T')
                resultArray[size - 1- i] = 'A';
            else if (charArray[i] == 'G')
                resultArray[size -1 - i] = 'C';
            else if (charArray[i] == 'C')
                resultArray[size - 1 - i] = 'G';
        }
        String result = new String(resultArray);
        System.out.printf(result);
    }
}
