import java.util.Arrays;
import java.util.Collections;

public class stack {
    int []arr;
    int top=-1;
    int maxsize;
    public stack(int n){
        arr=new int[n];
        maxsize=n;

    }

    public boolean isFull(){
        return top==maxsize-1;
    }
    public boolean isEmpty(){
        return top==-1;
    }
    /*入栈*/
    public void push(int n){
        if(isFull()){
            System.out.println("该栈已满");
        }
        else{
            arr[++top]=n;
        }
    }
    public int pop(){
        if(isEmpty()){
            throw  new RuntimeException("栈为空");
        }
       else{
           return arr[top--];
        }
    }
    public static int size(int ch){
        if(ch=='/'||ch=='*') return 1;
        else return 0;
    }
    public static  boolean isOper(int ch){
        if(ch=='/'||ch=='*'||ch=='+'||ch=='-') return true;
        return false;
    }
    public int peek(){
        return arr[top];
    }
}
