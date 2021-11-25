// 學號：108213052
// 姓名：楊心慈
import java.util.Scanner;
public class CountPrime {
    public static boolean isPrime(int x) {
        // 判斷質數
        if(x <= 1) { // 如果 x 小於 1
            return false; // 就不是質數
        }
        if(x == 2) { // 如果 x 等於 2
            return true; // 就是質數
        }
        if(x % 2 == 0) { // 如果 x 能被 2 整除
            return false; // 就不是質數
        }
        int div = 3;
        while(div < x) { // 當 div 小於 x 就停止
            if(x % div == 0) { // 如果 x 能被div整除
                return false; // 就不是質數
            }
            div += 2; // 將div遞增
        }
        return true; // 若 x 都除不盡，那就是質數
    }
    public static int countAdd(int begin, int end) {
        int counter = 0; // 設計數
        for(int num = begin; num <= end; num++) {
            if(isPrime(num)) { // 如果 num 是質數
                count++; // 計數加一
            }
        }
        return counter; // 回傳計數
    }
    public static void main(String[] arge) {
        Scanner input = new Scanner(System.in);
        int x = input.nextInt(); // 輸入 begin 數字
        int y = input.nextInt(); // 輸入 end 數字
        int count = countAdd(x, y);
        System.out.println(count); // 輸出計數
    }
}
