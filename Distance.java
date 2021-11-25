// 學號：108213052
// 姓名：楊心慈
// 二維陣列，不
import java.util.Scanner;
public class Distance {
    private static int max;
    public static int findSol(int[][] data){
        max = 0;
        findSol(data, 0, 0, 0);
        return max;
    }
    private static void mark(int[][] data, int r, int c, int v){
        int[] roff = new int[]{1, -1, 0, 0, 2, -2, 0, 0, 1, -1, 1, -1};
        int[] coff = new int[]{0, 0, 1, -1, 0, 0, 2, -2, 1, -1, -1, 1};
        for (int i = 0; i < roff.length; i++){
            if (r+roff[i] >=0 &&
                r+roff[i] < data.length &&
                c+coff[i] >=0 &&
                c+coff[i] < data[r+roff[i]].length){
                data[r+roff[i]][c+coff[i]] += v;
            }
        }
    }
    // data : 座位狀況
    // seat : 已經排了幾個人
    private static void findSol(int[][] data, int nowr, int nowc, int seat){
        if (nowr >= data.length){
            if (max < seat)
                max = seat;
            return;
        }
        // 找出所有可以坐的位置
        for (int r = nowr; r < data.length; r++) {
            int c = 0;
            if(r == nowr) {
                c = nowc;
            }
            for (; c < data[r].length; c++){
                if (data[r][c] == 0) { // 可以坐
                    // 坐上去
                    data[r][c] = 1;
                    // 標記離我距離在2以內的位置
                    mark(data, r, c, 1);
                    // 交給下一位排座位表
                    if (c == data[r].length-1){
                        findSol(data, r+1, 0, seat+1);
                    } else {
                        findSol(data, r, c+1, seat+1);
                    }
                    // 還原距離在2以內的位置
                    mark(data, r, c, -1);
                    // 歸還座位
                    data[r][c] = 0;
                }
            }
        }
    }
    public static void main(String[] argv){
        Scanner input = new Scanner(System.in);
        int r = input.nextInt();
        int[][] data = new int[r][];
        for (int i = 0; i < r; i++)
            data[i] = new int[input.nextInt()];
        System.out.println(findSol(data));
    }
}
// 最後完成日期 : 2020年06月09日 10:30

// int[][] x;
// x = new int[5][];
// x[0] = new int[3];
// x[1] = new int[2];
// x[2] = new int[15];

// input :
// 5 
// 3 3 3 3 3
// output :
// 4

// input :
// 7
// 1 5 3 8 12 7 13
// output :
// 14