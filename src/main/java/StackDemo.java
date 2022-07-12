import sun.java2d.pipe.SpanIterator;

import java.util.Scanner;

/**
 * @Author: yangkai
 * @Date: 2022/2/14 9:16
 */
public class StackDemo {
    public static void main(String[] args) {
        arrayStack stack = new arrayStack(4);
        String key="";
        boolean flag=true;
        Scanner scanner=new Scanner(System.in);
        while (flag){

            System.out.println("s表示显示数据");
            System.out.println("e表示退出");
            System.out.println("push表示添加数据");
            System.out.println("pop表示取出数据");
            System.out.println("请输入你的选择");
            key=scanner.next();
            switch (key){
                case "s":
                    stack.show();
                    break;
                case "e":
                    scanner.close();
                    flag=false;
                    break;
                case "push":
                    System.out.println("请输入一个数");
                    int value=scanner.nextInt();
                    stack.push(value);
                    break;
                case "pop":
                    try {
                        System.out.println(stack.pop());
                    }catch (Exception e){
                        System.out.println(e.getMessage());
                    }
                    break;
                default:
                    break;


            }
        }
    }
}

class arrayStack{
    private int maxSize;
    private int top=-1;
    private int[] stack;
    public arrayStack(int maxSize){
        this.maxSize=maxSize;
        this.stack=new int[maxSize];
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
            System.out.println(stack[i]);
        }
    }

}
