public class SelectSort {
    public  static void sort(int []arr){
        for (int i = 0; i <arr.length-1 ; i++) {
            int temp;
            int min=i;
            for (int j=i+1;j<arr.length;j++){
                if(arr[j]<arr[min]) min=j;
            }
            temp=arr[i];
            arr[i]=arr[min];
            arr[min]=temp;

        }

    }
}
