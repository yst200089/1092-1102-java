import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 *
 * @author hazuya
 */

class node{
    int v;
    node link;
}

class DFStest {
    
    final static int maxVer = 100;    //最大節點數
    
    node node = new node();
    node lastnode = new node();
    static node[] adjlist = new node[maxVer + 1];    //相鄰串列
    static boolean[] visit = new boolean[maxVer + 1];       //紀錄是否已被走訪
    static int totalVer = 0;
    
    public void buildAdj(){
        
        int vi = 0, vj = 0, weight = 0; //節點V(i, j) 以及 路徑之權重
        Scanner input = null;
        
        try{
        
            input = new Scanner(new FileInputStream("dfs.txt")); //讀入資料檔
        
        }catch(FileNotFoundException e){  //接取檔案讀取錯誤例外
        
            System.out.print("dfs.txt not found.");
            System.exit(1); //離開程式
        
        }
        
        totalVer = input.nextInt();     //總結點數量
        
        //建立串列首與預設尚未走訪
        for(vi = 1; vi <= totalVer; vi++){
        
            visit[vi] = false; //預設尚未走訪
            adjlist[vi] = new node(); //建立串列首
            adjlist[vi].v = vi;     //節點
            adjlist[vi].link = null;
        
        }
        
        //讀取節點
        for(vi = 1; vi <= totalVer; vi++){
        
            for(vj = 1; vj <= totalVer; vj++){
            
                weight = input.nextInt();  //取得V(i,j)路徑權重
                
                if(weight != 0){        //如果V(i,j)權重不為0，則加入串列
                
                    node = new node();
                    node.v = vj;    //節點
                    lastnode = searchlast(adjlist[vi]);     //將其串入相鄰串列的後面
                    lastnode.link = node;
                
                }
            
            }
        
        }
        
        input.close();
        
    }
    
    //列出相鄰串列
    public void showAdj(){
    
        node ptr = new node();
        
        System.out.println("Head        adjacencyNode");
        System.out.println("=========================");
        
        for(int index = 1; index <= totalVer; index++){
        
            System.out.printf("V%d  ", adjlist[index].v);
            ptr = adjlist[index].link;
            while(ptr != null){
                          
                System.out.printf("=>V%d   ", ptr.v);
                ptr = ptr.link;
            
            }
            
            System.out.println();
        
        }
        
        
        
    }
    
    //進行DFS走訪
    public void dfs(int v){
    
        node ptr = new node();
        System.out.printf("V%d, ", adjlist[v].v);  //輸出節點
        visit[v] = true;    //節點已訪問
        ptr = adjlist[v].link;  //訪問鄰近節點
        
        while(ptr != null){
            if(visit[ptr.v] != true)    //當鄰近節點沒被訪問時就去訪問，遞迴呼叫dfs函式
                dfs(ptr.v);
            else
                ptr = ptr.link;     //已被訪問就略過
        
        }
    
    }
        
    //尋找串列末端
    public node searchlast(node ll){
        
        node ptr = new node();
        ptr = ll;
        while(ptr.link != null){
            
            ptr = ptr.link;
            
        }
        return ptr;
        
    }

    //主函數
    public static void main(String[] args) {
        DFStest dfs = new DFStest();
        dfs.buildAdj();
        dfs.showAdj();
        dfs.dfs(1);
    }
    
}