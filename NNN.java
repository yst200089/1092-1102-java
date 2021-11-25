// 學號：108213052
// 姓名：楊心慈
import java.util.Scanner;
public class NNN {
    public static long countLen(long n) {
        //設變數紀錄數列長度
        int cycleLen = 1;
        // 把傳入的參數 n 拿來做 3n+1 的運算
        while(n != 1) {
            if(n % 2 == 0){
                n = n / 2;
            } else {
                n = 3 * n +1;
            }
            cycleLen += 1; // 每做一次就可以把 cycleLen + 1
        }
        // 做完之後回傳cycleLen
        return cycleLen;
    }
    public static long findSol(long start, long end) {
        Long tmp;
        if(start > end){
            tmp = start;
            start = end;
            end = tmp;
        }
        long maxLen = 0;
        // 把 start 到 end 之間的每個數字丟去做 3n+1 的運算
        for(long i = start; i <= end+1; i++) {
            // 紀錄運算完之後的數列長度
            long len = countLen(i); 
            // 每次得到新的數列長度就跟之前取得的做比較
            if(len > maxLen) {
                // 如此就能找到最大的那個
                maxLen = len;
            }
        }
        return maxLen;
    }
    public static void main(String[] argv) {
        Scanner input = new Scanner(System.in);
        long start = input.nextLong();
        long end = input.nextLong();
        long maxLen = findSol(start, end);
        // 印出
        System.out.println(start + " " + end + " "+ maxLen);
    }
}