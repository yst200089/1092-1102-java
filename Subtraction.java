// 學號 : 108213052
// 姓名 : 楊心慈
import java.util.Scanner;
public class Subtraction {
    static int count = 0;
    static int[] num = new int[50];
    public static void findSol(int max, int min){
        int ans = max - min;
        System.out.println(max+" - "+min+" = "+ans);
        boolean check = false;
        for(int i=0; i<count; i++){
            if(num[i] == ans){
                check = true;
            }
        }
        num[count] = ans;
        count += 1;
        if(check){
            System.out.println("執行次數 : "+count);
            for(int i=0; i<num.length; i++){
                num[i] = 0;
            }
            count = 0;
        } else {
            findNum(ans, findLong(ans));
        }
    }
    // 找出最大最小值
    public static void Sort(int[] data){
        for(int j=data.length; j>1; j--){
            // bubble by swap
            for(int i=0; i<j-1; i++){
                if(data[i] > data[i+1]){
                    int tmp = data[i];
                    data[i] = data[i+1];
                    data[i+1] = tmp;
                }
            }
        }
        int min = 0;
        for(int i=0; i<data.length; i++){
            min = min * 10;
            min = min + data[i];
        }
        for(int j=data.length; j>1; j--){
            // bubble by swap
            for(int i=0; i<j-1; i++){
                if(data[i] < data[i+1]){
                    int tmp = data[i];
                    data[i] = data[i+1];
                    data[i+1] = tmp;
                }
            }
        }
        int max = 0;
        for(int i=0; i<data.length; i++){
            max = max * 10;
            max = max + data[i];
        }
        findSol(max, min);
    }
    // 將整數分割成個個數字
    public static void findNum(int num, int L){
        int[] data = new int[L];
        for(int i=0; i<L; i++){
            data[i] = num % 10;
            num = num / 10;
        }
        Sort(data);
    }
    // 判斷整數的長度
    public static int findLong(int num){
        int L = 0;
        while(num > 0){
            L += 1;
            num = num / 10;
        }
        return L;
    }
    public static void main(String[] argv){
        Scanner input = new Scanner(System.in);
        int n = input.nextInt(); // 輸入有幾個數字
        int[] data = new int[n];
        for(int i=0; i<n; i++){ // 輸入 n 個整數
            data[i] = input.nextInt();
        }
        // 執行
        for(int i=0; i<n; i++){
            System.out.println();
            System.out.println("原始數字 : "+data[i]);
            findNum(data[i], findLong(data[i]));
        }
    }
}
// 最後完成日期 : 2020年06月17日 09:15