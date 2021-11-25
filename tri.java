// 學號：108213052
// 姓名：楊心慈
import java.util.Scanner;
public class tri {
    public static void main(String[] argv) {
        Scanner input = new Scanner(System.in);
        int a, b, c; //宣告 byte, short, int, long, boolean, char, float, double
        a = input.nextInt();
        b = input.nextInt();
        c = input.nextInt();
        int tmp;
        if (a > b) {
            tmp = a;
            a = b;
            b = tmp;
        } if (a > c) {
            tmp = a;
            a = c;
            c = tmp;
        } if (b > c) {
            tmp = b;
            b = c;
            c = tmp;
        }
        System.out.println(a + " " + b + " " + c);
        if ( a + b <= c) {
            System.out.println("No");
        } else if ( a * a + b * b < c * c ) {
            System.out.println("Obtuse");
        } else if ( a * a + b * b == c * c ) {
            System.out.println("Right");
        } else if ( a * a+b * b > c * c ) {
            System.out.println("Acute");
        }
    }
}