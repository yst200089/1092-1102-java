// 學號：108213052
// 姓名：楊心慈
import java.util.Scanner;
public class hu {
    // data: 每種萬子的張數
    // n: 一共有幾張牌
    // hasMJ: 之前已經挑過麻將了
    private static boolean canHu(int[] data, int n, boolean hasMJ) {
        if (n == 0) { // 全部的牌都被選完後
            return true;
        }
        boolean hu = false;
        for (int i = 0; i < data.length; i++) { // 每種組合都試看看
            // 湊麻將
            if (hasMJ == false && data[i] >= 2) { // 可以湊麻將
                data[i] -= 2; // 湊麻將後拿走
                if (canHu(data, n-2, true)) {
                    hu = true;
                }
                // 還原
                data[i] += 2;
            }
            // 湊"刻"
            if (data[i] >= 3) { // 可以湊刻
                data[i] -= 3; // 湊刻後拿走
                if(canHu(data, n-3, hasMJ)) {
                    hu = true;
                }
                // 還原
                data[i] += 3;
            }
            // 湊"順"
            if (i < 25  && i<9*(i/9)+7) { // 先分出萬、筒、條
                if(data[i] >= 1 && data[i+1] >= 1 && data[i+2] >= 1){ // 找出連號
                data[i] -= 1; // 湊順後拿走
                data[i+1] -= 1; // 湊順後拿走
                data[i+2] -= 1; // 湊順後拿走
                if(canHu(data, n-3, hasMJ)) {
                    hu = true;
                }
                // 還原
                data[i] += 1;
                data[i+1] += 1;
                data[i+2] += 1;
                }
            }
        }
        return hu;
    }
    // 計算牌數
    public static boolean canHu(int[] data) {
        int n = 0;
        for (int i = 0; i < data.length; i++) {
            n += data[i]; // 計算張數
        }
        return canHu(data, n, false);
    }
    // 加牌
    public static void Add(int[] data) {
        // 每個數字所代表的牌
        String[] mj = new String[]{"一萬","二萬","三萬","四萬","五萬","六萬","七萬","八萬","九萬","一筒","二筒","三筒","四筒","五筒","六筒","七筒","八筒","九筒","一條","二條","三條","四條","五條","六條","七條","八條","九條","東風","南風","西風","北風","紅中","青發","白板"};
        for (int j = 0; j <data.length; j++) { // 每種牌都加進去
            // 已滿四張就不能加
            if(data[j] < 4){
                data[j] += 1; // 該張牌加一
                if (canHu(data)){ // 如果可以胡牌
                    System.out.println(mj[j]); // 輸出
                }
                data[j] -= 1; // 還原
            }
        }
    }
    public static void main(String[] argv) {
        Scanner input = new Scanner(System.in);
        int[] data = new int[34];
        // 輸入每張牌的張數
        for (int i = 0; i < 34; i++) {
            data[i] = input.nextInt();
        }
        // 加牌進去
        Add(data);
    }
}

// 最後完成日期 : 2021年04月12日