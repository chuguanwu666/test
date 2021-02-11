import java.util.Arrays;

public class DFS {
   /* #代表终点*/
    public static boolean dfs(int arr[][],int x,int y){
        if(arr[x][y]=='#'){
            return true;
        }
        else if(arr[x][y]==0){
            arr[x][y]=2;
            if(dfs(arr,x+1,y)||dfs(arr,x,y+1)||dfs(arr,x-1,y)||dfs(arr,x,y-1)){
                return true;
            }
            else {
                return false;

            }
        }
        else {
            return false;
        }

    }
}
