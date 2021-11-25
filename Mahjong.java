// 學號：108213052
// 姓名：楊心慈

// 麻將可以胡牌嗎?
// 輸入: 9個整數代表1萬~9萬的"張"數 ex:3 2 1 1 1 1 1 1 3
// 輸出: true(可以胡牌) or false(不能胡牌)
// 可以和牌的條件為，可以"組合"成 3N+2 的形式
// 定義:
// 麻將: 兩張一樣的牌，ex: 1萬1萬
// 刻: 三張一樣的牌，ex: 3萬3萬3萬
// 順: 三張連號的牌，1萬2萬3萬 or 7萬8萬9萬
// 3 2 1 1 1 1 1 1 3 可以胡，因為可排成: 3 2 (1 1 1) (1 1 1) 3
// 4 1 1 1 1 1 1 1 3 也可以胡
// 3張1萬 (1萬2萬3萬) (4萬5萬6萬) (7萬8萬9萬) 9萬9萬

import java.util.Scanner;
public class Mahjong {
    // data: 每種萬子的張數
    // n: 一共有幾張牌
    // hasMJ: 之前已經挑過麻將了
    private static boolean canHu(int[] data, int n, boolean hasMJ) {
        if (n == 0) {
            return true;
        }
        boolean hu = false;
        for (int i = 0; i < data.length; i++) { // 每種組合都試看看
            if  (hasMJ == false && data[i] >= 2) { // 可以拿來湊麻將
                data[i] -= 2;
                if(canHu(data, n-2, true)) {
                    hu = true;
                }
                data[i] += 2;
            }
            // 湊"刻"
            if (data[i] >= 3) { // 可以湊刻
                data[i] -= 3;
                if(canHu(data, n-3, hasMJ)) {
                    hu = true;
                }
                data[i] += 3;
            }
            // 湊"順"
            if (i < 7 && data[i] >= 1 && data[i+1] >= 1 && data[i+2] >= 1) {
                data[i] -= 1;
                data[i+1] -= 1;
                data[i+2] -= 1;
                if(canHu(data, n-3, hasMJ)) {
                    hu = true;
                }
                data[i] += 1;
                data[i+1] += 1;
                data[i+2] += 1;
            }
        }
        return hu;
    }
    // 判斷是否可以胡
    public static boolean canHu(int[] data) {
        int n = 0;
        for (int i = 0; i < data.length; i++) {
            n += data[i]; // 計算張數
        }
        return canHu(data, n, false);
    }
    public static void main(String[] argv) {
        Scanner input = new Scanner(System.in);
        int[] data = new int[9];
        for (int i = 0; i < 9; i++) {
            data[i] = input.nextInt();
        }
        System.out.println(canHu(data));
    }
}

// 最後完成日期 : 2021年04月09日