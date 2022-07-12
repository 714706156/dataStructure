package solutions;

/**
 * @Author: yangkai
 * @Date: 2022/6/13 10:29
 */
public class soulutionHuiWen {
    public static void main(String[] args) {
        Integer x=1221;
        System.out.println(new soulutionHuiWen().isPalindrome(x));
    }
    public boolean isPalindrome(int x) {
        boolean rel =true;
        String s=String.valueOf(x);
        String str=new StringBuilder(s).reverse().toString();
        System.out.println(s);
        System.out.println(str);
        if(s.equals(str)){
            rel=true;
        }else {
            rel=false;
        }
        return rel;
    }
}
