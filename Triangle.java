import java.util.Scanner;
public class Triangle {
    public static void main(String[] argv) {
        Scanner input = new Scanner(System.in);
        int h = input.nextInt();
        int line = 0;
        for(int i=0; i<h; i++){
            line++;
            if (line < h) {
                for (int k=0; k<h-line; k++) {
                    System.out.print(" ");
                }
            }
            for (int j=0; j<2*i+1; j++) {
                System.out.print("*");
            }
            System.out.println();
        }
    }
}