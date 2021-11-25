// 學號:108213052
// 姓名:楊心慈
// 點燈遊戲
import java.util.Scanner;
public class Light {
    // 印出動過的開關
    public static void print(int n, boolean[] result) {
        System.out.println();
        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                // 如果是 true 就印出 #，false 就印出 .
                System.out.print(result[i * n + j] ? "# " : ". ");
            }
            System.out.println();
        }
        System.out.println("--------------");
        
    }
    // 點亮
    // n : 空間大小
    // row : 列
    // col : 行
    private static void mark(int n, int row, int col, boolean[] light) {
        int[][] posList = {{0, 0}, {0,1}, {0,-1}, {1,0}, {-1,0}}; // 自己 右 左 上 下
        for (int i=0; i < 5; i++) { // 改變周圍狀態
            int pos = (row + posList[i][0]) * n + col + posList[i][1];
            // 不要超出範圍
            if (row+posList[i][0] >= 0 &&  row + posList[i][0] < n){ // 限制第一排和第 n 排的範圍
                if(col+posList[i][1] >= 0 && col+posList[i][1] < n){ // 限制第一列和第 n 列的範圍
                    light[pos] = !light[pos];
                }
            }
        }
    }
    // n : 有幾排燈
    // pos : 我負責哪一燈
    // light : 每一個燈的狀態，true亮 false暗
    // result : 紀錄開關
    private static int findSol(int n, int pos, boolean[] light, boolean[] result) {
        // 全部的燈都亮
        if (pos == n * n) {
            print(n, result);
            return 1; // 找到一解
        }
        int ans = 0; // 計算有多少解
        int row = pos / n; // 判斷列
        int col = pos % n; // 判斷行
        // 判斷我該不該點這個燈
        if (row == 0) { // 第一排
            mark(n, row, col, light); // 點亮
            result[pos] = true; // 紀錄開關
            ans += findSol(n, pos+1, light, result);
            mark(n, row, col, light); // 還原
            result[pos] = false; // 還原
            // 不點亮
            ans += findSol(n, pos+1, light, result);
        }
        else if (row == n-1) { // 最後一排
            if (col >= 1) { // 從第二列開始
                if (light[pos-n] != light[pos-1]) { // 左邊和上面的燈狀態不同
                    return 0;
                }
            }
            if (col == n-1 && light[pos-n] != light[pos]) { // 最後的燈與上面的燈狀態不同
                return 0;
            }
            if (light[pos-n] == false) {
                mark(n, row, col, light); // 點亮
                result[pos] = true; // 紀錄開關
                ans += findSol(n, pos+1, light, result);
                mark(n, row, col, light); // 還原
                result[pos] = false; // 還原
            } else {
                // 不點亮
                ans += findSol(n, pos+1, light, result);
            }
        }
        else {
            if (light[pos-n] == false) {
                mark(n, row, col, light); // 點亮
                result[pos] = true; // 紀錄開關
                ans += findSol(n, pos+1, light, result);
                mark(n, row, col, light); // 還原
                result[pos] = false; // 還原
            }else{
                // 不點亮
                ans += findSol(n, pos+1, light, result);
            }
        }
        // 回傳解法
        return ans;
    }
    public static int findSol(int n){
        return findSol(n, 0, new boolean[n*n], new boolean[n*n]);
    }
    public static void main(String[] argv) {
        Scanner input = new Scanner(System.in);
        int n = input.nextInt(); // 輸入空間大小
        // 輸出解法
        System.out.println("總共"+findSol(n)+"種方法");
    }
}
// 最後完成日期:2021年04月26日