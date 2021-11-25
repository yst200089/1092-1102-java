// 學號:108213052
// 姓名:楊心慈
/**
 * Program Name: SwingOXMain.java
 * Purpose: Showing how to Swing to write 井字遊戲
 * Modify Date: 2005/03/29
 */
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
// CloseWindow 繼承自 WindowAdapter(父類別) 實作 ActionListener 介面
class CloseWindow extends WindowAdapter implements ActionListener {
    private Window target;
    private boolean exit;
    public CloseWindow(Window target, boolean exit) {
        this.target = target;
        this.exit = exit;
    }
    public CloseWindow(Window target) {
        this.target = target;
    }
    // 處理視窗關閉後的的事件
    public void windowClosing(WindowEvent e) {
        target.dispose(); // 釋放target資源
        if (exit) {
            System.exit(0); // 點擊視窗關閉按鈕的話，程式就會直接結束
        }
    }
    // 設定按下按鈕後的動作
    public void actionPerformed(ActionEvent e) {
        target.dispose();
        if (exit) {
            System.exit(0); // 點擊視窗關閉按鈕的話，程式就會直接結束
        }
    }
}
// GridBagLayout 把視窗分成一個一個的格子 (grid) ，然後把小工具 (widget) 放到選定的格子中，可依視窗元件的大小設定佔用的格子數
class AddConstraint {
    public static void addConstraint(Container container, Component component,
          int grid_x, int grid_y, int grid_width, int grid_height,
          int fill, int anchor, double weight_x, double weight_y,
          int top, int left, int bottom, int right) {
        GridBagConstraints c = new GridBagConstraints();
        c.gridx = grid_x; // 行數
        c.gridy = grid_y; // 列數
        c.gridwidth = grid_width; // 行寬
        c.gridheight = grid_height; // 列高
        c.fill = fill; // 填滿方式
        c.anchor = anchor; // 定位點
        c.weightx = weight_x; // 行權值
        c.weighty = weight_y; // 列權值
        // 創建並初始化具有頂部、左、左邊、底部和右邊的對象
        c.insets = new Insets(top, left, bottom, right);
        // 呼叫管理員，並將c類型對象設置的約束添加到component的組件中
        ((GridBagLayout)container.getLayout()).setConstraints(component, c);
        container.add(component); // 加入component(選項)到選單
    }
}

// ErrorDialog 繼承自 Dialog(父類別)
class ErrorDialog extends Dialog {
    public ErrorDialog(Frame parent, String message) { // 傳入訊息對話框
        super(parent,"",true);
        setup(parent, message);
    }

