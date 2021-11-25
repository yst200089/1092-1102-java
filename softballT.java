import java.util.Scanner;
public class softballT {
    public static int findSol(char[][] canPlay) {
        return findSol(canPlay, new boolean[canPlay.length], canPlay[0].length-1);
    }
    // canPlay:某人能守備某位置
    // busy:某人已經上場了嗎？
    // pos:正在排哪個守備位置
    private static int findSol(char[][] canPlay, boolean[] busy, int pos) {
        if (pos < 0) {
            return 1;
        }
        int ans = 0;
        for (int player=0; player<canPlay.length; player++) {
            // player可以守pos這個位置，且player還未上場
            if (canPlay[player][pos] == '1' && !busy[player]) { // char 比對 ==
                busy[player] = true;
                ans += findSol(canPlay, busy, pos-1);
                busy[player] = false;
            }
        }
        return ans;
    }
    public static void main(String[] argv) {
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        int m = input.nextInt();
        char[][] data = new char[n][]; // 字元
        for (int i=0; i<n; i++){
            data[i] = input.next().toCharArray(); // toCharArray() 方法將字符串轉換為字符數組
        }
        System.out.println(findSol(data));
    }
}