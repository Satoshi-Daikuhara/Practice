package com.example.play;

import java.util.*;

public class DropObjectGame {
    public static void main(String[] args) {
        // 自分の得意な言語で
        // Let's チャレンジ！！

        Scanner sc = new Scanner(System.in);
        String ready = sc.nextLine();
        String[] objList = ready.split(" ", 0);
        int high = Integer.parseInt(objList[0]);
        int wide = Integer.parseInt(objList[1]);
        int obSu = Integer.parseInt(objList[2]);
        String[][] mapList = new String[high][wide];

        for (int i = 0; i < high; i++) {
            for (int j = 0; j < wide; j++) {
                mapList[i][j] = ".";
            }
        }

        for (int n = 0; n < obSu; n++) {
            String obj = sc.nextLine();
            String[] addObjList = obj.split(" ", 0);
            int obH = Integer.parseInt(addObjList[0]);
            int obW = Integer.parseInt(addObjList[1]);
            int obX = Integer.parseInt(addObjList[2]);
            int top = -1;

            for (int h = 0; h < high; h++) {
                for (int w = obX; w < obX + obW; w++) {
                    if(mapList[h][w].equals("#")) {
                        top = h;
                    }
                }
            }

            for (int h = top+1; h <= top+obH; h++) {
                for (int w = obX; w < obX+obW; w++) {
                    mapList[h][w] = "#";
                }
            }
        }

        for (int h = high-1; h >= 0; h--) {
            for (int w = 0; w < wide; w++) {
                System.out.print(mapList[h][w]);
            }
            System.out.println();
        }

    }
}
