import java.util.Date;

public class Test {
    public static void main(String[] args) {
        int arr[][]=new int[7][7];
        for (int i=0;i<7;i++){
            arr[0][i]=1;
            arr[6][i]=1;
            arr[i][0]=1;
            arr[i][6]=1;
        }
        arr[5][5]='#';
        for(int i=0;i<7;i++){
            for(int j=0;j<7;j++){
                System.out.print(arr[i][j]+" ");
            }
            System.out.println();
        }
        System.out.println(DFS.dfs(arr,1,1));
        for(int i=0;i<7;i++){
            for(int j=0;j<7;j++){
                System.out.print(arr[i][j]+" ");
            }
            System.out.println();
            System.out.println();
        }
    }
}
