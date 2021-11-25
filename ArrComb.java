public class ArrComb {
    public static void print(int[] data) {
        for(int i=0; i<data.length; i++) {
            System.out.print(data[i]);
        }
        System.out.println();
    }
    // pos 是 data 取出的位置
    // got 是 result 放入的位置
    public static void comb(int[] data, int n, int pos, int got, int[] result) {
        // 終止條件，選完了 n 個，因此終結條件就是 n == 0
        if(n == 0) {
            print(result);
            return;
        }
        // i 為 array 的索引值
        for(int i = pos; i < data.length; i++) {
            result[got] = data[i]; // 把 result 裡的值，用 data 裡拿出來的值取代
            comb(data, n-1, i+1, got+1, result);
        }
    }
    public static void comb(int[] data, int n) {
        comb(data, n, 0, 0, new int[n]);
    }
    public static void main(String[] argv) {
        int[] data = new int[]{1, 2, 3, 4, 5};
        comb(data, 2);
    }
}