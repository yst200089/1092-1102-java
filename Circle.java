// 學號：108213052
// 姓名：楊心慈
public class Circle extends Shape { // 繼承了 Shape 的 class
    private float radius; // 宣告半徑屬性
    public Circle(float r) {
        this.radius = r;
    }
    // redefine area in Shape, this is called 'override'
    public double area() {
        System.out.println("using area Circle");
        return 3.14149 * radius * radius; // 回傳圓形面積
    }
    public double SideLength() {
        System.out.println("using SideLength Circle");
        return 3.14149 * radius * 2; // 回傳圓形周長
    }
}