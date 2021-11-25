// 學號:108213052
// 姓名:楊心慈
import java.util.Scanner;
class List {
    int size;
    int[] data; // 宣告 data 型態
    // 建構子
    public List(){
        size = 0;
        data = new int[100];
    }
    public int size(){
        return this.size;
    }
    public void add(int v){
        if (this.size > this.data.length) { // 長度不夠
            int[] tmp = new int[data.length*2]; // 長度加一倍
            for (int i=0; i<size; i++) {
                tmp[i] = this.data[i]; // copy data to temp array
            }
            this.data = tmp; // let data point to tmp
        }
        this.data[size++] = v;
    }
    public int get(int i){
        return this.data[i];
    }
    public int pop(){
        // int v = data[size--];
        // size = size-1;
        // return v;
        return this.data[size--];
    }
}
public class PrimeList {
    public static boolean isPrime(int n){
        for (int v=2; v*v <= n; v++){
            if( n%v == 0)
                return false;
        }
        return true;
    }
    public static List findPrimes(int n){
        List result = new List();
        for (int v=2; v<=n; v++){
            if(isPrime(v))
                result.add(v);
        }
        return result;
    }
    public static void main(String[] argv){
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        List result = findPrimes(n);
        for (int i=0; i<result.size(); i++)
            System.out.println(result.get(i));
    }
}
// 最後完成日期:2021年03月08日