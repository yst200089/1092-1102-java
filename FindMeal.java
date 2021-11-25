// 學號 : 108213052
// 姓名 : 楊心慈
// 遞迴/物件問題-餐廳預算
import java.util.Scanner;
class Restaurant {
    // 宣告餐廳的名字、最小預算、最大預算
    String name;
    int min;
    int max;
    public Restaurant(String name, int min, int max){
        this.name = name;
        this.min = min;
        this.max = max;
    }
}
public class FindMeal {
    static boolean check1 = false; // 用來檢查有沒超過全部餐廳最高值
    static boolean check2 = false; // 用來檢查有沒到達全部餐廳最低值
    static boolean check3 = false; // 如果是剩餘情況
    // 如果只有一家餐廳符合預算，寫入 name
    static String name;
    public static void findSol(Restaurant[] restaurant, int[] money){
        for(int i=0; i<money.length; i++){
            int chance = 0; // 有幾家餐廳符合條件
            int high = 0; // 超出幾家餐廳最高值
            int low = 0; // 未到幾家餐廳最低值
            for(int j=0; j<restaurant.length; j++){
                // 如果錢都剛好在餐廳預算之內
                if(money[i] <= restaurant[j].max && money[i] >= restaurant[j].min){
                    name = restaurant[j].name; // 將該餐廳名字寫入
                    chance += 1; // 符合預算的餐廳數加一
                // 如果錢超過餐廳預算之最高
                } else if(money[i] > restaurant[j].max) {
                    high += 1;
                    if(high == restaurant.length){ // 如果錢都超過所有餐廳的最高預算
                        check1 = true;
                    }
                // 如果錢未達餐廳預算之最低
                } else if(money[i] < restaurant[j].min){
                    low += 1;
                    if(low == restaurant.length){ // 如果錢都未達所有餐廳的最低預算
                        check2 = true;
                    }
                // 剩餘情況
                } else{
                    check3 = true;
                }
            }
            if (!check1){ // 如果錢只是部分超過所有餐廳的最高預算
                // 還原
                high = 0;
                check1 = false;
            }
            if (!check2){ // 如果錢只是部分未達所有餐廳的最低預算
                // 還原
                low = 0;
                check2 = false;
            }
            if(chance == 1){ // 當符合餐廳數為一
                System.out.println(name);
            } else if(chance > 1){ // 當符合餐廳數多餘一
                System.out.println("有選擇困難");
            } else if (check1){ // 如果錢都超過所有餐廳的最高預算
                System.out.println("預算出太多了");
                check1 = false;
            } else if (check2){ // 如果錢都未達所有餐廳的最低預算
                System.out.println("預算出太少了");
                check2 = false;
            } else { // 剩餘情況
                System.out.println("買不了");
                check3 = false;
            }
        }
    }
    public static void main(String[] argv){
        Scanner input = new Scanner(System.in);
        // 輸入 n 家餐廳
        int n = input.nextInt();
        Restaurant[] restaurant = new Restaurant[n];
        // 分別輸入 n 家餐廳的名字、最小預算、最大預算
        for(int i=0; i<n; i++){
            restaurant[i] = new Restaurant(input.next(), input.nextInt(), input.nextInt());
        }
        // 輸入 m 個預算
        int m = input.nextInt();
        int[] money = new int[m];
        // 分別輸入 m 個預算的值
        for(int i=0; i<m; i++){
            money[i] = input.nextInt();
        }
        // 執行
        findSol(restaurant, money);
    }
}
