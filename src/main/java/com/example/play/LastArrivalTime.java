package com.example.play;

import java.util.*;

public class LastArrivalTime {
    public static void main(String[] args) {
        // 自分の得意な言語で
        // Let's チャレンジ！！

        Scanner sc = new Scanner(System.in);
        String[] line = sc.nextLine().split(" ");
        int a = Integer.parseInt(line[0]);
        int b = Integer.parseInt(line[1]);
        int c = Integer.parseInt(line[2]);

        int times = sc.nextInt();
        ArrayList<String[]> trainTimes = new ArrayList<>();

        String[] tra;
        for (int i = 0; i < times; i++) {
            tra = sc.next().split(" ");
            trainTimes.add(tra);
        }

        int x = b + c;
        int h = 0;
        int m = 0;

        do {
            if (x >= 60) {
                h++;
                x -= 60;
            }
        } while (x >= 60);
        m = x;

        int lh = 8;
        int lm = 60;

        lh -= h;
        lm -= m;

        if (lm == 60) {
            lh++;
        }

        int rH = 0;
        int rM = 0;

        for (int j = 0; j < times; j++) {
            String[] tTime = trainTimes.get(j);
            int tH = Integer.parseInt(tTime[0]);
            int tM = Integer.parseInt(tTime[1]);

            if (tH <= lh && tM <= lm) {
                rH = tH;
                rM = tM;
            }
        }

        int hh = 0;
        int mm = 0;

        do {
            if (a > 60) {
                hh++;
                a -= 60;
            }
        } while (a > 60);
        mm = a;

        if (rM < mm) {
            rH--;
            rH = 60 + rH - mm;
        } else {
            rH -= mm;
        }

        rH -= hh;

        String rrm = "";

        if(rH == 0) {
            rrm = "00";
        } else {
            rrm = rrm.toString();
        }

        System.out.println("0" + rH + ":" + rrm);
    }
}
