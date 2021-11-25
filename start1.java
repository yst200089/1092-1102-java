import java.util.Scanner;
public class start1 {
    public static void main(String[] argv) {
        // while loop
        int sum = 0, i ;
        i = 0;
        while (i <= 10) {
            sum = sum + i;
            i = i + 1;
        }
        System.out.println(sum);
    }
}

import java.util.Scanner;
public class start1 {
    public static void main(String[] argv) {
        int i = 0;
        System.out.println(i++); //0
        System.out.println(++i); //2
        System.out.println(i); //2
    }
}