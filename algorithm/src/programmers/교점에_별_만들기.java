package programmers;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

/**
 * 교점에_별_만들기
 * https://school.programmers.co.kr/learn/courses/30/lessons/87377
 */
public class 교점에_별_만들기 {

    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.solution(new int[][]{{0, 1, -1}, {1, 0, -1}, {1, 0, 1}});
    }

}

class Solution {
    public String[] solution(int[][] line) {
        Set<Point> points = new HashSet<>();

        for (int i = 0; i < line.length - 1; i++) {
            for (int j = i + 1; j < line.length; j++) {
                if (i != j) {
                    Point point = getPoint(line[i][0], line[i][1], line[i][2], line[j][0], line[j][1], line[j][2]);

                    if (point != null) {
                        points.add(point);
                    }
                }
            }
        }

        Point maxPoint = getMaxPoint(points);
        Point minPoint = getMinPoint(points);

        int xSize = (int) (maxPoint.x - minPoint.x + 1);
        int ySize = (int) (maxPoint.y - minPoint.y + 1);

        char[][] arr = new char[ySize][xSize];
        for (char[] row : arr) {
            Arrays.fill(row, '.');
        }

        for (Point point : points) {
            arr[(int) (maxPoint.y - point.y)][(int) (point.x - minPoint.x)] = '*';
        }

        String[] answer = new String[arr.length];
        for (int i = 0; i < answer.length; i++) {
            answer[i] = new String(arr[i]);
        }

        return answer;
    }


    public Point getPoint(long a, long b, long e, long c, long d, long f) {

        double x = (double) ((b * f) - (e * d)) / (double) ((a * d) - (b * c));
        double y = (double) ((e * c) - (a * f)) / (double) ((a * d) - (b * c));

        if (x % 1 == 0 && y % 1 == 0) {
            return new Point((long) x, (long) y);
        }

        return null;
    }

    public Point getMaxPoint(Set<Point> points) {
        long maxX = Long.MIN_VALUE;
        long maxY = Long.MIN_VALUE;

        for (Point point : points) {
            maxX = Math.max(point.x, maxX);
            maxY = Math.max(point.y, maxY);
        }

        return new Point(maxX, maxY);
    }

    public Point getMinPoint(Set<Point> points) {
        long minX = Long.MAX_VALUE;
        long minY = Long.MAX_VALUE;

        for (Point point : points) {
            minX = Math.min(point.x, minX);
            minY = Math.min(point.y, minY);
        }

        return new Point(minX, minY);
    }

    public String[][] makeBoard(int xSize, int ySize) {

        String[][] board = new String[ySize][xSize];

        for (int i = 0; i < ySize; i++) {
            for (int j = 0; j < xSize; j++) {
                board[i][j] = ".";
            }
        }

        return board;
    }

}

class Point {
    public long x;
    public long y;

    public Point(long x, long y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Point point = (Point) o;
        return x == point.x && y == point.y;
    }

    @Override
    public int hashCode() {
        return Objects.hash(x, y);
    }
}