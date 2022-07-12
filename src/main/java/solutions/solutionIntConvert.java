package solutions;

/**
 * @Author: yangkai
 * @Date: 2022/6/10 15:15
 */
public class solutionIntConvert {
    public int reverse(int x) {
        if(x<Math.pow(-2,31) || x>Math.pow(2,31)){
            return 0;
        }
        int y=0;
        StringBuilder stringBuilder=new StringBuilder("");
        if(x>0){
            StringBuilder s=new StringBuilder(x+"");
            stringBuilder=s.reverse();
            y=Integer.valueOf(stringBuilder.toString());
        }else if(x<0){
            String s1=x+"";
            s1=s1.substring(1);
            StringBuilder s=new StringBuilder(s1);
            stringBuilder=s.reverse();
            y=Integer.valueOf(stringBuilder.toString());
            y=0-y;
        }else {
            y=x;
        }
        return y;
    }

    public static void main(String[] args) {
        int a=231;
        System.out.println(new solutionIntConvert().reverse(a));
        System.out.println(Integer.MIN_VALUE);
    }
}
