package hash;

public class Search {
    int max;
    int min;
    public void setArr(int []arr){
        max=arr[0];
        min=arr[0];
        for (int i = 0; i < arr.length; i++) {
           if (arr[i]>max){
               max=arr[i];
           }
            if (arr[i]<min){
                min=arr[i];
            }
        }
    }
}
