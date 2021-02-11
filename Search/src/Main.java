public class Main {
    /*核心思想 if(i=j) dp[i][j]=dp[i-1]dp[i+1] else dp[i][j]=max{dp[i-1][j],dp[i][j-1]}*/
    public static int findLcs(String str1,String str2){
        int [][]dp=new int[str1.length()+1][str2.length()+1];
        for (int[] ints : dp) {
            for (int anInt : ints) {
                anInt=0;
            }
        }
        for (int i = 1; i <str1.length()+1; i++) {
            for (int j = 1; j <str2.length()+1; j++) {
                if(str1.charAt(i-1)==str2.charAt(j-1)){
                    dp[i][j]=dp[i-1][j-1]+1;
                }
                else{
                    dp[i][j]=Math.max(dp[i-1][j],dp[i][j-1]);
                }
            }
        }
        return dp[str1.length()][str2.length()];

    }

    public static void main(String[] args) {
        System.out.println(findLcs("357684782","13456778"));
    }
}
