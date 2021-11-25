// 學號：108213052
// 姓名：楊心慈
import java.util.Scanner;
class Stack {
    private int top;
    private int[] data = new int[1000];
    public void push(int v) {
        data[top++] = v;
    }
    public int pop() {
        return data[--top];
    }
    public boolean isEmpty() {
        return top == 0;
    }
    public int peek() {
        return data[top-1];
    }
}
public class ReduceFormula {
    public static int eval(String e) {
        return eval(e.toCharArray());
    }
    private static int isp(int c) {
        if (c == '+' || c == '-')
            return 0;
        return 1;
    }
    private static int icp(int c) {
        if (c == '+' || c == '-')
            return 0;
        return 1;
    }
    private static Stack op = new Stack(), num = new Stack();
    private static void doOp() {
        int act = op.pop();
        if (act == '+') {
            num.push(num.pop()+num.pop());
        } else if (act == '-') {
            int tmp = num.pop();
            num.push(num.pop()-tmp);
        } else if (act == '*') {
            num.push(num.pop()*num.pop());
        } else if (act == '/') {
            int tmp = num.pop();
            num.push(num.pop()/tmp);
        }
    }
    public static int eval(char[] exp) {
        for (int i = 0; i < exp.length; i++) {
            if (exp[i]=='+' || exp[i]=='-' || exp[i]=='*' || exp[i]=='/') {
                while (!op.isEmpty() && icp(exp[i]) <= isp(op.peek())) {
                    doOp();
                }
                op.push((int)exp[i]);
            } else {
                num.push(exp[i]-'0');
            }
        }
        while (!op.isEmpty()) {
            doOp();
        }
        return num.pop();
    }
    // data : 要處理的數字群 
    // ans : 運算後的答案
    // ops : 有哪些運算符號可以選
    // result : 前面同學已經做好的運算式
    private static void findSol(String data, int ans, String[] ops, String result) {
        if (data.length() == 1) {
            if (eval(result+data) == ans)
                System.out.println(result+data);
            return;
        }
        for (int i = 0; i < ops.length; i++)
            findSol(data.substring(1,data.length()), ans, ops, result+data.charAt(0)+ops[i]);
    }
    public static void findSol(String data, int ans) {
        findSol(data, ans, new String[]{"+","-","*","/"}, "");
    }
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        findSol(input.next(), input.nextInt());
    }
}
// 最後完成日期 : 2020年06月16日 09:38