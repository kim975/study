package baekjoon;

import java.util.Scanner;

/**
 * 상수 : https://www.acmicpc.net/problem/2908
 */
public class 상수 {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        StringBuilder s1 = new StringBuilder(sc.next());
        StringBuilder s2 = new StringBuilder(sc.next());

        int i1 = Integer.parseInt(s1.reverse().toString());
        int i2 = Integer.parseInt(s2.reverse().toString());

        System.out.println(Math.max(i1, i2));
    }
}
