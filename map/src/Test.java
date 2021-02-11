import java.util.Arrays;

public class Test {
    public static void main(String[] args) {
        Graph g=new Graph(7);
        g.addVertex("A");
        g.addVertex("B");
        g.addVertex("C");
        g.addVertex("D");
        g.addVertex("E");
        g.addVertex("F");
        g.addVertex("G");
        int edge[][]=g.edges;
        for (int[] ints : edge) {
            Arrays.fill(ints,65535);
        }
        g.addEdge(0,1,5);
        g.addEdge(0,2,7);
        g.addEdge(1,3,9);
        g.addEdge(3,5,4);
        g.addEdge(4,5,5);
        g.addEdge(5,2,8);
        g.addEdge(0,6,2);
        g.addEdge(1,6,3);
        g.addEdge(4,6,4);
        g.addEdge(5,6,6);
        for (int i = 0; i <edge.length ; i++) {
            edge[i][i]=0;
        }
      Floyd f=new Floyd(g);
      f.show();





    }
}
