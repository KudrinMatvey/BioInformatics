package Task3.Lab10;
import java.util.*;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        String peptide = sc.nextLine();
        String spectrumString = sc.nextLine();
        sc.close();


        HashMap<Character, Integer> map = new HashMap<>();
        map.put('G', 57);
        map.put('A', 71);
        map.put('S', 87);
        map.put('P', 97);
        map.put('V', 99);
        map.put('T', 101);
        map.put('C', 103);
        map.put('I', 113);
        map.put('L', 113);
        map.put('N', 114);
        map.put('D', 115);
        map.put('K', 128);
        map.put('Q', 128);
        map.put('E', 129);
        map.put('M', 131);
        map.put('H', 137);
        map.put('F', 147);
        map.put('R', 156);
        map.put('Y', 163);
        map.put('W', 186);





        ArrayList<Integer> experimentalSpectrum = new ArrayList<>();
        experimentalSpectrum.add(new Integer(0));
        String[] tmp = spectrumString.split(" ");
        for (String t:tmp) {
            experimentalSpectrum.add(Integer.valueOf(t));
        }

        ArrayList<Integer> spr = new ArrayList<>();
        for (int i = 0; i < peptide.length(); i++) {
            spr.add(map.get(peptide.charAt(i)));
        }

        ArrayList<Integer> result = new ArrayList<>();
        ArrayList<Integer> doublePeptides = new ArrayList<>(spr);

        doublePeptides.addAll(spr);
        int s = spr.size();
        result.add(new Integer(0));
        for (int start = 0; start < s; start++) {
            for (int length = 1; length < s; length++) {
                List<Integer> acid = doublePeptides.subList(start, start + length);
                Integer res = new Integer(0);
                for (int k1 = 0; k1 < acid.size(); k1++) {
                    res += acid.get(k1);
                }
                result.add(res);
            }
        }
        Integer sum = new Integer(0);
        for (Integer lng : spr) {
            sum += lng;
        }
        result.add(sum);


        int score = 0;
        for (Integer re : result) {
            if(experimentalSpectrum.contains(re)){
                experimentalSpectrum.remove(experimentalSpectrum.indexOf(re));
                score ++;
            }
        }
        System.out.println(score);
    }
}


//NQEL
//0 99 113 114 128 227 257 299 355 356 370 371 484