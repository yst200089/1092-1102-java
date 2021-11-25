// 學號:108213052
// 姓名:楊心慈

// data取n組合(不重複)
// {1,2,3,4,5} 取 2 -> {1, 2}, {1, 3}, {1, 4}
import java.util.Scanner;
public class CombCountT {
    // 將元素放入 result
    public static int[] append(int[] data, int v) {
        int[] result = new int[data.length+1];
        for (int i = 0; i < data.length; i++) {
            result[i] = data[i];
        }
        result[data.length] = v;
        return result;
    }
    // 選完後不再放入
    public static int[] tail(int[] data, int pos) {
        int[] result = new int[data.length-pos-1];
        for (int i = pos + 1, j = 0; i < data.length; i++) {
            if (i != pos)
                result[j++] = data[i];
        }
        return result;
    }
    // 開始組合
    public static int comb(int[] data, int m, int[] result){
        // m 減掉元素後小於零
        if (m < 0) {
            return 0;
        }
        // m 減掉元素後等於零(加總等於零)
        if (m == 0) {
            return 1;
        }
        // 用來計算有幾個 result 符合要求
        int sum = 0;
        // 自己先選一個，有多少種選擇方式？
        // 選第i個
        for (int i = 0; i < data.length; i++) {
            // 每找到符合資格的 result 加一
            sum += comb(tail(data, i), m - data[i], append(result, data[i]));
        }
        return sum;
    }
    // 增加 result 陣列
    public static int comb(int[] data, int m) {
        return comb(data, m, new int[0]);
    }
    public static void main(String[] argv) {
        Scanner input = new Scanner(System.in);
        // 有 N 個整數要輸入
        int n = input.nextInt();
        int[] data = new int[n];
        int m = input.nextInt();
        // 輸入 N 個整數
        for (int i  = 0; i < n; i++) {
            data[i] = input.nextInt();
        }
        // 請問這 N 個數字有多少種組合使其和為 M
        System.out.println(comb(data, m));
    }
}
// 最後完成日期:2021年03月26日