package solutions;

/**
 * @Author: yangkai
 * @Date: 2022/6/21 15:07
 */
public class sumBinary {
    public static void main(String[] args) {
        String a="1010";
        String b="1011";
        System.out.println(Integer.toBinaryString(-19));
    }
    public String addBinary(String a, String b) {
        String result="";
        int ai=0;
        int bi=0;
        int sum=0;
        for (int i = 0; i < a.length(); i++) {
            if(i==a.length()-1){
                ai+=Integer.parseInt(a.substring(i))*Math.pow(2,0);
            }else {
                ai+=Integer.parseInt(a.substring(i,i+1))*Math.pow(2,a.length()-1-i);
            }
        }
        for (int i = 0; i < b.length(); i++) {
            if(i==b.length()-1){
                bi+=Integer.parseInt(b.substring(i))*Math.pow(2,0);
            }else {
                bi+=Integer.parseInt(b.substring(i,i+1))*Math.pow(2,b.length()-1-i);
            }
        }
        ai=Integer.parseInt(a,8);
        System.out.println(ai);
        bi=Integer.parseInt(b,8);
        System.out.println(bi);
        sum=ai+bi;
        result=Integer.toBinaryString(sum);
        return result;
    }

}
