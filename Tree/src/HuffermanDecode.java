import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class HuffermanDecode {

    public static byte[] decodeZip(byte []zip,HashMap<Byte,String> code){

        List<Byte> list=new ArrayList<>();
        StringBuilder str=new StringBuilder(getCode(zip));
        System.out.println(str);
        /*将哈夫曼编码倒置*/
        HashMap<String,Byte> map=new HashMap<>();
        for (Map.Entry<Byte, String> Entry : code.entrySet()) {
            map.put(Entry.getValue(),Entry.getKey());
        }

        /*双指针把编码转换为原本的数组i指向编码的起始j代码的长度*/

        for (int i = 0; i <str.length();) {

            int j=1;
            boolean flag=true;
            Byte b=null;

            while (flag){
                System.out.println(i+j);
                String key=str.substring(i,i+j);
                 b = map.get(key);
                if (b==null){
                    j++;
                }
                else{

                    flag=false;

                }
            }

            list.add(b);
            i+=j;
            System.out.println(i);
        }
        byte []arr=new byte[list.size()];
        for (int i = 0; i <list.size() ; i++) {
            arr[i]=list.get(i);
        }
        return arr;

    }





    public static String getCode(byte []zip){
        StringBuilder sb=new StringBuilder();
        for (int i = 0; i <zip.length ; i++) {
            if (i!=zip.length-1){
                sb.append(getBineary(zip[i],true));
            }
            else{
                sb.append(getBineary(zip[i],false));
                System.out.println(zip[i]);
            }
        }
        return sb.toString();
    }
    /*flag 表示是否为最后一个如果是最后一个则不用补0*/
    public static String  getBineary(byte zip, boolean flag){
     int temp=zip;
     if (flag){
         temp|=256;
         String t=Integer.toBinaryString(temp);
         return t.substring(t.length()-8);
     }
     else{
         return Integer.toBinaryString(temp);
     }
    }
}
