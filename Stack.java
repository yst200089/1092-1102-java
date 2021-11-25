// 1 + 2 * 3 中置式
// 1 2 3 * + 後置式
// who to evaluate post fix expression?
// for each input token :
//     if token is number :
//         push(add) token to stack
//     otherwise :
//         pop(delete) two numbers from stack, do operation, then push result
public class Stack {
    public static void main(String[] argv) {
        Stack s = new Stack();
        for(int i=0; i<10; i++) {
            s.add(i);
        }
        while(!s.isEmpty()) {
            System.out.println(s.delete());
        }
    }
}
class Stack {
    private int[] data; // 屬性
    private int top; // point to 'tempy' slot
    // 建構子
    public Stack() {
        data = new int[1000]; // 可放入1000格符號
    }
    // 方法
    public void add(int x) { // 加入東西
        data[top++] = x; // 東西放入後top+1(top永遠指向空的stack)
        // data[top] = x;
        // top = top + 1
    }
    public int delete() { // 拿出東西
        return data[--top]; // top往下移動後才能拿出東西
        // top = top -1;
        // return data[top];
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