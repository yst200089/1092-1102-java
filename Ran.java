import java.util.Random;
public class Ran {
    public static void P(int[] data) {
        System.out.print(data[0]);
        for (int i = 1; i < data.length; i++){
            System.out.print(" "+data[i]);
        }
        System.out.println();
    }
    public static int[] Sort(int[] data) {
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
        return data;
    }
    public static boolean Check(int[] data, int num) {
        boolean check =true;
        for (int i = 0; i < data.length; i++){
            if (num == data[i]) {
                check = false;
                //return;
            }
        }
        return check;
    }
    public static void main(String[] argv) {
        Random ran = new Random();
        int[] data = new int[6];
        for (int i=0; i<6; i++) {
            int num = ran.nextInt(38)+1;
            if (Check(data, num)) {
                data[i] = num;
            } else {
                i--;
            }
        }
        P(Sort(data));
    }
}