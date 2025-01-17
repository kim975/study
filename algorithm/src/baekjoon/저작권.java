package baekjoon;

import java.util.Scanner;

/**
 * 저작권 : https://www.acmicpc.net/problem/2914
 */
public class 저작권 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int A = sc.nextInt();
        int B = sc.nextInt();

        System.out.println(A * (B - 1) + 1);
    }
}

