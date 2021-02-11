import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class InvCalu {
    String express;
    int result;

    public void setExpress(String express) {
        this.express = express;
    }
    /*扫描后缀表达式将结果存入到arr数组中*/
    public List<String> getList(){
        List<String> list=new ArrayList<>();
        String[] arr = express.split("\\s");
        for (String s : arr) {
            list.add(s);
        }
        return list;
    }
    public int getResult(){
        List<String> list = getList();
        System.out.println(list);
        Stack<Integer> stack=new Stack<>();
        int num1;
        int num2;
       /* 扫描list集合*/
        for (String s : list) {
            if(s.matches("\\d")){
                stack.push(Integer.parseInt(s));
            }
            else if(s.equals("+")){
                num1=stack.pop();
                num2=stack.pop();
                stack.push(num1+num2);
            }
            else if(s.equals("-")){
                num1=stack.pop();
                num2=stack.pop();
               stack.push(num2-num1);
            }
            else if(s.equals("*")){
                num1=stack.pop();
                num2=stack.pop();
                stack.push(num2*num1);
            }
            else {
                num1=stack.pop();
                num2=stack.pop();
                stack.push(num2/num1);
            }
        }
        result=stack.pop();
        return result;
    }
    public int getResult(String str){
        List<String> list = getJan(str);
        System.out.println(list);
        Stack<Integer> stack=new Stack<>();
        int num1;
        int num2;
        /* 扫描list集合*/
        for (String s : list) {
            if(s.matches("\\d")){
                stack.push(Integer.parseInt(s));
            }
            else if(s.equals("+")){
                num1=stack.pop();
                num2=stack.pop();
                stack.push(num1+num2);
            }
            else if(s.equals("-")){
                num1=stack.pop();
                num2=stack.pop();
                stack.push(num2-num1);
            }
            else if(s.equals("*")){
                num1=stack.pop();
                num2=stack.pop();
                stack.push(num2*num1);
            }
            else {
                num1=stack.pop();
                num2=stack.pop();
                stack.push(num2/num1);
            }
        }
        result=stack.pop();
        return result;
    }
    public List<String> getJan(String str){
        List<String> list=new ArrayList<>();
            Stack<String> stack=new Stack<>();
        for (char c: str.toCharArray()) {
            if(c>=48&&c<=57){
                list.add(c+"");
            }
            else if(stack.empty()||c=='('||stack.peek().equals("(")){
                stack.add(c+"");
            }
            else if(c==')'){
                /*弹栈直到遇到(*/
                while(!stack.peek().equals("("))
                {
                    list.add(stack.pop());
                }
                stack.pop();
            }
            else{
                if(Operpro.getPro(c+"")>Operpro.getPro(stack.peek())){
                    stack.add(c+"");
                }
                else {

                    while (!stack.empty()&&!stack.peek().equals("(")&&Operpro.getPro(c+"")<=Operpro.getPro(stack.peek())) {
                        list.add(stack.pop());
                    }


                    stack.add(c+"");                }
            }
        }
        while (!stack.empty()){
            list.add(stack.pop());
        }
        return list;
    }
}
