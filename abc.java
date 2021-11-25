import java.util.Scanner;
// 還記得迴文嗎？
// 1234321
// 如果某數x不是迴文,則計算x + x反轉數, 直到找到迴文為止
// 給數x,請問要做幾次加法?
public class abc {
    // 12345 ==> 54321 how?  
    // x : 12345 1234 123 12  1
    // y :       5    54  543 5432  54321
    public static double[] cal(int[] data, int n) {
        double sum = 0;
        for (int i = 0; i < n; i++) {
            sum = sum + data[i];
        }
        double avg = sum / n;
        sum = 0;
        for (int i = 0; i < n; i++) {
            sum = sum + (data[i]-avg)*(data[i]-avg);
        }
        double stddev = Math.sqrt(sum/n);
        return new double[]{avg,stddev};
    }
    public static void main(String[] argv) {
        Scanner input = new Scanner(System.in);
        int[] data; // data is a reference to array of int
        int n = input.nextInt();
        data = new int[n]; // create an array object
        for (int i = 0; i < n; i++){
            data[i] = input.nextInt();
        }
        double[] rel = cal(data, n);
        System.out.println("avg="+rel[0]+",stddev="+rel[1]);
    }
}