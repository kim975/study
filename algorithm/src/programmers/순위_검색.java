package programmers;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 순위 검색 : https://school.programmers.co.kr/learn/courses/30/lessons/72412
 */
public class 순위_검색 {

    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.solution(
            new String[]{"java backend junior pizza 150"},
            new String[]{"java and backend and 1junior and pizza 100"}
        );
    }

    private static class Solution {

        Map<String, List<Integer>> infoMap = new HashMap<>();

        public int[] solution(String[] info, String[] query) {
            int[] answer = new int[query.length];

            for (String i : info) {
                String[] split = i.split(" ");
                makeInfo(0, split, "");
            }

            for (String s : infoMap.keySet()) {
                Collections.sort(infoMap.get(s));
            }

            for (int i = 0; i < query.length; i++) {
                String[] split = query[i].split(" and ");
                int score = Integer.parseInt(split[split.length - 1].split(" ")[1]);
                split[split.length - 1] = split[split.length - 1].split(" ")[0];

                String collect = String.join("", split);
                List<Integer> list = infoMap.getOrDefault(collect, new ArrayList<>());
                answer[i] = list.size() - binarySearch(list, score);
            }

            return answer;
        }

        public void makeInfo(int index, String[] infoToken, String infoKey) {

            if (index == infoToken.length - 1) {
                int i = Integer.parseInt(infoToken[infoToken.length - 1]);
                infoMap.putIfAbsent(infoKey, new ArrayList<>());
                infoMap.get(infoKey).add(i);
                return;
            }

            makeInfo(index + 1, infoToken, infoKey + infoToken[index]);
            makeInfo(index + 1, infoToken, infoKey + "-");
        }

        public int binarySearch(List<Integer> list, int target) {

            int start = 0;
            int end = list.size() - 1;

            while (start < end) {
                int mid = (start + end) / 2;
                if (list.get(mid) >= target) {
                    end = mid;
                } else {
                    start = mid + 1;
                }
            }

            if (list.isEmpty() || list.get(start) < target) {
                return list.size();
            }

            return start;
        }
    }

//"- and - and - and - 150"
}
