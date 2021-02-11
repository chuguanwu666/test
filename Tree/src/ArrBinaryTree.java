public class ArrBinaryTree {
    /*用数组模拟二叉树*/
   private int []arr;

    public void setArr(int[] arr) {
        this.arr = arr;
    }
    /*前序遍历二叉树*/
    public void print(){
        print(0);
    }
    public void print(int n){
        /*输出当前位置元素的值*/
        System.out.println(arr[n]);
        /*递归左子树*/
        if (2*n+1<=arr.length-1){
            print(2*n+1);
        }
        /*递归右子树*/
        if (2*n+2<=arr.length-1){
            print(2*n+2);
        }
    }
}
