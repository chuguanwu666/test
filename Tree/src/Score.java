import java.io.FileWriter;
import java.io.IOException;

public class Score {
    int sno;
    int cno;
    int score;
    public void output() throws IOException {
        FileWriter fw=new FileWriter("Score.txt");
        fw.write("学号:"+this.sno);
        fw.write("编号:"+this.cno);
        fw.write("成绩:"+this.score);
        fw.close();
    }
}
