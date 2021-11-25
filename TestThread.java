public class TestThread {
    public static void main(String[] argv){
        Thread x = new PrintThread(); // poiymorphism
        x.start(); // thread start, like main() but call Thread.run()
        ToImplements a = new ToImplements();
        Thread y = new Thread(a);
        y.start();
        for(int i = 0; i <= 5; i++) {
            System.out.println("main" + i);
            try {
                Thread.currentThread().sleep(2000); // 毫秒
            } catch(Exception err) { // 錯誤丟這
            }
        }
        System.out.println("Main end");
    }
}
class PrintThread extends Thread {
    public void run() { // override Thread.run()
        for(int i = 0; i < 50; i++) {
            System.out.println("hello" + i);
            try {
                sleep(3000); // call parent's sleep() function
            } catch(Exception err) {
            }
        }
        System.out.println("Tread end");
    }
}
// try catch
class ToImplement implements Runnable {
    public void run() {
        for(int i = 0; i < 50; i++) {
            System.out.println("Test"+ " " +i);
        }
        System.out.println("Runnable Thread end");
    }
}