// 學號:108213052
// 姓名:楊心慈

// 輸入:
// a b c 分別是 ? ? 16
// 三個由0~9及？所組成的字串, 表示可以任填1到9
// 讓那些數字 a * b = c
import java.util.Scanner;
public class Match {
    public static void findSol(String a, String b, String c) {
        // 寫法1
        // StringBuffer 有彈性的
        findSol(new StringBuffer(a+b+c), a.length(), b.length(), 0);
        // 寫法2
        findSol(new String(a+b+c), a.length(), b.length(), 0);
    }
    // s : a + b + c
    // lena:字串a的長度
    // lenb:字串b的長度
    // pos:目前要處理字串a所在的字元位置
    private static void findSol(StringBuffer s, int lena, int lenb, int pos) {
        if (pos == s.length()) { // 都處理完了
            //System.out.println(s);
            // 驗證 a * b == c s是否成立，成立就印出
            // Integer.valueOf : 轉整數
            // substring : 切割
            if (Integer.valueOf(s.substring(0, lena)) *
                Integer.valueOf(s.substring(lena, lena + lenb)) ==
                Integer.valueOf(s.substring(lena+lenb, s.length()))){
                System.out.println(s.substring(0, lena) + "*" + s.substring(lena, lena + lenb) + "=" + s.substring(lena+lenb, s.length()));
            }
            return;
        }
        // 相異處
        if (s.charAt(pos) == '?') {
            for (int i = 0; i < 10; i++) {
                // setCharAt : 要改s的第i個位置要改什麼值
                s.setCharAt(pos, (char)('0' + i));
                findSol(s, lena, lenb, pos+1);
            }
            s.setCharAt(pos, '?');
        } else {
            findSol(s, lena, lenb, pos+1);
        }
    }
    private static void findSol(String s, int lena, int lenb, int pos) {
        if (pos == s.length()) { // 都處理完了
            //System.out.println(s);
            // 驗證 a * b == c s是否成立，成立就印出
            if (Integer.valueOf(s.substring(0, lena)) *
                Integer.valueOf(s.substring(lena, lena + lenb)) ==
                Integer.valueOf(s.substring(lena+lenb, s.length()))){
                System.out.println(s.substring(0, lena) + "*" + s.substring(lena, lena + lenb) + "=" + s.substring(lena+lenb, s.length()));
            }
            return;
        }
        // 相異處
        if (s.charAt(pos) == '?') {
            for (int i = 0; i < 10; i++) {
                findSol(s.substring(0, pos)+(char)('0' + i)+s.substring(pos+1,s.length()), lena, lenb, pos+1);
            }
        } else {
            findSol(s, lena, lenb, pos+1);
        }
    }
    public static void main(String[] argv) {
        Scanner input = new Scanner(System.in);
        String a, b, c;
        a = input.next();
        b = input.next();
        c = input.next();
        findSol(a, b, c);
    }
}

// 最後完成日期:2021年03月29日