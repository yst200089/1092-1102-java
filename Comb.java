// 學號:108213052
// 姓名:楊心慈
public class Comb {
    public static int[] append(int[] data, int v) {
        int[] result = new int[data.length+1];
        for (int i = 0; i< data.length; i++) {
            result[i] = data[i];
        }
        result[data.length] = v;
        return result;
    }
    // 選完後不再放入
    public static int[] slice(int[] data, int start, int end) {
        int[] result = new int[end - start];
        for (int i = start, at = 0; i < end; i++, at++) {
            result[at] = data[i];
        }
        return result;
    }
    public static void print(int[] data) {
        for (int i = 0; i < data.length; i++) {
            System.out.print(data[i]+" ");
        }
        System.out.println();
    }
    // data取n組合(不重複)
    // {1,2,3,4,5} 取 2 -> {1, 2}, {1, 3}, {1, 4}
    public static void comb(int[] data, int n, int[] result){
        if (n == 0) {
            print(result);
            return;
        }
        // 自己先選一個，有多少種選擇方式？
        // 選第i個
        for (int i = 0; i < data.length; i++) {
            comb(slice(data, i+1, data.length), n-1, append(result, data[i]));
        }
    }
    public static void comb(int[] data, int n){
        comb(data, n, new int[0]);
    }
    public static void main(String[] args) {
        int[] data = {1,2,3,4,5};
        comb(data, 3);
    }
}
// 最後完成日期:2021年03月22日