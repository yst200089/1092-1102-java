import java.util.Scanner;
public class numMap {
    // n : 地圖由 n*n 組成
    // data : 紀錄地圖所有數字
    // ans : 地圖共有 ans 幾個區塊
    public static void findSol(int n , String[][] data , int ans) {
        for(int i = 0; i < n ; i++) {
            for(int j = 0 ; j < n ; j++) { //跑全部地圖
                if(!data[i][j].equals("X")) { //如果該點不是 X ，代表沒走過
                    myFindSol(n, data, data[i][j], i, j); // 開找
                    data[i][j] = "X"; // 找過了就設成 X
                    ans = ans + 1; // 答案加一
                }
            }
        }
        System.out.print(ans);
    }
    // num : 未找過的數字
    // x : num 所在的 row
    // y : num 所在的 col
    //          0(-1, 0)
    // (0, -1)0     n    0(0, 1)
    //          0(1, 0)
    public static void myFindSol(int n , String[][] data , String num , int x, int y){
        int[] xList = {1, -1, 0, 0};
        int[] yList = {0, 0, 1, -1};
        for(int i = 0 ; i < 4 ; i++) { // 總共有上下左右四個座標
            int x2 = x + xList[i]; // 一樣參考點燈遊戲，確認要去的地方的座標
            int y2 = y + yList[i];
            if(y2 > -1 && y2 < n && x2 > -1 && x2 < n) { // 檢查有沒有超出範圍
                if(data[x2][y2].equals(num)) { // 如果沒超出，檢查是不是與num一樣的數字
                    data[x2][y2] = "X"; // 是就設成 X
                    myFindSol(n, data, num, x2, y2); // 繼續找這個的上下左右
                }
            }
        }
    }
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int n = input.nextInt(); // n : 接下來有n行輸入
        String[][] data = new String[n][]; // 紀錄所有輸入
        for(int i = 0 ; i < n ; i++){ // [[1,1,2,4,4],[...],[...],...]
            data[i] = input.next().split(""); // 將該行字串切割並存入data
        }
        findSol(n, data, 0);
    }
}
// 給定一個由n*n個正整數(0-9)組成的矩陣，尋找這矩陣中總共有幾個區塊。
// 區塊的定義:
// 為同樣的數字相連的地區。
// 數字"相連"指的是同樣的數字有上、下、左、右四個方向鄰近的關係。
// input:
// 5
// 11244 data[0]
// 12224 data[1]
// 33355
// 32225
// 11111

// output:
// 7