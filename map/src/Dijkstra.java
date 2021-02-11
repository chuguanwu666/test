import java.util.ArrayList;
import java.util.Arrays;

public class Dijkstra {
    ArrayList<String> vertex;
    int index;
    int []dis;/*当前终点到该点的最短距离*/
    boolean visited[];
    int []pre;
    int edges[][];
    int num;
    /*index代表顶点点位置*/
    public Dijkstra(Graph graph,int index) {
        vertex=graph.vertexLst;
        this.index=index;
        visited=graph.visited;
        edges=graph.edges;
        dis=new int[graph.num];
        Arrays.fill(dis,65535);
        dis[index]=0;
        num=graph.num;
        pre=new int[num];
        start();

    }
    /*设置前驱结点*/
    public void setPre(int index,int i){
      pre[i]=index;
    }
    public void setDis(int index,int len)
    {
        dis[index]=len;
    }
    /*当访问新顶点时更新距离数组*/
    public void updateDis(int index) {
        int[] edge = edges[index];/*获取该点连通的边*/
        int len=0;
        for (int i = 0; i <edge.length ; i++) {
            len=edge[i]+dis[index];
            if (dis[i]>len){
               setDis(i,len);
               setPre(index,i);
            }
        }
    }
    public int search(){
        int min=65535;
        int index=-1;
        for (int i = 0; i <dis.length ; i++) {
            if (visited[i]!=true&&dis[i]<min){
                min=dis[i];
                index=i;
            }
        }
        return index;
        }
        public void start(){
             updateDis(index);
             visited[index]=true;
             pre[index]=index;
             /*访问新的顶点并且更新数据*/
            for (int i = 1; i <num ; i++) {
                int j=search();
                visited[j]=true;
                updateDis(j);
            }
        }
        public void show(){
            for (int i = 0; i <num ; i++) {
                String str=vertex.get(i);
                int j=pre[i];
                System.out.print(vertex.get(index)+"到"+vertex.get(i)+"最短距离为"+dis[i]);
                while(j!=index){
                    str=str+"-<"+vertex.get(j);
                    j=pre[j];
                }
                str=str+"-<"+vertex.get(j);
                System.out.println("最短路径为"+new StringBuffer(str).reverse());

            }
        }

    }

