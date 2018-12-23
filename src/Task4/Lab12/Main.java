package Task4.Lab12;


import javax.naming.OperationNotSupportedException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Scanner;

class Main{

    public static Integer countDifferences(String s1, String s2) throws OperationNotSupportedException {
        if(s1.length() != s2.length())
            throw new OperationNotSupportedException("Different lengths");
        Integer diff = 0;
        for (int i = 0; i < s1.length(); i++) {
            if(!(s1.charAt(i) == s2.charAt(i))) {
                diff++;
            }
        }
        return diff;
    }

    public static ArrayList<String> getPatterns(String kMer) {
        ArrayList<ArrayList<String>> patterns = new ArrayList<>();
        ArrayList<String> aminoCharachters = new ArrayList<>();
        aminoCharachters.add("T");
        aminoCharachters.add("G");
        aminoCharachters.add("A");
        aminoCharachters.add("C");
        ArrayList<String> result = new ArrayList<>();
        for (int i = 0; i < 4; i++) {
            patterns.add(new ArrayList<>());
            patterns.get(i).add(aminoCharachters.get(i));
        }
        for (int i = 0; i < kMer.length() - 1; i++) {
            Integer size = patterns.size();
            for (int j = 0; j < size; j++) {
                for (int k = 0; k < 4; k++) {
                    ArrayList<String> str = new ArrayList<>();
                    String pattern = new String();
                    for (int l = 0; l < patterns.get(j).size(); l++) {
                        str.add(patterns.get(j).get(l));
                        pattern += patterns.get(j).get(l);
                    }
                    str.add(aminoCharachters.get(k));
                    pattern += aminoCharachters.get(k);
                    patterns.add(str);
                    if(pattern.length() == kMer.length())
                        result.add(pattern);
                }
                patterns.remove(j);
                j--;
                size--;
            }
        }
        return result;
    }

    public static void main(String[]args){
        Scanner sc = new Scanner(System.in);
        String[] arr = sc.nextLine().split(" ");

        final Integer k = Integer.valueOf(arr[0]);
        final Integer d = Integer.valueOf(arr[1]);

        ArrayList<String> DNA = new ArrayList<>();
        for (int i = 0; i < 4; i++) {
            DNA.add(sc.nextLine());
        }
        sc.close();

        ArrayList<String> patterns = new ArrayList<>();
        for (String dna : DNA) {
            for (int i = 0; i < dna.length() - k + 1; i++) {
                String kMer = dna.substring(i, i + k);
                ArrayList<String> ptr = getPatterns(kMer);
                for (String pattern : ptr) {
                    Integer err = null;
                    try {
                        err = countDifferences(pattern,kMer);
                    } catch (OperationNotSupportedException e) {
                        continue;
                    }
                    if(err <= d && err >= 0) {
                        Integer count = 0;
                        for (String tmp : DNA) {
                            for (int j = 0; j < tmp.length() - k + 1; j++) {
                                Integer differences;
                                try {
                                    differences = countDifferences(tmp.substring(j, j + k), pattern);
                                } catch (OperationNotSupportedException e) {
                                    continue;
                                }
                                if (differences <= d && differences >= 0) {
                                    count++;
                                    break;
                                }
                            }
                        }
                        if (count == DNA.size()) {
                            patterns.add(pattern);
                        }
                    }
                }
            }
        }
        HashSet<String> patternsSet = new HashSet<>();
        patternsSet.addAll(patterns);
        for (String s : patternsSet) {
            System.out.printf("%s ",s);
        }
    }
}