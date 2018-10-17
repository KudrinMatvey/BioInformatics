package Lab1;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
            Scanner scanner = new Scanner(System.in);
            String pattern = scanner.next();
            String string = scanner.next();
            int count = 0;
            int tmp;
            for(int i = 0;i<string.length();i++){
                tmp = string.indexOf(pattern,i);
                if(tmp != -1){
                    i = tmp;
                    count++;
                }
                else break;
            }
            System.out.print(count);
    }
}
