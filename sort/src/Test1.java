import com.sun.org.apache.bcel.internal.generic.Select;
import jdk.nashorn.tools.Shell;

import java.util.Arrays;
import java.util.Date;

public class Test1 {
    public static void main(String[] args) {
        int arr[]={5,9,15,15,15,69,8,5};
       HeapSort.sort(arr);
        System.out.println(Arrays.toString(arr));

    }
}
