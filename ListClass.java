// 學號:108213052
// 姓名:楊心慈
//import java.util.Scanner;
import java.util.StringTokenizer;
public class ListClass {
    // class List 以外的 class 不能存取它
    private int size;
    private Object[] data;
    // Overloading:名稱可以相同
    public List(){
        this.size = 0;
        this.data = new Object[100];
    }
    public List(String s){
        this.size = 0;
        this.data = new Object[100];
        StringTokenizer st = new StringTokenizer(s);
        while (st.hasMoreTokens())
            this.add(st.nextToken());
    }
    public int size(){
        return this.size;
    }
    public Object get(int index){
        return this.data[index];
    }
    public void add(Object v){
        if(this.size >= this.data.length){
            Object[] tmp = new Object[this.data.length*2];
            for(int i=0; i<size; i++)
                tmp[i] = this.data[i];
            this.data = tmp;
        }
        this.data[size++] = v;
    }
    public Object[] toArray(){
        Object[] tmp = new Object[this.size];
        for (int i=0; i<this.size; i++)
            temp[i] = this.data[i];
        return tmp;
    }
    public boolean isEmpty(){
        return this.size == 0;
    }
    public Object Pop(){
        return this.data[--this.size];
    }
    // public static void main(String[] args){
    //     Scanner input = new Scanner(System.in);
    //     //\
    // }
}
// 最後完成日期:2021年03月12日