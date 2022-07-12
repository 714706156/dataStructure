package recursion;

/**
 * @Author: yangkai
 * @Date: 2022/2/15 16:45
 */
public class RecursionTest {
    public static void main(String[] args) {
        //test(4);
        int res=0;
        res=factorial(4);
        System.out.println(res);
    }
    public static void test(int n){
        if (n>2){
            test(n-1);
        }
        System.out.println(n);
    }
    public static int factorial(int n){
        if(n==1){
           return n;
        }else {
            return factorial(n-1)*n;
        }
    }
}
