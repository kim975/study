package baekjoon;

import java.util.Scanner;

/**
 * 유학 금지 : https://www.acmicpc.net/problem/2789
 */
public class 유학_금지 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String A = sc.nextLine();

        String replace = A.replaceAll("[CAMBRIDGE]", "");
        System.out.println(replace);

    }
}
