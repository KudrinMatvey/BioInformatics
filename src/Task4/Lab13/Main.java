package Task4.Lab13;



import java.util.ArrayList;
import java.util.HashSet;
import java.util.Scanner;

public class Main {

    static String medianString (ArrayList<String> dna, Integer k) {
        Integer dist = Integer.MAX_VALUE;
        HashSet<String> patterns = new HashSet<>();
        HashSet<String> tmp = new HashSet<>();
        HashSet<Character> list = new HashSet<>();
        list.add('T');
        list.add('G');
        list.add('A');
        list.add('C');
        tmp.add("T");
        tmp.add("G");
        tmp.add("A");
        tmp.add("C");

        for (int i = 1; i < k ; i++) {
            tmp.addAll(patterns);
            patterns.clear();
            for (String s : tmp) {
                for (Character character : list) {
                    patterns.add(s + character);
                }
            }
            tmp.clear();
        }

        String res = new String();
        for (String pattern : patterns) {

            Integer currentDistance = 0;
            for (String s : dna) {
                currentDistance += d(pattern, s, k);
            }

            if (dist >= currentDistance) {
                dist = currentDistance;
                res = pattern;
            }
        }
        return res;
    }

    static Integer findHammingDistance(String p1, String p2, Integer k) {
        if(p1.length() != p2.length()) return -1;
        Integer diff = 0;
        for (int i = 0; i < k; i++) if(!(p1.charAt(i) == p2.charAt(i))) diff++;
        return diff;
    }

    static Integer d (String pattern, String str, Integer k) {
        ArrayList<Integer> distanceArray = new ArrayList<>();
        for (int i = 0; i < str.length() - k + 1; i++) {
            distanceArray.add(findHammingDistance(pattern, str.substring(i, i + k), k));
        }
        Integer minimum = distanceArray.get(0);
        for (Integer dist : distanceArray) {
            if(dist < minimum) {
                minimum = dist;
            }
        }
        return minimum;
    }

    public static void main(String[] args)   {
        Scanner sc = new Scanner(System.in);
        Integer k = Integer.valueOf(sc.nextLine());
        ArrayList<String> DNA = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            DNA.add(sc.nextLine());
        }
        sc.close();

        System.out.printf("%s", medianString(DNA, k));
    }

}
