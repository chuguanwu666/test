import java.lang.reflect.Array;
import java.util.*;

public class Graph {
    int [][]edges;
    int num;
    boolean []visited;
    ArrayList<String> vertexLst;/*点的集合*/
    public Graph(int n){
        num=n;
        vertexLst=new ArrayList<>(n);
        visited=new boolean[n];
        edges=new int [n][n];
        /*1代表有道路*/
    }
    public void addVertex(String str){
        vertexLst.add(str);
    }
    public void addEdge(int v1,int v2,int weight){
        edges[v1][v2]=weight;
        edges[v2][v1]=weight;
    }
    public void getEdges(){
        for (int[] edge : edges) {
            for (int i : edge) {
                System.out.print(i+" ");
            }
            System.out.println();
        }
    }


    public int getFirst(int v){
        for (int i = 0; i <num ; i++) {
            if (edges[v][i]!=0&&visited[i]==false){
                return i;
            }
        }
        return -1;
    }
    public int getFirst(int v1,int v2){
        for (int i = v2+1; i <num ; i++) {
            if (edges[v1][i]!=0&&visited[i]==false){
                return i;
            }
        }
        return -1;
    }
    public void dfs(int i){
        visited[i]=true;
        System.out.println(vertexLst.get(i));
        int v2=getFirst(i);
        if (v2==-1){
            return ;
        }
        dfs(v2);
        while ((v2=getFirst(i,v2))!=-1){
            dfs(v2);
        }
    }
    public void dfs(){
        int i;
        Stack<Integer> s=new Stack<>();
        s.push(0);
        while (!s.isEmpty()){
            i=s.peek();
            if (visited[i]==false){
            System.out.println(vertexLst.get(i));
            visited[i]=true;
            }
            if (getFirst(i)!=-1){
                s.push(getFirst(i));
            }
            else{
                s.pop();
            }
        }

    }
    public void bfs(){
        Queue<Integer> queue=new LinkedList<>();
        queue.add(0);
        visited[0]=true;
        while (!queue.isEmpty()){
            int temp=queue.poll();
            int v2=getFirst(temp);
            System.out.println(vertexLst.get(temp));

            while(v2!=-1){
                queue.add(v2);
                visited[v2]=true;
                v2=getFirst(temp,v2);
            }
        }
    }
}
