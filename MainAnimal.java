abstract class Animal {
    int feet;
    int ear;
    int eye;
    String color;
    public abstract void move();
}

class Dog extends Animal {
    private String name = "Lucky";
    // override
    public void move() {
        System.out.println(this.name + " run with " + this.feet + " feet");
    }
    public Dog(int i) {
        this.feet = i;
        this.ear = 2;
        this.eye = 2;
        this.color = "Blue";
    }
    public Dog() {
        this.feet = 4;
        this.ear = 2;
        this.eye = 2;
        this.color = "Blue";
    }
}

class FlyDog extends Dog {
    public void move() {
        super.move();
    }
    public FlyDog() {
        super(9); // 直接複製子類別的建構子
    }
}

class FlyCow extends Animal {
    public void move() {
        System.out.println(" run with " + this.feet + " feet, then fly");
    }
    public FlyCow() {
        this.feet = 4;
        this.ear = 2;
        this.eye = 2;
        this.color = "Green";
    }
}

public class MainAnimal {
    public static void main(String[] argv) {
        Dog lucky = new Dog();
        lucky.move();
        FlyCow farm = new FlyCow();
        farm.move();
        FlyDog goofy= new FlyDog();
        goofy.move();
    }
}