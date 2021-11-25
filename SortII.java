import java.util.Scanner;
public class SortII {
    public static void SortMax(int[] data){
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
        System.out.print("Max:");
        for(int i=0; i<data.length; i++){
            max = max * 10;
            max = max + data[i];
        }
        System.out.println(max);
    }
    public static void SortMin(int[] data){
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
        System.out.print("Min:");
        for(int i=0; i<data.length; i++){
            min = min * 10;
            min = min + data[i];
        }
        System.out.println(min);
    }
    public static int findLong(int num){
        int count = 0;
        while(num > 0){
            count += 1;
            num = num / 10;
        }
        return count;
    }
    public static void findNum(int num, int count){
        int[] data = new int[count];
        for(int i=0; i<count; i++){
            data[i] = num % 10;
            num = num / 10;
        }
        SortMin(data);
        SortMax(data);
    }
    public static void main(String[] argv){
        Scanner input = new Scanner(System.in);
        int num = input.nextInt();
        findNum(num, findLong(num));
    }
}