// 學號:108213052
// 姓名:楊心慈
// icp : 表示目前處理中的運算符號其優先權為何
// isp : 表示在堆疊中的運算符號其優先權為何
// 如何定義icp, isp:
// 如果是左結合，icp 和 isp 相同即可
// 如果是右結合，icp > isp
// +-:優先權 低，左結合
// */:優先權 高，左結合
// ^:次方，最高優先權，右結合
//      + - * / ^
// icp: 1 1 2 2 4
// isp: 1 1 2 2 3
// 數字越大，優先權越高
// 一、由左而右處理運算式，如果是:
// (1) 數字->直接輸出
// (2) 符號->當icp<=isp時，輸出堆疊上的符號，反之，則放入堆疊
// "(" ")" -> 怎麼處理？ ( 的icp設最大，isp設最小值
// 二、輸出堆疊所有符號
import java.util.Scanner;
public class post {
    static String[] ops = {"+", "-", "*", "/", "%", "^", "("};
    static int[] icp = {1, 1, 2, 2, 2, 4,10};
    static int[] isp = {1, 1, 2, 2, 2, 3, 0};
    // 檢查v是否為符號
    public static boolean isOp(String v) {
        for (int pos=0; pos<ops.length; pos++) {
            if (ops[pos].equals(v))
                return true;
        }
        return false;
    }
    public static int isp(String v) {
        for (int pos=0; pos<ops.length; pos++) {
            if (ops[pos].equals(v))
                return isp[pos];
        }
        return 0;
    }
    public static int icp(String v) {
        for (int pos=0; pos<ops.length; pos++) {
            if (ops[pos].equals(v))
                return icp[pos];
        }
        return 0;
    }
    public static void toPost(Object[] exp) {
        List opStack = new List();
        // 左至右讀取
        for (int i=0; i<exp.length; i++) {
            String v = (String)exp[i];
            if (v.equals(")")){
                String got;
                while (!opStack.isEmpty() && !(got=(String)opStack.pop()).equals("("))
                    System.out.print(got+" ");
            }
            else if (isOp(v)) { // 如果是運算符號
                while (!opStack.isEmpty() && icp(v) <= isp((String)opStack.peek())) {
                    System.out.print(opStack.pop()+" ");
                }
                opStack.add(v);
            } else {
                System.out.print(exp[i]+" ");
            }
        }
        while (!opStack.isEmpty())
            System.out.print(opStack.pop()+" ");
        System.out.println();
    }
    public static void main(String[] argv) {
        Scanner input = new Scanner(System.in);
        int n = Integer.valueOf(input.nextLine());
        for (int i=0; i<n; i++) {
            List exp = new List(input.nextLine());
            toPost(exp.toArray());
        }
    }
}
// 最後完成日期:2021年03月15日