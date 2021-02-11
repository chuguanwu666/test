package asdsd;

import org.omg.CORBA.portable.OutputStream;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;

public class son extends father {
   int co=0;
   public void sout(){
       System.out.println("WSSS");
   }
   public void show(){
       File X=new File("/dasd.x");
       try {
           FileOutputStream t=new FileOutputStream(X);
       } catch (FileNotFoundException e) {
           e.printStackTrace();
       }

       s();
       System.out.println(super.co);
       System.out.println(co);
   }
}
