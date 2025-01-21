package programmers;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.TreeMap;
import java.util.stream.Collectors;

/**
 * 메뉴 리뉴얼 : https://school.programmers.co.kr/learn/courses/30/lessons/72411
 */
public class 메뉴_리뉴얼 {

    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.solution(new String[]{"XYZ", "XWY", "WXA"}, new int[]{2, 3, 4});
    }

    private static class Solution {

        Map<String, Integer> map = new TreeMap<>();
        Map<Integer, Integer> map2 = new TreeMap<>();
        public String[] solution(String[] orders, int[] course) {
            String[] answer = {};

            List<Integer> courseList = Arrays.stream(course).boxed().collect(Collectors.toList());

            for (int i = 0; i < orders.length; i++) {
                Boolean[] booleans = new Boolean[orders[i].length()];
                Arrays.fill(booleans, false);
                String[] array = Arrays.stream(orders[i].split("")).sorted().toArray(String[]::new);
                findCourse(courseList, 0, array, booleans, "");
            }
            for (String string : map.keySet()) {

                int max = 0;

                for (String order : orders) {
                    char[] charArray = order.toCharArray();
                    Arrays.sort(charArray);
                    String string1 = Arrays.toString(charArray);

                    String replace = string.replace("", ".*");
                    boolean matches = string1.matches(replace);

                    if (matches) {
                        map.put(string, map.getOrDefault(string, 0) + 1);
                        max++;
                    }

                }

                map2.put(string.length(), Math.max(map2.getOrDefault(string.length(), 0), max));

            }
            String[] array = map.entrySet().stream()
                .filter(e -> e.getValue() == map2.get(e.getKey().length()) && e.getValue() >= 2)
                .map(Entry::getKey)
                .toArray(String[]::new);
            return array;
        }

        public void findCourse(List<Integer> courseList, int start, String[] order, Boolean[] visited, String course) {

            if (courseList.contains(course.length())) {
                map.put(course, 0);
            }

            long count = Arrays.stream(visited).filter(i -> i).count();

            if (visited.length == count) {
                return;
            }
            if (courseList.stream().max(Integer::compareTo).get() == course.length()) {
                return;
            }

            for (int i = start; i < order.length; i++) {
                if (visited[i]) {
                    continue;
                }

                visited[i] = true;
                findCourse(courseList, i + 1, order, visited, course + order[i]);
                visited[i] = false;

            }
        }
    }
}
