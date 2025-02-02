package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 단어의_개수 : https://www.acmicpc.net/problem/2908
 */
public class 단어의_개수 {

    public static void main(String[] args) throws IOException {

        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String s = bf.readLine(); //String
        s = s.trim();

        if (s.isEmpty()){
            System.out.println(0);
            return;
        }

        System.out.println(s.split(" ").length);
    }
}
