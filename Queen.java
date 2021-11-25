// 學號:108213052
// 姓名:楊心慈

import java.util.Scanner;
public class Queen {
    // 求n皇后問題有幾解
    public static int findSol(int n) {
        return findSol(n,0,new boolean[n],new boolean[2*n-1],new boolean[2*n-1],new boolean[n][n]);
    }
    // Q: 如果目前位置是(r,c)，請問此位置佔住了哪幾條線?
    // A: c直線、r+c的ur線、r-c+n-1的dr線
    // n : n 皇后問題
    // row : 要負責擺row的編號
    // c : 某個 column(直線) 是否已有皇后佔住
    // ur : 某個右上斜線，是否已有皇后佔住
    // dr : 某個右下斜線，是否已有皇后佔住
    // result : 是否有擺皇后
    public static int findSol(int n, int r, boolean[] col, boolean[] ur, boolean[] dr, boolean[][] result) {
        if (n == r) { // 擺滿了
            return 1;
        }
        int sum = 0;
        for (int c = 0; c < n; c++) { // try each column in this row
            if (!(col[c] || ur[r+c] || dr[r-c+n-1])) { // 如果都沒佔住
                result[r][c] = col[c] = ur[r+c] = dr[r-c+n-1] = true;
                sum += findSol(n, r+1, col, ur, dr, result);
                result[r][c] = col[c] = ur[r+c] = dr[r-c+n-1] = false;
            }
        }
        return sum;
    }
    public static void main(String[] argv) {
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        System.out.println(findSol(n));
    }
}

// 最後完成日期:2021年03月29日