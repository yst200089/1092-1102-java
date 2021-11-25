// 學號：108213052
// 姓名：楊心慈
import java.util.Scanner;
public class Fruit {
    // 輸出的形式
    public static void print(int[] result, int[] data) {
        System.out.print(data[0]+"元的 "+result[0]+" 個");
        for (int i = 1; i < data.length; i++) {
            System.out.print("、"+data[i]+"元的 "+result[i]+" 個");
        }
        System.out.println();
    }
    public static void findSol(int money, int n, int species, int[] data, int pos, int[] result){
        if (n == 0 && money >= 0) { // 買完水果，錢剛好或有剩下的話
            print(result, data); // 輸出
            return;
        }
        if (money < 0 || pos >= species) { // 錢不夠或是水果種類超過的話
            return;
        }
        for (int i = n; i >= 0; i--) { // 每種水果可以買幾顆
            result[pos] = i;
            findSol(money - data[pos] * i, n - i, species, data, pos+1, result);
            // 還原
            result[pos] = 0;
        }
    }
    public static void findSol(int money, int n, int species, int[] data){
        findSol(money, n, species, data, 0, new int[species]);
    }
    public static void main(String[] argv) {
        Scanner input = new Scanner(System.in);
        // 整數 money 表示買水果的金額上限
        int money = input.nextInt();
        // 整數 n 表示總共要買的水果數量
        int n = input.nextInt();
        // 整數 species 表示水果的種類
        int species = input.nextInt();
        int[] data = new int[species];
        // species 種水果的價錢
        for (int i = 0; i < species; i++) {
            data[i] = input.nextInt();
        }
        // 如果最便宜的水果也買不起我要的數量
        if (data[0]*n > money) {
            System.out.println("無法買滿");
        } else { // 開始買水果
            findSol (money, n, species, data);
        }
    }
}
// 最後完成日期 : 2021年03月31日