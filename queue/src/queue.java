public class queue{
    /*底层数组实现*/
    int []arr;
    int rear=0; /*队尾*/
    int front=0;  /*队头*/
    int maxsize; /*数组的最大容量*/
  public queue(int n){
      maxsize=n;
      arr=new int[n];
  }
  public boolean isFull(){
      return (rear+1)%maxsize==front;
  }
    public boolean isEmpty(){
        return rear==front;
    }


   public void add(int n){
if(isFull()){
    System.out.println("该队列已满无法加入更多元素");
}
   else{
       arr[rear]=n;
       rear=(rear+1)%maxsize;
}
   }
   public void peek(){
      if(isEmpty()){

          System.out.println("该队列为空");
      }
      else{
          System.out.println(arr[front]);
          front=(front+1)%maxsize;
      }
   }

}
