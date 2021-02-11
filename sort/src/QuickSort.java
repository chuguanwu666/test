import java.util.Arrays;

public class QuickSort {
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
        int aim=arr[left];
        int rightstr=right;
        int leftstr=left;
        while(true) {

            while (rightstr > leftstr && arr[rightstr] >=aim)  rightstr--;  /*如果遇到相等的跳过,那么如果最右边的数小于基准而左边一直没有找到大于基准的数那么返回值为right陷入了死循环*/
            while (rightstr > leftstr && arr[leftstr] <aim) leftstr++;     /*如果遇到相等的都交换如果相邻的两个数相等那么也会陷入死循环*/
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
