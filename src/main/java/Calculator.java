/**
 * @Author: yangkai
 * @Date: 2022/2/14 11:00
 */
public class Calculator {
    public static void main(String[] args) {
        String expression="3+8*6-17";
        arrayStack2 stackNum = new arrayStack2(10);
        arrayStack2 stackOper=new arrayStack2(10);
        int index=0;
        int num1=0;
        int num2=0;
        int res=0;
        int oper=0;
        char ch=' ';
        String keepNum="";
        while (true){
            ch=expression.substring(index,index+1).charAt(0);
            if(stackOper.isOper(ch)){
                if(!stackOper.empty()){
                    //如果符号栈有操作符，就进行比较，如果当前操作符的优先级小于或者等于栈中的操作符优先级，则需要
                    //从数栈中取出两个数，再从符号栈中取出一个数，进行运算，得到的结果入数栈，然后当前操作符入符号栈；
                    if(stackOper.priority(ch)<=stackOper.priority(stackOper.peak())){
                        num1=stackNum.pop();
                        num2=stackNum.pop();
                        oper=stackOper.pop();
                        res=stackNum.cal(num1,num2,oper);
                        stackNum.push(res);
                        stackOper.push(ch);
                    }else {
                        //如果当前操作符的优先级大于栈中操作符的优先级，则直接入栈；
                        stackOper.push(ch);
                    }
                }else {
                    stackOper.push(ch);
                }
            }else {//如果是数，则直接入栈
                keepNum+=ch;
                if(index==expression.length()-1){
                    stackNum.push(Integer.parseInt(keepNum));
                }else {
                    if(stackOper.isOper(expression.substring(index+1,index+2).charAt(0))){
                        stackNum.push(Integer.parseInt(keepNum));
                        keepNum="";
                    }
                }
            }
            index++;
            if(index>=expression.length()){
                break;
            }
        }
        //当表达式扫描完毕，就顺序地从栈中取出数据进行运算；
        while (true){
            if(stackOper.empty()){
                break;
            }
            num1=stackNum.pop();
            num2=stackNum.pop();
            oper=stackOper.pop();
            res=stackNum.cal(num1,num2,oper);
            stackNum.push(res);
        }
        System.out.println("结果为： "+stackNum.pop());
    }
}
class arrayStack2{
    private int maxSize;
    private int top=-1;
    private int[] stack;
    public arrayStack2(int maxSize){
        this.maxSize=maxSize;
        this.stack=new int[maxSize];
    }
    //返回栈顶的值，但是不取出
    public int peak(){
        return stack[top];
    }
    public int priority(int oper){
        if (oper =='*' || oper == '/'){
            return 1;
        }else if(oper =='+' || oper == '-'){
            return 0;
        }else {
            return -1;
        }
    }
    public boolean isOper(char val){
        return val=='+' || val=='-' || val=='*' || val=='/';
    }
    public int cal(int num1,int num2,int oper){
        int res=0;
        switch (oper){
            case '+':
                res=num1+num2;
                break;
            case '-':
                res=num2-num1;
                break;
            case '*':
                res=num1*num2;
                break;
            case '/':
                res=num2/num1;
                break;
        }
        return res;


    }
    public boolean full(){
        return (top==maxSize-1);
    }
    public boolean empty(){
        return (top==-1);
    }
    public void push(int value){
        if(full()){
            System.out.println("栈满了");
        }
        top++;
        stack[top]=value;
    }
    public int pop(){
        if (empty()){
            throw new RuntimeException("栈为空");
        }
        int value=stack[top];
        top--;
        return value;
    }

    public void show(){
        if(empty()){
            System.out.println("栈为空");
            return;
        }
        for(int i=top;i>=0;i--){
            System.out.println(stack[i]+"\n");
        }
    }

}
