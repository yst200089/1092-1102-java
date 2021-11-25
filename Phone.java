import java.util.Scanner;
public class Phone {
    public static void func(int price) {
        int count = 0;
        while (price > 50) {
            price = price / 2;
            count += 1;
        }
        if (price <= 50) {
            System.out.println(count);
        }
    }
    public static void main(String[] argv) {
        Scanner input = new Scanner(System.in);
        int price = input.nextInt();
        if (price < 0) {
            System.out.println("error");
        } else {
            func(price);
        }
    }
}