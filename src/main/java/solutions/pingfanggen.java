package solutions;

/**
 * @Author: yangkai
 * @Date: 2022/6/22 10:02
 */
public class pingfanggen {
    public int mySqrt(int x) {
        int rel=x;
        while (rel*rel<x){
            ++rel;
            if(rel*rel>x){
                --rel;
                break;
            }else if(rel*rel==x){
                break;
            }
        }
        return rel;
    }
    public static void main(String[] args) {
        int x=2147483647;
        System.out.println(new pingfanggen().mySqrt(x));
    }
}
