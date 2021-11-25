// 學號：108213052
// 姓名：楊心慈

// 使用者呼叫函數
import java.util.Scanner;
import java.io.*;
public class Fun {
    // 宣告 c 是 PrintStream
    public static void callMagic(PrintStream p, String value) {
        p.println(value);
    }
    public static void main(String[] argv){
        Scanner input = new Scanner(System.in);
        callMagic(System.out, "Hello World");
    }
}

 // 最後完成日期 : 2021年05月10日