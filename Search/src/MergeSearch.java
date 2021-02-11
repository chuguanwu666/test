public class MergeSearch {
    private int max;
    private int min;

    public int getMax() {
        return max;
    }

    public int getMin() {
        return min;
    }
    public void setArr(int arr[]){
        max=arr[0];
        min=arr[0];
        Merge(arr,0,arr.length-1);
    }

    public void Merge(int []arr,int left,int right){
        int a;
        int b;
        if (right-left>1){
            int mid=(left+right)/2;
            /*继续递归*/
            Merge(arr,left,mid);
            Merge(arr, mid+1, right);
        }
        else {
            /*如果剩下两个元素则进行比较*/
            if ((a = (Math.min(arr[left], arr[right]))) < min) {
                min = a;
            }
            if ((b = (Math.max(arr[left], arr[right]))) > max) {
                max = b;
            }
        }
    }
}
