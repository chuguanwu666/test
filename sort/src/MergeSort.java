public class MergeSort {
    public static void sort(int []arr){
        int []temp=new int[arr.length];
        sort(arr,0,arr.length-1,temp);
    }
    /*排序新数组,先使俩个子数组顺序,然后归并俩个子数组*/
    public  static void sort(int []arr,int left,int right,int []temp){
        /*递归结束条件*/
        if(left==right) return;
        int mid=(left+right)/2;
        /*左数组*/
        sort(arr,left,mid,temp);
        /*右数组*/
        sort(arr,mid+1,right,temp);
   /*归并俩个子数组*/
        merge(left,mid,right,arr,temp);
    }

    /*temp是临时数组mid是合并数组前半部分最后一个索引*/
    public static void merge(int left,int mid,int right,int []arr,int []temp){
        int i=left;
        int j=mid+1;
        int k=0;
        while(i<=mid&&j<=right){
            if(arr[i]<=arr[j]){
                temp[k++]=arr[i];
                i++;
            }
            else{
                    temp[k++]=arr[j];
                    j++;
            }
        }
        while(i<=mid){temp[k++]=arr[i++];}
        while(j<=right){temp[k++]=arr[j++];}
        /*拷贝数组*/
        int m=left;
        for (int l = 0; l <k ; l++) {
            arr[m++]=temp[l];
        }

    }
}
