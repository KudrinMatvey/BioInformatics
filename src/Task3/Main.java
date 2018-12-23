package Task3;

import java.util.*;

public class Main {

    public static void main(String[] args) throws CloneNotSupportedException {

        HashMap<Character,Integer> map = new HashMap<>();
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


        Scanner scanner = new Scanner(System.in);
        ArrayList<Integer> list = new ArrayList();
        String string = scanner.nextLine();
        String tmp[] = string.split(" ");
        int maxListWeight = 0;
        for (String str: tmp) {
            if(Integer.valueOf(str) > maxListWeight)
                maxListWeight = Integer.valueOf(str);
            list.add(Integer.valueOf(str));
        }

        ArrayList<Integer> mono = new ArrayList<>();
        for (Integer i: list) {
            if (map.containsValue(i))
                mono.add(i);
        }

        class LinearPeptide{
            ArrayList<Character> peptide;
            int weight;
            ArrayList<Integer> weightCollection;

            LinearPeptide(){
                peptide = new ArrayList<>();
                weight = 0;
                weightCollection = new ArrayList<>();
            }

            @Override
            public boolean equals(Object obj) {
                LinearPeptide lp = (LinearPeptide) obj;
                return weightCollection.equals(lp.weightCollection);
            }

            @Override
            public int hashCode() {
                return weight;
            }

            @Override
            protected LinearPeptide clone() throws CloneNotSupportedException {
                LinearPeptide tmp = new LinearPeptide();
                tmp.peptide = (ArrayList<Character>) this.peptide.clone();
                tmp.weight = this.weight;
                tmp.weightCollection.addAll(this.weightCollection);
                return tmp;
            }

            public ArrayList<LinearPeptide> expand() throws CloneNotSupportedException {
                ArrayList<LinearPeptide> list = new ArrayList<>();
                Iterator it = map.entrySet().iterator();
                while (it.hasNext()) {
                    LinearPeptide tmp = this.clone();
                    Map.Entry<Character,Integer> pair = (Map.Entry)it.next();
                    tmp.peptide.add(pair.getKey());
                    tmp.weight += pair.getValue();
                    tmp.weightCollection.add(pair.getValue());
                    list.add(tmp);
                }
                return list;
            }

            public ArrayList<Integer> createSubpeptideSpectrumsList() throws CloneNotSupportedException {
                ArrayList<LinearPeptide> list = this.createSubpeptideList();
                ArrayList<Integer> res = new ArrayList<>();
                for (LinearPeptide linearPeptide : list) {
                    res.add(linearPeptide.weight);
                }
                return res;
            }


            public ArrayList<LinearPeptide> createSubpeptideList() throws CloneNotSupportedException {
                ArrayList<LinearPeptide> list = new ArrayList<>();
                list.add(new LinearPeptide());
                for (int start = 0; start < this.weightCollection.size() ; start++) {
                    for (int length = 1; length  + start <= weightCollection.size(); length++) {
                        LinearPeptide tmp = new LinearPeptide();
                        for (int i = 0; i < length ; i++) {
                            tmp.peptide.add(this.peptide.get( i + start));
                            tmp.weightCollection.add(this.weightCollection.get( i + start));
                            tmp.weight += this.weightCollection.get( i + start);
                        }
                        list.add(tmp);
                    }
                }
                return list;
            }

        }
        ArrayList<LinearPeptide> linearPeptidesArray = new ArrayList<>();
        LinearPeptide linearPeptide = new LinearPeptide();
        linearPeptidesArray.add(linearPeptide);

        ArrayList<LinearPeptide> tmpArray = linearPeptide.expand();
        ArrayList<LinearPeptide> resultArray = new ArrayList<>();
        ArrayList<LinearPeptide> expanded = new ArrayList<>();

        for (LinearPeptide lp: tmpArray) {
            if (list.contains(lp.weight))
                expanded.add(lp);
        }

        while(expanded.size() != 0) {
            {
                resultArray.clear();
                resultArray.addAll(expanded);
                tmpArray.clear();
                for (LinearPeptide lp : expanded) {
                    tmpArray.addAll(lp.expand());
                }
                expanded.clear();

                for (LinearPeptide peptide : tmpArray) {
                    boolean flag = true;
                    ArrayList<Integer> a = new ArrayList<>();
                    a.addAll(list);
                    ArrayList<Integer> b = peptide.createSubpeptideSpectrumsList();
                    for (Integer integer : b) {
                        if (!a.contains(integer)) {
                            flag = false;
                            break;
                        } else a.remove(a.indexOf(integer));
                    }
                    if (flag)
                        expanded.add(peptide);
                }

            }
        }
        HashSet<LinearPeptide> resultSet = new HashSet<>();
        resultSet.addAll(resultArray);

        ArrayList<LinearPeptide> arr = new ArrayList<>();
        arr.addAll(resultSet);


        for (LinearPeptide lp: arr) {
            System.out.print(lp.weightCollection.get(0));
            for (int i = 1; i < lp.peptide.size() ; i++) {
                System.out.print("-" + lp.weightCollection.get(i));
            }
            System.out.print(" ");
        }
    }

}
