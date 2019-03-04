package com.example.AAAAA;

import java.util.*;

public class PaizaBallGame {
    public static void main(String[] args) {
        // 自分の得意な言語で
        // Let's チャレンジ！！

        Scanner sc = new Scanner(System.in);
        String[] line = sc.nextLine().split(" ");
        int frame = Integer.parseInt(line[0]);
        int pin = Integer.parseInt(line[1]);
        int ball = Integer.parseInt(line[2]);
        String[] kekka = sc.nextLine().split(" ");

        int zanPin = 0;
        int point = 0;
        int frameSu = 1;
        boolean strike = false;
        boolean strike2 = false;
        boolean spair = false;
        boolean nitoume = false;


        for (int i = 0; i < ball; i++) {
            String one = kekka[i];

            if (one.equals("G")) {
                if (!nitoume) {
                    zanPin = pin;
                    nitoume = true;
                    strike2 = false;
                    spair = false;
                } else {
                    nitoume = false;
                    zanPin = 0;
                    frame++;
                    strike = false;
                    strike2 = false;
                    spair = false;
                }
                continue;
            }

            int num = Integer.parseInt(one);

            if (!nitoume && num == pin) {
                if (strike) {
                    if (strike2) {
                        point += num * 3;
                        frame++;
                        continue;
                    } else {
                        point += num * 2;
                        strike2 = true;
                        frame++;
                        continue;
                    }
                } else {
                    strike = true;
                    frame++;
                    continue;
                }
            }
            if (!nitoume) {
                if (spair) {
                    point += num * 2;
                    spair = false;
                    nitoume = true;
                    zanPin = pin - num;
                    continue;
                } else if (strike) {
                    if (strike2) {
                        point += num * 3;
                        strike2 = false;
                        nitoume = true;
                        zanPin = pin - num;
                        continue;
                    } else {
                        point += num * 2;
                        nitoume = true;
                        zanPin = pin - num;
                        continue;
                    }
                } else {
                    point += num;
                    nitoume = true;
                    zanPin = pin - num;
                    continue;
                }
            }

            if (nitoume) {
                if (zanPin == num) {
                    spair =true;
                    nitoume = false;
                    if (strike){
                        point += num *2;
                        strike = false;
                    } else {
                        point = +num;
                    }
                } else {
                    nitoume = false;
                    if (strike){
                        point += num *2;
                        strike = false;
                    } else {
                        point = +num;
                    }
                }
                zanPin = 0;
            }

            if (frameSu == frame) {
                break;
            }
        }

        System.out.println(point);
    }
}
