import java.util.ArrayList;
import java.util.Arrays;

public class Floyd {
    /*寻找图中各个点到其他点的最短距离*/
    int dis[][];
    ArrayList<String> vertex;
    int num;
    public Floyd(Graph graph){
        dis=graph.edges;
        vertex=graph.vertexLst;
        num=graph.num;
        search();
    }
    public void search(){
        int len=0;
        /*以第i个点为中转站j为起点k为终点*/
        for (int i = 0; i <num ; i++) {
            for (int j = 0; j <num ; j++) {
                for (int k = 0; k <num; k++) {
                    len=dis[j][i]+dis[i][k];
                    if (len<dis[j][k]){
                        dis[j][k]=len;
                    }
                }
            }
        }
    }
    public void show(){
        for (int[] di : dis) {
            System.out.println(Arrays.toString(di));
        }
        for (int i = 0; i <num ; i++) {
            for (int j = 0; j <num ; j++) {
                System.out.println("顶点"+vertex.get(i)+"到顶点"+vertex.get(j)+"的最短距离为"+dis[i][j]);
            }
            System.out.println();
        }
    }
}
