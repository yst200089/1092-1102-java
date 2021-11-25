// 學號:108213052
// 姓名:楊心慈
import java.util.Scanner;
public class Isolation {
    // 輸出全部學生的資料
    public static void Data(Student[] Data, int n) {
        System.out.println("- - - - 全部學生 - - - -");
        System.out.println("姓名"+"\t"+"體溫"+"\t"+"出國史"+"\n");
        for (int i = 0; i < n; i++){
            // 將所有學生的資料都印出
            System.out.println(Data[i].name+"\t"+Data[i].temper+"\t"+Data[i].history);
        }
        System.out.println();
    }
    // 輸出須隔離的學生資料
    public static void Isolation(Student[] Data, int n) {
        System.out.println("- - - - 隔離名單 - - - -");
        System.out.println("姓名"+"\t"+"體溫"+"\t"+"出國史"+"\n");
        for (int i = 0; i < n; i++) {
            if (Data[i].temper > 37.4 || Data[i].history == 1) { // 選取溫度超過37.4或有出國史都須隔離
                System.out.println(Data[i].name+"\t"+Data[i].temper+"\t"+Data[i].history);
            }
        }
        System.out.println();
    }
    // 輸出所查詢的學生資料
    public static void Search(Student[] Data, String Sid, int n) {
        System.out.println("- - - - 查詢結果 - - - -"+"\n");
        for (int i = 0; i < n; i++) {
            if (Data[i].id.equals(Sid)) { // 將學號相同者的資料印出
                System.out.println(Data[i].name+"\t"+Data[i].id+"\t"+Data[i].temper+"\t"+Data[i].history);
            }
        }
        System.out.println();
    }
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        // 輸入總共有幾筆學生資料
        int n = input.nextInt();
        // 輸入n筆學生的姓名、學號、體溫、出國史
        Student[] StudentsData = new Student[n];
        for (int i=0; i<n; i++) {
            StudentsData[i] = new Student(input.next(), input.next(), input.nextFloat(), input.nextInt());
        }
        // 輸入要查詢的學號
        String SearshID = input.next();
        // 輸出全部名單
        Data(StudentsData, n);
        // 輸出隔離名單
        Isolation(StudentsData, n);
        // 輸出該學生的查詢結果
        Search(StudentsData, SearshID, n);
    }
}
class Student {
    String name;
    String id;
    float temper;
    int history;
    public Student(String name, String id, float temper, int history){
        this.name = name; // 傳入當前學生的姓名
        this.id = id; // 傳入當前學生的學號
        this.temper = temper; // 傳入當前學生的溫度
        this.history = history; // 傳入當前學生是否有出國史
    }
}
// 最後完成日期:2021年03月13日