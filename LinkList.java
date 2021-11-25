// a link list is a data structure
public class LinkList {
    Noda head, tail; // list 一開始是空的，此時 head == tail == null
    // 從前面加到尾巴
    public void add(int v) {
        if(tail == null) { // 如果 list 是空的
            head = tail = new Noda(v);
        } else { // 不是空的
            Noda newNoda = new Noda(v);
            // -> ... -> ... -> lastNoda    new Noda
            //                     ^
            //              tail --|
            tail.next = newNoda;
            // 要變成這樣
            // -> ... -> ... -> lastNoda "-->" new Noda
            //                     ^
            //              tail --|
            tail = newNoda;
            // ==> 再變成這樣
            // -> ... -> ... -> lastNoda --> new Noda
            //                              "  ^"
            //                         tail "--|"
        }
    }
    // 從前面開始移除
    public int remove() {
        int v = head.val;
        head = head.next; // 將頭往後移成下一個
        if(head == null) { // 如果移走最後一個，list 空了
            tail = null; // 回歸成最初 head == tail == null
        }
        return v;
    }
    public boolean isEmpty() {
        // return head == null;
        if(head == null) {
            return true;
        } else {
            return false;
        }
    }
}
class Noda {
    int val;
    // 指出在 list 裡面的下一個數
    Noda next;
    public Noda(int v) {
        this.val = v;
        this.next = null;
    }
}