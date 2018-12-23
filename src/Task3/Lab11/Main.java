package Task3.Lab11;

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
        Integer N = Integer.valueOf(scanner.nextLine());
        ArrayList<Integer> list = new ArrayList();
        String string = scanner.nextLine();
        String tmp[] = string.split(" ");
        Integer maxListWeight = 0;
        for (String str: tmp) {
            if(Integer.valueOf(str) > maxListWeight)
                maxListWeight = Integer.valueOf(str);
            list.add(Integer.valueOf(str));
        }

        class LinearPeptide{
            ArrayList<Character> peptide;
            int weight;
            int score;
            ArrayList<Integer> weightCollection;

            LinearPeptide(){
                peptide = new ArrayList<>();
                weight = 0;
                score = 0;
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

            public void addScore(){
                score++;
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


        ArrayList<LinearPeptide> leadersPeptidesArray = new ArrayList<>();
        LinearPeptide leaderPeptide = new LinearPeptide();
        leadersPeptidesArray.add(leaderPeptide);
        ArrayList<LinearPeptide> tmpArray = new ArrayList<>();
        Comparator<LinearPeptide> top = new Comparator<LinearPeptide>() {
            @Override
            public int compare(LinearPeptide o1, LinearPeptide o2) {
                return o1.score - o2.score;
            }
        };

        boolean flag = false;

        whileCycle:        while (!leadersPeptidesArray.isEmpty()){
            for (LinearPeptide lp : leadersPeptidesArray) {
                tmpArray.addAll(lp.expand());
            }
            outer:            for (LinearPeptide linearPeptide : tmpArray) {
                ArrayList<Integer> a = new ArrayList<>();
                a.addAll(list);
                ArrayList<Integer> b = linearPeptide.createSubpeptideSpectrumsList();
                for (Integer integer : b) {
                    if(a.contains(integer)) {
                        a.remove(a.indexOf(integer));
                        linearPeptide.addScore();
                    } else if (maxListWeight < integer){
                        leadersPeptidesArray.remove(linearPeptide);
                        continue outer;
                    }
                }
                if (leaderPeptide.score < linearPeptide.score){
                    leaderPeptide = linearPeptide;
                }
                leadersPeptidesArray.add(linearPeptide);
            }

            if (!flag && leadersPeptidesArray.size() == 9)
                flag = true;
            else if (flag)
                break whileCycle;
            leadersPeptidesArray.sort(top);
            int s = leadersPeptidesArray.size() - N;
            for (int i = 0; i < s; i++) {
                leadersPeptidesArray.remove(0);
            }
            tmpArray.clear();
        }
        System.out.print(leaderPeptide.weightCollection.get(0));
        for (int i = 1; i < leaderPeptide.peptide.size() ; i++) {
            System.out.print("-" + leaderPeptide.weightCollection.get(i));
        }
        System.out.print(" ");

    }

}
