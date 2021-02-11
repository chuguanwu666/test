public class Number {
    public static int fact(int n){
        if (n==1||n==0) return 1;
        else return fact(n-1)*n;
    }
    public static int max(int n,int m){
        return n>m?n:m;
    }
    public static int multi(int n1,int n2,int n3){
        return n1*n2*n3;
    }
}
