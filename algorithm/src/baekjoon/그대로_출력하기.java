package baekjoon;

import java.util.Scanner;

/**
 * 그대로 출력하기 : https://www.acmicpc.net/problem/11718
 */
public class 그대로_출력하기 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        while (sc.hasNextLine()) {
            System.out.println(sc.nextLine());
        }
    }
}
