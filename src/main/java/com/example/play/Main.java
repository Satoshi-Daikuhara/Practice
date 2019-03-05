package com.example.play;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        // 自分の得意な言語で
        // Let's チャレンジ！！

        Scanner sc = new Scanner(System.in);
        String line = sc.nextLine();
        int cardSu = Integer.parseInt(line);

        ArrayList cards = new ArrayList();
        for (int i = 0; i < cardSu; i++) {
            cards.add(sc.nextLine());
        }

        for (int num = 0; num < cards.size(); num++) {
            int even = 0;
            int odd = 0;
            String card = cards.get(num);
            ArrayList<Integer> cardNumbers = new ArrayList();
            for (int i = 0; i < card.length() - 1; i++) {
                cardNumbers.add(Integer.parseInt(card.substring(i, i + 1)));
            }

            for (int i = 0; i < cardNumbers.size(); i += 2) {
                int number = cardNumbers.get(i) * 2;
                if (number >= 10) {
                    int newNum = 1 + ((number) % 10);
                    even += newNum;
                } else {
                    even += number;
                }
            }

            for (int j = 1; j < cardNumbers.size(); j += 2) {
                int number = cardNumbers.get(j);
                odd += number;
            }

            int sum = even + odd;
            int result = 10 - sum % 10;
            if (result == 10) {
                System.out.println(0);
            } else {
                System.out.println(result);
            }
        }
    }
}
