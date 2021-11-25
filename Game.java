import java.util.Scanner;
public class Game {
    int n, t;
    int[][] cost;
    public static int findMaxLine(int n, int[][] cost, int time) {
        return findMaxLine(n, cost, time, new boolean[n][n], 0);
    }
    // n : problem size
    // cost : job cost
    // time : remaining time
    // done : which jobs has done
    // pos : chooing job
    private static int findMaxLine(int n, int[][] cost, int time, boolean[][] done, int pos) {
        if (pos == n*n) {
            int line = 0;
            int r, c;
            hline:
            for (r=0; r<n; r++) {
                for (c=0; c<n; c++){
                    if (!done[r][c]) {
                        continue hline;
                    }
                }
                line++;
            }
            vline:
            for (c=0; c<n; c++) {
                for (r=0; r<n; r++) {
                    if (!done[r][c]) {
                        continue vline;
                    }
                }
                line++;
            }
            for (r=0, c=0; r<n && done[r][c]; r++, c++) {
                ;
            }
            if (r == n) {
                line++;
            }
            for (r=n-1, c=0; r>=0 && done[r][c]; r--, c++) {
                ;
            }
            if (r < 0) {
                line++;
            }
            return line;
        }

        int max = 0;
        int v;
        int r = pos / n;
        int c = pod % n;
        if (time >= cost[r][c]) {
            done[r][c] = true;
            v = findMaxLine(n, cost, time-cost[r][c], done, pos+1);
            if (v > max) {
                max = v;
            }
            done[r][c] = false;
        }
        v = findMaxLine(n, cost, time, done, pos+1);
        if (v > max) {
            max = v;
        }
        return max;
    }
    public static void main(String[] argv) {
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        int t = input.nextInt();
        int[][] data = new int[n][n];
        for (int r=0; r<n; r++) {
            for (int c=0; c<n;c++) {
                data[r][c] = input.nextInt();
            }
        }
        // Game g = new Game(n, data, t);
        System.out.println(g.findMaxLine(n, data, t));
    }
}