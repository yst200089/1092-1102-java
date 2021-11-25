// 學號 : 108213052
// 姓名 : 楊心慈
// 組合\物件問題-TA 的名字、監考時間、性別
import java.util.Scanner;
class TA {
    // 宣告 TA 的名字、監考時間、性別
    String name;
    int time;
    String gender;
    public TA(String name, int time, String gender){
        this.name = name;
        this.time = time;
        this.gender = gender;
    }
}
public class Main {
    // 移除已經選過的時間
    public static int[] slice(int[] data, int start, int end) {
        int[] result = new int[end-start];
        int at = 0;
        for(int i=start; i<end; i++) {
            result[at] = data[i];
            at += 1;
        }
        return result;
    }
    // 找到各種組合
    public static int poem(int[] data, int t){
        int sol = 0;
        if(t <= 0){
            return 1;
        }
        for(int i=0; i<data.length; i++){
            sol += poem(slice(data, i+1, data.length), t-data[i]);
        }
        return sol;
    }
    public static void findSol(TA[] ta, int t, String who, int[] data){
        String B = "B";
        boolean check = true;
        // 先判斷助教性別是否符合學生要求
        for(int i=0; i<ta.length; i++){
            if(who.equals(ta[i].gender)){
                for(int j=0; j<data.length;j++){
                    data[j] = ta[i].time;
                }
            }
            if(who.equals(B)){
                for(int j=0; j<data.length;j++){
                    data[j] = ta[i].time;
                }
            } else if(!(ta[i].gender.equals(who))){
                check = false;
            }
        }
        // 還原
        if(!check){
            check = true;
        }
        // 如果是就開始排列
        if(check){
            System.out.println(poem(data, t)*2+" 種");
        // 如果無法符合
        } else {
            System.out.println("0 種");
            check = true;
        }
    }
    public static void main(String[] argv){
        Scanner input = new Scanner(System.in);
        // 有 n 位 TA
        int n = input.nextInt();
        TA[] ta = new TA[n];
        // 分別輸入 TA 的姓名、監考時間、性別
        for(int i=0; i<n; i++){
            ta[i] = new TA(input.next(), input.nextInt(), input.next());
        }
        // 輸入時間
        int t = input.nextInt();
        // 輸入想要選擇的ta性別
        String who = input.next();
        findSol(ta, t, who, new int[n]);
    }
}
// 最後完成日期 : 2020年6月日