// 學號：108213052
// 姓名：楊心慈
public class TestShape {
    public static void main(String[] argv) {
        // reference of type super class can point to sub class object
        // we can this concept 'polymorphism' 多形
        Shape[] all = new Shape[]{new Circle(3), new Triangle(3, 4, 5)}; // 設定圓形和三角形的半徑和邊長
        // Shape x = new Circle(8);
        System.out.println(Shape.sum(all)); // 輸出圓形和三角形的面積和
        Shape.showLength(all); // 分別求出圓形和三角形的周長
    }
}