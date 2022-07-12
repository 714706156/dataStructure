import java.util.Stack;

/**
 * @Author: yangkai
 * @Date: 2022/2/11 11:33
 */
public class StackTest {
    public static void main(String[] args) {
        Stack<String> stack=new Stack<>();
        stack.add("a");
        stack.add("b");
        stack.add("c");
        stack.add("d");
        while (stack.size()>0){
            System.out.println(stack.pop());
        }
    }

}
