public class BubbleSort {
    public static void sort(int []arr){
        boolean flag=true;
        int temp;
        /*共循环n-1次*/
        for (int i = 1; i <arr.length ; i++) {
            for (int j=0;j<arr.length-i;j++){
                if(arr[j]>arr[j+1]){
                    temp=arr[j];
                    arr[j]=arr[j+1];
                    arr[j+1]=temp;
                    flag=false;
                }
            }
            if(flag){
                break;
            }
        }
    }
}
