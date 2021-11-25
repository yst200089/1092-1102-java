public class TestValue {
    public static void fun(int x) {
        x = 0;
    }
    // 變數: int, float, double, 
    // 物件:
    public static void main(String[] argv) {
        // variable in java, a "container" store value
        int x = 100;
        // parameters are "passed by value"
        // in the following case, f(x), the x is "NOT" a variable, the x is "expression"
        // the result of expression "x" is 100
        fun(x);
        System.out.println(x);
        // 第七行是多少，輸出就是多少
    }
}