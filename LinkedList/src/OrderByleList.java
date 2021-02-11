public class OrderByleList {

   private Node header=new Node();
    public Node getHeader() {
        return header;
    }

    public void add(Node node){
        boolean flag=false;
    Node temp=header;
    while(temp.next!=null){
        if(temp.next.t>node.t){
            break;
        }
        else{
            if(temp.next.t==node.t)
            {
                flag=true;
                break;
            }
        temp=temp.next;
        }
    }
    if(flag) {
        System.out.println("该结点已经存在");
        return ;
    }
    node.next=temp.next;
    temp.next=node;
   }

    public boolean isEmpty(){
        return header.next==null;
    }
    /*打印链表*/
public void showList(){
        /*判断链表是否为空*/
        if(this.isEmpty()){
            System.out.println("该链表为空");
            return ;
        }
    Node temp=header.next;
        while(temp!=null){
            System.out.println(temp);
            temp=temp.next;
        }
}
/*删除结点*/
    public void removeNode(Node node){
        boolean flag=false;
        Node temp=header;
        while(temp.next!=null){
            if(temp.next.t==(node.t))  {
                flag=true;
                break;
            }
            temp=temp.next;
        }
        /*如果flag为true说明找到应该删除的结点*/
        if(flag==true){
            temp.next=temp.next.next;
        }
        else{
            System.out.println("没有找到该结点");
        }

    }


}
