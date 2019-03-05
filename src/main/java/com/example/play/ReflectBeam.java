package com.example.play;

import java.util.*;

public class ReflectBeam {
    public static void main(String[] args) {
        // 自分の得意な言語で
        // Let's チャレンジ！！

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
        boolean rowOrCol = true;
        boolean upOrDown = true;
        boolean rightOrLeft = true;
        int count = 0;
        int nowHigh = 0;
        int nowWide = 0;

        while(flag) {
            for(int w = 0; w < wide; w++) {
                count++;
                String now = board[nowHigh][nowWide];
                if (!now.equals("_")) {
                    if(rowOrCol) {
                        if (rightOrLeft && now.equals("/") && nowHigh == 0) {
                            flag = false;
                            break;
                        } else if (rightOrLeft && now.equals("\\") && nowHigh == high - 1) {
                            flag = false;
                            break;
                        } else if (!rightOrLeft && now.equals("/") && nowHigh == high - 1) {
                            flag = false;
                            break;
                        } else if (!rightOrLeft && now.equals("\\") && nowHigh == 0) {
                            flag = false;
                            break;
                        } else {
                            if (rightOrLeft && now.equals("/")) {
                                upOrDown = true;
                                rowOrCol = false;
                                nowHigh--;
                            } else if (rightOrLeft && now.equals("\\")) {
                                upOrDown = false;
                                rowOrCol = false;
                                nowHigh++;
                            } else if (!rightOrLeft && now.equals("/")) {
                                upOrDown = false;
                                rowOrCol = false;
                                nowHigh++;
                            } else if (!rightOrLeft && now.equals("\\")) {
                                upOrDown = true;
                                rowOrCol = false;
                                nowHigh--;
                            }
                        }
                    } else {
                        if(upOrDown){
                            if (now.equals("/")) {
                                if (nowWide == wide -1) {
                                    flag = false;
                                    break;
                                } else {
                                    rightOrLeft = true;
                                    rowOrCol = true;
                                    nowWide++;
                                }
                            } else {
                                if (nowWide == 0) {
                                    flag = false;
                                    break;
                                } else {
                                    rightOrLeft = false;
                                    rowOrCol = true;
                                    nowWide--;
                                }
                            }
                        } else {
                            if (now.equals("/")) {
                                if (nowWide == 0) {
                                    flag = false;
                                    break;
                                } else {
                                    rightOrLeft = false;
                                    rowOrCol = true;
                                    nowWide--;
                                }
                            } else {
                                if (nowWide == wide -1) {
                                    flag = false;
                                    break;
                                } else {
                                    rightOrLeft = true;
                                    rowOrCol = true;
                                    nowWide++;
                                }
                            }
                        }
                    }
                } else {
                    if (rowOrCol) {
                        if (rightOrLeft) {
                            if (nowWide == wide - 1) {
                                flag = false;
                                break;
                            } else {
                                nowWide++;
                            }
                        } else {
                            if (nowWide == 0) {
                                flag = false;
                                break;
                            } else {
                                nowWide--;
                            }
                        }
                    } else {
                        if (upOrDown) {
                            if (nowHigh == 0) {
                                flag = false;
                                break;
                            } else {
                                nowHigh--;
                            }
                        } else {
                            if (nowHigh == high - 1) {
                                flag = false;
                                break;
                            } else {
                                nowHigh++;
                            }
                        }
                    }
                }
            }
        }

        System.out.println(count);
    }
}
