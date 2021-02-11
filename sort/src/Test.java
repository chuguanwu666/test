
import java.util.ArrayList;
import java.util.Scanner;


public class Test {
    public static void main(String[] args) {
        int customer;
        Scanner input = new Scanner(System.in);
        System.out.print("请输入顾客数目：");
        customer = input.nextInt();
        input.close();
        new Thread(new Barber(), "理发师" + Integer.toString(0) + "号").start();
        for (int i = 0; i < customer; i++) {
            new Thread(new Customer(), "顾客" + Integer.toString(i) + "号").start();
        }
    }
}

//理发师
class Barber implements Runnable {
    @Override
    public void run() {
        // TODO Auto-generated method stub
        while (true) {
            Global.naps();
            Global.Customer.P();  //试图给顾客理发，没有理发师就睡觉
            Global.mutex.P();  //修改空椅子的数量
            Global.empty++;  //空出一张椅子
            Global.mutex.V();  //理发，空出椅子，使进店的顾客能够访问椅子的数量

            String name = "";
            if (!Global.cust.isEmpty()) {
                name = Global.cust.remove(0);
            }
            System.out.println(name + "  在理发...");
            Global.naps();
            System.out.println(name + "  理完发...");
        }
    }
}

//顾客
class Customer implements Runnable {
    @Override
    public void run() {
        // TODO Auto-generated method stub
        Global.naps();  //为了防止顾客名字字符串乱码
        Global.mutex.P();  //想做到椅子上
        if (Global.empty > 0) {  //还有位置
            Global.empty--;  //椅子数量减一
            Global.Customer.V();  //通知理发师，顾客来了
            Global.mutex.V();  //顾客做到椅子上

            Global.cust.add(Thread.currentThread().getName());
            System.out.println(Thread.currentThread().getName() + "  等待...");
        } else {
            Global.mutex.V();
            System.out.println(Thread.currentThread().getName() + "  离开...");
        }
    }
}

//全局对象
class Global {
    public static Semaphore Customer = new Semaphore(0);  //是否有顾客
    public static Semaphore mutex = new Semaphore(1);  //互斥信号灯
    public static int empty = 5;  //空椅子数量
    public static ArrayList<String> cust = new ArrayList<String>();  //等待的顾客

    //随机等待
    public static void naps() {
        try {
            Thread.sleep((int) (2000 * Math.random()));
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

}

//信号量
class Semaphore {
    public int value;

    public Semaphore(int value) {
        super();
        this.value = value;
    }
    //P操作
    public synchronized final void P() {
        // TODO Auto-generated method stub
        value--;
        if(value < 0) {
            try {
                this.wait();
            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
    }
    //V操作
    public synchronized final void V() {
        // TODO Auto-generated method stub
        value++;
        if (value <= 0) {
            this.notify();
        }
    }
}