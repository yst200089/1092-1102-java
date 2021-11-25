import java.util.Scanner;
public class ChoseSum {
    public static int[] append(int[] result, int num) {
        int[] data = new int[result.length+1];
        for (int i = 0; i < result.length; i++) {
            data[i] = result[i];
        }
        data[result.length] = num;
        return data;
    }
    public static int[] slice(int[] num, int start, int end) {
        int[] data = new int[end-start];
        int pos = 0;
        for(int i = start; i < end; i++) {
            data[pos] = num[i];
            pos++;
        }
        return data;
    }
    public static boolean check(int[] sum, int ans) {
        boolean check = true;
        for (int j = 0; j < sum.length; j++) {
            if (sum[j] == ans) {
                check = false;
            }
        }
        return check;
    }
    public static int Sum(int[] result) {
        int total = 0;
        for(int i = 0; i < result.length; i++) {
            total += result[i];
        }
        return total;
    }
    public static void P(int[] result) {
        //System.out.print(result[0]);
        for(int i = 0; i < result.length; i++) {
            System.out.print(" "+result[i]);
        }
        System.out.println("\n--------------");
    }
    public static int[] sum = new int[0];
    public static int findSol(int[] num, int m, int total, int[] result) {
        if (m == 0) { // 選完 m 個數後
            P(result);
            if (Sum(result) <= total){ // 小於等於 total
                if (check(sum, Sum(result))) {
                    sum = append(sum, Sum(result));
                    P(sum);
                    return 1;
                }
            }
        }
        int ans = 0;
        for (int i = 0; i < num.length; i++) {
            ans += findSol(slice(num, i+1, num.length), m-1, total, append(result, num[i]));
        }
        return ans;
    }
    public static void main(String[] argv) {
        Scanner input = new Scanner(System.in);
        int n = input.nextInt(); // 數字範圍為 1~n
        int m = input.nextInt(); // 取 m 個數字總和
        int[] num = new int[n];
        for (int i = 0; i < n; i++) {
            num[i] = i + 1;
        }
        System.out.println(findSol(num, m, n*2, new int[0])+" 種");
    }
}