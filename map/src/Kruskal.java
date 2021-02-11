import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Kruskal {
    public void createMinTree(Graph graph){
        int sum=0;
        int num=graph.num;
        ArrayList<String> vertexLst = graph.vertexLst;
        int arr[][]=graph.edges;
        int ends[]=new int[num];
        for (int i = 0; i <ends.length ; i++) {
            ends[i]=i;
        }
        List<Edge> list=new ArrayList<>();
        for (int i = 0; i <num ; i++) {
            for (int j = i+1; j <num ; j++) {
                if (arr[i][j]!=0) {
                   list.add(new Edge(vertexLst.get(i),vertexLst.get(j),arr[i][j],i,j));

                }
            }
        }
        System.out.println(list.size());
        Edge []Tree=new Edge[50];
        int index=0;
        Collections.sort(list);
        for (Edge edge : list) {
            if (ends[edge.i]!=ends[edge.j]){
                System.out.println(index);
                Tree[index]=edge;
                index++;
               if (ends[edge.i]>ends[edge.j]){
                   ends[edge.j]=ends[edge.i];
               }
               else {
                   ends[edge.i]=ends[edge.j];
               }
                sum+=edge.weight;

            for (int i = num-1; i >=0 ; i--) {
                int x=ends[i];
                while(x!=ends[x]){
                    x=ends[x];
                }
                ends[i]=x;
            }

            System.out.println(11);}
        }
        System.out.println("最短生成路径为"+ Arrays.toString(Tree)+"最短路径为"+sum);

    }
}
