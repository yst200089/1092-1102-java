// 未完成
import java.util.Scanner;
public class softball {
    public static boolean check(boolean[] ball){ // 確認是否每個位置都有選過了
        boolean ck = true;
        for(int i=0; i< ball.length; i++){
            if (ball[i] == false) {
                ck = false;
            }
        }
        return ck;
    }
    public static int findSol(String[] data, boolean[] ball, boolean[] people, int pos) {
        if(pos == m-1) {
            if (check(ball)) {
                return 1;
            }
        }
        int ans = 0; // 找到一解
        for (int i=0; i<n; i++) {
            if (pos<data[i].length && data[i].substring(pos, pos+1).equals("1")) {
                if(people[i] == false && ball[pos] == false){ // 如果還沒選
                    //int p = pos;
                    ball[pos] = true;
                    people[i] = true; // 已選
                    ans += findSol(data, n, m, ball, people, pos+1);
                    ball[pos]=false;
                    people[i] = false;
                }
            }
        }
        return ans;
    }
    public static int findSol(String[] data, int n, int m) {
        return findSol(data, new boolean[data[0].length], new boolean[data.length], 0);
    }
    public static void main(String[] argv) {
        Scanner input = new Scanner(System.in);
        int n = input.nextInt(); // 輸入總共有幾人
        int m = input.nextInt(); // 輸入有幾個位置
        String[] data = new String[n]; // 輸入每個人可否能擔任的位置
        for (int i=0; i<n; i++) {
            data[i] = input.next();
        }
        System.out.println(findSol(data, n, m));
    }
}