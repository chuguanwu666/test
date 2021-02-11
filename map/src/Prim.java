import java.util.ArrayList;

public class Prim {
    public void createMinTree(Graph graph){
        boolean []visited=graph.visited;
        ArrayList<String> vertexLst = graph.vertexLst;
        int sum=0;
        int min;
        int v1=-1;
        int v2=-1;
        int edges[][]=graph.edges;
        visited[0]=true;
        for (int i=0;i<graph.num-1;i++){
     min=10000;
            for (int j = 0; j <graph.num ; j++) {
                if (visited[j]==true){
                for (int k = 0; k <graph.num; k++) {
                    if (visited[k]==false&&edges[j][k]!=0){
                        if (min>edges[j][k]){
                            v1=j;
                            v2=k;
                            min=edges[j][k];
                        }
                    }

                }
                }
            }
            sum+=min;
            visited[v2]=true;
            System.out.println(vertexLst.get(v1)+"<-"+vertexLst.get(v2)+" "+min);
        }
        System.out.println("总路径为"+sum);
    }
}
