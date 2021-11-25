import java.util.Scanner;
public class choose{ // 檔名隨便大家取
    public static boolean hasIn(int[] ans , int ans1) {
        for(int i = 0 ; i < ans.length ; i++){
            if(ans[i] == ans1){ // 如果有一樣的數字
                return true;    // 那就說有出現過
            }
        }
        return false; //檢查完全部，確認都沒出現過
    }
    public static int[] append(int[] ans , int ans1) {
        // 為什麼要寫 append ?????
        // 因為你不知道總共有幾組答案， ans 的長度一開始只能預設 0
        // 之後每找到一組答案，就透過 append 來拉長 ans 的長度
        // 並把新的解答塞進來
        int[] tmp = new int[ans.length + 1];
        for(int i = 0 ; i < ans.length ; i++){
            tmp[i] = ans[i];
        }
        tmp[ans.length] = ans1;
        return tmp;
    }
    public static int[] check(int n , int[] tmp , int[] ans) {
        int ans1 = 0; // 拿來計算 tmp 總和的
        for(int i = 0 ; i < tmp.length ; i++){
            ans1 = ans1 + tmp[i];
        }
        // 題目要求，總和是小於等於 n * 2
        if(ans1 <= n*2){
            // 用來判斷 ans1 有沒有出現在 ans 裡面
            // 有出現過會 return true ，所以要用 not true 把它變 false 才不會執行
            // 沒出現過會 return false，就用 not false 把它變 true ，讓它執行
            if(!hasIn(ans,ans1)){ 
                //如果沒出現，就把答案加到 ans 裡面
                ans = append(ans,ans1);
            }
        }

        return ans;
    }
    // n 代表題目有幾個數字
    // m 代表我要選幾個數字
    // chose 代表我已經選了幾個數字
    // data 裝題目的數字
    // pos  要從第幾個數字開始選
    // tmp  用來裝已經選了的數字
    // ans  拿來存放答案的
    public static int[] findSol(int n , int m , int chose, int[] data , int pos , int[] tmp, int[] ans) {
        if(m == chose){ // 終止條件:我已經選了 m 個數字
            ans = check(n,tmp,ans); // check 要來確認是否這個答案是我要的/是否需要更新
            return ans;
        }
        for(int i = pos ; i < n ; i++){ 
            // 從第 pos 個數字開始選，這邊可以參考馬拉松那邊
            tmp[chose] = data[i]; //選數字
            // chose + 1 : 我選了一個數字了
            // i + 1 : 下個 findSol 請從我選的這個數字的下一個數字開始選
            // 為什麼要 ans = findSol(......)
            // 因為叫之後的 findSol 找答案，需要記錄下來，那記錄下來就要回傳回來
            // 否則我不知道後面的 findSol 找了什麼答案
            ans = findSol(n, m , chose + 1, data, i+1 , tmp, ans);
            tmp[chose] = 0; //復原
        }
        // 回報答案
        return ans;
    }
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();//輸入 n
        int m = input.nextInt();//輸入 m
        int[] data = new int[n];
        for(int i = 0 ; i < n ; i++){ // 造一個有 1 ~ n 的 array
            data[i] = i+1;
        }
        // 因為我們最後是要印有幾種解答
        // 那我們就需要一個 array 去記有哪些解答
        // 然後 array 的長度就代表我們找到幾種解答
        // 這邊的 findSol 最後是一個 array
        // 那我們只要把 array 的長度印出來就是要的答案
        System.out.print(findSol(n,m,0,data,0,new int[m],new int[0]).length);
    }
}