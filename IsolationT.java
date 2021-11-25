import java.util.Scanner;
public class IsolationT {
    public static void main(String[] argv) {
        Scanner input = new Scanner(System.in);
        List allStu = new List(input.nextInt(), input);
        allStu.print();
        allStu.filter().print();
        allStu.find(input.next()).print();
    }
}
class Student {
    String name, id;
    float tem;
    int travel;
    public Student(String name, String id, float tem, int travel) {
        this.name = name;
        this.id = id;
        this.tem = tem;
        this.travel = travel;
    }
    public void print() {
        System.out.println(name+"\t"+tem+"\t"+travel);
    }
}
class List {
    Student[] data;
    int len;
    public List(int max) {
        data = new Student[max];
        len = 0;
    }
    public List(int max, Scanner input) {
        this(max); // call another constructor
        for (int i = 0; i < max; i++) {
            addStu(new Student(input.next(),input.next(),input.nextFloat(),input.nextInt()));
        }
    }
    public void addStu(Student s) {
        data[len++] = s;
    }
    public void print() {
        System.out.println("姓名\t溫度\t出國史");
        for (int i = 0; i < len; i++) {
            data[i].print();
        }
    }
    public List filter() {
        List result = new List(len);
        for (int i = 0; i < len; i++) {
            if (data[i].tem > 37.4 || data[i].travel==1) {
                result.addStu(data[i]);
            }
        }
        return result;
    }
    public Student find(String id) {
        for (int i = 0; i < len; i++) {
            if (data[i].id.equals(id)) {
                return data[i];
            }
        }
        return null;
    }
}