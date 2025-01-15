package programmers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * 불량 사용자
 * https://school.programmers.co.kr/learn/courses/30/lessons/64064
 */
public class 불량_사용자 {
    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.solution(new String[] {"frodo", "fradi", "crodo", "abc123", "frodoc"}, new String[] {"*rodo", "*rodo", "******"});
    }

    private static class Solution {

        private Boolean[] userIdVisited;
        private Boolean[] bannedIdVisited;
        private Set<Set<String>> set = new HashSet<>();

        public int solution(String[] userIds, String[] bannedIds) {

            userIdVisited = new Boolean[userIds.length];
            bannedIdVisited = new Boolean[bannedIds.length];

            for (int i = 0; i < userIds.length; i++) {
                userIdVisited[i] = false;
            }
            for (int i = 0; i < bannedIds.length; i++) {
                bannedIdVisited[i] = false;
            }

            for (int i = 0; i < bannedIds.length; i++) {
                bannedIds[i] = bannedIds[i].replace("*", ".");
            }

            Set<String> list = new HashSet<>();
            banned(userIds, bannedIds, list);
            return set.size();
        }

        public void banned(String[] userIds, String[] bannedIds, Set<String> idList) {

            long count = Arrays.stream(bannedIdVisited)
                .filter(i -> i)
                .count();

            if (count == bannedIds.length) {
                set.add(new HashSet<>(idList));
                return;
            }

            int tempUsedBannedIndex = -1;

            for (int i = 0; i < userIds.length; i++) {

                if (userIdVisited[i]) {
                    continue;
                }

                for (int j = 0; j < bannedIds.length; j++) {
                    if (!userIdVisited[i] && !bannedIdVisited[j] && userIds[i].matches(bannedIds[j])) {
                        bannedIdVisited[j] = true;
                        tempUsedBannedIndex = j;
                        idList.add(userIds[i]);
                        break;
                    }
                }
                userIdVisited[i] = true;
                banned(userIds, bannedIds, idList);
                userIdVisited[i] = false;
                if (tempUsedBannedIndex != -1) {
                    bannedIdVisited[tempUsedBannedIndex] = false;
                    tempUsedBannedIndex = -1;
                    idList.remove(userIds[i]);
                }
            }
        }
    }
}
