// 三角形的三邊長的數字加總需相等需相等
import java.util.Scanner;
public class TriTest {
    private int[] found = new int[0];
    public int findSol(int n) {
        int[] data = new int[3*n-3];
        for(int i = 0; i < data.length; i++) {
            data[i] = i+1;
        }
        findSol(n, data, 0, new int[3*n-3]);
        return found.length;
    }
    private void append(int v) {
        for (int i = 0; i < found.length; i++) { // 檢查是否出現
            if (found[i] == v) {
                return;
            }
        }
        int[] tmp = new int[found.length+1];
        for (int i = 0; i < found.length; i++) {
            tmp[i] = found[i];
        }
        tmp[found.length] = v;
        found = tmp;
    }
    // n : 題目給的 n
    // data : value to select
    // got : 已經選了幾個
    // result : 選了哪些
    private void findSol(int n, int[] data, int got, int[] result) {
        int target = ((3*n-3)*(3*n-2)/2+result[0]+result[1]+result[2])/3;
        if (got == n-2+3) { // 頂點確定就知道邊長
            int sum1 = result[0] + result[1];
            for (int i = 3; i<3+n-2; i++) {
                sum1 += result[i];
            }
            if (target != sum1) {
                return;
            }
        }
        if (got == 2*n-4+3) {
            int sum2 = 0;
            sum2 = result[1]+result[2];
            for (int i = 3+n-2; i < 3+n-2+n-2; i++) {
                sum2 += result[i];
            }
            if (target == sum2) {
                append(target);
            }
            return;
        }
        for (int pos = got; pos < data.length; pos++){
            // if not processing the first element of a set, then the chose value must > last result
            // and sum of vertex of triangle must divided by 3
            if ((got == 0 || got == 3|| got == 3+n-2 || result[got-1] < data[pos]) && !(got == 2 && (result[0]+result[1]+data[pos])%3 != 0)) {
                result[got] = data[pos];
                int tmp = data[pos]; // 做交換
                data[pos] = data[got];
                data[got] = tmp;
                findSol(n, data, got+1, result);
                tmp = data[pos]; // 還原
                data[pos] = data[got];
                data[got] = tmp;
            }
        }
    }
    public static void main(String[] argv) {
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        System.out.println(new TriTest().findSol(n));
    }
}