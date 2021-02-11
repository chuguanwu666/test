import sun.swing.BakedArrayList;

import java.awt.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

public class HourseChess {
    int [][] chess;
    boolean [][]visited;
    int total;
    int num;
    int row;
    int col;
    boolean finsh=false;

   public void show(){
       for (int[] ints : chess) {
           System.out.print(Arrays.toString(ints));
           System.out.println();
       }
   }

    public HourseChess(int n, int r, int c){
        num=n-1;
        chess=new int[n][n];
        visited=new boolean[n][n];
        total=n*n;
        row=r;
        col=c;
        setStart(r,c);
        show();
    }
    public void setStart(int x,int y){
        travelChess(x,y,1);
    }
    public void travelChess(int row,int col,int step){
        System.out.println(step);
        visited[row][col]=true;
        chess[row][col]=step;
        ArrayList<Point> next = getNext(new Point(row, col));
        sort(next);
        while (!next.isEmpty()){
            Point p=next.remove(0);
            int r=p.x;
            int c=p.y;
            if (!visited[r][c]){
                travelChess(r,c,step+1);
            }
        }
        if (step==total||finsh){
            finsh=true;
        }
        else {
            visited[row][col]=false;
            chess[row][col]=0;
        }

    }
    public ArrayList<Point> getNext(Point p){
        ArrayList<Point> list=new ArrayList<>();
        Point p1=new Point();
        if ((p1.x=p.x-2)>=0&&(p1.y=p.y+1)<=num){
            list.add(new Point(p1));
        }
        if ((p1.x=p.x-2)>=0&&(p1.y=p.y-1)>=0){
            list.add(new Point(p1));
        }
        if ((p1.x=p.x+2)<=num&&(p1.y=p.y+1)<=num){
            list.add(new Point(p1));
        }
        if ((p1.x=p.x+2)<=num&&(p1.y=p.y-1)>=0){
            list.add(new Point(p1));
        }
        if ((p1.x=p.x+1)<=num&&(p1.y=p.y+2)<=num){
            list.add(new Point(p1));
        }
        if ((p1.x=p.x+1)<=num&&(p1.y=p.y-2)>=0){
            list.add(new Point(p1));
        }
        if ((p1.x=p.x-1)>=0&&(p1.y=p.y+2)<=num){
            list.add(new Point(p1));
        }
        if ((p1.x=p.x-1)>=0&&(p1.y=p.y-2)>=0){
            list.add(new Point(p1));
        }
        return list;
    }
    public void sort(ArrayList<Point> ps){
       ps.sort(new Comparator<Point>() {
           @Override
           public int compare(Point o1, Point o2) {
               return getNext(o1).size()-getNext(o2).size();
           }
       });
    }

}
