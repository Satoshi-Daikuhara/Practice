package com.example.play;

import java.util.*;

public class AloneSugoroku {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] line = sc.nextLine().split(" ");
        Map<Integer,String> dice = new HashMap<>();
        dice.put(Integer.parseInt(line[0]), "T");
        dice.put(Integer.parseInt(line[1]), "B");
        dice.put(Integer.parseInt(line[2]), "U");
        dice.put(Integer.parseInt(line[3]), "D");
        dice.put(Integer.parseInt(line[4]), "L");
        dice.put(Integer.parseInt(line[5]), "R");

        int n = Integer.parseInt(sc.nextLine());
        ArrayList<Integer> boardList = new ArrayList<>();

        for (int i = 0; i < n; i++){
            boardList.add(Integer.parseInt(sc.nextLine()));
        }

        String currentStr = "T";
        int count = 0;

        for (int i = 1; i < boardList.size(); i++){
            int nextNum = boardList.get(i);
            String nextStr = dice.get(nextNum);
            if ((currentStr.equals("T") && nextStr.equals("B"))
                || (currentStr.equals("B") && nextStr.equals("T"))
                || (currentStr.equals("L") && nextStr.equals("R"))
                || (currentStr.equals("R") && nextStr.equals("L"))
                || (currentStr.equals("U") && nextStr.equals("D"))
                || (currentStr.equals("D") && nextStr.equals("U"))) {
                count += 2;
                currentStr = nextStr;
            } else if (!currentStr.equals(nextStr)) {
                count++;
                currentStr = nextStr;
            }
        }
        System.out.println(count);
    }
}
