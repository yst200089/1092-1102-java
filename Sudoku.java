// 學號：108213052
// 姓名：楊心慈
import java.util.Scanner;
// 0  1  2  3  4  5  6  7  8
// 9 10 11 12 13 14 15 16 17
// 數獨有81個格子要填入1~9
// 橫列、直行、區塊內的數字不得重複
// 假設我們0~80表示由上而下，由左至右的格子編號
// 0  1  2  3  4  5  6  7  8
// 9 10 11 12 13 14 15 16 17
// 請問編號x在......
// 哪條橫列？ x // 9
// 哪條直行？ x % 9
// 哪個區塊？ (x // 9)//3*3 + (x % 9)//3 = x//27*3+x%9//3
// 區塊編號
// 0 1 2
// 3 4 5
// 6 7 8
// 輸入：
// 一行有81個0~9的整數，代表九宮格的81個數字，數字0表示空白沒指定，1~9表示只能填該數字
// 輸出數獨的答案，9列每列9行

// broad : 81個數字，非0代表以確定只能填該數字
// rowNum : 某橫列還有哪些數字是可能的
// colNum : 某直行還有哪些數字是可能的
// blockNum : 某區塊還有哪些數字是可能的
public class Sudoku {
    // broad : 81個格子內的數字
    // x : 要負責填幾個格子
    // rowNum : 某橫列還有哪些數字是可能的
    // colNum : 某直行還有哪些數字是可能的
    // blockNum : 某區塊還有哪些數字是可能的
    public static void fill(int[] board, int x, boolean[][] rowNum, boolean[][] colNum, boolean[][] blockNum) {
        if(x == 81) { // 當全部格子都填完時，輸出
            for(int i=0; i<81; i++) {
                System.out.print(board[i]+" "); // 依序輸出
                if(i % 9 == 8) {  // 一行填滿 9 個數字就換行
                    System.out.println();
                }
            }
            return;
        }
        if(board[x] != 0) { // 已經確定的格子
            fill(board, x+1, rowNum, colNum, blockNum); // 往下填
            return;
        }
        for(int j=1; j<=9; j++) {
            // 當數字還沒填過時，將該行、列、區塊改為 true
            if(!(rowNum[x/9][j-1] || colNum[x%9][j-1] || blockNum[x/27*3+x%9/3][j-1])) {
                rowNum[x/9][j-1] = true;
                colNum[x%9][j-1] = true;
                blockNum[x/27*3+x%9/3][j-1] =true;
                board[x] = j; // 模板填該數字
                fill(board, x+1, rowNum, colNum, blockNum);
                // 將該模板恢復成原狀
                rowNum[x/9][j-1] = false;
                colNum[x%9][j-1] = false;
                blockNum[x/27*3+x%9/3][j-1] = false;
                board[x] = 0;
            }
        }
    }
    public static void markKnown(int[] board, boolean[][] rowNum, boolean[][] colNum, boolean[][] blockNum) {
        // 確認一經填好的數
        for(int x=0; x<81; x++) {
            if(board[x] != 0) { // 將已經確認(已被佔走)格子的行、列、區塊改為true
                rowNum[x/9][board[x]-1] = true;
                colNum[x%9][board[x]-1] = true;
                blockNum[x/27*3+x%9/3][board[x]-1] = true;
            }
        }
    }
    public static void findSol(int[] board) {
        // 建立行、列、區塊的陣列
        boolean[][] rowNum = new boolean[9][9]; // [每一行][可填的數字(已被占走的數字)]
        boolean[][] colNum = new boolean[9][9];
        boolean[][] blockNum = new boolean[9][9];
        // 先用已經確定的數字整理每個列行塊的數字
        markKnown(board, rowNum, colNum, blockNum);
        // 將未知的空格填滿
        fill(board, 0, rowNum, colNum, blockNum);
    }
    public static void main(String[] argv) {
        Scanner input = new Scanner(System.in);
        int[] data = new int[81];
        // 輸入數獨的題目
        for(int i=0; i<81; i++) {
            data[i] = input.nextInt();
        }
        findSol(data);
    }
}
// 最後完成日期 : 2020年05月01日 16:08