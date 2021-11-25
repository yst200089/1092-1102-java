import java.util.Scanner;
public class Stu {
    public static void FindAns(int n,int[] data) {
        int total = 0;
        int count = 0;
        for (int i = 0; i < n; i++) {
            total += data[i];
        }
        double avg = (double)total / (double)n;
        for (int j = 0; j < n; j++) {
            if (data[j] < avg) {
                count++;
            }
        }
        System.out.println("average:"+avg);
        System.out.println("number:"+count);
    }
    public static void main(String[] argv) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] data = new int[n];
        for (int i = 0; i < n; i++) {
            data[i] = in.nextInt();
        }
        FindAns(n, data);
    }
}