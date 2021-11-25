// 學號：108213052
// 姓名：楊心慈 
// Bingo遊戲
import java.util.Scanner;
public class Bingo {
    int[] board;
    // 印版面
    public void printBoard(int[] data) {
        for(int i=0; i<25; i++) {
            boolean check = false; // 檢查數字是否在面板上
            for(int j=0; j<data.length; j++){
                if (data[j] == this.board[i]) // 如果玩家猜的數字在面板上
                    check = true;
            }
            if(check) {
                // 遇到個位數，自動補零成 0X
                String str = String.format("%02d", this.board[i]);
                System.out.print(str + " "); // 印出玩家猜的數字
                if(i % 5 == 4) {
                    System.out.println(); // 換行
                }
            } else {
                System.out.print("** "); // 還沒猜的以 ** 呈現
                if(i % 5 == 4) {
                    System.out.println(); // 換行
                }
            }
        }
    }
    // 檢查遊戲是否結束(檢查 5 條連線)
    public boolean game_over(int[] data){
        int[] row = new int[5]; // 橫線
        int[] col = new int[5]; // 直線
        int upright = 0; // 右上斜線
        int downright = 0; // 右下斜線
        int line = 0; // 連線條數
        for(int i=0; i<25; i++) {
            boolean check = false; // 檢查數字是否在面板上
            for(int j=0; j<data.length; j++) {
                if (data[j] == this.board[i]) // 如果玩家猜的數字在面板上
                    check = true;
            }
            if(check) {
                row[i/5] += 1; // 該數字的橫線 + 1
                col[i%5] += 1; // 該數字的直線 + 1
                if(i/5 == i%5) { // 如果該數字的橫線位置等於直線位置
                    downright += 1; // 此斜線加 1
                }
                if(i/5 + i%5 == 4) { // 如果該數字的橫線位置 + 直線位置 = 4
                    upright += 1 ; // 此斜線加 1
                }
            }
        }
        for(int j=0; j<5; j++) {
            if(row[j] == 5) { // 如果該橫線集滿 5 個
                line += 1; // 連線 + 1
            }
            if(col[j] == 5) { // 如果該直線集滿 5 個
                line += 1; // 連線 + 1
            }
        }
        if(upright == 5) { // 如果右上斜線集滿 5 個
            line += 1; // 連線 + 1
        }
        if(downright == 5) { // 如果右下斜線集滿 5 個
            line += 1; // 連線 + 1
        }
        if(line >= 5) { // 如果連成 5 條線以上(包括)
            return true;
        }
        return false;
    }
    // 玩
    public void play() {
        Scanner input = new Scanner(System.in);
        Count time = new Count(); // 用來計數
        int[] data = new int[25]; // 用來紀錄玩家輸入過的數字
        while(!game_over(data)) { // 若還未連成 5 條線
            int num = input.nextInt(); // 使用者輸入
            boolean check = false; // 檢查是否重複輸入
            if(num < 1 || num > 25) { // 如果輸入小於 1 或大於 25 的數字
                System.out.println("wrong number"); // 印出 wrong number
                continue; // 繼續下輪遊戲
            }
            for(int i=0; i<data.length; i++) {
                if(data[i] == num) { // 如果玩家重複輸入同一數字
                    System.out.println("guessed"); // 印出 guessed
                    check = true;
                }
            }
            if (check) {
                continue; // 繼續下輪遊戲
            }
            data[time.count] = num; // 將玩家當前所輸入的數字加在 data 裡
            time.add(); // 遊戲次數加一
            printBoard(data); // 確認版面
        }
        // 若連成 5 條線以上(包括)
        System.out.println("Bingo! you guessed " + time.count + " times."); // 輸出玩家遊戲次數
    }
    // 建立 Bingo 盤(建構子)
    public Bingo() {
        int[] arr = new int[25];
        for(int i=0; i<25; i++) {
            // 由 1 ~ 25 隨機產生數字
            arr[i] = (int) (Math.random() * 25)+1;
            for(int j=0; j<i; j++) {
                // 如出現重複的數字
                if(arr[j] == arr[i]) {
                    i--;
                    break; // 再重新產生數字
                }
            }
        }
        int[] board = new int[25];
        for(int i=0; i<25; i++) {
            board[i]= arr[i]; // 將產生的隨機數字套入模板
        }
        this.board = board;
    }
    public static void main(String[] argv) {
        Bingo play1 = new Bingo();
        play1.play(); // 遊戲開始
    }
}
// 用來計數遊戲次數
class Count {
    static int count = 0;
    void add() {
        count++;
    }
}
// 最後完成日期 : 2020年05月11日 20:35