public class InsertSort {
    public static void sort(int []arr){
        /*把n个待排元素看成有序表和无序表*/
        /*因为第一个元素不需要排序所以共需要n-1把无序表中的元素排到有序表中*/
        for (int i = 1; i <arr.length ; i++) {
            int aim=arr[i];
            int index=i-1;  /*比较的第一个下标为i-1*/
            while(index>=0&&aim<arr[index]){
                arr[index+1]=arr[index];
                index--;
            }
            arr[index+1]=aim;
        }
    }
}
