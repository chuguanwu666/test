public class Kmp {
    public static void main(String[] args) {
        System.out.println(getIndex("BBC ABCDA ABCDABCDABDE","ABCDABCD"));
    }
public static int getIndex(String str1,String str2){
    /*获取字符串2的next数组*/
    int[] next = getNext(str2);
    /*循环str的指针*/
    for (int i = 0,j=0; i <str1.length(); i++) {

        while(j>0&&str2.charAt(j)!=str1.charAt(i)){
            j=next[j-1];
        }
        if(str1.charAt(i)==str2.charAt(j)){
            j++;
        }
        if(j==str2.length()){
            return i-j+1;
        }

    }
    return -1;

}

    /*获取该字符串的next数组 next数组的意义为当匹配该字符不匹配时子串指针回溯到的位置0代表主串指针后移*/
    public static int [] getNext(String str){
        int []next=new int[str.length()];
        next[0]=0;
        int j=0;
        /*j代表上一个next数组元素的逻辑位置等于物理位置+1*/
        for (int i = 1; i <str.length() ; i++) {
            while(j>0&&str.charAt(j)!=str.charAt(i)){
               j=next[j-1];
            }
           if (str.charAt(j)==str.charAt(i)){
               j++;
           }
            next[i]=j;
        }
        return next;
    }

}
