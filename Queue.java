// 學號:108213052
// 姓名:楊心慈

// implements Queue with linked list
// FIFO
class Node {
    int value;
    Node next; // a reference to Node object
    public Node(int v) {
        this.value = v;
    }
}
public class Queue {
    Node head, tail;
    int size;
    // synchronized 不可分割
    public synchronized void add(int v) { // 讓指令不被分割
        while (size >= 100) {
            try {
                wait();
            } catch (Exception e){
                //
            }
        }
        Node tmp = new Node(v); // create a new node
        if (tail == null) { // if the queue is empty
            head = tail = tmp;
        } else {
            tail.next = tmp; // 原先最後一人的下一位是剛來這位
            tail = tmp; // tail 為新加的節點
        }
        size++;
        if (size == 1) { // 如果剛剛是空的
            notifyAll();
        }
    }
    // remove the frist element
    public synchronized int remove() {
        while (head == null) {
            try {
                // wait()與notifyAll()為一組
                wait(); // 不會自己醒，當 notifyAll() 函數呼叫時，重新開始執行
            } catch (Exception e) {
            }
        }
        int v = head.value;
        head = head.next;
        if (head == null) { // remove the last element
            tail = null;
        }
        size--;
        // notifyAll() 呼叫所有在 wait() 的函數，開始執行
        if (size == 99) { // 剛剛是滿的，現在有空位
            notifyAll(); // 叫醒在wait()的物件
        }
        return v;
    }
    // 檢查 Queue 是否為空
    public synchronized boolean isEmpty() {
        return head == null;
    }
    public static void main(String[] argv) {
        Queue q = new Queue();
        for (int i = 1; i <= 10; i++) {
            q.add(i);
        }
        while(!q.isEmpty()){
            System.out.println(q.remove());
        }
    }
}

// 最後完成日期:2021年05月17日