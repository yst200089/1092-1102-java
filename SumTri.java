//import java.util.Scanner;
public class SumTri {
    public static void findSol(int[] result, int n) {
        int total = 0;
        int[] sum = new int[3];
        for (int i=0 ; i < result.length; i++) {
            total += result[i];
            if (i > 0 && i % (n-1) == 0) {
                sum[ i/n]= total;
                total = 0;
                total += result[i];
            }
            if (i == result.length-1) {
                total += result[0];
                sum[n-1]= total;
            }
        }
        if(sum[0] == sum[1]) {
            System.out.println(0);
        }
    }
    public static int[] append(int[] data, int v) {
        int[] result = new int[data.length+1];
        for (int i = 0; i< data.length; i++) {
            result[i] = data[i];
        }
        result[data.length] = v;
        return result;
    }
    public static void print(int[] data) {
        for (int i = 0; i < data.length; i++) {
            System.out.print(data[i]+" ");
        }
        System.out.println();
    }
    public static void main(String[] argv) {
        //Scanner input = new Scanner(System.in);
        int n = 3; // 輸入三角形的邊長個數
        int[] data = {1, 6, 2, 4, 3, 5};
        findSol(data, n);
    }
}

// for (int j=0; j<n; j++) {
//                 sum += result[i];
//                 if (i % pos == 0) {
//                     i--;
//                 }
//                 if (i == result.length){
//                     sum += result[0];
//                 }
//             }