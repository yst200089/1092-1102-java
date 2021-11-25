// 學號:108213052
// 姓名:楊心慈
import java.util.Scanner;
public class AmazingT {
    // 新增元素到陣列
    public static int[] append(int[] data, int v) {
        int[] result = new int[data.length+1];
        for (int i = 0; i< data.length; i++) {
            result[i] = data[i];
        }
        result[data.length] = v;
        return result;
    }
    // 移除一個，其他複製
    public static int[] remove(int[] data, int pos) {
        int[] result = new int[data.length-1];
        for (int i = 0, j = 0; i < data.length; i++) {
            if (i != pos) {
                result[j++] = data[i];
            }
        }
        return result;
    }
    // 將數字內容組合
    // r : 代表三角形每邊的元素個數為 r 個
    // n : 判斷是否選完全部數字
    // result : 紀錄組合的結果
    // ans : 紀錄答案
    public static int[] perm(int[] data, int r, int n, int[] result, int[] ans){
        if (n == 0) { // 全部數字都選完後
            int tmp = findSol(result, r);
            if (tmp != 0 && hasIn(ans, tmp)){ // 如果答案之前沒出現過的話
                ans = append(ans, tmp); // 將答案加到陣列裡面
                return ans;
            }
        }
        for (int i = 0; i < data.length; i++) { // 將數字組合
            ans = perm(remove(data, i), r, n-1, append(result, data[i]), ans);
        }
        return ans;
    }
    // 回傳邊長
    public static int findSol(int[] result, int n) {
        int ans = 0; // 紀錄該三角形各邊長長度總和
        int total = 0; // 該邊長總和
        int[] sum = new int[3]; // 存三角形三個邊長
        for (int i=0 ; i < result.length; i++) {
            total += result[i];
            if (i > 0 && i % (n-1) == 0) { // 遇到連接前後的節點時
                sum[i/n]= total; // 每算完先存進去
                total = 0; // 繼續算下一個邊
                total += result[i];
            }
            if (i == result.length-1) { // 最後一個邊長需與第一個數字相加
                total += result[0];
                sum[sum.length-1]= total;
            }
        }
        if (sum[0] == sum[1] && sum[0]==sum[2]) { // 三邊都相等
            ans = sum[0];
        }
        return ans; // 回傳邊長
    }
    // 確認此答案有沒有重複
    public static boolean hasIn(int[] ans , int ans1) {
        for(int i = 0 ; i < ans.length ; i++){
            if(ans[i] == ans1){ // 如果有一樣的數字
                return false; // 那就說有出現過
            }
        }
        return true; //檢查完全部，確認都沒出現過
    }
    public static void main(String[] argv) {
        Scanner input = new Scanner(System.in);
        int n = input.nextInt(); // 輸入三角形的邊長個數
        int[] data = new int[3*n-3]; // data 用來存該三角形邊長
        for(int i = 0; i < data.length; i++) {
            data[i] = i + 1;
        }
        System.out.println((perm(data, n, data.length, new int[0], new int[0])).length);
    }
}
// 最後完成日期:2021年05月28日