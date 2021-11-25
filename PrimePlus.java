import java.util.Scanner;
public class PrimePlus {
    public static long factorial(long n) {
        if (n == 1) {
            return 1;
        }
        else {
            return n*factorial(n-1);
        }
    }
    public static boolean isPrime(long n){
        for (long v=2; v*v <= n; v++){
            if( n%v == 0)
                return false;
        }
        return true;
    }
    public static int findPrime(long n){
        int times = 0;
        for(long i=2; i<=n; i++){
            // System.out.println(i);
            if (isPrime(i)) {
                times += 1;
                System.out.println(i+"! = "+factorial(i));
            }
        }
        return times;
    }
    public static void main(String[] argv){
        Scanner input = new Scanner(System.in);
        // 輸入一個整數 n
        long n = input.nextLong();
        // 找到質數
        System.out.println("factorial called "+findPrime(n)+" times");
    }
}