    private void setup(Frame parent, String message) {
        // setLayout() 用來設定元件的版面配置
        // 創建具有GridBagLayout設置的對象並設定元件的版面配置
        this.setLayout(new GridBagLayout());
        int row=0, col=0, i, width=0; // 宣告列數、行數、寬度
        // 創建 font 字型種類設定為 Serif ，字型樣式設定為 Font.PLAIN ，字型大小為 16
        // Font.PLAIN = 設定文字字型樣式為不具有特別樣式
        Font font = new Font("Serif", Font.PLAIN, 16);
        char c=' '; // 宣告 c 字元為 
        for (i = 0; i < message.length(); i++) {
            c = message.charAt(i); // 選取字元
            if (c == '\n') { // 如果字元為 \n
               row++; // 列數加一
               if (width > col) { // 當寬度比行數大
                   col = width; // 則行數等於寬度
               }
               width=0; // 否則寬度為0
            } else if (c == '\t') { // 如果字元為 \t
                width += 7 - width % 7; // 縮排
            } else {
                if (c > 0x00FF) { // 如果字元大於16進位制
                    width += 2; // 則寬度加二
                } else {
                    width++; // 否則寬度加一
                }
            }
        }
        if (c!='\n') { // 如果字元不為 \t
           row++; // 列數加一
           if (width > col) { // 當寬度比行數大
               col = width; // 則行數等於寬度
           }
        }
        col++; // 行數加一
        row = (row > 24) ? 24 : row; // 希望視窗出來不要太大或太小
        if (row < 5) { // 如果列數小於5
            row = 5; // 列數就取5
        }
        if (col < 20) { // 如果行數小於20
            col = 20; // 列數就取20
        }
        // TextArea() 用來建立多行的文字輸入框
        TextArea tx = new TextArea(message, row, col); // 創建文字輸入框 tx
        // setEditable() 設定文字輸入框是可被編輯
        tx.setEditable(false); // 設定tx不可被編輯
        tx.setFont(font); // 設定tx字型
        // 填滿方式:GridBagConstraints.BOTH = 垂直水平都填滿
        // 定位點:GridBagConstraints.NORTHWEST = 左上對齊
        AddConstraint.addConstraint(this, tx, 0, 0, 1, 1,
            GridBagConstraints.BOTH,
            GridBagConstraints.NORTHWEST,
            1,1,0,0,0,0);
        // 創建「確定」按鈕
        Button b = new Button("確定");
        b.setFont(font); // 設定b字型
        // 填滿方式:GridBagConstraints.HORIZONTAL = 水平填滿
        // 定位點:GridBagConstraints.CENTER = 中央對齊
        AddConstraint.addConstraint(this, b, 0, 1, 1, 1,
            GridBagConstraints.HORIZONTAL,
            GridBagConstraints.CENTER,
            1,0,0,0,0,0);
        CloseWindow cw = new CloseWindow(this); // 創建並紀錄是否關閉視窗的對象
        // addWindowListener() 用來加入視窗相關的事件處理
        this.addWindowListener(cw); 
        // addActionListener() 用來設定按鈕的事件處理
        b.addActionListener(cw); // 用來設定「確定」按鈕的事件處理
        pack(); // pack() 用來將視窗中的各個元件，自動依版面配置作適當的排列
        setVisible(true); // 將元件設為可見
    }
}
// 視窗
// SwingOXMain 繼承自 JFrame(父類別) 實作 ActionListener 介面
public class SwingOXMain extends JFrame implements ActionListener {
    private OX oxBoard;
    private SwingOXMain() {
        // super() 是從子類別的建構元呼叫父類別的建構元
        super("井字遊戲"); // 呼叫JFrame的建構子, 並傳入視窗標題
        JMenu m; // 下拉式選單
        JMenuBar mb; // 下拉式選單列
        oxBoard = new OX(this); // 創建 OX 類別的對象
        // getContentPane()取得物件，加入oxBoard到this
        this.getContentPane().add(oxBoard);
        CloseWindow close = new CloseWindow(this, true); // 創建並初始化紀錄是否關閉視窗的對象
        this.setJMenuBar(mb = new JMenuBar()); // 創建下拉式選單列
        // 在下拉式選單加入「遊戲」這個選項，並將該選單列中加入「新遊戲」選項為其選單列
        // addActionListener() 用來設定按鈕的事件處理
        mb.add(m = new JMenu("遊戲")).add(new JMenuItem("新遊戲")).addActionListener(this);
        // 在下拉式選單的「遊戲」這個選項加入「結束」選項為其選單列
        m.add(new JMenuItem("結束")).addActionListener(close);
        // 在下拉式選單加入「說明」這個選項，並將該選單列中加入「關於本遊戲」選項為其選單列
        mb.add(new JMenu("說明")).add(new JMenuItem("關於本遊戲")).addActionListener(this);
        // addWindowListener() 用來加入視窗相關的事件處理
        this.addWindowListener(close);
        pack(); // pack() 用來將視窗中的各個元件，自動依版面配置作適當的排列
        // setVisible()用來設定元件的可見性
        setVisible(true); // 將元件設為可見
    }
    public static void main(String argv[]) {
        new SwingOXMain();
    }
    // implements the ActionListener interface
    // 用來設定按下按鈕後的動作
    public void actionPerformed(ActionEvent e) {
        String command = e.getActionCommand(); // 取得按鈕設定的指令
        if (command.equals("關於本遊戲")) { // 如果選擇「關於本遊戲」按鈕
            new ErrorDialog(this,"俞旭昇寫好玩的"); // 則創建並打開訊息對話框
        } else if (command.equals("新遊戲")) { // 如果選擇「新遊戲」按鈕
            oxBoard.newGame(); // 開新遊戲
        }
    }
}
// Component 為大部分 AWT 視窗元件的父類別
// OX 繼承自 Component(父類別) 實作 MouseListener 介面
class OX extends Component implements MouseListener {
    private Dimension mySize = new Dimension(450,450); // 視窗的大小
    public void newGame() { // 開新遊戲
    }
    private JFrame parent;
    public OX(JFrame p) {
        // addMouseListener() 用來設定元件滑鼠的事件處理
        this.addMouseListener(this); // 紀錄滑鼠動作
        this.parent = p;
    }
    // The following 5 functions implement the MouseListener interface
    // 在組件上單擊鼠標時調用
    public void mouseClicked(MouseEvent e) {}
    // 在組件上按下鼠標按鈕時調用
    public void mousePressed(MouseEvent e) {}
    // 當鼠標進入組件時調用
    public void mouseEntered(MouseEvent e) {}
    // 鼠標退出組件時
    public void mouseExited(MouseEvent e) {}
    // 在組件上釋放鼠標按鈕時調用
    public void mouseReleased(MouseEvent e) {}
    @Override
    // override paint() defined in Component
    // 印出9 * 9的線
    public void paint(Graphics g) {
        // 橫線-由上至下
        g.drawLine(0,50,450,50);  g.drawLine(0,100,450,100);
        g.drawLine(0,150,450,150);  g.drawLine(0,200,450,200);
        g.drawLine(0,250,450,250);  g.drawLine(0,300,450,300);
        g.drawLine(0,350,450,350);  g.drawLine(0,400,450,400);
        // 直線-由左至右
        g.drawLine(50,0,50,450);  g.drawLine(100,0,100,450);
        g.drawLine(150,0,150,450);  g.drawLine(200,0,200,450);
        g.drawLine(250,0,250,450);  g.drawLine(300,0,300,450);
        g.drawLine(350,0,350,450);  g.drawLine(400,0,400,450);
    }
    // override getPreferredSize defined in Component,
    // so that the Component has proper size on screen
    @Override
    // 指定視窗尺寸
    public Dimension getPreferredSize() {
        return this.mySize;
    }
}

// 最後完成日期:2021年05月01日