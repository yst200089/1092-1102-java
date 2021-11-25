import java.util.Scanner;
public class Sort {
    // sort data to ascending order, how?
    // insertion sort
    // bubble sort, 氣泡排序法
    public static void bubble(int[] data){
        // 4 5 2 3 1
        // 4 2 5 3 1
        // 4 2 3 5 1
        // 4 2 3 1 5
        for(int notLen = data.length; notLen > 1;notLen--){
            // bubble by swap
            for(int i = 0; i < notLen - 1; i++){
                if(data[i] > data[i+1]){
                    int tmp = data[i];
                    data[i] = data[i+1];
                    data[i+1] = tmp;
                }
            }
        }
    }
    // test if in ascending order
    public static boolean sorted(int[] data){
        // compare each pair
        for(int i = 0; i < data.length-1; i++){
            if(data[i] > data[i+1]){
                return false; // not in correct order
            }
        }
        return true;
    }
    public static void sort(int[] data){
        // assume we have n sorted elements
        // then how to 'insert' a new element remains it sorted
        // 1 2 3 4 5 6 7 8, try to insert 4
        // 1 2 3 4 5 6 7 8 4
        // (1) save 4 to a variable
        // 1 2 3 4 5 6 7 8 __
        // 1 2 3 4 5 6 7 __ 8
        // 1 2 3 4 5 6 __ 7 8
        // 1 2 3 4 5 __ 6 7 8
        // 1 2 3 4 __ 5 6 7 8
        // 1 2 3 4 4 5 6 7 8
        // let pos point to the last element
        // While pos >= 0 and data[pos] with x not in order
        //    move data[pos] to data[pos+1]
        // put x in data[pos]
        for(int sortedLen = 1; sortedLen < data.length; sortedLen++){ // 從後面開始找
            int tmp = data[sortedLen]; // 要插入的元素
            int pos = sortedLen - 1; // 由後往前比較位置
            while(pos >= 0 && data[pos] > tmp){ // 當前面的數大於插入的元素時
                data[pos+1] = data[pos]; // 將前面的數往後一格
                pos = pos - 1; // 繼續往前比較
            }
            data[pos+1] = tmp; // 將空格往前移
        }
    }
    public static void main(String[] arge){
        Scanner input = new Scanner(System.in);
        // how many number to test sort
        int n = input.nextInt();
        int[] data = new int[n]; // 生成 data 有 n 個隨機數列
        // generate testing data
        for(int i = 0; i < n; i++){
            // how to generate integer i, snch that a <= i <= b
            // how to generate integer i, snch that i <= 100
            // 0 <= random() < 1 (同乘以 i)
            // 0 <= random() * i < i
            // 0 <= random() * (b-a+1) < b-a+1
            // a <= random() * (b-a+1)+a < b+1
            // a <= (int)(random() * (b-a+1)+a) <= b
            data[i] = ((int)(Math.random()*1000000));
        } 
        sort(data);
        for(int i = 0; i < n; i++){
            System.out.print(data[i]+" ");
        }
        System.out.println(" ");
        if(sorted(data)){
            System.out.println("correct");
        } else {
            System.out.println("error!");
        }
    }
}
