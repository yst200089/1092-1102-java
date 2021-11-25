// 兩個矩陣相加
import java.util.Scanner;
public class TestT {
    public static void main(String[] argv) {
        Scanner input = new Scanner(System.in);
        int r, c;
        r = input.nextInt();
        c = input.nextInt();
        float[][] data = new float[r][c]; // 宣告一個二維陣列
        Matrix a, b;
        for(int i=0; i<r; i++) {
            for(int j=0; j<c; j++) {
                data[i][j] = input.nextFloat();
            }
        }
        a = new Matrix(data);
        for(int i=0; i<r; i++) {
            for(int j=0; j<c; j++) {
                data[i][j] = input.nextFloat();
            }
        }
        b = new Matrix(data);
        a.add(b).print();
    }
}
class Matrix {
    private int r, c;
    private float[][] data;
    // define a "constructor" for creating Matrix object
    public Matrix(float[][] d) {
        // copy d to data d = [[123],[456]]
        r = d.length;
        c = d[0].length;
        this.data = new float[d.length][d[0].length];
        for(int i=0; i<r; i++) {
            for(int j=0; j<c; j++) {
                data[i][j] = d[i][j];
            }
        }
    }
    // function name can be defined more than once,
    // as long as they can be distinguished by parameter number and
    // this concepts is celled "overloading"
    public Matrix(int row, int col) {
        data = new float[row][col];
        r = row;
        c = col;
    }
    public Matrix add(Matrix b) {
        Matrix d = new Matrix(r, c);
        for(int i=0; i<r; i++) {
            for(int j=0; j<c; j++) {
                d.data[i][j] = this.data[i][j] + b.data[i][j];
            }
        }
        return d;
    }
    public void print() {
        System.out.println(r + " " + c);
        for(int i=0; i<r; i++) {
            for(int j=0; j<c; j++) {
                if(j != 0) {
                    System.out.print(' ');
                }
                System.out.print(data[i][j]);
            }
            System.out.println();
        }
    }
}
// input of first line : row and column number, r and c
        // then r lines represents Matrix a
        // each line has c floats
        // then another r lines represents Matrix b
        // print out the result of Matrix a + Matrix b
        // input:
        // 2  3
        // 1  2  3
        // 4  5  6
        // 4  2  1
        // 0  5  7
        // output:
        // 5  4  4
        // 4  10 13
        // 矩陣相加條件：同維度
        // if A and B has r row, c column
        // C = A + B
        // then C[i][j] = A[i][j] + B[i][j] for i in range(r) for j in range(c)