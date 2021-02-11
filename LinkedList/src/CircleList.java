public class CircleList {
    Node first;
    /*创建一个大小为n的环*/
    public void add(int n){
        Node current;
        first=new Node(1);
        first.next=first;
        current=first;
        for (int i=2;i<=n;i++){
            Node temp=new Node(i);
            current.next=temp;
            temp.next=first;
            current=temp;
        }

    }
    public void show(){
        Node current=first;
        while (true){
            if(current.next!=first) {
                System.out.println(current);
                current=current.next;
            }
            else{
                System.out.println(current);
                break;
            }
        }
    }
    /*k代表从第k个人开始,n代表数到n,m代表环总共有m人*/
    public void Josef(int k,int n,int m){
        add(m);
        /*找到需要被删除节点的前一个结点,初始为first前的一个结点*/
        Node pre=first;
        while(pre.next!=first){
            pre=pre.next;
        }
        /*当前结点*/
        Node current=first;
        for(int i=0;i<k-1;i++)
        {
            current=current.next;
            pre=pre.next;
        }
        /*开始出队*/
        while(true){
            if(pre==current) {
                System.out.println(current);
                break;
            }
            for(int j=0;j<n-1;j++){
                current=current.next;
                pre=pre.next;
            }
            System.out.println(current);
            /*删除该结点*/
            pre.next=current.next;
            current=current.next;
        }



    }

}
