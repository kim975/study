package baekjoon;

import java.util.Scanner;

/**
 * 다이얼 : https://www.acmicpc.net/submit/5622
 */
public class 다이얼 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        String str = sc.next();

        char[] ch = str.toCharArray();

        int count = 0;

        for (int i = 0; i < ch.length; i++) {

            char c = ch[i];

            if (c == 'A' || c == 'B' || c == 'C') {
                count = count + 3;
            } else if (c == 'D' || c == 'E' || c == 'F') {
                count = count + 4;
            } else if (c == 'G' || c == 'H' || c == 'I') {
                count = count + 5;
            } else if (c == 'J' || c == 'K' || c == 'L') {
                count = count + 6;
            } else if (c == 'M' || c == 'N' || c == 'O') {
                count = count + 7;
            } else if (c == 'P' || c == 'Q' || c == 'R' || c == 'S') {
                count = count + 8;
            } else if (c == 'T' || c == 'U' || c == 'V') {
                count = count + 9;
            } else if (c == 'W' || c == 'X' || c == 'Y' || c == 'Z') {
                count = count + 10;
            }

        }

        System.out.println(count);
    }
}
