package Task2.Lab8;
import java.util.*;

public class Main {

    public static void main(String[] args) {

        Integer[] arr = { 57, 71, 87, 97, 99, 101, 103, 113, 114, 115, 128, 129, 131, 137, 147, 156, 163, 186 };

        ArrayList<Integer> massArraList = new ArrayList<>(Arrays.asList(arr));

        HashMap<Integer,Long> map = new HashMap<>();

        map.put(0,(long)1);

        Scanner scanner = new Scanner(System.in);

        Integer mass = scanner.nextInt();

        scanner.close();
        Integer integer;

        for (int i = 57; i <= mass; i++) {

            integer = 0;

            map.put(i,integer.longValue());

            for (int j = 0; j < 18; j++) {

                if(map.containsKey(i - massArraList.get(j))) {

                    Long res = map.get(i) + map.get(i - massArraList.get(j));

                    map.put(i,res);

                }

            }

        }

        System.out.print(map.get(mass));

    }
}