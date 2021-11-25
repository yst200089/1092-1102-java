// 學號 : 108213052
// 姓名 : 楊心慈
import java.util.*; // * : 全部
public class Hello {
    static boolean isPrime(int v){
        for (int d=2; d*d<=v; d++){
            if (v % d == 0)
                return false;
        }
        return true;
    }
    static List<Integer> findPrimes(int n){
        // < > : 模板
        List<Integer> result = new ArrayList<Integer>();
        // ArrayList 是 List 的 subclass子類別
        for (int v=2; v<=n; v++){
            if (isPrime(v))
                result.add(new Integer(v));
        }
        return result;
    }
    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        List<Integer> result = findPrimes(n);
        for (int i=0; i<result.size(); i++)
            System.out.print(result.get(i)+" ");
        System.out.println();
    }
}
// 最後完成日期 : 2021年03月05日