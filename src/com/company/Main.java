package com.company;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        final int numCelebrities = 5;

        String[] celebrityNames = new String[numCelebrities];
        int[] scoresJudge1 = new int[numCelebrities];
        int[] scoresJudge2 = new int[numCelebrities];
        int[] scoresJudge3 = new int[numCelebrities];
        int[] total = new int[numCelebrities];


        celebrityNames = addNAMES(celebrityNames);

        total = addSCORES(scoresJudge1, scoresJudge2, scoresJudge3, total, celebrityNames);

        showTABLE(scoresJudge1, scoresJudge2, scoresJudge3, total, celebrityNames);
    }

    public static String[] addNAMES(String[] names) {
        for (int i = 0; i < names.length; i++) {
            names[i] = inputString("What is your name?");
        }

        return names;
    }

    public static int[] addSCORES(int[] scoreJudge1, int[] scoreJudge2, int[] scoreJudge3, int[] total, String[] names) {
        int score;
        print("Judge 1");
        for (int i = 0; i < names.length; i++) {
            score = inputInt("What is your score for " + names[i]);
            while (score > 5 || score < 1)
            {
                score = inputInt("Choose an appropriate score");
            }
            scoreJudge1[i] = score;
            total[i] = total[i] + scoreJudge1[i];
        }

        print("Judge 2!");
        for (int i = 0; i < names.length; i++) {
            score = inputInt("What is your score for " + names[i]);
            while (score > 5 || score < 1)
            {
                score = inputInt("Choose an appropriate score");
            }
            scoreJudge2[i] = score;
            total[i] = total[i] + scoreJudge2[i];
        }
        print("Judge 3!");
        for (int i = 0; i < names.length; i++) {
            score = inputInt("What is your score for " + names[i]);
            while (score > 5 || score < 1)
            {
                score = inputInt("Choose an appropriate score");
            }
            scoreJudge3[i] = score;
            total[i] = total[i] + scoreJudge3[i];
        }
        return total;
    }

    public static void showTABLE(int[] scoreJudge1, int[] scoreJudge2, int[] scoreJudge3, int[] total, String[] names) {
        sortTABLE(scoreJudge1, scoreJudge2, scoreJudge3, total, names);
        printTABLE(scoreJudge1, scoreJudge2, scoreJudge3, total, names);
    }

    public static void sortTABLE(int[] scoreJudge1, int[] scoreJudge2, int[] scoreJudge3, int[] total, String[] names) {
        for (int i = 0; i < total.length-1; i++) {
            for (int j = 0; j < total.length-1-i; j++) {
                if (total[j] < total[j + 1]) {
                    total = swapInt(total, j);
                    scoreJudge1 = swapInt(scoreJudge1, j);
                    scoreJudge2 = swapInt(scoreJudge2, j);
                    scoreJudge3 = swapInt(scoreJudge3, j);
                    names = swapString(names, j);
                }
            }
        }

    }

    public static int[] swapInt(int[] a, int j)
    {
        int temp;

        temp = a[j];
        a[j] = a[j+1];
        a[j+1] = temp;

        return a;
    }

    public static String[] swapString(String[] a, int j)
    {
        String temp;

        temp = a[j];
        a[j] = a[j+1];
        a[j+1] = temp;

        return a;
    }
    public static void printTABLE(int[] scoreJudge1, int[] scoreJudge2, int[] scoreJudge3, int[] total, String[] names)
    {
        int n = scoreJudge1.length;
        for (int i = 0; i < n; i++) {
            print(names[i] + " got a total of " + total[i] + "\nJudge 1 gave a score of "+ scoreJudge1[i]
            + "\nJudge 2 gave a score of "+ scoreJudge2[i] + "\nJudge 3 gave a score of " + scoreJudge3[i]);
        }
    }
    public static void print(String m)
    {
        System.out.println(m);
    }

    public static String inputString(String m)
    {
        String answer;
        Scanner scanner = new Scanner(System.in);

        print(m);
        answer = scanner.nextLine();
        return answer;
    }

    public static int inputInt(String m)
    {
        int answer;
        Scanner scanner = new Scanner(System.in);

        print(m);
        answer = scanner.nextInt();
        return answer;
    }
}
