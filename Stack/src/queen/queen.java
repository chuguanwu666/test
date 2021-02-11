package queen;

public class queen {
    int n;/*代表n个皇后*/
    int []arr=new int[n];
    int count;
    /*判断第n个皇后的位置是否合法*/
    public boolean judge(int n){
        for (int i=0;i<n;i++){
            /*如果第n个皇后与前n-1个皇后在同一列或同一行则返回false说明不合法*/
            if (arr[i]==arr[n]||Math.abs(i-n)==Math.abs(arr[i]-arr[n])){
                return false;
            }
        }
        return true;
    }
    /*当指针到第八行时说明满足条件输出列的号码*/
    public void print(){
        for (int i : arr) {
            System.out.print(i);
        }
        System.out.println();
    }

    public void setN(int n) {
        this.n = n;
        arr=new int[n];
        check(0);
        System.out.print(count);
    }
    /*回溯指针*/
    public void check(int n) {
        /*当指针在第九行时说明是一种方法*/
        if (n == 8) {
            print();
            count++;
        } else {
            /*i代表列数*/
            for (int i = 0; i < 8; i++) {
                arr[n] = i;
                /*如果满足摆放条件则进行下一行的遍历*/
                if (judge(n)) {
                    check(n + 1);
                }
            }
        }
    }

}
