public class Demo {
    public static int totalDemo = 0;
    public String name;
    public Demo(String s) {
        this.name = s;
        totalDemo += 1;
    }
    public static int sum(int n) {
        System.out.println(n);
        if (n == 1) {
            return 1;
        }
        return n + sum(n - 1);
    }
    public static void change(int n){
        n = 0;
    }
    public static main(String[] args) {
        Demo.totalDemo = 10;
        Demo d;
        d = new Demo("first demo");
        System.out.println(d.name);
        sum(s);
    }
}