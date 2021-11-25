// 學號：108213052
// 姓名：楊心慈
import java.util.Scanner;
public class multi {
    public static void main(String[] argv) {
        Scanner input = new Scanner(System.in);
        int m, n1, n2, p;
        m = input.nextInt();
        n1 = input.nextInt();
        n2 = input.nextInt();
        p = input.nextInt();
        float[][] adata = new float[m][n1]; // 宣告一個二維陣列
        float[][] bdata = new float[n2][p];
        Matrix a, b, c;
        for(int i=0; i<m; i++) {
            for(int j=0; j<n1; j++) {
                adata[i][j] = input.nextFloat();
            }
        }
        a = new Matrix(adata);
        for(int i=0; i<n2; i++) {
            for(int j=0; j<p; j++) {
                bdata[i][j] = input.nextFloat();
            }
        }
        b = new Matrix(bdata);
        float[][] cdata = new float[m][p];
        c = new Matrix(cdata);
        c.multi(a, b).print();
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
    public Matrix(int row, int col) {
        data = new float[row][col];
        r = row;
        c = col;
    }
    public Matrix multi(Matrix a, Matrix b) {
        Matrix d = new Matrix(a.r, b.c);
        for(int m=0; m<a.r; m++) {
            for(int p=0; p<b.c; p++) {
                for(int n=0; n<a.c ; n++){
                    d.data[m][p] = d.data[m][p] + a.data[m][n] * b.data[n][p];
                }
            }
        }
        return d;
    }
    public void print() {
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
// Python
// def main():
//     m, n, p = map(int,input().split())
//     a = [list(map(int,input().split()))for i in range(m)]
//     b = [list(map(int,input().split()))for i in range(n)]
//     c = [[sum([a[i][k]*b[k][j]for k in range(n)])for j in range(p)]for i in range(m)]
// main()