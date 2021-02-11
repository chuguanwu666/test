import java.util.ArrayList;
import java.util.List;

public class BinarySearch {
    /*非递归版本*/
    public static int search(int []arr,int aim){
        int left=0;
        int right=arr.length-1;
        while(left<right){
            int mid=(left+right)/2;
            if(arr[mid]==aim){
                return mid;
            }
            else if(arr[mid]>aim){
                right=mid-1;
            }
            else{
                left=mid+1;
            }
        }
        return -1;

    }
    public static List Isearch(int []arr, int aim){
        List list=new ArrayList();
        int left=0;
        int right=arr.length-1;
        while(left<right){
            int mid=(left+right)/2;
            if(arr[mid]==aim){
                int leftstr=mid-1;
                int rightstr=mid+1;
                list.add(mid);
                while (arr[leftstr]==aim) {list.add(leftstr); leftstr--;}
                while (arr[rightstr]==aim){list.add(rightstr);rightstr++;}
                return list;
            }
            else if(arr[mid]>aim){
                right=mid-1;
            }
            else{
                left=mid+1;
            }
        }
        return list;

    }
}
