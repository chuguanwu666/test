public class Node {
    int t;
    Node next;

    public Node(int t) {
        this.t = t;
    }

    public Node() {
    }

    @Override
    public String toString() {
        return "{" +
                "t=" + t +
                '}';
    }
}
