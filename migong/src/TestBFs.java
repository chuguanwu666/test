import java.util.Scanner;

public class TestBFs {
    public static void main(String[] args) {
        /*n行m列*/
        int n;
        int m;
        Point end=null;
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        Point [][]arr=new Point[n][m];
        int x;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                arr[i][j]=new Point();
                x=sc.nextInt();
                arr[i][j].x=i;
                arr[i][j].y=j;
             if(x==0){
                 arr[i][j].flag=true;
             }
              else if(x==2){
                 arr[i][j].flag=true;
                 arr[i][j].isEnd=true;
                 end=arr[i][j];
             }
            }
        }
        System.out.println(1);
        Point P=end;
       if(BFS.BFS(arr,1,1)){
           System.out.print("该迷宫经过终点点");
           while(P.x!=1||P.y!=1) {
               System.out.printf("(%d,%d)", P.x, P.y);
               P=P.pre;
           }
           System.out.printf("共用%d步",end.count);
       }
       else{
           System.out.println("该迷宫不通");
       }
    }
}