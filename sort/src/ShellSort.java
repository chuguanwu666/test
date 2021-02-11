public class ShellSort {
    public static void sort(int []arr){
        /*增量最初为数组的1/2每次排序后重新分组*/
        for (int i = arr.length/2; i >0; i/=2) {
            for (int j = i; j <arr.length ; j++) {
                int aim=arr[j];
                int index=j;
                while(index-i>=0&&arr[index-i]>aim){
                    index-=i;
                    arr[index+i]=arr[index];
                }
                arr[index]=aim;

            }
        }


    }
}
