public class BST {
    private Node root;
    private Node pre;
    /*添加元素*/
    public void add(int x){
        Node temp=root;
        Node node=new Node(x);
        if (root==null){
            root=node;
            return;
        }

        while(true){
            if (temp.value<x){
                if (temp.right==null){
                    temp.right=node;
                    return;
                }
                else{
                    temp=temp.right;
                    continue;
                }
            }
            else{
                if (temp.left==null){
                    temp.left=node;
                    return;
                }
                else{
                    temp=temp.left;
                }

            }
        }
    }
    /*中序遍历二叉排序树*/
    public void midOrder(){
        midOrder(root);
    }
    public void midOrder(Node node){
 if (node==null) return;
 midOrder(node.left);
        System.out.println(node.value);
        midOrder(node.right);
    }
    public void midThread(Node node){

        if (node==null){
            return;
        }
        /*先线索化左子树*/
        midThread(node.left);
        if (node.left==null){
            node.setLefttype(1);
            node.left=pre;
        }
        if (pre!=null&&pre.right==null){
            pre.setRighttype(1);
            pre.right=node;
        }
        pre=node;
        midThread(node.right);

    }
    public void midThread(){
        midThread(root);
    }
    public void midThreadeOrder(){
        Node temp=root;
        while(temp!=null) {
            while (temp.getLefttype() != 1) {
                temp=temp.left;
            }
            System.out.println(temp);
            while (temp.getRighttype()==1){
                temp=temp.right;
                System.out.println(temp);
            }
            temp=temp.right;
        }
    }
    public void delete(int i){
   Node  node=findNode(i);
   Node  parent=findParentNode(i);
   if (node==null) return;
   if (node.right==null&&node.left==null){
       zeroNode(node,parent);
   }
   else if(node.left!=null&&node.right==null||node.left==null&&node.right!=null){
       singleNode(node,parent);
   }
   else{
       doubleNode(node,parent);
   }
    }
    public Node findNode(int i){
        Node temp=root;
        while(true){
            if (temp.value==i){
                return temp;
            }
            if (temp.right!=null&&temp.value<i){
                temp=temp.right;
            }
            else if (temp.left!=null&&temp.value>i){
                temp=temp.left;
            }
            else return null;
        }
    }
    public Node findParentNode(int i){
        Node parent=root;
        if (root.value==i){
            return null;
        }
        while (true){
            if(parent.value<i){
                if (parent.right==null) return null;
                else if (parent.right.value==i){
                    return parent;
                }
                else{
                    parent=parent.right;
                }
            }
            else{
                if (parent.left==null) return null;
                else if (parent.left.value==i){
                    return parent;
                }
                else{
                    parent=parent.left;
                }
            }
        }

    }
    public void zeroNode(Node node,Node parent){
        /*根节点的情况下*/
        if (parent==null){
            node=null;
            return;
        }
        /*非根节点的情况下*/
        else{
            if (parent.left==node){
                parent.left=null;
            }
            else{
                parent.right=null;
            }
        }

    }
    public void singleNode(Node node,Node parent){
        /*根节点的情况下*/
        if (parent==null){
            if (node.right!=null){
                root=node.right;
            }
            else{
                root=node.left;
            }
        }
        /*非根节点情况下*/
        else{
            if (parent.right==node){
            if (node.right!=null){
                parent.right=node.right;
            }
            else{
                parent.right=node.left;
            }}
            else {
                if (node.right!=null){
                    parent.left=node.right;
                }
                else{
                    parent.left=node.left;
                }
            }
        }
    }
    public void doubleNode(Node node,Node parent){
        int i;/*保存右子树最小值*/
        Node min=getMin(node);
        i=min.value;
        /*删除该结点右子树最小节点*/
        delete(i);
        /*将右子树最小节点的值赋给当前结点*/
        node.value=i;
    }
    public Node getMin(Node node){
        Node temp=node.right;
        if (temp.left!=null){
            temp=temp.left;
        }
        return temp;
    }
}
