package com.example.play;

import java.util.*;

public class ReflectBeamRefactor {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] line = sc.nextLine().split(" ");

        int high = Integer.parseInt(line[0]);
        int wide = Integer.parseInt(line[1]);
        String[][] board = new String[high][wide];

        for (int h = 0; h < high; h++) {
            String row = sc.nextLine();
            for (int w = 0; w < wide; w++) {
                if (w == wide-1) {
                    board[h][w] = row.substring(w);
                } else {
                    board[h][w] = row.substring(w, w + 1);
                }
            }
        }

        boolean flag = true;
        int count = 0;
        int nowHigh = 0;
        int nowWide = 0;
        Direction dir = Direction.RIGHT;

        while(flag) {
            count++;
            String now = board[nowHigh][nowWide];

            switch (dir) {
                case RIGHT:
                    switch (now) {
                        case "_":
                            if (nowWide == wide-1) flag = false;
                            else nowWide++;
                            break;
                        case "/":
                            if (nowHigh == 0) flag = false;
                            else {
                                dir = Direction.UP;
                                nowHigh--;
                            }
                            break;
                        case "\\":
                            if (nowHigh == high-1) flag = false;
                            else {
                                dir = Direction.DOWN;
                                nowHigh++;
                            }
                            break;
                    }
                    break;
                case LEFT:
                    switch (now) {
                        case "_":
                            if (nowWide == 0) flag = false;
                            else nowWide--;
                            break;
                        case "/":
                            if (nowHigh == high-1) flag = false;
                            else {
                                dir = Direction.DOWN;
                                nowHigh++;
                            }
                            break;
                        case "\\":
                            if (nowHigh == 0) flag = false;
                            else {
                                dir = Direction.UP;
                                nowHigh--;
                            }
                            break;
                    }
                    break;
                case DOWN:
                    switch (now) {
                        case "_":
                            if (nowHigh == high-1) flag = false;
                            else nowHigh++;
                            break;
                        case "/":
                            if (nowWide == 0) flag = false;
                            else  {
                                dir = Direction.LEFT;
                                nowWide--;
                            }
                            break;
                        case "\\":
                            if (nowWide == wide-1) flag = false;
                            else {
                                dir = Direction.RIGHT;
                                nowWide++;
                            }
                            break;
                    }
                    break;
                case UP:
                    switch (now) {
                        case "_":
                            if (nowHigh == 0) flag = false;
                            else  nowHigh--;
                            break;
                        case "/":
                            if (nowWide == wide-1) flag = false;
                            else {
                                dir = Direction.RIGHT;
                                nowWide++;
                            }
                            break;
                        case "\\":
                            if (nowWide == 0) flag = false;
                            else  {
                                dir = Direction.LEFT;
                                nowWide--;
                            }
                            break;
                    }
                    break;
            }
        }
        System.out.println(count);
    }

    enum Direction{
        RIGHT,
        LEFT,
        UP,
        DOWN;
    }
}
