// 學號:108213052
// 姓名:楊心慈
// 中置式轉後置式
// ?Integer
import java.util.Scanner;
public class Postfix {
    public static int eval(Object[] exp) {
        //ListClass stack = new ListClass();
        List stack = new List();
        for(int i=0; i<exp.length; i++) {
            String op = (String)exp[i];
            // 如果是運算符號
            if (op.equals("+")||op.equals("-")||op.equals("*")||op.equals("/")) {
                int op2 = ((Integer)stack.pop()).intValue();
                int op1 = ((Integer)stack.pop()).intValue();
                if (op.equals("+"))
                    stack.add(Integer.valueOf(op1+op2));
                else if (op.equals("-"))
                    stack.add(Integer.valueOf(op1-op2));
                else if (op.equals("*"))
                    stack.add(Integer.valueOf(op1*op2));
                else if (op.equals("/"))
                    stack.add(Integer.valueOf(op1/op2));
            } else {
                stack.add(Integer.valueOf((String)exp[i]));
            }
        }
        return ((Integer)stack.pop()).intValue();
    }
    public static void main(String[] argv) {
        Scanner input = new Scanner(System.in);
        // read in integer n
        // then n lines of postfix expression
        // evaluation and print out result
        // 3+5-1= --> 35+1-
        int n = Integer.valueOf(input.nextLine());
        for (int i=0; i<n; i++) {
            //ListClass exp = new ListClass(input.nextLine());
            List exp = new List(input.nextLine());
            // casting:轉型
            int result = eval(exp.toArray());
            System.out.println(result);
        }
    }
}
// https://codertw.com/程式語言/527751/
// Java中 Int 和Integer 的區別 
// 1. int 是基本資料型別（原始資料型別），直接存數值；integer是int 的封裝類，是物件型別 
// 2. int預設值為0，integer預設值為null 
// 3. 向ArrayList裡面add，add的必須是Object而不是int
// 最後完成日期:2021年03月12日