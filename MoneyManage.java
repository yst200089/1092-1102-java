// 學號:108213052
// 姓名:楊心慈
import java.util.Scanner;
public class MoneyManage {
    public static void main(String[] argv) {
        Scanner input = new Scanner(System.in);
        // 輸入擁有者姓名
        String owner = input.next();
        // 輸入錢包金額
        int remain = input.nextInt();
        Wallet Mine = new Wallet(owner, remain);
        System.out.println("擁有人 "+ Mine.owner +" 還剩下 "+ Mine.remain+ " 元");
        Mine.Make(2000); // 賺
        System.out.println("擁有人 "+ Mine.owner +" 還剩下 "+ Mine.remain+ " 元");
        Mine.Pay(234); // 花費
        System.out.println("擁有人 "+ Mine.owner +" 還剩下 "+ Mine.remain+ " 元");
        System.out.println("剩"+Mine.Check()+" 元");
    }
}
class Wallet {
    String owner; // 擁有者
    int remain; // 錢包餘額
    // 建構子
    public Wallet(String owner, int remain) {
        this.owner = owner;
        this.remain = remain;
    }
    // 花錢
    public void Pay(int money) {
        // 如果錢夠付
        if (this.remain > money) {
            this.remain -= money;
            System.out.println("買起來～我花了"+ money+" 元");
        // 錢不夠
        } else {
            System.out.println("錢不夠!!");
        }
    }
    // 賺錢
    public void Make(int money) {
        this.remain += money;
        System.out.println("我賺了 "+money+" 元呦:)");
    }
    // 檢查錢包餘額
    public int Check() {
        return this.remain;
    }
}
// 最後完成日期:2021年03月19日