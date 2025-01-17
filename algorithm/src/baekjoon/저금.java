package baekjoon;

import java.util.Scanner;

/**
 * 저금 : https://www.acmicpc.net/problem/4998
 */
public class 저금 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        try {
            while (true) {
                double A = sc.nextDouble();
                double B = sc.nextDouble();
                double C = sc.nextDouble();

                double D = A;

                int count = 0;
                while (D <= C) {
                    D = D + D * (B / 100);
                    count++;
                }

                System.out.println(count);
            }
        } catch (Exception e) {

        }
    }
}

