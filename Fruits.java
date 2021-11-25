// 學號：108213052
// 姓名：楊心慈
import java.util.Scanner;
public class Fruits{
    public static void print(int[] result, int[] data){
        System.out.print(data[0] + "元的 " + result[0] + " 個");
        for(int i=1; i<data.length; i++) {
            System.out.print("、" + data[i] + "元的 " + result[i] + " 個");
        }
        System.out.println();
    }
    // money 剩多少預算
    // n 剩多少顆水果要買
    // species 有幾種水果
    // data 水果的價錢
    // result 購物籃
    // pos 買到第幾顆水果
    public static void findSol(int money, int n, int species, int[] data, int pos, int[] result){
        // 終止條件
        if(n == 0 &&  money >= 0) { // 水果買完還有剩錢
            // 執行輸出
            print(result, data);
            return;
        }
        if(money < 0 || pos >= species) { // 如果超出預算或是沒有 species+1 種水果
            return;
        }
        for(int i=n; i>=0; i--){ // 可以買 0~n 顆種水果
            result[pos] = i;
            findSol(money - data[pos]*i, n-i, species, data, pos+1, result);
            // 接下來丟給下一個人
            // 下一個人可以買 n-1 個水果
            result[pos] = 0;
        }
    }
    public static void main(String[] argv) {
        Scanner input = new Scanner(System.in); 
        // 整數 money 表示買水果的金額上限
        int money = input.nextInt();
        // 整數 n 表示總共要買的水果數量
        int n = input.nextInt();
        // 整數 species 表示水果的種類
        int species = input.nextInt();
        // species 種水果的價錢
        int[] data = new int[species];
        for(int i=0; i<data.length; i++) {
            data[i] = input.nextInt();
        }
        // 如果錢不夠把最便宜的錢買滿
        if(data[0]*n > money) {
            System.out.println("無法買滿");
        } else { // 呼叫遞迴函數去窮舉所有結果
        findSol(money, n, species, data, 0, new int[species]);
        }
    }
}
// 最後完成日期 : 2020年05月05日 19:30

// input :
// 100 5 5
// 19 22 24 26 28
// output :
// 19元的 5 個、22元的 0 個、24元的 0 個、26元的 0 個、28元的 0 個
// 19元的 4 個、22元的 1 個、24元的 0 個、26元的 0 個、28元的 0 個
// 19元的 4 個、22元的 0 個、24元的 1 個、26元的 0 個、28元的 0 個