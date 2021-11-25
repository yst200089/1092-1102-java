// 學號：108213052
// 姓名：楊心慈
import java.util.Scanner;
abstract class Transportation {
    // 宣告車牌號碼、品牌、顏色的屬性
    String num;
    String brand;
    String color;
    public abstract void move(); // 駕駛的方式
}

class Ambulance extends Transportation {
    public void move() { // 輸出車輛的駕駛方式，以及屬性
        System.out.println("I drive Ambulance " + this.num + " " + this.brand + " " + this.color);
    }
    public Ambulance(String num,String brand,String color) {
        this.num = num; // 當前汽車的車牌號碼
        this.brand = brand; // 當前汽車的品牌
        this.color = color; // 當前汽車的顏色
    }
}

class Motorcycle extends Transportation {
    public void move() { // 輸出車輛的駕駛方式，以及屬性
        System.out.println("I ride Motorcycle " + this.num + " " + this.brand + " " + this.color);
    }
    public Motorcycle(String num,String brand,String color) {
        this.num = num; // 當前機車的車牌號碼
        this.brand = brand; // 當前機車的品牌
        this.color = color; // 當前機車的顏色
    }
}

class Bike extends Transportation {
    public void move() { // 輸出車輛的駕駛方式，以及屬性
        System.out.println("I ride Bike " + this.num + " " + this.brand + " " + this.color);
    }
    public Bike(String num,String brand,String color) {
        this.num = num; // 當前腳踏車的車牌號碼
        this.brand = brand; // 當前腳踏車的品牌
        this.color = color; // 當前腳踏車的顏色
    }
}

public class MakeTranspor {
    public static void main(String[] argv) { 
        Scanner input = new Scanner(System.in);
        Transportation[] Car = new Transportation[3];
        Car[0] = new Ambulance(input.next(), input.next(), input.next()); // 依序輸入汽車的車牌號碼、品牌、顏色
        Car[1] = new Motorcycle(input.next(), input.next(), input.next()); // 依序輸入機車的車牌號碼、品牌、顏色
        Car[2] = new Bike(input.next(), input.next(), input.next()); // 依序輸入腳踏車的車牌號碼、品牌、顏色
        Car[0].move(); // 執行汽車駕駛方式
        Car[1].move(); // 執行機車駕駛方式
        Car[2].move(); // 執行腳踏車駕駛方式
    }
}
// 最後完成日期 : 2020年04月09日 22:25

// input :
// AAA-1234 BMW Rainbow
// BBB-8888 SYM Transparent
// CCC-5555 Giant White

// output :
// I drive Ambulance AAA-1234 BMW Rainbow
// I ride Motorcycle BBB-8888 SYM Transparent
// I ride Bike CCC-5555 Giant White