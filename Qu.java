import java.util.Scanner;
//請解n皇后問題
//直、橫、右上斜、右下斜都不可以有其他皇后
//直橫各有n條，編號給0~n-1
//右上斜，右下斜各有2n-1條，標號給0~2n-2
//board[r]][c],代表盤面的(r,c)位置,r是row,c是column,都是0~n-1
//那這個位置是屬於哪條直，橫，右上斜，右下斜線?
//直:c
//橫:r
//右上斜:r+c
//右下斜:r-c+n-1
public class Qu {
    // downright : 每條右下斜線被佔用的狀況， false 表示沒被佔用
    public static int queen(int n, int r, boolean[] straight, boolean[] upright, boolean[] downright) {
        if(n == r) { // 都擺上去
            return 1; // 找到一組解
        }
        int sol = 0; // 多少解法
        // 這個 row 上的每個 column c 都試試看能不能擺上去
        for(int c=0; c<n; c++) {
            // 如果三種線都沒被佔住(false)
            if(!(straight[c] || upright[r+c] || downright[r-c+n-1])) {
                // 擺上去，所以這三種線就被佔住了(true)<-使用塗改法
                straight[c] = upright[r+c] = downright[r-c+n-1] = true;
                // 解法+1
                sol += queen(n, r+1, straight, upright, downright);
                // 記得要塗掉剛剛做的記號(還原)
                straight[c] = upright[r+c] = downright[r-c+n-1] = false;
            }
        }
        return sol;
    }
    // 會有幾種情況發生
    public static int queen(int n) {
        // 建構每一行的陣列 straight, upright, downright
        return queen(n, 0, new boolean[n], new boolean[2*n-1], new boolean[2*n-1]);
    }
    public static void main(String[] argv) {
        Scanner input = new Scanner(System.in);
        // 有 n 個皇后
        int n = input.nextInt();
        // 執行
        System.out.println(queen(n));
    }
}