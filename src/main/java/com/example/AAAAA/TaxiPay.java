package com.example.AAAAA;

import java.util.*;


public class TaxiPay {
    public static void main(String[] args) {
        // 自分の得意な言語で
        // Let's チャレンジ！！

        Scanner sc = new Scanner(System.in);
        String[] line = sc.nextLine().split(" ");
        int taxies = Integer.parseInt(line[0]);
        int mer = Integer.parseInt(line[1]);
        ArrayList<String[]> taxiPays = new ArrayList<>();

        for (int i = 0; i < taxies; i++) {
            taxiPays.add(sc.nextLine().split(" "));
        }
        int minCost = 0;
        int maxCost = 0;

        for(int i = 0; i < taxies; i++) {
            int cost = 0;
            String[] pay = taxiPays.get(i);
            int firstLong = Integer.parseInt(pay[0]);
            int firstPay = Integer.parseInt(pay[1]);
            int addLong = Integer.parseInt(pay[2]);
            int addPay = Integer.parseInt(pay[3]);

            if(mer < firstLong) {
                cost = firstPay;
            } else {
                int count = 1;
                while(true) {
                    if (mer < firstLong + addLong * count) {
                        cost = firstPay + addPay * count;
                        break;
                    } else {
                        count++;
                    }
                }
            }

            if (minCost == 0 || minCost > cost) {
                minCost = cost;
            }

            if (maxCost < cost) {
                maxCost = cost;
            }
        }

        System.out.println(minCost + " " + maxCost);

    }
}
