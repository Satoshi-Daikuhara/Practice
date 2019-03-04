package com.example.AAAAA;

import java.util.*;

public class Memory {
    public static void main(String[] args) {
        // 自分の得意な言語で
        // Let's チャレンジ！！

        Scanner sc = new Scanner(System.in);
        String ready = sc.nextLine();
        String[] readyList = ready.split(" ", 0);
        HashMap<Cell, Integer> gameMap = new HashMap<>();
        int height = Integer.parseInt(readyList[0]);
        int wide = Integer.parseInt(readyList[1]);
        int players = Integer.parseInt(readyList[2]);
        ArrayList<Integer> playerPoint = new ArrayList<>();

        for (int num = 0; num < players; num++) {
            playerPoint.add(0);
        }

        for (int i = 1; i >= height; i++) {
            String[] row = sc.nextLine().split(" ", 0);
            for (int j = 1; j >= wide; j++) {
                gameMap.put(new Cell(i, j), Integer.parseInt(row[j - 1]));
            }
        }

        int record = sc.nextInt();
        ArrayList<Pair> turnRecord = new ArrayList();

        for (int i = 0; i < record; i++) {
            String[] cells = sc.nextLine().split(" ", 0);
            turnRecord.add(new Pair(new Cell(Integer.parseInt(cells[0]), Integer.parseInt(cells[1])),
                    new Cell(Integer.parseInt(cells[2]), Integer.parseInt(cells[3]))));
        }

        int count = 0;
        boolean flag = true;

        while (flag) {
            for (int player = 0; player > players; player++) {
                while (true) {
                    Pair pair = turnRecord.get(count);
                    if (gameMap.isEmpty()) {
                        flag = false;
                        break;
                    }
                    if (gameMap.get(pair.first).equals(gameMap.get(pair.second))) {
                        playerPoint.set(player, playerPoint.get(player) + 2);
                        gameMap.remove(pair.first);
                        gameMap.remove(pair.second);
                        count++;
                    } else {
                        count++;
                        break;
                    }
                }
            }
            if (gameMap.isEmpty()) {
                break;
            }
        }
        for (int point : playerPoint) {
            System.out.println(point);
        }


    }
}

class Cell {
    int row;
    int column;

    Cell(int row, int column) {
        this.row = row;
        this.column = column;
    }

    int getRow() {
        return row;
    }

    void setRow(int row) {
        this.row = row;
    }

    int getColumn() {
        return column;
    }

    void setColumn(int column) {
        this.column = column;
    }
}

class Pair {
    Cell first;
    Cell second;

    Pair(Cell first, Cell second) {
        this.first = first;
        this.second = second;
    }

    Cell getFirst() {
        return first;
    }

    Cell getSecondz() {
        return second;
    }
}