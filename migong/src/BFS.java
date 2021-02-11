import java.util.LinkedList;
import java.util.Queue;

public class BFS {
    /*(x,y)为终点起点坐标*/
    public static boolean BFS(Point[][] arr,int x,int y){
        Queue<Point> q=new LinkedList<>();
        arr[x][y].flag=false;
        q.offer(arr[x][y]);
    /*判断队列的第一个元素的四个方向是否可以走*/
        while(!q.isEmpty()){

            Point p=q.remove();
            System.out.println(p.x+" "+p.y);
            if(arr[p.x+1][p.y].flag){
                /*该点的步数+1,并且设置为不可走*/
                arr[p.x+1][p.y].count=p.count+1;
                arr[p.x+1][p.y].flag=false;
                arr[p.x+1][p.y].pre=p;
                if(arr[p.x+1][p.y].isEnd) return true; /*如果该点为终点跳出该函数*/
                q.offer(arr[p.x+1][p.y]);
            }
            if(arr[p.x][p.y-1].flag){
                /*该点的步数+1,并且设置为不可走*/
                arr[p.x][p.y-1].count=p.count+1;
                arr[p.x][p.y-1].flag=false;
                arr[p.x][p.y-1].pre=p;
                if(arr[p.x][p.y-1].isEnd) return true; /*如果该点为终点跳出该函数*/
                q.offer(arr[p.x][p.y-1]);
            }
            if(arr[p.x-1][p.y].flag){
                /*该点的步数+1,并且设置为不可走*/
                arr[p.x-1][p.y].count=p.count+1;
                arr[p.x-1][p.y].flag=false;
                arr[p.x-1][p.y].pre=p;
                if(arr[p.x-1][p.y].isEnd) return true; /*如果该点为终点跳出该函数*/
                q.offer(arr[p.x-1][p.y]);
            }
            if(arr[p.x][p.y+1].flag){
                /*该点的步数+1,并且设置为不可走*/
                arr[p.x][p.y+1].count=p.count+1;
                arr[p.x][p.y+1].flag=false;
                arr[p.x][p.y+1].pre=p;
                if(arr[p.x][p.y+1].isEnd) return true; /*如果该点为终点跳出该函数*/
                q.offer(arr[p.x][p.y+1]);
            }




        }



        return false;
    }
}
