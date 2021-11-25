import java.util.Scanner;
public class Prime {
    public static boolean isPrime(int n){
        //從 2 開始找
        int num = 2;
        while (num < n)
            // 可以整除
            if (n % num != 0){
                return false;
            }
            else {
                return true;
            }
        // 繼續往下找
        num++;
    }
    public static List<int> findPrime(int n){
        List<int> all = new List<int>();
        for(int i=2; i<=n; i++){
            if (isPrime(i))
                all.add(i);
        }
        return all;
    }
    public static void main(String[] argv){
        Scanner.input = new Scanner(System.in);
        // 輸入一個整數 n
        int n = input.nextInt();
        // 找到質數
        allPrime = findPrime(n);
        // 輸出
        for(int s : allPrime){
            System.out.println(s+" ");
        }
    }
}