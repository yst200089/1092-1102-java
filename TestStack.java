// 學號 : 108213052
// 姓名 : 楊心慈
// 1 + 2 * 3
// 中置式轉後置式，其方法如下
// 首先定義兩種 “優先順序”
// icp : incoming priority, 指該符號尚未進入堆疊時的優先權
// isp : in stack priority, 指該符號已在堆疊內時的優先權
// 每個運算符號都有上述兩種優先權
// 如果輸入是數字，則立刻輸出
// 如果是運算符號 :
//     當 堆疊不為空 且 讀入的 icp < 堆疊最上面的 isp 時:
//         delete stack and output
//     add 讀入的運算符號 到 stack
// 資料都讀完了，則清空 stack and output
// how to define icp and isp?
// 優先權高的，數字設大的
// 左結合的符號, icp and isp 設一樣大
// 右結合的符號, icp = isp + 1, 也就是 icp 比較大(因為後來的比較大)
// 特殊規則，“(” 的 icp 比較大，但 isp 最小
// 特殊規則，看到”)“，則不停 delete stack, 直到發現”(“為止
// + - * / 怎麼設 icp and isp 呢？
//       ( + - * / **
// icp : 5 1 1 2 2 4
// isp : 0 1 1 2 2 3
// (1+2)*3 - 5**6
// stack : ( + )
// output : 1 2
// stack : 
// output : 1 2 +
// stack : * -
// output : 1 2 + 3
// stack : - **
// output : 1 2 + 3 * 5 6
// stack : 
// output : 1 2 + 3 * 5 6 ** -
public class TestStack {
    public static void main(String[] argv) {
        toPost("(1+2)*3 - 5**6"); // 設定需要改變的式子
        // 1 2 + 3 * 5 6 ** -
    }
    public static boolean isOp(String s) { // 遇到運算符號需回傳
        return s.equals("+") || s.equals("-") || s.equals("*") || s.equals("/") || s.equals("**") || s.equals("(");
    }
    public static int isp(String s) { // 將運算符號定 isp 值
        String[] ops = new String[]{"(","+","-","*","/","**"};
        int[] pri = new int[]{0, 1, 1, 2, 2, 3}; // 設 isp 值
        for (int i = 0; i < ops.length; i++) {
            if (ops[i].equals(s)) {
                return pri[i];
            }
        }
        return -1; // 可能會有沒有輸入值(空值)的時候，預防此時會跑出 index out of range (錯誤訊息)，所以 return -1 作為檢查
    }
    public static int icp(String s) { // 將運算符號定 icp 值
        String[] ops = new String[]{"(","+","-","*","/","**"};
        int[] pri = new int[]{5, 1, 1, 2, 2, 4}; // 設 icp 值
        for (int i = 0; i < ops.length; i++) {
            if (ops[i].equals(s)) {
                return pri[i];
            }
        }
        return -1; // 可能會有沒有輸入值(空值)的時候，預防此時會跑出 index out of range (錯誤訊息)，所以 return -1 作為檢查
    }
    // 以後置式輸出
    public static void toPost(String expression) {
        Stack s = new Stack();
        Token t = new Token(expression);
        String exp;
        while((exp = t.next()) != null) { // 沒有遇到空位時
            if (exp.equals(")")) { // 如果遇到右括號
                String op;
                // 當 stack 不為空，一直拿出來,直到拿到“(”
                while (!s.isEmpty() && !(op=s.delete()).equals("(")) {
                    System.out.print(op+" ");
                }
            } else if (isOp(exp)) { // 若遇到運算符號
                // 當 stack 不為空，拿出所有isp >= icp 的運算符號
                while (!s.isEmpty() && isp(s.peek()) >= icp(exp)) {
                    System.out.print(s.delete()+" ");
                }
                // 最後把自己加入 stack
                s.add(exp);
            } else { // 遇到數字
                System.out.print(exp+" "); // 直接輸出
            }
        }
        // 最後清空 stack
        while (!s.isEmpty()) {
            System.out.print(s.delete()+" ");
        }
        System.out.println();
    }
}
class Token {
    String data; // 傳入的運算式字串
    int pos; // 讀取位置
    public Token(String s) {
        data = s;
    }
    // null if no more
    public String next() {
        // 跳過所有的空白或換行
        while(pos < data.length() && (data.charAt(pos) == ' ' || data.charAt(pos) == '\t')) {
            pos++;
        }
        if(pos == data.length()) { // 如果全部都讀完
            return null;
        }
        // 判斷開頭是哪種東西
        if(data.charAt(pos) == '+') { // 如果是 +
            pos++;
            return "+";
        } else if(data.charAt(pos) == '-') { // 如果是 -
            pos++;
            return "-";
        } else if(data.charAt(pos) == '*') { // 如果是 *
            pos++;
            if(pos < data.length() && data.charAt(pos) == '*') { // 若長度大於 1
                pos++;
                return "**"; // 則為次方
            }
            return "*"; // 否則為乘法
        } else if(data.charAt(pos) == '/') { // 如果是 /
            pos++;
            return "/";
        } else if(data.charAt(pos) == '(') { // 如果是 (
            pos++;
            return "(";
        } else if(data.charAt(pos) == ')') { // 如果是 )
            pos++;
            return ")";
        } else { // 若為數字
            int start = pos;
            while(pos < data.length() && data.charAt(pos) >= '0' && data.charAt(pos) <= '9') {
                pos++;
            }
            return data.substring(start, pos); // 回傳 start 到 pos 之間的數字
        }
    }
}
class Stack {
    private String[] data; // 屬性
    private int top; // point to 'tempy' slot
    // 建構子
    public Stack() { // 
        data = new String[1000]; // 可放入1000格符號
    }
    // 方法
    public void add(String x) { // 加入東西
        data[top++] = x; // 東西放入後top+1(top永遠指向空的stack)
        // data[top] = x;
        // top = top + 1;
    }
    public String delete() { // 拿出東西
        return data[--top]; // top往下移動後才能拿出東西
        // top = top -1;
        // return data[top];
    }
    public String peek() {
        return data[top-1];
    }
    public boolean isEmpty() { // 檢查stack是否是空的
        //if(top == 0) {
        //    return true;
        //} else {
        //    return false;
        //}
        return top == 0;
    }
}
// 最後完成日期 : 2020年04月07日 11:45