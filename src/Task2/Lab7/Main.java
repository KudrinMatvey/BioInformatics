package Task2.Lab7;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        HashMap<String,Integer> map = new HashMap<>();
        ArrayList<String> set = new ArrayList<>();
        ArrayList<Integer> sumSet = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);
        map.put("G",57);
        map.put("A",71);
        map.put("S",87);
        map.put("P",97);
        map.put("V",99);
        map.put("T",101);
        map.put("C",103);
        map.put("I",113);
        map.put("L",113);
        map.put("N",114);
        map.put("D",115);
        map.put("K",128);
        map.put("Q",128);
        map.put("E",129);
        map.put("M",131);
        map.put("H",137);
        map.put("F",147);
        map.put("R",156);
        map.put("Y",163);
        map.put("W",186);
        String string = scanner.next();
        String st = new String();
        for (int i = 0; i < string.length(); i++) {
            set.add(string.substring(i,i+1));
        }
        int summ = 0;
        for (int start = 0; start < string.length()  ; start++) {
            for (int length = 2; length < string.length() ; length++) {
                if(length + start <= string.length()) st = string.substring(start,length+start);
                else{
                    st = string.substring(start);
                    st += (string.substring(0,length + start - string.length()));
                }
                set.add(st);
            }
        }
        set.add(string);
        for (String s : set) {
            summ = 0;
            for (int i = 0; i < s.length() ; i++) {
                summ+=map.get(s.substring(i,i+1));
            }
            sumSet.add(summ);
        }
        sumSet.add(0);
        sumSet.sort((a,b)->{return a - b;});
        for (Integer integer : sumSet) {
            System.out.printf("%d ",integer);
        }
    }

}

