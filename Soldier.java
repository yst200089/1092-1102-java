import java.util.Scanner;
public class Soldier {
    public static int FindAns(int y, int m, int d) {
        int quotient = 0; // 商數
        int remainder = 0; // 餘數
        int ans = 0;
        quotient = y / (m + d);
        remainder = y % (m + d);
        ans = quotient + remainder + m + d;
        System.out.println(quotient);
        System.out.println(remainder);
        return ans;
    }
    public static void main(String[] argv) {
        Scanner input = new Scanner(System.in);
        int year = input.nextInt();
        int month = input.nextInt();
        int day = input.nextInt();
        System.out.println(FindAns(year, month, day));
    }
}
// 最後完成日期:2021年04月17日