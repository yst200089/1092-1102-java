// 學號 : 108213052
// 姓名 : 楊心慈
import java.util.Scanner;
public class Snail {
    public static int CountDays(int h, int d, int n){
        // 計算天數
        int count = 0;
        // 當蝸牛沒爬到該高度時
        while(h > 0){
            count++; // 再加一天繼續爬
            h = h - d; // 以爬高度減掉白天能爬的距離
            if(h <= 0){ // 當蝸牛爬到井口時
                break;
            }
            h = h +n; // 以爬高度加上晚上下滑距離
        }
        return count; // 回傳爬行天數
    }
    public static void main(String[] argv){
        Scanner input = new Scanner(System.in);
        // 輸入井的高度
        int height = input.nextInt();
        // 輸入蝸牛白天能爬的距離
        int daily_dis = input.nextInt();
        // 輸入蝸牛晚上會下滑的距離
        int night_dis = input.nextInt();
        // 計算出到井口的天數
        int days = CountDays(height, daily_dis, night_dis);
        // 輸出
        System.out.println(days);
    }
}
// 最後完成日期 : 2021年03月06日