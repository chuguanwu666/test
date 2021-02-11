public class RadixSort {
    public static void sort(int []arr){
        /*循环的次数取决于数组最大元素的位数*/
        int max=arr[0];
        for (int i = 1; i <arr.length ; i++) {
            max=Math.max(max,arr[i]);
        }
        int length=(""+max).length();
        int bucket[][]=new int[10][arr.length];
        int bucketindex[]=new int[10];/*每个桶的指针值*/
        for (int i = 0,m=1; i <length; i++,m*=10) {
                 /*每次循环将数组元素放入桶中*/
            for (int j = 0; j <arr.length ; j++) {
                int index=arr[j]/m%10;/*寻找桶的索引并放入桶中*/
                bucket[index][bucketindex[index]++]=arr[j];
            }
            /*将桶元素放回原数组*/
            int d=0;
            for (int n = 0; n <10 ; n++) {
                for (int j = 0; j <bucketindex[n]; j++) {
                    arr[d++]=bucket[n][j];
                }
                /*清空每个桶的指针值*/
                bucketindex[n]=0;
            }



        }
    }
}
