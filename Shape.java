// 學號：108213052
// 姓名：楊心慈
// abstract class is a kind of class that can't be new
// Shape is defined as a super class(parent class)
public abstract class Shape{
    // an abstract method. ask subclass to implement it
    public abstract double area(); // 求面積
    public abstract double SideLength(); // 求邊長
    public static double sum(Shape[] list) {
        double sum = 0;
        for(int i = 0; i < list.length; i++) {
            // 請問此處的 area() 應該用誰的？ super class? sub class?
            // 會有此問題是因為 list 宣告的型態是 Shape
            // 但java允許 'polymorpism', 所以 list 會參考到 Circle or Triangle
            // 若此語言呼叫 sub class 的方法，則稱為 virtual function
            // 若此語言呼叫 super class(需吿變數的型態)的方法，則稱為 non virtual function
            // java 只有 virtual funtion
            // C++ 兩種都有，寫程式時 programmer 要告訴 compiler 用哪一種
            sum = sum + list[i].area(); // 將三角形和圓形的面積相加
        }
        return sum; // 回傳面積的總和
    }
    public static void showLength(Shape[] list) {
        for(int i = 0; i < list.length; i++) {
            System.out.println(list[i].SideLength()); // 分別輸出圓形和三角形的周長
        }
    }
}