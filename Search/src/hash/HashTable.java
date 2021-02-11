package hash;

import java.util.ArrayList;

public class HashTable<T> {
    private Node<T>[] table;
    ArrayList<T> [] list=(ArrayList<T>[]) new ArrayList[10];
    Node<T> N=new Node<T>();
    private int size;
    public HashTable(int n){
        table= (Node<T>[]) new Node[n];
        size=n;
    }
    public HashTable(){
        this(16);
    }
    public boolean add(Node <T> n){
        T key=n.t;
        int hash=key.hashCode();
        int index=hash&(size-1);
        if(table[index]==null){
            table[index]=n;
            return true;
        }
        else {
            /*判断在该位置的元素是否重复如果重复则返回false*/
            Node temp=table[index];
            while(temp.next!=null)
            {
                if(temp.t.equals(key)) return false;
                temp= temp.next;
            }
            if (temp.t.equals(key)){
                return false;
            }
            else {
                temp.next=n;
                return true;
            }
        }
    }
    public Node<T> get(T t){
        int hash=t.hashCode();
        int index=hash&(size-1);
        Node<T> n=table[index];
        while(n!=null){
            if(n.t.equals(t)) break;
        }
        return n;
    }

}
