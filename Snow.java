// 學號：108213052
// 姓名：楊心慈
// 科赫雪花是由三條科赫曲線組成
// 科赫曲線 : 一種「遞迴」定義的圖形，由4條長度為1/3的小科赫曲線所組成
// 如何描述(座標系統)科赫曲線？
// 極座標 l:長度 d:角度
// 科赫曲線(x, y, l, d) =
// (x, y, l/3, d),
// (x + cos(d*3.14/180)*l/3, y - sin(d*3.14/180)*l/3, l/3, d+60),
// (x + cos(d*3.14/180)*l/3 + cos((d+60)*3.14/180)*l/3,y - in(d*3.14/180)*l/3 - sin((d+60)*3.14/180)*l/3, l/3, d-60),
// (x + cos(d*3.14/180)*l*2/3, y - sin(d*3.14/180)*l*2/3, l/3, d)
public class Snow extends Thread{
    public static Pen p = new Pen();
    public void run() {
        snow(x, y, l, d);
    }
    double x, y;
    int l, d;
    public Snow(double x, double y, int l, int d){
        this.x = x;
        this.y = y;
        this.l = l;
        this.d = d;
    }
    public static void snow(double x, double y, int l, int d){
        if (l == 1) {
            synchronized(p){
                p.flyTo((int)x, (int)y); // 確保不會出現 float 浮點數
                p.runTo((int)x, (int)y);
            }
            try {
                Thread.currentThread().sleep(5); // 畫完停千分之五秒
            } catch (Exception err){
            }
            return;
        }
        snow(x, y, l/3, d);
        snow(x + Math.cos(d*3.14/180)*l/3, y - Math.sin(d*3.14/180)*l/3, l/3, d+60);
        snow(x + Math.cos(d*3.14/180)*l/3 + Math.cos((d+60)*3.14/180)*l/3,y - Math.sin(d*3.14/180)*l/3 - Math.sin((d+60)*3.14/180)*l/3, l/3, d-60);
        snow(x + Math.cos(d*3.14/180)*l*2/3, y - Math.sin(d*3.14/180)*l*2/3, l/3, d);
    }
    public static void main(String[] argv) {
        new Snow(0, 200, 243, 0).start();
        new Snow(0, 300, 243, 0).start();
        new Snow(0, 400, 243, 0).start();
        // 81*3
        // snow(20, 200, 243, 0);
        // snow(263, 200, 243, 235);
        // snow(125, 400, 243, 480);
    }
}

// 最後完成日期 : 2021年05月03日