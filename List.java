import java.util.StringTokenizer;
public class List{
    private int size;//private? this class can access
    private Object[] data;//array of reference to Object
    public List(){
        this.size = 0;
        this.data = new Object[100];//Object:所有物件的父類別
    }
    //assume String s is 'space' seperated
    public List(String s){//overloading:名稱可以相同
        this.size = 0;
        this.data = new Object[100];
        StringTokenizer st = new StringTokenizer(s);
        while(st.hasMoreTokens())
            this.add(st.nextToken());
    }
    public int size(){
        return this.size;
    }
    public Object get(int index){
        return this.data[index];
    }
    public void add(Object v){
        if(this.size >=this.data.length){//overflow
            Object[] tmp = new Object[this.data.length*2];
            for(int i = 0;i < size;i++){
                tmp[i] = this.data[i];
            }
            this.data = tmp;
        }
        this.data[size++] = v;
    }
    public Object[] toArray(){
        Object[] tmp = new Object[this.size];
        for(int i = 0;i < this.size;i++){
            tmp[i] = this.data[i];
        }
        return tmp;
    }
    public boolean isEmpty() {
        return this.size == 0;
    }
    public Object pop(){//remove the last element
        return this.data[--this.size];
    }
    public Object peek() {
        return this.data[this.size-1];
    }
}