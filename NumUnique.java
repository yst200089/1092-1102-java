// 數獨
// 直 橫 塊 相同的數字只能出現一次
// 直 橫 塊 : 各有 9個,給編號0~8
// 塊 : 0 1 2
//      3 4 5
//      6 7 8
// 如果把81個數字編號0~ 80
// 則編號n在哪個row r, col c, block b?
// r = n / 9
// c = n % 9
// b = r/3*3+c/3
import java.util.Scanner;
public class NumUnique {
    // 0 表示還沒填入
    // 1~9表示該位置已經確定了
    private int[] data;
    private boolean[][] 直, 橫, 塊;
    // 在n位置上, 填入數字num
    private void fill(int n, int num) {
        int r = n / 9;
        int c = n % 9;
        int b = r/3*3+c/3;
        直[c][num-1] = 橫[r][num-1] = 塊[b][num-1] = true;
    }
    private void unFill(int n, int num) {
        int r = n / 9;
        int c = n % 9;
        int b = r/3*3+c/3;
        直[c][num-1] = 橫[r][num-1] = 塊[b][num-1] = false;
    }
    private boolean canFill(int n, int num) {
        int r = n / 9;
        int c = n % 9;
        int b = r/3*3+c/3;
        // 非 (直 或 橫 或 塊 已填)
        return !(直[c][num-1] || 橫[r][num-1] || 塊[b][num-1]);
    }
    public NumUnique(int[] data) {
        this.data = data;
        直 = new boolean[9][9]; // 每一個直行(索引1)那些數字(索引2)已經被占住了
        橫 = new boolean[9][9]; // 每一個橫行那些數字已經被占住了
        塊 = new boolean[9][9]; // 每一個塊那些數字已經被占住了
        for (int i = 0; i < 81; i++) {
            if (data[i] != 0) {
                fill(i, data[i]);
            }
        }
    }
    // 試著在位置n填入可能的數字
    private void findSol(int n) {
        if (n == 81) { // found
            for (int i = 0; i < 9 ; i++) {
                for (int j = 0; j < 9; j++) {
                    System.out.print(data[i*9+j]+" ");
                }
                System.out.println();
            }
            return;
        }
        if (data[n] == 0) { // 此位置還沒確定
            // 那些數字是可以填的?
            for (int i = 1; i <= 9 ; i++) { // 數字i
                if (canFill(n, i)) {
                    fill(n, i);
                    data[n] = i;
                    findSol(n+1);
                    data[n] = 0;
                    unFill(n, i);
                }
            }
        } else { // 已確定,填下一個位置就好
            findSol(n+1);
        }
    }
    public void printSol() {
        findSol(0);
    }
    public static void main(String[] argv) {
        Scanner input = new Scanner(System.in);
        int[] data = new int[81];
        for (int i = 0; i < 81; i++) {
            data[i] = input.nextInt();
        }
        NumUnique nu = new NumUnique(data);
        nu.printSol();
    }
}