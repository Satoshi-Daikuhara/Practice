package com.example.AAAAA;

import com.sun.xml.internal.ws.api.ha.StickyFeature;

import java.util.*;

public class DictionarySortMin {
    private static int[] min;

    public static void main(String[] args) {
        // 自分の得意な言語で
        // Let's チャレンジ！！

        Scanner sc = new Scanner(System.in);
        int line = Integer.parseInt(sc.nextLine());
        int[] numbers = new int[line];
        String[] ds = sc.nextLine().split(" ");

        for (int i = 0; i < line; i++) {
            numbers[i] = Integer.parseInt(ds[i]);
        }

        int syurui = Integer.parseInt(sc.nextLine());
        ArrayList<int[]> rules = new ArrayList<>();

        for (int i = 0; i < syurui; i++) {
            String[] ss = sc.nextLine().split(" ");
            int [] rule = new int[line];
            for (int j = 0; j < line; j++) {
                rule[j] = Integer.parseInt(ss[j]);
            }
            rules.add(rule);
        }
//        int end = 0;
//        int pattern = 0;
//        for (int j = 0; j < syurui; j++) {
//            int kari = 1;
//            for (int i = syurui; i > end; i++) {
//                kari = kari * i;
//            }
//            pattern += kari;
//            end++;
//        }
        min = numbers;
//
//        for (int i = 0; i < syurui; i++) {
//            int[] newNumbers = sort(numbers, rules.get(i));
//            minNumbers = compare(newNumbers, minNumbers);
//        }

//        private void loop(){
//
//        }

        test(numbers, rules);

        for (int i = 0; i < min.length; i++) {
            System.out.print(min[i]);
        }
    }


    static int[] sort(int[] numbers, int[] rules) {
        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < numbers.length; i++) {
            map.put(rules[i], numbers[i]);
        }

        Object[] sort = map.keySet().toArray();
        Arrays.sort(sort);
        int[] returnList = new int[numbers.length];

        for (int i = 0; i < numbers.length; i++) {
            returnList[i] = map.get(i+1);
        }
        return returnList;
    }

    static int[] compare(int[] newNumbers, int[] minNumbers) {
        for (int i = 0; i < newNumbers.length; i++) {
            if (newNumbers[i] < minNumbers[i]){
                return newNumbers;
            } else if (newNumbers[i] > minNumbers[i]){
                return minNumbers;
            }
        }
        return minNumbers;
    }

    private static void test(int[] numbers, ArrayList<int[]> rList) {
        ArrayList<int[]> a = new ArrayList<>();

        if (rList.size() != 4 && rList.get(0) != null) {
            a.add(null);
        }

        a.addAll(rList);

        for (int index = 0; index < a.size(); index++) {
            int[] rule = a.get(index);

            if (rule == null) {
                compare(numbers, min);
            } else {

                int[] newStr = numbers.clone();
                newStr = sort(newStr, rule);

                ArrayList<int[]> newR = (ArrayList<int[]>) a.clone();
                newR.remove(index);
                if (newR.size() == 0) {
                    compare(numbers, min);
                    return;
                }
                test(newStr, newR);
            }
        }

    }

}
