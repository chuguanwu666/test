public class Point {
    int x;
    int y;
    Point pre;
    boolean flag=false;  /*判断该点是否可走.如果是障碍或者已经走过为false*/
    boolean isEnd=false;
    int count;
}
