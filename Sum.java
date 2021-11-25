// 學號：108213052
// 姓名：楊心慈

// input :
// 4
// 3 4 6 7
// 1 4 4 9

// output :
// 1100
// 0001
// 0101
// 0011
import java.util.Scanner;
public class Sum {
    public static void PrintSol(int n, boolean[] result){
        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                // 如果 ? 左邊是 true 就執行 : 左邊，不是就執行 : 右邊
                System.out.print(result[i*n+j] ? "1" : "0");
            }
            System.out.println();
        }
        System.out.println();
    }
    // pos : 人家要我負責的位置
    // result : 前面的人已經填好的答案紙
    public static void StudentDo(int n, int[] row, int[] col, int pos, boolean[] result){
        if(pos == n*n){ // 答案卷都已經寫完了
            PrintSol(n, result);
            return;
        }
        int r = pos / n;
        int c = pos % n;
        // 只有兩種可能
        // 不選，把答案卷交給另一位同學做下一題
        if((r != n-1 && c != n-1) || // 不是在最後一個都可以 不選
           (r != n-1 && c == n-1 && row[r] == 0) || // row 在最後一個 col 剛好為0
           (r == n-1 && c != n-1 && col[c] == 0) || // col 在最後一個 row 剛好為0
           (r == n-1 && c == n-1 && row[r] == 0 && col[c] == 0)){
            StudentDo(n, row, col, pos+1, result);
        }
        // 選，把答案卷寫在答案紙上，再交給另一位同學做下一題
        if((r != n-1 && c != n-1 && row[r] >= c+1 && col[c] >= r+1) ||
           (r != n-1 && c == n-1 && row[r] == c+1 && col[c] >= r+1) || // 最後一個要扣到剛好
           (r == n-1 && c != n-1 && row[r] >= c+1 && col[c] == r+1) || // 最後一個要扣到剛好
           (r == n-1 && c == n-1 && row[r] == c+1 && col[c] == r+1)){
            result[pos] = true;
            row[r] -= c+1; // 行從1開始
            col[c] -= r+1; // 列從1開始
            StudentDo(n, row, col, pos+1, result);
            // 還原
            result[pos] = false;
            row[r] += c+1;
            col[c] += r+1;
        }
    }
    // n : 方陣有多大
    // row : 每一個 row 的加總要求
    // col : 每一個 col 的加總要求
    public static void TeacherDo(int n, int[] row, int[] col){
        // 弄一張空白的答案卷，請學生由第一個位置開始填答
        StudentDo(n, row, col, 0, new boolean[n*n]);
    }
    public static void main(String[] argv){
        Scanner input = new Scanner(System.in);
        int n = input.nextInt(); // 輸入方陣大小
        int[] row = new int[n]; // 輸入n個整數代表最右邊的 row 目標
        int[] col = new int[n]; // 輸入n個整數代表最下面的 col 目標
        for(int i=0; i<n; i++){
            row[i] = input.nextInt();
        }
        for(int j=0; j<n; j++){
            col[j] = input.nextInt();
        }
        TeacherDo(n, row, col);
    }
}
// 最後完成日期 : 2020年06月02日 10:54