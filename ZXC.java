import java.util.Scanner;
public class ZXC {
    public static void main(String[] argv) {
        Scanner input = new Scanner(System.in);
        int[] data = new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9};
        for(int i=0; i<9; i++) {
            if(i % 3 != 0) {
                System.out.print(" "+data[i]);
            }
            if(i % 3 == 0) {
                if(i != 0) {
                    System.out.println();
                }
                System.out.print(data[i]); 
            }
        }
        System.out.println();
    }
}