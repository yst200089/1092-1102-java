public class Carpet extends Thread { // 同時進行
    public int x, y, l;
    public static Pen pen = new Pen();
    public Carpet(int x, int y, int l) {
        this.x = x;
        this.y = y;
        this.l = l;
    }
    // ovorride run() defined in Thread
    public void run() {
        draw(x, y, l);
    }
    // 劃出卡氏地毯，其左上角座標(x, y)，地毯邊長為 l
    // 向右 x+
    // 向下 y+
    public static void draw(int x, int y, int l) {
        if(l <= 1) { // 地毯太小了，用一個"點"來代表
            try {
                 Thread.currentThread().sleep(1);
            } catch(Exception err) {
            }
            drawDot(x, y);
            return;
        }
        draw(x, y, l/3); // 開始的點
        draw(x+l/3, y, l/3);
        draw(x+2*l/3, y, l/3);
        draw(x, y+l/3, l/3);
        draw(x+2*l/3, y+l/3, l/3);
        draw(x, y+2*l/3, l/3);
        draw(x+l/3, y+2*l/3, l/3);
        draw(x+2*l/3, y+2*l/3, l/3);
    }
    public static void threadDraw(int x, int y, int l) {
        new Carpet(x, y, l/3).start();
        new Carpet(x+l/3, y, l/3).start();
        new Carpet(x+2*l/3, y, l/3).start();
        new Carpet(x, y+l/3, l/3).start();
        new Carpet(x+2*l/3, y+l/3, l/3).start();
        new Carpet(x, y+2*l/3, l/3).start();
        new Carpet(x+l/3, y+2*l/3, l/3).start();
        new Carpet(x+2*l/3, y+2*l/3, l/3).start();
    }
    public static synchronized void drawDot(int x, int y) {
        pen.flyTo(x, y);
        pen.runTo(x, y);
    }
    public static void main(String[] argv) {
        threadDraw(0, 0, 9*9*9);
    }
}