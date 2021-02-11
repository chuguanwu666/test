public class ImproveQuickSort {
    public static void sort(int []arr){
        sort(arr,0,arr.length-1);
    }
    public static void sort(int []arr,int left,int right){
        if (left==right) return;
        int end=getPositon(arr,left,right);
        sort(arr, left, end);
        sort(arr, end+1, right);
    }

    public static int getPositon(int []arr,int left,int right)

    {
        int aim=arr[(left+right)/2];
        int rightstr=right;
        int leftstr=left;
        while(true) {

            while (rightstr > leftstr && arr[rightstr] >= aim)  rightstr--;
            while (rightstr > leftstr && arr[leftstr] <aim) leftstr++;
            if (rightstr > leftstr) {
                int temp = arr[rightstr];
                arr[rightstr] = arr[leftstr];
                arr[leftstr] = temp;
            }
            else break;
        }
        return rightstr;
    }
}
