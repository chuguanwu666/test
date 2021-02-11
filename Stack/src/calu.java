public class calu {
    int number;/*记录数字*/
    int ch;/*记录操作符*/
    int index=0;/*记录字符串索引*/
    int ch1;
    int result;
    String exp;
   stack numberstack=new stack(10);
   stack operstack=new stack(10);
   stack temp=new stack(10);
    public void setExp(String exp) {
        this.exp = exp;
    }
    public int cal(){
        /*将表达式入栈*/
        while(index<exp.length()){
            /*如果是数字压入数栈*/
            if(!stack.isOper(exp.charAt(index))){
                while(true){
                    if(index<exp.length()&&!stack.isOper(exp.charAt(index))){
                number=exp.charAt(index++)-48;
                temp.push(number);
                    }
                    else break;
                }
                numberstack.push(x(temp));
            }
            /*如果是表达式判断栈是否为空*/
            else if(operstack.isEmpty()){
                ch=exp.charAt(index++);
                operstack.push(ch);
            }
            else{
                ch=exp.charAt(index++);
                ch1=operstack.peek();
                /*判断该运算符和前一个的优先级*/
                if(stack.size(ch)>stack.size(ch1)){
                    operstack.push(ch);
                }
                else{
                    operstack.pop();
               number=c(numberstack.pop(),numberstack.pop(),ch1);
               numberstack.push(number);
               operstack.push(ch);
                }
            }
        }
        while (!operstack.isEmpty()){
         ch=operstack.pop();
            number=c(numberstack.pop(),numberstack.pop(),ch);
            numberstack.push(number);
        }

 result=numberstack.pop();

        return result;
    }
    public int c(int n,int m,int ch){
        int res=0;
        switch (ch){
            case '+':res=n+m; break;
            case '-':res=m-n; break;
            case '*':res=n*m; break;
            case '/':res=m/n; break;

        }
return res;

    }
    public int x(stack s){
        int result=0;
        int e=1;
        while(!s.isEmpty()){
            result=result+s.pop()*e;
            e*=10;
        }



        return result;
    }


}
