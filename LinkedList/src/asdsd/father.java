package asdsd;

public class father {
    int co;
    public father() {
        System.out.println(super.getClass());
    }

    public void sout(){
        System.out.println("我是爸爸");
    }
    public void s(){
        sout();
        this.co=1;
    }
}
class user{

}