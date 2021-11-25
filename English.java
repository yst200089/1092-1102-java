// 學號：108213052
// 姓名：楊心慈
import java.util.Scanner;
public class English {
    static String[][] data; // 原始資料
    static int found; // 已找到幾個
    static String[] matchedWord; // 找到的單字
    static String[] dict; // 要找的單字
    static int row, col, words;
    public static void printResult(){
        System.out.println("以下是包含在字母堆中的單字");
        for(int i=0; i<found; i++){
            System.out.println(matchedWord[i]);
        }
    }
    public static void tryMatch(StringBuffer sb){
        for(int i=0; i<words; i++){ // check each word in dict
            if(sb.indexOf(dict[i]) != -1 || sb.reverse().indexOf(dict[i]) != -1){ // indexOf
                // isert to matchedWord
                int pos = found - 1; // pos 插入位置
                while(pos >= 0 && matchedWord[pos].compareTo(dict[i]) > 0){ // 若比較大
                    matchedWord[pos+1] = matchedWord[pos]; // 往後移
                    pos--;
                }
                matchedWord[pos+1] = dict[i]; // 若沒得比較，直接放在最右
                found++; //已找到
                // remove this from dictionary 為了避免重複，將最後的單字覆蓋在已找到的單字上
                dict[i] = dict[--words];
            }
        }
    }
    // x : col
    // y : row
    // xoff : 往右找 col
    // yoff : 往下找 row
    public static void genLine(int x, int y, int xoff, int yoff){
        // 在使用 StringBuffer 類時，每次都會對 StringBuffer 對象本身進行操作，
        // 而不是生成新的對象，所以如果需要對字符串進行修改推薦使用 StringBuffer
        StringBuffer sb = new StringBuffer();
        while(x < col && x >= 0 && y < row && y >= 0) {
            sb.append(data[y][x]);
            x += xoff; // 往右找 col
            y += yoff; // 往下找 row
        }
        tryMatch(sb);
    }
    public static void findSol(){
        // 橫線-找出每個 row 的字串，row 由 x=0 開始
        for(int line=0; line<row; line++){
            genLine(0, line, 1, 0);
        }
        // 直線-找出每個 col 的字串，col 由 y=0 開始
        for(int line=0; line<row; line++){
            genLine(line, 0, 0, 1);
        }
        // 找出每個右上斜的字串，x+1 , y-1, 由 x=0 , 或 y=row-1 開始
        for(int line=0; line<row; line++){ // 從第一排開始，找右上斜線的左半邊
            genLine(0, line, 1, -1);
        }
        for(int line=1; line<col; line++){ // 從最後一排開始，找右上斜線的右半邊
            genLine(line, row-1, 1, -1);
        }
        // 找出每個右下斜的字串，x+1 , y+1, 由 x=0 , 或 y=0 開始
        for(int line=0; line<col; line++){ // 從第一列開始，找右上斜線的右半邊
            genLine(line, 0, 1, 1);
        }
        for(int line=1; line<row; line++){  // 從第一列開始，找右上斜線的左半邊
            genLine(0, line, 1, 1);
        }
        printResult();
    }
    public static void main(String[] argv){
        Scanner input = new Scanner(System.in);
        row = input.nextInt(); // 輸入有幾行
        col = input.nextInt(); // 輸入有幾列
        words = input.nextInt(); // 輸入有幾個要確認的單字
        data = new String[row][col];
        // 輸入原始資料
        for(int i=0; i<row; i++){
            for(int j=0; j<col; j++){
                data[i][j] = input.next();
            }
        }
        // 輸入需確認的單字
        dict = new String[words];
        matchedWord = new String[words];
        for(int i=0; i<words; i++){
            dict[i] = input.next();
        }
        findSol();
    }
}
// 最後完成日期 : 2020年05月26日 11:00

// input:
// 14 14 10
// e e y p s t r a w b e r r y
// l r t w a t e r m e l o n y
// b e y l k w p s e l p p a y
// l l k b i e b a t o a a a r
// a e r a w w w a g l l b l r
// c o p l i l e m o n n y a e
// k s i b w o g m r s r o a b
// b m a e e e s r r b r w y p
// e r b n e r e p a a w a a s
// r p a r a r m l n p b a p a
// r n e e r u b g k p e a a r
// y y r r e b e u l b e p p w
// y b y a n a n a b y e b a r
// l l a a r a p p e b e l w a
// elephant
// penglai
// apple
// frog
// banana
// orange
// maplestory
// koishi
// grape
// papaya

// output:
// 以下是包含在字母堆中的單字
// apple
// banana
// grape
// orange
// papaya