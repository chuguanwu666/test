public class Rope {
    /*定义每段绳子的长度*/
    public int []price={0,1,5,8,9,10,17,17,20,24,30};
    public  int []result;

    public Rope(int n) {
        result=new  int[n+1]/*记录每段绳子的最优解*/;
        System.out.println(setLength(n));
    }

    public int setLength(int n){
        int max=0;
        /*结束条件n=0*/
        if (n==0) return 0;
        else{
            /*寻找最优解*/
            for (int i = 1; i <=n ; i++) {
                max=Math.max(max,setLength(n-i)+price[i]);
            }
        }
        return max;
    }

}
