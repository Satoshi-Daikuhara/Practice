package com.example.play;

import java.util.ArrayList;
import java.util.Scanner;


public class Election {
    public static void main(String[] args) {
        // 自分の得意な言語で
        // Let's チャレンジ！！

        Scanner sc = new Scanner(System.in);
        String[] line = sc.nextLine().split(" ", 0);
        int ri = Integer.parseInt(line[0]);
        int yu = Integer.parseInt(line[1]);
        int en = Integer.parseInt(line[2]);
        ArrayList<Integer> riList = new ArrayList<>();

        for (int i = 0; i < ri; i++) {
            riList.add(0);
        }

        for (int i = 0; i < en; i++) {
            int enzetsu = sc.nextInt()-1;
            int count = 0;

            for (int j = 0; j < riList.size(); j++) {
                int set = riList.get(j);
                if (j != enzetsu && set > 0) {
                    riList.set(j, set - 1);
                    count++;
                }
            }

            if (yu > 0) {
                yu = yu - 1;
                count++;
            }

            int get = riList.get(enzetsu) + count;
            riList.set(enzetsu, get);
        }

        ArrayList<Integer> topList = new ArrayList<>();
        int top = 0;

        for (int i = 0; i < riList.size(); i++) {

            if (riList.get(i) > top) {
                topList = new ArrayList<>();
                topList.add(i);
                top = riList.get(i);
            } else if (top == riList.get(i)) {
                topList.add(i);
            }
        }
        for (int i = 0; i < topList.size(); i++) {
            System.out.println(topList.get(i)+1);
        }
    }
}
