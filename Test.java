class MyException extends Exception {
}
public class Test {
    public static void print(int[] x) {
        for(int i=0; i<=x.length; i++) {
            System.out.println(x[i]);
        }
    }
    public static void troubleFunction() throws MyException { // 宣告 troubleFunction 丟出 MyException
        int x = 0; // whatever
        throw new MyException(); // 建 MyException 並丟出，但未出 troubleFunction
    }
    public static void main(String[] argv) {
        int[] x = new int[5];
        // 定義在 java.lang.*內的 Exception, 可以不需要 try catch
        try {
            print(x);
            int y = Integer.valueOf("14"); // 返回保存指定的 String 的值的 Integer 对象
            troubleFunction();
        } catch(ArrayIndexOutOfBoundsException e1) {
            System.out.println("你傻蛋啦，陣列索引弄錯了!");
        } catch(NumberFormatException e2) {
            System.out.println("你糊塗喔，想把不是整數的字串轉整數");
            e2.printStackTrace(); // 確定是哪一行錯
        } catch(MyException errABC) {
            System.out.println(errABC);
        } catch(Exception e3) {
            System.out.println("你阿呆，怎死的都不知道");
            e3.printStackTrace();
        } finally {
            System.out.println("管你有沒有錯，我就是要念妳一下");
        }
    }
}