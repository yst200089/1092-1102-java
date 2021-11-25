// 學號:108213052
// 姓名:楊心慈
abstract class Animal {
    String name;
    // abstract 只有宣告沒有實作的方法，要求子類別要實作
    public String moveMethod(){
        return "walk";
    }
}
class Dog extends Animal {
    public String moveMethod() {
        return "run";
    }
}
class Fish extends Animal {
    public String moveMethod() {
        return "swim";
    }
}
class Bird extends Animal {
    public String moveMethod() {
        return "fly";
    }
}
class Student extends Animal {
}
public class TestExtend {
    public static void directAll(Animal[] list) {
        for (int i =0; i < list.length; i++){
            System.out.println(list[i].moveMethod());
        }
    }
    public static void main(String[] argv) {
        Animal[] mypet = new Animal[] {new Dog(), new Bird(), new Fish(), new Student()};
        directAll(mypet);
        Animal x = new Bird();
        x.moveMethod();
    }
}
// 最後完成日期:2021年04月19日