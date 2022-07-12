
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @Author: yangkai
 * @Date: 2022/2/15 11:34
 */
public class PolandNotation {
    public static void main(String[] args) {
        String infixExpression="1+((2+3)*4)-5";
        List<String> list=toSuffixList(infixExpression);
        System.out.println(list);
        List<String> list1=toSuffixExpression(list);
        System.out.println(list1);
//        String suffixExpression="4 5 + 7 * 8 -";
//        List<String> list=getList(suffixExpression);
        int res=cal(list1);
        System.out.println(res);

    }

    public static List<String> toSuffixList(String s){
        int i=0;//指针，用于遍历字符串
        List<String> ls=new ArrayList<String>();
        String str;//用于拼接多位数
        char c=' ';//每遍历一个字符便存入c中
        do{//如果是非数字
            if((c=s.charAt(i))<48 || (c=s.charAt(i))>57){
                ls.add(""+c);
                i++;
            }else {//如果是一个数，则要考虑多位数
                str="";
                while (i<s.length() && (c=s.charAt(i))>=48 && (c=s.charAt(i))<=57){
                    str+=c;
                    i++;
                }
                ls.add(str);
            }
        }while (i<s.length());
        return ls;

    }

    //将list转为后缀表达式
    public static List<String> toSuffixExpression(List<String> ls){
        Stack<String> s1 = new Stack<>();
        List<String> s2=new ArrayList<String>();
        for(String item:ls){
            if(item.matches("\\d+")){
                s2.add(item);
            }else if(item.equals("(")){
                s1.push(item);
            }else if(item.equals(")")){
                while (!s1.peek().equals("(")){
                    s2.add(s1.pop());
                }
                s1.pop();
            }else {
                while (s1.size()!=0 && priority.getValue(item)<=priority.getValue(s1.peek())){
                    s2.add(s1.pop());
                }
                s1.push(item);
            }
            }
        while (s1.size()!=0){
            s2.add(s1.pop());
        }
        return s2;
    }

    //将后缀表达式转为List
    public static List<String> getList(String suffix){
        String[] split=suffix.split(" ");
        List<String> list=new ArrayList<>();
        for(String ele:split){
            list.add(ele);
        }
        return list;
    }
    public static int cal(List<String> ls){
        Stack<String> stack = new Stack<String>();

        for (String item:ls){
            if(item.matches("\\d+")){
                stack.push(item);
            }else {
                int num1=Integer.parseInt(stack.pop());
                int num2=Integer.parseInt(stack.pop());
                int res=0;
                if(item.equals("+")){
                    res=num1+num2;
                }else if(item.equals("-")){
                    res=num2-num1;
                }else if(item.equals("*")){
                    res=num1*num2;
                }else if(item.equals("/")){
                    res=num2/num1;
                }
                stack.push(res+"");
            }
        }
        return Integer.parseInt(stack.pop());
    }
}

class priority{
    private static int ADD=1;
    private static int SUB=1;
    private static int MUL=1;
    private static int DIV=1;

    public static int getValue(String str){
        int res=0;
        switch (str){
            case "+":
                res=ADD;
                break;
            case "-":
                res=SUB;
                break;
            case "*":
                res=MUL;
                break;
            case "/":
                res=DIV;
                break;
        }
        return res;
    }
}
