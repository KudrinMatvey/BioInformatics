package Task2.Lab4;

        import java.util.HashMap;
        import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        HashMap<String,String> map3 = new HashMap<>();
        HashMap<String,String> map2 = new HashMap<>();
        map2.put("CC","P");
        map2.put("CG","R");
        map2.put("CU","L");
        map2.put("GC","A");
        map2.put("GG","G");
        map2.put("GU","V");
        map2.put("UC","S");
        map2.put("AC","T");
        map3.put("UGU","C");
        map3.put("UGC","C");
        map3.put("UAU","Y");
        map3.put("GAU","D");
        map3.put("CAU","H");
        map3.put("CAC","H");
        map3.put("CAA","Q");
        map3.put("CAG","Q");
        map3.put("GAC","D");
        map3.put("GAA","E");
        map3.put("GAG","E");
        map3.put("UAC","Y");
        map3.put("UAG","");
        map3.put("UAA","");
        map3.put("UGA","");
        map3.put("UGG","W");
        map3.put("UUU","F");
        map3.put("UUC","F");
        map3.put("UUA","L");
        map3.put("UUG","L");
        map3.put("AAC","N");
        map3.put("AAU","N");
        map3.put("AAG","K");
        map3.put("AAA","K");
        map3.put("AGU","S");
        map3.put("AGC","S");
        map3.put("AGA","R");
        map3.put("AGG","R");
        map3.put("AUA","I");
        map3.put("AUU","I");
        map3.put("AUC","I");
        map3.put("AUG","M");
        Scanner scanner = new Scanner(System.in);
        String string = scanner.next();

        if(string.isEmpty() && string.length()%3 != 0)
            return;

        int times = string.length() / 3;
        String tmp;
        String res = new String();
        for (int i = 0; i < times ; i++) {
            tmp = string.substring(i*3,i*3+3);
            if (map3.containsKey(tmp)) {
                res += map3.get(tmp);
            }
            else {
                tmp = tmp.substring(0, 2);
                res += map2.get(tmp);
            }
        }
        System.out.printf(res);
    }
}


