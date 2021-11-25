import java.util.Scanner;
public class Seat {
    // r: 有幾排座位
    // c: 每一排座位有幾列
    public static int findSol(int r, int[] c) {
        int[][] hot = new int[r][];
        for (int i=0; i<r; i++)
            hot[i] = new int[c[i]];
        return findSol(0, 0, hot);    
    }
    private static void mark(int r, int c, int[][] hot) {
        int[][] 不能坐 = {{2,0},{-2,0},{1,0},{-1,0},{0,2},{0,-2},{0,1},{0,-1},{1,1},{-1,-1},{-1,1},{1,-1}};
        for (int i=0; i<不能坐.length; i++) {
            int nr = r + 不能坐[i][0];
            int nc = c + 不能坐[i][1];
            if (nr>=0 && nr<hot.length && nc>=0 && nc<hot[nr].length)
                hot[nr][nc] += 1;
        }
    }
    private static void unmark(int r, int c, int[][] hot) {
        int[][] 不能坐 = {{2,0},{-2,0},{1,0},{-1,0},{0,2},{0,-2},{0,1},{0,-1},{1,1},{-1,-1},{-1,1},{1,-1}};
        for (int i=0; i<不能坐.length; i++) {
            int nr = r + 不能坐[i][0];
            int nc = c + 不能坐[i][1];
            if (nr>=0 && nr<hot.length && nc>=0 && nc<hot[nr].length)
                hot[nr][nc] -= 1;
        }        
    }
    // r: 正在排的row
    // c: 正在排的column
    // hot: 座位能坐嗎?
    private static int findSol(int r, int c, int[][] hot) {
        if (r>=hot.length) // 每一排都檢查過了
            return 0;
        // 檢查目前這一排
        int max = 0, got; // 最多可以坐幾人
        int nextr, nextc; // 先判斷下一個檢查的位置
        if (c>= hot[r].length-1) {
            nextr = r+1; // 下一排的
            nextc = 0; // 第一個
        } else {
            nextr = r;
            nextc = c+1;
        }        
        // 如果這個位置可以坐, 先坐下去, 再問可以坐幾人
        if (hot[r][c]==0) { // 可以坐
            // 坐下去
            mark(r, c, hot); // 標記坐下
            got = findSol(nextr, nextc, hot);
            unmark(r, c, hot); // 標記站起來
            max = got+1;
        }    
        // 不坐呢?
        got = findSol(nextr, nextc, hot);
        if (got>max)
            max = got;
        return max;   
        
    }
    public static void main(String[] argv) {
        Scanner input = new Scanner(System.in);
        int r = input.nextInt();
        int[] c = new int[r];
        for (int i=0; i<r; i++)
            c[i] = input.nextInt();
        System.out.println(findSol(r, c));    
    }
}