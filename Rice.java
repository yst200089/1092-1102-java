import java.util.Scanner;
class Stuffing {
    String item;
    int price;
    public Stuffing(String item, int price){
        this.item = item;
        this.price = price;
    }
}
public class Rice {
    Stuffing[] stuff;
    int price = 0;
    public static void print(Rice[] rdList){
        for(int i=0; i<rdList.length; i++){
            System.out.print("餡料 : ");
            for(int j=0; j<rdList[i].stuff.length; j++){
                System.out.print(rdList[i].stuff[j].item+" ");
            }
            System.out.println("\n價格 : "+rdList[i].price);
        }
    }
    // 裝餡料的陣列
    Stuffing[] stuffingMenu;
    // m個餡料
    int m;
    // 粽子這個物件
    public Rice(Stuffing[] stuffingMenu, int m){
        Scanner input = new Scanner(System.in);
        // 儲存我現在選的粽子餡料
        this.stuff = new Stuffing[m];
        System.out.println("請選擇 "+ m +" 種餡料(輸入餡料配方)");
        for(int i=0; i<m; i++){
            // 輸入要哪一個餡料的編號
            int stuffIndex = input.nextInt();
            this.stuff[i] = stuffingMenu[stuffIndex];
            this.price += this.stuff[i].price;
        }
    }
    public static void main(String[] argv){
        Scanner input = new Scanner(System.in);
        Stuffing[] stuffingMenu = new Stuffing[5];
        String[] item = {"糯米", "爌肉", "蛋黃", "香菇", "蝦米"};
        int[] price = {5, 5, 2, 3, 1};
        for(int i=0; i<5; i++){
            stuffingMenu[i] = new Stuffing(item[i], price[i]);
        }
        System.out.println("編號\t品項\t價格");
        for(int i=0; i<5; i++){
            System.out.print(i+"\t");
            System.out.print(stuffingMenu[i].item+"\t");
            System.out.println(stuffingMenu[i].price);
        }
        System.out.println("請輸入要包幾個粽子 : ");
        int n = input.nextInt();
        Rice[] rdList = new Rice[n];
        for(int i=0; i<n; i++){
            System.out.println("請輸入要選幾種餡料 : ");
            int m = input.nextInt();
            rdList[i] = new Rice(stuffingMenu, m);
        }
        print(rdList);
    }
}