package Task1.Lab2;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String string = scanner.next();
        int k = scanner.nextInt();
        HashMap<String,Integer> map = new HashMap<>();
        for(int i = 0; i < string.length() - k; i++){
            String str = string.substring(i,i+k);
            if(map.get(str) == null){
                map.put(str,1);
            }
            else{
                map.put(str,map.get(str) + 1);
            }
        }
        ArrayList<String> MaxKeyArray = new ArrayList<>();
        Integer MaxValue = 0;
        for(Map.Entry<String, Integer> entry : map.entrySet()) {
            String key = entry.getKey();
            Integer value = entry.getValue();
            if(value == MaxValue){
                MaxKeyArray.add(key);
            }
            else if(value > MaxValue){
                MaxValue = value;
                MaxKeyArray.clear();
                MaxKeyArray.add(key);
            }
        }
        for(String str: MaxKeyArray){
            System.out.printf(str + " ");
        }
    }
}
