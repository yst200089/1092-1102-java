// 學號:108213052
// 姓名:楊心慈
public class Perm {
    public static int[] append(int[] data, int v) {
        int[] result = new int[data.length+1];
        for (int i = 0; i< data.length; i++) {
            result[i] = data[i];
        }
        result[data.length] = v;
        return result;
    }
    // 移除一個，其他複製
    public static int[] remove(int[] data, int pos) {
        int[] result = new int[data.length-1];
        for (int i = 0, j = 0; i < data.length; i++) {
            if (i != pos) {
                result[j++] = data[i];
            }
        }
        return result;
    }
    public static void print(int[] data) {
        for (int i = 0; i < data.length; i++) {
            System.out.print(data[i]+" ");
        }
        System.out.println();
    }
    // data取n排列
    // {1,2,3,4,5} 取 2 -> {1, 2}, {1, 3}, {1, 4}, {4, 1}
    public static void perm(int[] data, int n, int[] result){
        if (n == 0) {
            print(result);
            return;
        }
        // 自己先選一個，有多少種選擇方式？
        // 選第i個
        for (int i = 0; i < data.length; i++) {
            perm(remove(data, i), n-1, append(result, data[i]));
        }
    }
    public static void perm(int[] data, int n){
        perm(data, n, new int[0]);
    }
    public static void main(String[] args) {
        int[] data = {1,2,3,4,5};
        perm(data, 2);
    }
}
// 最後完成日期:2021年03月22日