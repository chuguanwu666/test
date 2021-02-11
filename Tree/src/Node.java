public class Node implements Comparable<Node> {
     Byte data;
     int value;

    @Override
    public String toString() {
        return "Node{" +
                "data=" + data +
                ", value=" + value +
                '}';
    }

    Node right;
     Node left;
     int lefttype;/*0代表孩子1代表后继*/
     int righttype;/*0代表孩子1代表后继*/
    @Override
    public int compareTo(Node o) {
        return this.value-o.value;
    }


    public int getLefttype() {
        return lefttype;
    }

    public void setLefttype(int lefttype) {
        this.lefttype = lefttype;
    }

    public int getRighttype() {
        return righttype;
    }

    public void setRighttype(int righttype) {
        this.righttype = righttype;
    }

    public Node(int value) {
        this.value = value;
    }
    public void add(int i){
        if (i>value){
            if (right==null) {
                right=new Node(i);
            }
            else{
                right.add(i);
            }
            }
        else{
            if(left==null){
                left=new Node(i);
            }
            else{
                left.add(i);
            }
        }
        if (leftHeight()-rightHeight()>1){
            if(left.leftHeight()<left.rightHeight()){
                left.leftRoate();
                rightRoate();
            }
            else{
                rightRoate();
            }
            return;
        }
        if (rightHeight()-leftHeight()>1){
            if (right.rightHeight()<right.rightHeight()){
                right.rightRoate();
               leftRoate();
            }
            else{
                leftRoate();
            }
        }
    }
    public void leftRoate(){
        Node node=new Node(value);
        node.left=left;
        node.right=right.left;
        value=right.value;
        right=right.right;
        left=node;
    }
    public void rightRoate(){
        Node node=new Node(value);
        node.right=right;
        node.left=left.right;
        value=left.value;
        left=left.left;
        right=node;
    }
    public int height(){
        return Math.max(right!=null?right.height():0,left!=null?left.height():0)+1;
    }
    public int rightHeight(){
        if (right==null){
            return 0;
        }
        return right.height();
    }
    public int leftHeight(){
        if (left==null){
            return 0;
        }
        return left.height();
    }
    }

