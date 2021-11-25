import java.util.Scanner;
public class oge {
    public static void main(String[] argv) {
        // 相同型態的資料才能一起做運算，結果也是相同型態
        int n = 18; //宣告
        if (n < 18) {
            System.out.println("child");
        } else if (n >= 50) {
            System.out.println("old man");
        } else {
            System.out.println("adult");
        }
    }
}
