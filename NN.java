import java.util.Scanner;
// 方法二
public class NN {
    public static void P(int n, int[] data){
        for(int i = 0; i < data.length; i++){
            System.out.print(data[i]+ "	");
            if (i % n == n-1) {
                System.out.println();
            }
        }
    }
    public static void main(String[] argv) {
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        int[] data = new int[n*n];
        int pos = 0;
        for (int i=1; i<=n; i++) {
            data[pos] = i;
            pos++;
            for(int j=2; j<=n; j++) {
                if (i > j) {
                    data[pos] = i;
                    pos++;
                }
                else {
                    data[pos] = j;
                    pos++;
                }
            }
        }
        P(n, data);
    }
}
// 方法一
// public class NN {
//     public static void main(String[] argv) {
//         Scanner input = new Scanner(System.in);
//         int n = input.nextInt();
//         //int[][] data = new int[n][n];
//         for (int i=1; i<=n; i++) {
//             System.out.print(i + "	");
//             for(int j=2; j<=n; j++) {
//                 if (i > j) {
//                     System.out.print(i + "	");
//                 }
//                 else {
//                     System.out.print(j+ "	");
//                 }
//             }
//             System.out.println();
//         }
//     }
// }