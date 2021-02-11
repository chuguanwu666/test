public class Edge implements Comparable<Edge> {
    String start;
    String end;
    int weight;
    int i;
    int j;

    @Override
    public int compareTo(Edge o) {
        return this.weight-o.weight;
    }

    public Edge(String start, String end, int weight,int i,int j) {
        this.start = start;
        this.end = end;
        this.weight = weight;
        this.i=i;
        this.j=j;
    }

    @Override
    public String toString() {
        return "Edge{" +
                "start='" + start + '\'' +
                ", end='" + end + '\'' +
                ", weight=" + weight +
                '}';
    }
}
