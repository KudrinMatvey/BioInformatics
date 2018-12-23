package Task2.Lab5;

import java.util.*;

public class Main {
    public static void main(String[] args) {

        HashMap<String,String> codonTable = new HashMap<>();

        codonTable.put("AAC","N");
        codonTable.put("AAU","N");
        codonTable.put("AAA","K");
        codonTable.put("AAG","K");
        codonTable.put("ACU","T");
        codonTable.put("ACC","T");
        codonTable.put("ACA","T");
        codonTable.put("ACG","T");
        codonTable.put("AGU","S");
        codonTable.put("AGC","S");
        codonTable.put("AGA","R");
        codonTable.put("AGG","R");
        codonTable.put("AUU","I");
        codonTable.put("AUC","I");
        codonTable.put("AUA","I");
        codonTable.put("AUG","M");
        codonTable.put("CAU","H");
        codonTable.put("CAC","H");
        codonTable.put("CAA","Q");
        codonTable.put("CAG","Q");
        codonTable.put("CCU","P");
        codonTable.put("CCC","P");
        codonTable.put("CCA","P");
        codonTable.put("CCG","P");
        codonTable.put("CGU","R");
        codonTable.put("CGC","R");
        codonTable.put("CGA","R");
        codonTable.put("CGG","R");
        codonTable.put("CUU","L");
        codonTable.put("CUC","L");
        codonTable.put("CUA","L");
        codonTable.put("CUG","L");
        codonTable.put("GAU","D");
        codonTable.put("GAC","D");
        codonTable.put("GAA","E");
        codonTable.put("GAG","E");
        codonTable.put("GCU","A");
        codonTable.put("GCC","A");
        codonTable.put("GCA","A");
        codonTable.put("GCG","A");
        codonTable.put("GGU","G");
        codonTable.put("GGC","G");
        codonTable.put("GGA","G");
        codonTable.put("GGG","G");
        codonTable.put("GUU","V");
        codonTable.put("GUC","V");
        codonTable.put("GUA","V");
        codonTable.put("GUG","V");
        codonTable.put("UAU","Y");
        codonTable.put("UAC","Y");
        codonTable.put("UAA","");
        codonTable.put("UAG","");
        codonTable.put("UCU","S");
        codonTable.put("UCC","S");
        codonTable.put("UCA","S");
        codonTable.put("UCG","S");
        codonTable.put("UGU","C");
        codonTable.put("UGC","C");
        codonTable.put("UGA","");
        codonTable.put("UGG","W");
        codonTable.put("UUU","F");
        codonTable.put("UUC","F");
        codonTable.put("UUA","L");
        codonTable.put("UUG","L");

        Scanner scanner = new Scanner(System.in);
        String text = scanner.next();
        String peptide = scanner.next();
        String str;

        for (int i = 0; i <= text.length() - peptide.length() * 3; i++) {
            str = text.substring(i,i+peptide.length() * 3);
            StringBuilder revStr = new StringBuilder(str).reverse();
            for (int j = 0; j < str.length() ; j++) {
                switch (revStr.charAt(j)){
                    case 'A': revStr.replace(j,j+1,"T");break;
                    case 'T': revStr.replace(j,j+1,"A");break;
                    case 'G': revStr.replace(j,j+1,"C");break;
                    case 'C': revStr.replace(j,j+1,"G");break;
                }
            }

            String str1 = str.replaceAll("T","U");
            String str2 = revStr.toString().replaceAll("T","U");
            String result = new String();
            String result2 = new String();
            for (int j = 0; j < peptide.length() * 3; j+=3) {
                result += codonTable.get(str1.substring(j,j+3));
                result2 += codonTable.get(str2.substring(j,j+3));
            }

            if(result2.equals(peptide))
                System.out.println(str);
            if(result.equals(peptide))
                System.out.println(str);


        }
    }
}
