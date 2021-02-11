public class HeapSort {
    public static void sort(int []arr){
        /*第一步创建一个大顶堆由完全二叉树的性质得第一个非叶子结点的坐标为(length-2)/2*/
        for (int i = arr.length/2-1; i >=0 ; i--) {
   adjustHeap(arr,i,arr.length);
        }
        int length=arr.length;
        for (int j = arr.length-1; j >0 ; j--) {
            int temp=arr[j];
            arr[j]=arr[0];
            arr[0]=temp;
            /*将堆顶的第一个元素与数组的最后一个元素交换位置重新调整堆*/
            adjustHeap(arr,0,--length);
        }



    }






    /*i代表需要调整的结点,length代表长度*/
    public static void adjustHeap(int arr[],int i,int length){
        for (int j = 2*i+1; j <length ; j=2*i+1) {
            if(j+1<length&&arr[j+1]>arr[j]) j++;
            if (arr[j]>arr[i]){
                int temp=arr[i];
                arr[i]=arr[j];
                arr[j]=temp;
                i=j;
            }
            else{
                break;
            }
        }
    }
}
