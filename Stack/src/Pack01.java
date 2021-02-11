public class Pack01 {
    public static void main(String[] args) {
        int []value={0,1500,2500,3000};/*商品的价值*/
        int []weight={0,1,3,4};/*商品的种类*/
        /*4为最大容量*/
        int v[][]=new int[value.length][5];
        for (int i = 1; i <v.length; i++) {
            for (int j = 1; j <v[0].length ; j++) {
                System.out.println(i);
                if (j<weight[i]){
                    v[i][j]=v[i-1][j];
                }
                else{
                    v[i][j]=Math.max(v[i-1][j],v[i-1][j-weight[i]]+value[i]);
                }
            }

        }
        System.out.println(v[3][4]);
    }

}
